import java.io.*;
import java.util.*;


public class Statistik {
    private static String[] point = new String[0];

    public static void mestSolgtePizza(Ordre[] ordre) throws FileNotFoundException {
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
                        navneSamler(pizzaScan);
                    }
                }
            }
        }
        pointTæller();
    }


    public static String[] navneSamler(String navn) {
        String[] nyPoint = new String[point.length + 1];
        for (int i = 0; i < point.length; i++) {
            nyPoint[i] = point[i];
        }
        nyPoint[point.length] = navn;
        point = nyPoint;
        return point;
    }
    public static void pointTæller() {

        int Vesuvio = 0;
        int Amerikaner = 0;
        int Cacciatore = 0;
        int Carbona = 0;
        int Dennis = 0;
        int Bertil = 0;
        int Silvia = 0;
        int Victoria = 0;
        int Toronfo = 0;
        int Capricciosa = 0;
        int Hawai = 0;
        int LeBlissola = 0;
        int Venezia = 0;
        int Mafia = 0;

        for (String pizza : point) {
            if (pizza.equals("Vesuvio")) {
                Vesuvio++;
            }
            if (pizza.equals("Amerikaner")) {
                Amerikaner++;
            }
            if (pizza.equals("Cacciatore")) {
                Cacciatore++;
            }
            if (pizza.equals("Carbona")) {
                Carbona++;
            }
            if (pizza.equals("Dennis")) {
                Dennis++;
            }
            if (pizza.equals("Toronfo")) {
                Toronfo++;
            }
            if (pizza.equals("Capricciosa")) {
                Capricciosa++;
            }
            if (pizza.equals("Hawai")) {
                Hawai++;
            }
            if (pizza.equals("Le-Blissola")) {
                LeBlissola++;
            }
            if (pizza.equals("Venezia")) {
                Venezia++;
            }
            if (pizza.equals("Mafia")) {
                Mafia++;
            }
            if (pizza.equals("Victoria")) {
                Victoria++;
            }
            if (pizza.equals("Silvia")) {
                Silvia++;
            }
            if (pizza.equals("Bertil")) {
                Bertil++;
            }
        }

        System.out.println("===============================================");
        System.out.println("                   Statistik                   ");
        System.out.println("===============================================");
        System.out.println("1. Vesuvio: " + Vesuvio + solgtMaengde(Vesuvio));
        System.out.println("2. Amerikaner: " + Amerikaner + solgtMaengde(Amerikaner));
        System.out.println("3. Cacciatore: " + Cacciatore + solgtMaengde(Cacciatore));
        System.out.println("4. Carbona: " + Carbona + solgtMaengde(Carbona));
        System.out.println("5. Dennis: " + Dennis + solgtMaengde(Dennis));
        System.out.println("6. Toronfo: " + Toronfo + solgtMaengde(Toronfo));
        System.out.println("7. Capricciosa: " + Capricciosa + solgtMaengde(Capricciosa));
        System.out.println("8. Hawai: " + Hawai + solgtMaengde(Hawai));
        System.out.println("9. Le-Blissola: " + LeBlissola + solgtMaengde(LeBlissola));
        System.out.println("10. Venezia: " + Venezia + solgtMaengde(Venezia));
        System.out.println("11. Mafia: " + Mafia + solgtMaengde(Mafia));
        System.out.println("12. Victoria: " + Victoria + solgtMaengde(Victoria));
        System.out.println("13. Silvia: " + Silvia + solgtMaengde(Silvia));
        System.out.println("14. Bertil: " + Bertil + solgtMaengde(Bertil));
        System.out.println("");
    }
    public static String solgtMaengde(int a) {
        if (a >= 2) {
            return " Solgte";
        }
        else {
            return " Solgt";
        }

    }
}

