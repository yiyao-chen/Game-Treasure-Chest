import java.util.Random;

class Spiller {
    String navn;
    Skattkiste ryggsekk = new Skattkiste(5); // sekken har plass til 5 gjenstander
    Brukergrensesnitt bg;

    int trekk = 0; // teller antall trekk
    int totTrekk = 5;
    int formue = 0;
    
    Sted startsted;
    Sted erI; // stedet man er i


    public Spiller(String navn, Sted startsted, Brukergrensesnitt bg) {
        this.navn = navn;
        this.bg = bg;
        this.startsted = startsted;
        this.erI = startsted;
    }

    public void spill() {
        while(trekk < totTrekk) {
            nyttTrekk();
        }
    }

    public void nyttTrekk() {

        bg.giStatus(navn + ", " + erI.hentBeskrivelse() + "Skattkisten inneholder: \n" + erI.hentSkattkiste());

        if(erI.skattkiste.harPlass() && ! ryggsekk.erTom()){
            selgGjenstand();
        }
        if(ryggsekk.harPlass()) {
            plukkOppGjenstand();
        }
        erI = erI.utgang;
        trekk++;
    }

    public void selgGjenstand(){
        int leggNed = bg.beOmKommando(navn +", "+ "vil du selge en gjenstand?", new String[] {"0: Nei", "1: Ja"});
            
            if(leggNed == 1) {
                String[] alt = new String[ryggsekk.antallGjenstander()];

                for(int i = 0; i < ryggsekk.hentInnhold().length; i++){
                    if(ryggsekk.hentInnhold()[i] != null) {
                        alt[i] = i + ": " + ryggsekk.hentInnhold()[i];
                        
                    }
                }

                int indeks = bg.beOmKommando("\nHva vil du selge?", alt);   
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
                    indeks = rand.nextInt(erI.hentSkattkiste().hentInnhold().length);
                }

                System.out.println("\nDu plukket opp: " + erI.hentSkattkiste().hentInnhold()[indeks]);
                ryggsekk.leggNed(erI.hentSkattkiste().hentInnhold()[indeks]);
                erI.hentSkattkiste().taUt(indeks);
            }
       
    }

    public String skrivUtResultat() {
        return "\nNavn: " + navn + " \nFormue: " + formue + "\n\n" ;
    }


}

