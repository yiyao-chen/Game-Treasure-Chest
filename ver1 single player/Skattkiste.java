import java.util.concurrent.ThreadLocalRandom;
import java.lang.StringBuilder;

class Skattkiste {
    Gjenstand[] innhold; 

    public Skattkiste(int kapasitet){
        innhold = new Gjenstand[kapasitet];
    } 
    
    public boolean harPlass() {
        for(int i = 0; i < innhold.length; i++) {
            if(innhold[i] == null) {
                return true;
            }
        }
        return false;
    }

    public boolean erTom() {
        int teller = 0;
        for(int i = 0; i < innhold.length; i++) {
            if(innhold[i] == null) {
                teller++;
            }
        }
        return teller == innhold.length;
    }

    public int antallGjenstander() {
        int teller = 0;
        for(int i = 0; i < innhold.length; i++) {
            if(innhold[i] != null) {
                teller++;
            }
        }
        return teller;
    }

    public Gjenstand[] hentInnhold() {
        return innhold;
    }

    public Gjenstand taUt(int i) {
        Gjenstand g = innhold[i];
        innhold[i] = null;
        return g;
    }
    
    
    public int leggNed(Gjenstand g) {
        for(int i = 0; i < innhold.length; i++) {
            if(innhold[i] == null) {
                innhold[i] = g;
                int tilfeldigverdi = (int) ThreadLocalRandom.current().nextDouble(innhold[i].hentVerdi()*0.8, innhold[i].hentVerdi()*1.2);
                return tilfeldigverdi;
            }
        }

        return 0;
    }

    // Fylle opp skattekiste med et tilfeldig antall(>= 1) tilfeldige gjenstander
    public void fyllOpp(Gjenstand[] gjenstander){
        
        int antall = ThreadLocalRandom.current().nextInt(1, innhold.length+1); // minst 1 gjenstand skal legges inn
        int tilfeldigIndeks = ThreadLocalRandom.current().nextInt(gjenstander.length);

        for(int i = 0; i < antall; i++) {
            innhold[i] = gjenstander[tilfeldigIndeks];
            tilfeldigIndeks = ThreadLocalRandom.current().nextInt(gjenstander.length);
        }     
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        
        for(int i = 0; i<innhold.length; i++) {
            if(innhold[i] != null) {
                str.append(i + ": " + innhold[i] + "\n");
            }
        }

        return str.toString();
    }
     
}