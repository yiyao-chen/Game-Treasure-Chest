import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Spill {
    static String resultat = "\nResultat: \n";
    public static void main(String[] args) throws FileNotFoundException{
        Scanner tastatur = new Scanner(System.in);
        
        Terreng terreng = new Terreng();
        Brukergrensesnitt bg = new Terminal(tastatur);
        String[] navnListe = {"Ole", "Kari", "Spiller", "Marta", "Ann", "Ben", "Jay"};

        int antTerminalBruker;
        int antRobotBruker;

        System.out.println("Antall terminal-brukere: ");
        antTerminalBruker = Integer.parseInt(tastatur.nextLine()); 
        
        System.out.println("Antall robot-brukere: ");
        antRobotBruker = Integer.parseInt(tastatur.nextLine()); 

        int antTraader = antTerminalBruker + antRobotBruker;
        CountDownLatch ferdigSignal = new CountDownLatch(antTraader);
        Lock laas = new ReentrantLock();


        for(int i= 0; i<antTerminalBruker; i++) {
            Spiller spiller = new Spiller(navnListe[i], terreng.hentStart(), bg, laas);
            new Thread(new Traad(spiller, ferdigSignal)).start();
        }


        bg = new Robot();

        for(int i= 0; i<antRobotBruker; i++) {
            Spiller spiller = new Spiller(navnListe[antTerminalBruker+i], terreng.hentStart(), bg, laas);
            new Thread(new Traad(spiller, ferdigSignal)).start();
        }

        try{
            ferdigSignal.await();
        } catch(InterruptedException e){
            System.out.println(e.getMessage());
        }

        System.out.println(resultat);
    }

    public static class Traad implements Runnable {
        Spiller s;
        private final CountDownLatch ferdigSignal;

        public Traad(Spiller s, CountDownLatch ferdigSignal) {
            this.s = s;
            this.ferdigSignal = ferdigSignal;
        }

        public void run(){    
            s.spill();
            resultat += s.skrivUtResultat();
            ferdigSignal.countDown(); 
            
        }
    }
}


