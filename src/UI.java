import java.io.*;
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
        switch(valg) {
            case 1:
                System.out.println("case 1");
                MenuKort.printPizzaListe();
                break;
            case 2:
                System.out.println("case 2");
                break;
            case 3:
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
        }
    }
}
