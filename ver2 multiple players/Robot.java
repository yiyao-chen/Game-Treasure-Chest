import java.util.Random;

class Robot implements Brukergrensesnitt{
    String resultatene = "";

    public void giStatus(String status) {
        System.out.println("\n" + status + "\n");
    }

    public int beOmKommando(String spoersmaal, String[] alternativer){
        System.out.println(spoersmaal);
        Random rand = new Random();
        
        int valg = rand.nextInt(alternativer.length);
        System.out.println("robotvalg: " + valg);
        return valg;
    }

}