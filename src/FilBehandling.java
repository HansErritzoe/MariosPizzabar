import java.io.*;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

public class FilBehandling {

    //metode til at gemme alle ordre i et Ordre[] til "Ordre.txt" filen
    //bruges når der er foretaget ændringer i Ordrer[] i main
    public static void gemOrdre(Ordre[] ordreArray){
        String filNavn = "src/Ordre.txt";
        try {
            PrintStream output = new PrintStream(filNavn);
            for(int i = 0; i < ordreArray.length; i++) {
                output.print(ordreArray[i].toString()+"\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //metode til at returnere Ordre[] fra Ordre.txt
    //køres ved program start fra main
    public static Ordre[] hentOrdrer(){
        String filNavn = "src/Ordre.txt";
        try {
            Ordre[] nytOrdreArray = new Ordre[tælLinjerIFil(filNavn)];
            Scanner filLæser = new Scanner(new File(filNavn));
            int ordreTæller = 0;
            while(filLæser.hasNextLine()){
                String linje = filLæser.nextLine();
                Scanner linjeLæser = new Scanner(linje);
                //useLocale US så den ikke klager over punktum i doubles
                linjeLæser.useLocale(Locale.US);
                int id = linjeLæser.nextInt();
                String tidspunkt = linjeLæser.next();
                //konverterer til LocalDateTime fra String
                LocalDateTime afhTid = Ordre.localDateTimeFraString(tidspunkt);
                double totalPris = linjeLæser.nextDouble();
                //kalder metode til at tælle antal pizzaer på linjen
                int antalPizzaer = tælPizzaPålinje(linje);
                Pizza[] pizzaArray = new Pizza[antalPizzaer];
                int pizzaTæller = 0;
                while(linjeLæser.hasNext()){
                    String pizzaNavn = linjeLæser.next();
                    Pizza nyPizza = new Pizza(pizzaNavn);
                    pizzaArray[pizzaTæller] = nyPizza;
                    pizzaTæller++;
                }
                Ordre nyOrdre = new Ordre(id,pizzaArray,afhTid);
                nytOrdreArray[ordreTæller] = nyOrdre;
                ordreTæller++;
            }
            return nytOrdreArray;
        } catch (FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException();

        }
    }

    //Metode der tæller hvor mange pizzaer er på en linje
    //bruges til at skabe korrekt Pizza[] størrelse ved filIndlæsning
    public static int tælPizzaPålinje(String linje){
        Scanner linjePizzaTæller = new Scanner(linje);
        int pizzaTæller = 0;
        while(linjePizzaTæller.hasNext()){
            linjePizzaTæller.next();
            pizzaTæller++;
        }
        //-3 fordi den først scanner ID, Tidspunkt og pris.
        return pizzaTæller-3;
    }

    //tæller hvor mange linjer er i en fil, så vi ved hvor stort et Ordre[] array vi skal lave når vi henter fra fil
    public static int tælLinjerIFil(String filNavn) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filNavn));
        int linjer = 0;
        try {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                linjer++;
            }
        } catch (Exception e){
            e.printStackTrace();
            throw new FileNotFoundException();
        }
        return linjer;
    }


}


