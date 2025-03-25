package Exception.quartaA.AssedioCastello;

import Exception.quartaA.AssedioCastello.SiegeExceptions.AttaccoRespintoException;
import Exception.quartaA.AssedioCastello.SiegeExceptions.MalattiaException;
import Exception.quartaA.AssedioCastello.SiegeExceptions.MunizioniTerminateException;
import Exception.quartaA.AssedioCastello.SiegeExceptions.ProvvisteEsauriteException;

public class Main {
    public static void main(String[] args) {
        Esercito assedianti = new Esercito(50, 5, 5);
        Castello castello = new Castello(700, 500);

        System.out.println("Inizio assedio!");
        int turni = 0;

        while (!assedianti.isDistrutto() && !castello.isCaduto()) {
            turni++;
            System.out.println("Turno " + turni);

            try {
                int danni = assedianti.attacca();
                castello.subisciAttacco(danni);
                System.out.println("L'assedio continua! Danni inflitti: " + danni);
            } catch (MalattiaException | MunizioniTerminateException | AttaccoRespintoException e) {
                System.out.println(e.getMessage());
            } catch (ProvvisteEsauriteException e) {
                System.out.println(e.getMessage());
                break;
            }
        }

        if (castello.isCaduto()) {
            System.out.println("Il castello è caduto! L'assedio ha avuto successo.");
        } else {
            System.out.println("Gli assedianti si sono ritirati. Il castello resiste!");
        }
    }
}
