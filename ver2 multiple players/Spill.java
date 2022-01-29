import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;



public class Spill {

    static String resultat = "\nResultat: \n";

    public static void main(String[] args) throws FileNotFoundException{
        /*
        Terreng terreng = new Terreng();
        Brukergrensesnitt bg = new Robot();
        Spiller spiller = new Spiller("k", terreng.hentStart(), bg);
        spiller.spill();
        resultat += spiller.skrivUtResultat();
        System.out.println(resultat);
        */
        


        String[] navnListe = {"Ole", "Kari", "Spiller", "Marta", "Ann", "Ben", "Jay"};
        
        Scanner tastatur = new Scanner(System.in);
        
        Terreng terreng = new Terreng();
        Brukergrensesnitt bg = new Terminal(tastatur);

        int antTerminalBruker;
        int antRobotBruker;

        System.out.println("0: Enkelt terreng \n1: Terreng med veivalg");
        int terrengValg = Integer.parseInt(tastatur.nextLine()); 

        System.out.println("Antall terminal-brukere: ");
        antTerminalBruker = Integer.parseInt(tastatur.nextLine()); 

        System.out.println("Antall robot-brukere: ");
        antRobotBruker = Integer.parseInt(tastatur.nextLine()); 

        if(terrengValg == 0) {
            
            for(int i= 0; i<antTerminalBruker; i++) {
                Spiller spiller = new Spiller(navnListe[i], terreng.hentStart(), bg);
                spiller.spill();
                resultat += "Terminalspiller: "+spiller.skrivUtResultat();
            }

            
            bg = new Robot();

            for(int i= 0; i<antRobotBruker; i++) {
                Spiller spiller = new Spiller(navnListe[i+antTerminalBruker], terreng.hentStart(), bg);
                spiller.spill();
                resultat += "Robotspiller: "+spiller.skrivUtResultat();
            }
            
        }
        else if (terrengValg == 1){
            terreng = new VeivalgTerreng();
            
            for(int i= 0; i<antTerminalBruker; i++) {
                Spiller spiller = new VeivalgSpiller(navnListe[i], terreng.hentStart(), bg);
                spiller.spill();
                resultat += "Terminalspiller: "+spiller.skrivUtResultat();
            }

            bg = new Robot();

            for(int i= 0; i<antRobotBruker; i++) {
                Spiller spiller = new VeivalgSpiller(navnListe[i+antTerminalBruker], terreng.hentStart(), bg);
                spiller.spill();
                resultat += "Robotspiller: "+spiller.skrivUtResultat();
            }
      
        }

        System.out.println(resultat);
        tastatur.close();

        
       
    }

}

