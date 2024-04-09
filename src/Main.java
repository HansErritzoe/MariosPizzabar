import java.io.*;
import java.util.*;
public class Main {

    //henter nuværende ordrer og færdige ordrer når programmet starter op fra filer
    public static Ordre[] ordrer = FilBehandling.hentOrdrer();
    //public static Ordre[] færdigeOrdrer = FilBehandling.hentFærdigeOrdrer(); //to be done

    //scanner til genbrug i hele koden
    public static final Scanner brugerInput = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        UI.hovedMenu();
    }

}
