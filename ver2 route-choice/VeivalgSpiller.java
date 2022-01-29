
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
        

        bg.giStatus(erI.hentBeskrivelse() + "Skattkisten inneholder: \n" + erI.hentSkattkiste());

        if(erI.hentSkattkiste().harPlass() && ! ryggsekk.erTom()){
            selgGjenstand();
        }
        if(ryggsekk.harPlass()) {
            plukkOppGjenstand();
        }

        velgUtgang();
        
        trekk++;
    }

    public void velgUtgang() {
        int indeks = bg.beOmKommando("\nHvor vil du gaa?", new String[] {"0: Rett frem", "1: Til venstre", "2: Til høyre"});
       
        erI = erI.hentUtganger()[indeks];
       
    }
       
}