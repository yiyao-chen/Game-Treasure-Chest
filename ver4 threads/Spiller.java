import java.util.Random;
import java.util.concurrent.locks.Lock;

class Spiller {
    String navn;
    Skattkiste ryggsekk = new Skattkiste(5); 
    Brukergrensesnitt bg;

    int trekk = 0;
    int totTrekk = 5;
    int formue = 0;
    
    Sted startsted;
    Sted erI; 
    Lock laas;


    public Spiller(String navn, Sted startsted, Brukergrensesnitt bg, Lock laas) {
        this.navn = navn;
        this.bg = bg;
        this.startsted = startsted;
        this.erI = startsted;
        this.laas = laas;
    }

    public void spill() {
        while(trekk < totTrekk) {
            nyttTrekk();
        }
    }

    public void nyttTrekk() {
        
        laas.lock();
        try {
            System.out.println("laast");
            
            bg.giStatus(navn +", "+ erI.hentBeskrivelse() + "Skattkisten inneholder: \n" + erI.skattkiste);

            if(erI.skattkiste.harPlass() && ! ryggsekk.erTom()){
            selgGjenstand();
            } 
            if(ryggsekk.harPlass() && !erI.skattkiste.erTom()) {
                plukkOppGjenstand();
            }

            erI = erI.utgang;
            trekk++;
        }finally {
            laas.unlock();
        }         
    }

    public void selgGjenstand(){
        
        int leggNed = bg.beOmKommando(navn +", "+ "Vil du selge en gjenstand?", new String[] {"0: Nei", "1: Ja"});

        if(leggNed == 1) {
            String[] alt = new String[ryggsekk.antallGjenstander()];

            for(int i = 0; i < ryggsekk.hentInnhold().length; i++){
                if(ryggsekk.hentInnhold()[i] != null) {
                    alt[i] = i + ": " + ryggsekk.hentInnhold()[i];
                    System.out.println(alt[i]);
                }
            }

            int indeks = bg.beOmKommando(navn +", "+ "Hva vil du selge?", alt);   
            formue += erI.hentSkattkiste().leggNed(ryggsekk.innhold[indeks]);
            ryggsekk.taUt(indeks);
        }
        
    }

    public void plukkOppGjenstand() {
        
        int plukkOpp = bg.beOmKommando(navn +", "+ "Vil du plukke opp en tilfeldig gjenstand?", new String[] {"0: Nei", "1: Ja"});
        if(plukkOpp == 1) {
            Random rand = new Random();
            
            int indeks = rand.nextInt(erI.hentSkattkiste().hentInnhold().length);

            while (erI.hentSkattkiste().hentInnhold()[indeks] == null) {
                indeks = rand.nextInt(erI.skattkiste.innhold.length);
            }

            System.out.println("\nDu plukket opp: " + erI.skattkiste.innhold[indeks]);

            ryggsekk.leggNed(erI.hentSkattkiste().hentInnhold()[indeks]);
            erI.hentSkattkiste().taUt(indeks);
            
        }
    }

    public String skrivUtResultat() {
        return "\nNavn: " + navn + " \nFormue: " + formue + "\n\n" ;
    }


}