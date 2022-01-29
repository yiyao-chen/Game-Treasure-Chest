import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


class VeivalgTerreng extends Terreng {

    VeivalgSted start;
    public static VeivalgSted[] lager = new VeivalgSted[100];
    public static VeivalgSted[] steder;
    
    public VeivalgTerreng() throws FileNotFoundException {
        super();
    }
    
    @Override
    public void opprettSteder() throws FileNotFoundException {
        scanner = new Scanner(new File("steder.txt"));
        start = new VeivalgSted(scanner.nextLine());

    
        start.utganger[0] = new VeivalgSted(scanner.nextLine());
        VeivalgSted neste = start.hentUtganger()[0];
        teller = 2;
        lager[0] = start; 
        lager[1] = neste;

        while(scanner.hasNextLine()) {
            neste.hentUtganger()[0] = new VeivalgSted(scanner.nextLine());
            neste = neste.hentUtganger()[0];
            lager[teller] = neste;
            teller++;
        }

        steder = new VeivalgSted[teller];
        for(int i = 0; i<lager.length; i++) {
            if(lager[i] != null) {
                steder[i] = lager[i];
            }
        }

        leggTilNaboer();
        scanner.close();
    }

    public void leggTilNaboer() {
        Random rand = new Random();
        int indeks;

        for(int i = 0; i < steder.length; i++) {
            indeks = rand.nextInt(steder.length);
            
            steder[i].hentUtganger()[1] = steder[indeks];
            indeks = rand.nextInt(steder.length);
        
            steder[i].hentUtganger()[2] = steder[indeks];
        }
    }

    @Override 
    public void plasserSkattkister() {
        teller = 0;
        VeivalgSted sted = start;

        while(sted.hentUtganger()[0] != null) {
            sted.plasserSkattkiste(kister[teller]);
            sted = sted.hentUtganger()[0];
            teller++;
        }
    }

    public VeivalgSted hentStart() {
        return start;
    }
}
