import java.io.*;
import java.util.*;


public class Omsaetning {
    private static double[] omsætning = new double[0];

    public static void findOmsætning(Ordre[] ordre) throws FileNotFoundException {

        File file = new File("src/pizzaListe.txt");
        Scanner filescan = new Scanner(file);

        while (filescan.hasNextLine()) {
            int count = 0;
            while (filescan.hasNextLine()) {
                count++;
                filescan.nextLine();
            }
            String[] pizzaNavn = new String[count];
            double[] pizzaPris = new double[count];

            File fileloop = new File("src/pizzaListe.txt");

            Scanner loopfilescan = new Scanner(fileloop);
            for (int i = 0; i <= count - 1; i++) {
                loopfilescan.useLocale(Locale.US);
                String pizzaScan = loopfilescan.next();
                pizzaNavn[i] = pizzaScan;
                double prisScan = loopfilescan.nextDouble();
                pizzaPris[i] = prisScan;
                for (Ordre pizza : ordre) {
                    if (pizza.toString().contains(pizzaScan)) {
                        navneSamler(prisScan);
                    }
                }
            }
        }
        totalOmsætning();
    }


    public static double[] navneSamler(Double prisScan) {
        double[] nyPoint = new double[omsætning.length + 1];
        for (int i = 0; i < omsætning.length; i++) {
            nyPoint[i] = omsætning[i];
        }
        nyPoint[omsætning.length] = prisScan;
        omsætning = nyPoint;
        return omsætning;
    }
    public static void totalOmsætning() {
        double omsætningSamler = 0;
        for (double i : omsætning) {
            omsætningSamler += i;
        }
        System.out.println("===============================================");
        System.out.println("                   Omsætning                   ");
        System.out.println("===============================================");
        System.out.println("Din totale omsætning er: " + omsætningSamler + "kr.");
        System.out.println();
    }
}

