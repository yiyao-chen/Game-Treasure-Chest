class VeivalgSted extends Sted {
    VeivalgSted[] utganger = new VeivalgSted[3]; // 3 veier: rettfrem, til venstre, til høyre

    public VeivalgSted(String beskrivelse) {
        super(beskrivelse);
    }

    public VeivalgSted[] hentUtganger() {
        return utganger;
    }
}