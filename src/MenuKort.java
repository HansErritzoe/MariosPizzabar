import java.util.*;
import java.io.*;
public class MenuKort {

    public static void printPizzaListe() throws FileNotFoundException {
        File file = new File("src/pizzaListe.txt");
        Scanner filescan = new Scanner(file);
        while(filescan.hasNextLine()) {
            int count = 0; //tæller op for hver linje i pizzaListe
            while (filescan.hasNextLine()) {
                count++;
                filescan.useLocale(Locale.US);
                String nextPizza = filescan.nextLine();
                System.out.println(count + "." + " " + nextPizza + "kr."); //tager imod det nummer loopet er noget på samt hele indholdet af den linje
            }                                                              // og printer det derefter ud i følgende format eksempel:
        }                                                                  // count. nextPizzakr.
    }                                                                      // 1. Vesuvio 57.00kr.
}
