import java.util.*;
import java.io.*;
public class MenuKort {

    public static void printPizzaListe() throws FileNotFoundException {
        File file = new File("src/pizzaListe.txt");
        Scanner filescan = new Scanner(file);
        while (filescan.hasNextLine()) {
            int count = 0; //tæller op for hver linje i pizzaListe

            while (filescan.hasNextLine()) {
                count++;
                String[] pizzaNavn = new String[count];
                filescan.useLocale(Locale.US);
                String nextPizza = filescan.nextLine();
                pizzaNavn[count - 1] = nextPizza;
                System.out.println(pizzaNavn[count - 1]);
            }
        }

        UI.hovedMenu();
    }
}
