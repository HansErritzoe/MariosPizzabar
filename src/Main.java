import java.io.*;
import java.time.*;
import java.util.*;
public class Main {

    //henter nuværende ordrer og færdige ordrer når programmet starter op fra filer
    public static Ordre[] ordrer = FilBehandling.hentOrdrer(); //to be done
    //public static Ordre[] færdigeOrdrer = FilBehandling.hentFærdigeOrdrer(); //to be done

    //scanner til genbrug i hele koden
    public static final Scanner brugerInput = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        //UI.hovedMenu();
        //til test af oprettelse af PizzaArray samt Ordre
        /* Pizza[] pizzaTestArray = new Pizza[3];
        pizzaTestArray[0] = new Pizza("Vesuvio",20);
        pizzaTestArray[1] = new Pizza("Kartoffel",20);
        pizzaTestArray[2] = new Pizza("Quadro-Formaggio",20);
        Ordre testOrdre = new Ordre(25,pizzaTestArray, "12 45");

        //til test af hentOrdrer() samt gemOrdre()
        System.out.println(testOrdre.toString()); */
        /* for(Ordre ordre : ordrer){
            System.out.println(ordre.toString());
        }
        FilBehandling.gemOrdre(ordrer);
        */
    }

}
