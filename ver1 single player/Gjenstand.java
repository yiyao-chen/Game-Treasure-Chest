class Gjenstand {
    String navn; 
    int verdi;

    public Gjenstand(String navn, int verdi) {
        this.navn = navn;
        this.verdi = verdi;
    }

    public String hentNavn() {
        return navn;
    }

    public int hentVerdi() {
        return verdi;
    }

    public String toString() {
        return navn + " " + verdi;
    }
}