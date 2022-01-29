import java.util.Random;

class VeivalgSpiller extends Spiller{
    VeivalgSted veivalgStart;
    VeivalgSted erI;

    public VeivalgSpiller(String navn, Sted startsted, Brukergrensesnitt bg){
        super(navn, startsted, bg);
        
        VeivalgSted start = (VeivalgSted)startsted;
        veivalgStart = start;
        erI = veivalgStart;
    }

    @Override
    public void nyttTrekk(){
        

        bg.giStatus(navn +": " +erI.hentBeskrivelse() + "Skattkisten inneholder: \n" + erI.hentSkattkiste());

        if(erI.hentSkattkiste().harPlass() && ! ryggsekk.erTom()){
            selgGjenstand();
        }
        if(ryggsekk.harPlass()) {
            plukkOppGjenstand();
        }

        velgUtgang();        

        trekk++;
    }

    public void plukkOppGjenstand() {
        int plukkOpp = bg.beOmKommando(navn +", "+ "Vil du plukke opp en tilfeldig gjenstand?", new String[] {"0: Nei", "1: Ja"});
            
        if(plukkOpp == 1) {
            System.out.println("du er i");
            System.out.println(erI.hentBeskrivelse());
            
                Random rand = new Random();
                int indeks = rand.nextInt(erI.hentSkattkiste().hentInnhold().length);

                while (erI.hentSkattkiste().hentInnhold()[indeks] == null) {
                    System.out.println("i: " + indeks);
                    indeks = rand.nextInt(erI.hentSkattkiste().hentInnhold().length);
                }

                System.out.println("\nDu plukket opp: " + erI.hentSkattkiste().hentInnhold()[indeks]);

                ryggsekk.leggNed(erI.hentSkattkiste().hentInnhold()[indeks]);
                erI.hentSkattkiste().taUt(indeks);
            }
       
    }

    public void velgUtgang() {
        int indeks = bg.beOmKommando("\n"+navn +", hvor vil du gaa?", new String[] {"0: Rett frem", "1: Til venstre", "2: Til høyre"});
        erI = erI.hentUtganger()[indeks];       
    }
       
}