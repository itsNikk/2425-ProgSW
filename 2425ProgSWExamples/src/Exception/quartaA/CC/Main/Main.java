package Exception.quartaA.CC.Main;

import Exception.quartaA.CC.CCManagement.CC;
import Exception.quartaA.CC.CCManagement.CifraNegativaException;
import Exception.quartaA.CC.CCManagement.SaldoInsufficienteException;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        CC cc = new CC("Andrea Rossi", 1500);
        Random r = new Random();

        for (int i = 0; i < 1000; i++) {
            System.out.println("Iterazione " + (i + 1));
            boolean rndNum = r.nextBoolean();
            int amount;
            if (rndNum) {
                try {
                    amount = r.nextInt(100, 1000);
                    cc.preleva(amount);
                    System.out.println("Prelevato " + amount + ". Saldo: " + cc.getSaldo());
                } catch (SaldoInsufficienteException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                try {
                    amount = r.nextInt(100, 1000);
                    cc.deposita(amount);
                    System.out.println("Depositato " + amount + ". Saldo: " + cc.getSaldo());
                } catch (CifraNegativaException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
