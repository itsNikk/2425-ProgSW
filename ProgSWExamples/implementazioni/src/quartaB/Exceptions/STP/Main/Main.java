package quartaB.Exceptions.STP.Main;

import quartaB.Exceptions.STP.STP.*;

public class Main {
    public static void main(String[] args) {
        SistemaTrasporto sistema = new SistemaTrasporto();

        try {
            sistema.aggiungiFermata("Fermata A");
            sistema.aggiungiFermata("Fermata B");
            sistema.aggiungiFermata("Fermata C");

            sistema.aggiungiTragitto("Fermata A", "Fermata B");
            sistema.aggiungiTragitto("Fermata B", "Fermata C");

            // Prenotazione di un viaggio valido
            sistema.prenotaViaggio("Fermata A", "Fermata B", false);

            // Prenotazione con biglietto scaduto
            sistema.prenotaViaggio("Fermata B", "Fermata C", true);
        } catch (FermataNonTrovataException e) {
            System.err.println("Errore Fermata: " + e.getMessage());
        } catch (BigliettoScadutoException e) {
            System.err.println("Errore Biglietto: " + e.getMessage());
        } catch (TragittoAnnullatoException e) {
            System.err.println("Errore TragAnnullato: " + e.getMessage());
        } catch (InputNonValidoException e) {
            System.err.println("Errore INV: " + e.getMessage());
        }

        // Test con fermata non trovata
        try {
            sistema.prenotaViaggio("Fermata X", "Fermata Y", false);
        } catch (Exception e) {
            System.err.println("Errore: " + e.getMessage());
        }
    }
}
