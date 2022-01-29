import java.io.FileNotFoundException;
import java.util.Scanner;

public class Spill {
    public static void main(String[] args) throws FileNotFoundException{
        Terreng terreng = new Terreng();
        Brukergrensesnitt bg = new Terminal(new Scanner(System.in));
        Spiller spiller = new Spiller("Ole", terreng.hentStart(), bg);

        spiller.spill();
       
    }
}

