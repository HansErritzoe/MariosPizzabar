import java.io.*;
import java.util.*;

public class Pizza {

    private String navn;
    private double pris;

    public Pizza(String navn, double pris) {
        this.navn = navn;
        this.pris = pris;
    }

    public Pizza(String navn) throws FileNotFoundException {
        this.navn = navn;
        this.pris = prisFinder(navn);
    }

    public String toString() {
        return (navn + ": " + pris);
    }

    public double getPris() {
        return this.pris;
    }

    public String getNavn() {
        return this.navn;
    }

    public double prisFinder(String navn) throws FileNotFoundException {
        File file = new File("src/pizzaListe.txt");
        Scanner filescan = new Scanner(file);

        while (filescan.hasNextLine()) {
            int count = 0;
            while (filescan.hasNextLine()) {
                count++;
                filescan.nextLine();
            }
            String[] Pizza = new String[count];
            double[] pris = new double[count];
            File fileloop = new File("src/pizzaListe.txt");
            Scanner loopfilescan = new Scanner(fileloop);
            for(int i = 0; i <= count-1; i++) {
                filescan.useLocale(Locale.US);
                String pizzaScan = loopfilescan.next();
                Pizza[i] = pizzaScan;
                double prisScan = loopfilescan.nextDouble();
                pris[i] = prisScan;

            }
            for (int j = 0; j <= count-1; j++) {
                if (Pizza[j].equals(navn)) {
                    return pris[j];
                }
            }
        }
        return 0;
    }
}


