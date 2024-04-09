import java.io.*;
import java.util.Scanner;

public class FilBehandling {

    //metode til at gemme alle ordre i et array til ordre.txt filen
    public static void gemOrdre(Ordre[] ordreArray){
        String filNavn = "ordrer.txt";
        try {
            PrintStream output = new PrintStream(filNavn);
            for(int i = 0; i < ordreArray.length; i++) {
                output.print(ordreArray[i].toString()+"\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // (Ikke færdig) metode til at returnere ordrer fra ordrer.txt som Ordre[]
    public static Ordre[] hentOrdrer(){
        String filNavn = "ordrer.txt";
        try {
            Ordre[] nytArray = new Ordre[tælLinjerIFil(filNavn)];
            Scanner linjeLæser = new Scanner(filNavn);
            for(int i = 0; i < nytArray.length;i++){

            }
        } catch (FileNotFoundException e){
            throw new RuntimeException();
        }
    }

    //tæller hvor mange linjer er i en fil, så vi ved hvor stort et array vi skal lave når vi henter fra fil
    public static int tælLinjerIFil(String filNavn) throws FileNotFoundException {
        File fil = new File(filNavn);
        Scanner scanner = new Scanner(fil);
        int linjer = 0;
        try {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                linjer++;
            }
        } finally {
            scanner.close();
        }
        return linjer;
    }


}


