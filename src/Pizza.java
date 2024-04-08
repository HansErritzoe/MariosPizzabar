public class Pizza {

    private String navn;
    private double pris;

    public Pizza (String navn, double pris){
        this.navn=navn;
        this.pris=pris;
    }

    public String toString(){

        return (navn + ": " + pris);
    }
}
