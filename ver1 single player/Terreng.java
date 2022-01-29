import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Terreng {

    Sted start;
    Skattkiste[] kister;
    Gjenstand[] lager = new Gjenstand[100]; // midlertidig lager for gjenstander
    Gjenstand[] gjenstander;
    Scanner scanner;

    int teller = 0; // telle antall steder for å vite hvor mange skattekister vi trenger å opprette

    public Terreng() throws FileNotFoundException{
        opprettSteder();
        opprettSkattkister();
        fyllOppSkattkister();
        plasserSkattkister();
    }

    public void opprettSteder() throws FileNotFoundException {
        scanner = new Scanner(new File("steder.txt"));
        start = new Sted(scanner.nextLine());
        teller = 2;
        start.utgang = new Sted(scanner.nextLine());
        Sted neste = start.utgang;

        while(scanner.hasNextLine()) {
            neste.utgang = new Sted(scanner.nextLine());
            neste = neste.utgang;
            teller++;
        }
        scanner.close();
    }

    public void opprettSkattkister() {
        kister = new Skattkiste[teller];
        for(int i = 0; i < kister.length; i++) {
            kister[i] = new Skattkiste(3); // Hver skattkiste skal ha plass til maks 3 gjenstander
        }
    }

    // Fylle opp alle skattekister med gjenstander
    public void fyllOppSkattkister() throws FileNotFoundException{
        scanner = new Scanner(new File("gjenstander.txt"));
        teller = 0;
        
        String linje;
        String[] biter;
        Gjenstand g;

        while(scanner.hasNextLine()) {
            linje = scanner.nextLine();
            biter = linje.split(" ");
            g = new Gjenstand(biter[0], Integer.parseInt(biter[1]));
            lager[teller] = g;
            teller++;
        }

        gjenstander = new Gjenstand[teller];

        for(int i = 0; i<lager.length; i++) {
            if(lager[i] != null) {
                gjenstander[i] = lager[i];
            }
        }

        for(int i = 0; i<kister.length; i++) {
            kister[i].fyllOpp(gjenstander);
        }

        scanner.close();
    }
    
    // Plasser en skattekiste på hvert sted
    public void plasserSkattkister() {
        teller = 0;
        Sted sted = start;

        while(sted.utgang != null) {
            sted.plasserSkattkiste(kister[teller]);
            sted = sted.nesteSted();
            teller++;
        }
    }
    
    

    public Sted hentStart() {
        return start;
    }
    
}