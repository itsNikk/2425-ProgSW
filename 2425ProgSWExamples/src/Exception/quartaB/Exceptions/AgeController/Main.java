package quartaB.Exceptions.AgeController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        try {
            int age = s.nextInt();
            checkAge(age);
        } catch (InputMismatchException e) {
            System.out.println("Hai inserito un valore che non è un intero.");
            System.out.println(e.getMessage());
        } catch (InvalidAgeException invalidAgeException) {
            System.out.println(invalidAgeException.getMessage());
        }

    }

    private static void checkAge(int age) {
        if (age < 18) throw new InvalidAgeException("Il soggetto è minorenne. Non può guidare");
        System.out.println("Soggetto maggiorenne. Può guidare");
    }

}
