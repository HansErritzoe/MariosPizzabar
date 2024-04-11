import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ordre implements Comparable<Ordre>{
    Pizza[] pizzaArray;
    int ordreNr;
    double totalPris;
    LocalDateTime afhTid;

    //Constructor som tager imod afhentningstidspunkt som String i format "hh mm" (fx "15 45")
    //til brug i UI ved tilføj ordre
    public Ordre (int ordreNr, Pizza[] pizzaArray, String afhTid){
        this.pizzaArray=pizzaArray;
        this.ordreNr=ordreNr;
        this.totalPris = samletpris(pizzaArray);
        this.afhTid=localDateTimefraKlokkeSlæt(afhTid);
    }
    public int compareTo (Ordre ord){
        int comparDato = this.afhTid.toLocalDate().compareTo(ord.afhTid.toLocalDate());
        if (comparDato==0){
            return this.afhTid.toLocalTime().compareTo(ord.afhTid.toLocalTime());
        }
        return comparDato;
    } //end method compareTo

    public  int getOrdreNr(){
        return this.ordreNr;
    }


    //Constructor som tager imod afhentningstidspunkt som LocalDateTime objekt
    //til brug ved filindlæsning
    public Ordre(int ordreNr, Pizza[] pizzaArray, LocalDateTime afhTid){
        this.pizzaArray=pizzaArray;
        this.ordreNr=ordreNr;
        this.totalPris = samletpris(pizzaArray);
        this.afhTid=afhTid;
    }

    //metode som returnerer samlet pris for pizzaer i denne ordre.
    public double samletpris(Pizza[] array){
        double totalPris=0.0;
        for (Pizza pizza : array) {
            totalPris += pizza.getPris();
        }
        return totalPris;
    }

    public String toString(){
        //formaterer LocalDateTime objektet til ønsket format
        String datoformat = stringFraLocalDateTime(this.afhTid);
        //bygger en String med alle pizzaerne i ordrens pizzaArray
        StringBuilder pizzaListe = new StringBuilder();
        for(Pizza pizza : pizzaArray){
            pizzaListe.append(pizza.getNavn() + " ");
        }
        return this.ordreNr + " " + datoformat + " " + this.totalPris + " " + pizzaListe; // to be done
    }

    //metode som tager imod en String med klokkeslæt i format fx "15 45" og laver et localDateTime objekt
    public static LocalDateTime localDateTimefraKlokkeSlæt(String klokkeslæt){
        //henter nuværende dato og tid.
        LocalDateTime nuværendeDateTime = LocalDateTime.now();
        //aflæser klokkeslæt
        Scanner scanner = new Scanner(klokkeslæt);
        int timer = scanner.nextInt();
        int minutter = scanner.nextInt();
        //combinerer nuværende dato med ønskede klokkeslæt
        LocalDateTime ønsketDateTime = nuværendeDateTime.withHour(timer).withMinute(minutter);
        return ønsketDateTime;
    }

    //metode som tager imod en LocalDateTime objekt og returnerer en string med det ønskede format
    public static String stringFraLocalDateTime(LocalDateTime datoObjekt){
        //definerer ønsket format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd-yyyy-HH:mm");
        //formaterer objektet til ønsket string format
        String formateretTid = datoObjekt.format(formatter);
        return formateretTid;
    }

    //metode som tager imod "MM/dd-yyyy-HH:mm" som string og skaber et LocalDateTime objekt ud fra det
    //til brug ved indlæsning af ordrer fra fil.
    public static LocalDateTime localDateTimeFraString(String tidspunkt){
        // Definerer formattet der skal formateres
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd-yyyy-HH:mm");
        // Laver LocalDateTime objektet ud fra Stringen og formattet
        return LocalDateTime.parse(tidspunkt, formatter);
    }
}
