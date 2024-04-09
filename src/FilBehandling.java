import java.io.*;
import java.util.Scanner;

public class FilBehandling {

    //metode til at gemme alle ordre i et array til ordre.txt filen
    public static void gemOrdre(Ordre[] ordreArray){
        String filepath = "ordre.txt";
        try {
            PrintStream output = new PrintStream(filepath);
            for(int i = 0; i < ordreArray.length; i++) {
                output.print(ordreArray[i].toString()+"\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}


