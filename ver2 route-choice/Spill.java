import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


public class Spill {

    public static void main(String[] args) throws FileNotFoundException{
        Scanner tastatur = new Scanner(System.in);
        
        Terreng terreng = new Terreng();
        Brukergrensesnitt bg = new Terminal(tastatur);

        System.out.println("0: Enkelt terreng \n1: Terreng med veivalg");
        int terrengValg = Integer.parseInt(tastatur.nextLine()); 

        if(terrengValg == 0) {
            Spiller spiller = new Spiller("Spiller", terreng.hentStart(), bg);
            spiller.spill();
        }
        else if (terrengValg == 1){
            terreng = new VeivalgTerreng();
            Spiller spiller = new VeivalgSpiller("Spiller", terreng.hentStart(), bg);
            spiller.spill();
        }

        tastatur.close();
       
    }
}

