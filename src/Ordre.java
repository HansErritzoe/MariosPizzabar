import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Scanner;

public class Order {
    Pizza[] pizzas;
    int OrdreNr;
    double pris;
    LocalDateTime afhTids;

    public Order (int OrdreNr, Pizza[] pizzas, double pris, LocalDateTime afhTids){
        this.pizzas=pizzas;
        this.OrdreNr=OrdreNr;
        this.afhTids=afhTids;
        this.pris=pris;
    }
    public double samletpris( ){
        double Totalpris=0.0;
        for (int i=0; i<this.pizzas.length;i++) {
            Totalpris += pizzas[i].getPris();
        }
        return Totalpris;
    }

    public String ToString(){
        return (OrdreNr +" "+ afhTids + " " + Totalpris + );
    }


}
