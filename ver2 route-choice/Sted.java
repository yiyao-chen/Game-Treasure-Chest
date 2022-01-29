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

class VeivalgSted extends Sted {
    VeivalgSted[] utganger = new VeivalgSted[3]; // 3 veier: rettfrem, til venstre, til høyre

    public VeivalgSted(String beskrivelse) {
        super(beskrivelse);
    }

    public VeivalgSted[] hentUtganger() {
        return utganger;
    }
}