import java.util.Scanner;

class Terminal implements Brukergrensesnitt{
    
    Scanner scanner;

    public Terminal(Scanner scanner) {
        this.scanner = scanner;
    }
    

    public void giStatus(String status) {
        System.out.println("\n" + status + "\n");

    }

    public int beOmKommando(String spoersmaal, String[] alternativer){
        System.out.println(spoersmaal);

        for (int i = 0; i < alternativer.length; i++ ) {
            System.out.println(alternativer[i]);
        }

        int svar = Integer.parseInt(scanner.nextLine()); 
        
        return svar;
    }
}

