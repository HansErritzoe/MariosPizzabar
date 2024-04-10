import java.util.*;
import java.io.*;
public class MenuKort {

    public static void printPizzaListe() throws FileNotFoundException {
        File file = new File("src/pizzaListe.txt");
        Scanner filescan = new Scanner(file);
        while(filescan.hasNextLine()) {
            int count = 0;
            while (filescan.hasNextLine()) {
                count++;
                filescan.useLocale(Locale.US);
                String nextPizza = filescan.nextLine();
                System.out.println(count + "." + " " + nextPizza + "kr.");
            }
        }
    }
}
