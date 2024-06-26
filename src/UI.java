import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class UI {

    //metode for at printe hovedmenuen og lade brugeren foretage et valg
    public static void hovedMenu() throws FileNotFoundException {
        System.out.println("===============================================");
        System.out.println("                   Hovedmenu                   ");
        System.out.println("===============================================");
        System.out.println("      Indtast et tal for vælge en mulighed     ");
        System.out.println("===============================================");
        System.out.println("  tast 1: Se Menu-kort                         ");
        System.out.println("  tast 2: Se nuværende ordrer                  ");
        System.out.println("  tast 3: Tilføj ny ordre                      ");
        System.out.println("  tast 4: Marker ordre betalt og arkiver den   ");
        System.out.println("  tast 5: Se omsætning                         ");
        System.out.println("  tast 6: Se statsitik                         ");
        System.out.println("  tast 7: Luk programmet                       ");


        int valg = 0;
        //try/catch til hvis brugeren taster invalid input så som tekst istedet for tal.
        try {
            valg = Main.brugerInput.nextInt();
        } catch (Exception e) {
            System.out.println("Ikke accepteret input, prøv igen");
            Main.brugerInput.nextLine(); //clearer scanneren så den er klar til nyt input
            hovedMenu();
            return; //sørger for at resten af metoden efter try/catch ikke bliver kørt.
        }

        //selve switchen til hovedmenuen
        switch (valg) {
            case 1:
                //System.out.println("case 1");
                MenuKort.printPizzaListe();
                hovedMenu();
                break;
            case 2://se nuværende ordrer : de skal sorteres efter afhentningstidspunkt
                seOrdrer();
                //System.out.println("case 2");
                hovedMenu();
                break;
            case 3://tilføj ny ordre
                tilfoejordre(Main.brugerInput);
                //System.out.println("case 3");
                hovedMenu();
                break;
            case 4: //Marker ordre betalt og arkiver den
                faerdigOrdre(Main.brugerInput, Main.ordrer);
                hovedMenu();
                break;
            case 5: //se omsætning
                //System.out.println("case 5");
                Omsaetning.findOmsætning(Main.færdigeOrdrer);
                hovedMenu();
                break;
            case 6: //se statistik
                Statistik.mestSolgtePizza(Main.færdigeOrdrer);
                hovedMenu();
                break;
            case 7:
                System.exit(0);
            default: //til hvis brugeren indtaster et tal som ikke er en mulighed
                System.out.println("Ikke accepteret valg, prøv igen");
                hovedMenu();
        }//end of switch
    }//end of hovedmenu

    public static void seOrdrer(){
        Ordre[] ordrer = FilBehandling.hentOrdrer();
        Arrays.sort(ordrer);
        for (Ordre ordre : ordrer){
            System.out.println(ordre.toString());
        }
    }
    public static void testDone(){
        Ordre[] ordrer = FilBehandling.hentFaerdigeOrdrer();
        for (Ordre ordre : ordrer){
            System.out.println(ordre.toString());
        }
    }

    public static void tilfoejordre(Scanner scan) throws FileNotFoundException{
        int antalPizzaer = 1;
        int N=1; // counter der tæller numbers of pizzaer
        //Pizza [] nypizzaarray= new Pizza[1];

        System.out.println("hvor mange pizzaer vil du indtaste");
        int NbPizza = scan.nextInt();

        Pizza [] nypizzaarray= new Pizza[NbPizza];

        while (N<=NbPizza) {
            System.out.println("Indtast pizzanavn: ");
            String navn = scan.next();

            Pizza pizza = new Pizza(navn); //opretter pizza objekt
            //antalPizzaer++;
            nypizzaarray[N-1]=pizza;
            N++;

        }//end of while loopen

        //Nu skal der spørges om afhentnings tidspunkt:
        System.out.println("Indtast afhentningstidspunkt, i formen : hh mm: ");
        scan.nextLine();
        String afhTids= scan.nextLine();
        LocalDateTime tid =Ordre.localDateTimefraKlokkeSlæt(afhTids);

        //Nu skal der hentes OrdreNr:
        int ordreNr = FilBehandling.getNewID();

        Ordre nyordre = new Ordre(ordreNr, nypizzaarray, afhTids);

        Ordre[] nyOrdre = new Ordre[Main.ordrer.length+1];
                for(int i=0; i<Main.ordrer.length;i++){
                    nyOrdre [i]= Main.ordrer[i];
                }//end forloopen
        nyOrdre [Main.ordrer.length]=nyordre;
        Main.ordrer=nyOrdre;

        FilBehandling.gemOrdre(Main.ordrer);

    }//end of tilfoejordre method

    public static void faerdigOrdre(Scanner scan, Ordre[] ordres) throws FileNotFoundException {
        ordres = FilBehandling.hentOrdrer(); //læser ordrene fra filen og gemmer dem i ordre-arrayet
        System.out.println("Hvor mange ordrer vil du slette?");
        int Nb = scan.nextInt();

        int antalSlette = 1;

        PrintStream out = new PrintStream(new FileOutputStream("src/færdigeOrdre.txt", true));
        while (antalSlette <= Nb) {

            System.out.println("hvad er ID af den order du vil markere som færdiggjort?");
            int idSlette = scan.nextInt(); //læser ID -fra ekspedienten- af det ordre han vil slette

            int index = findOrdreIndex(ordres, idSlette);//metode der finder ordret der skal slettes i arrayet
            //System.out.println(ordres[index]); /print den for at sikre at det fungerer
            out.println(ordres[index]); //skriv ordret i færdigeOrdre

            Ordre[] nytArray = new Ordre[ordres.length - 1];//create a new array that has the same objects minus the deleted
            for (int i=0; i<index; i++){
                nytArray[i]=ordres[i];
            }
            for(int i=index; i<ordres.length - 1; i++){
                nytArray[i]=ordres[i+1];
            }
            ordres=nytArray;
            antalSlette ++;
        }//end whileloopen
        out.close();

        FilBehandling.gemOrdre(ordres);

    } // end of faerdigOrdre()

        public static int findOrdreIndex(Ordre[] ordres, int idSlette){
            for (int i=0; i<ordres.length; i++){
                if (ordres[i].getOrdreNr()==idSlette){
                    return i;
                }
            }
            return -1;
        } // end of findOrdreIndex


}//end of class


