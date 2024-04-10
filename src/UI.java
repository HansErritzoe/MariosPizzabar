import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class UI {

    //metode for at printe hovedmenuen og lade brugeren foretage et valg
    public static void hovedMenu() throws FileNotFoundException {
        System.out.println("========================================");
        System.out.println("               Hovedmenu                ");
        System.out.println("========================================");
        System.out.println("  Indtast et tal for vælge en mulighed  ");
        System.out.println("========================================");
        System.out.println("         tast 1: Se Menu-kort           ");
        System.out.println("         tast 2: Se nuværende ordrer    ");
        System.out.println("         tast 3: Tilføj ny ordre        ");
        System.out.println("         tast 4: Slet ordre             ");
        System.out.println("         tast 5: Marker ordre betalt    ");
        System.out.println("         tast 6: Se omsætning           ");
        System.out.println("         tast 7: Se statestik           ");
        System.out.println("         tast 8: Luk programmet         ");


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
                System.out.println("case 1");
                MenuKort.printPizzaListe();
                break;
            case 2://se nuværende ordrer : de skal sorteres efter afhentningstidspunkt
                System.out.println("case 2");
                break;
            case 3://tilføj ny ordre
                tilfoejordre(Main.brugerInput);
                System.out.println("case 3");
                break;
            case 4:
                System.out.println("case 4");
                break;
            case 5:
                System.out.println("case 5");
                break;
            case 6:
                System.out.println("case 6");
                break;
            case 7:
                System.out.println("case 7");
                break;
            case 8:
                System.exit(0);
            default: //til hvis brugeren indtaster et tal som ikke er en mulighed
                System.out.println("Ikke accepteret valg, prøv igen");
                hovedMenu();
        }//end of switch
    }//end of hovedmenu

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

}//end of class

