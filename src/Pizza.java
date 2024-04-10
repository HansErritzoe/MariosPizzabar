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

    public double prisFinder(String navn) throws FileNotFoundException { //prisFinder navn tager imod input pizza navn fra array
        File file = new File("src/pizzaListe.txt");
        Scanner filescan = new Scanner(file);

        while (filescan.hasNextLine()) { //her sætter vi while loops op til at tælle linjer i pizzaListe.txt
            int count = 0;
            while (filescan.hasNextLine()) {
                count++;
                filescan.nextLine();
            }
            String[] pizzaNavn = new String[count]; //laver to arrays til at tage imod pizza navn og pizza pris hver især
            double[] pizzaPris = new double[count]; //der har længden af pizzaListe.txt

            File fileloop = new File("src/pizzaListe.txt"); //initializer en ny File så vi starter med at kigge fra linje 1 igen

            Scanner loopfilescan = new Scanner(fileloop);        //i følgende loop indsætter vi det første element fra pizzaListe.txt -
            for(int i = 0; i <= count-1; i++) {                 //- i pizzaNavn[] array, det betyder at pizza navne fra pizzaListe.txt kommer ind på
                loopfilescan.useLocale(Locale.US);                  //plads 0 i pizzaNavn[], derefter leder vi efter en double som er prisen og gør det samme
                String pizzaScan = loopfilescan.next();         //hvor vi finder pizzaens pris og putter i pizzaPris[] array
                pizzaNavn[i] = pizzaScan;                       //dette gør vi så antal gange af count som vi har fra det tidligere loop
                double prisScan = loopfilescan.nextDouble();    //altså antal linjer fra filen pizzaListe.txt
                pizzaPris[i] = prisScan;
            }
            for (int j = 0; j <= count-1; j++) { //i dette for loop finder vi så en given pris på en pizza
                if (pizzaNavn[j].equals(navn)) { //hvis parameteren navn som bliver givet er det samme som et navn i pizzaNavn arrayet.
                    return pizzaPris[j];         //derefter tages pladsen som vi har fundet navnet på og returnere prisen fra pizzaPris
                }
            }
        }
        return 0;
    }
}


