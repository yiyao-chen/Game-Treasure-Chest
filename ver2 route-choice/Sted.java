class Sted {
    String beskrivelse;
    Skattkiste skattkiste;
    Sted utgang;

    public Sted(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public void plasserSkattkiste(Skattkiste s) {
        skattkiste = s;
    }

    public Skattkiste hentSkattkiste() {
        return skattkiste;
    }

    public String hentBeskrivelse() {
        return beskrivelse;
    }

    public Sted hentUtgang() {
        return utgang;
    }

}

