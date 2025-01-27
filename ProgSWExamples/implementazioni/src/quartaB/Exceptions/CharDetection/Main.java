package quartaB.Exceptions.CharDetection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Inserisci stringa:> ");
        String input = s.nextLine();

        System.out.println("Inserisci carattere da cercare:> ");
        char character = s.nextLine().charAt(0);

        boolean found = false;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == character) {
                found = true;
                break;
            }
        }

        if (!found) {
            try {
                throw new CharNotFoundException("Cararttere non trovato nella strigna " + input);
            } catch (CharNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }


    }
}
