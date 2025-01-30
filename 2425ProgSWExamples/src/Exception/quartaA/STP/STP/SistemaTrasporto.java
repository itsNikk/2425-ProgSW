package Exception.quartaA.STP.STP;

import java.util.ArrayList;
import java.util.List;

public class SistemaTrasporto {
    private List<Fermata> fermate = new ArrayList<>();
    private List<Tragitto> tratte = new ArrayList<>();

    public void aggiungiFermata(String nomeFermata) {
        fermate.add(new Fermata(nomeFermata));
    }

    public void aggiungiTragitto(String partenza, String destinazione) throws FermataNonTrovataException {
        Fermata fermataPartenza = cercaFermata(partenza);
        Fermata fermataArrivo = cercaFermata(destinazione);
        tratte.add(new Tragitto(fermataPartenza, fermataArrivo));
    }

    public void prenotaViaggio(String partenza, String destinazione, boolean bigliettoScaduto)
            throws FermataNonTrovataException, BigliettoScadutoException {
        if (bigliettoScaduto) {
            throw new BigliettoScadutoException("Il biglietto è scaduto.");
        }

        Fermata fermataPartenza = cercaFermata(partenza);
        Fermata fermataArrivo = cercaFermata(destinazione);

        boolean tragittoTrovato = false;
        for (Tragitto tragitto : tratte) {
            if (tragitto.getPartenza().equals(fermataPartenza) && tragitto.getArrivo().equals(fermataArrivo)) {
                tragittoTrovato = true;
                break;
            }
        }

        if (!tragittoTrovato) {
            throw new TragittoAnnullatoException("Il tragitto richiesto è stato annullato o non esiste.");
        }

        System.out.println("Viaggio prenotato con successo da " + partenza + " a " + destinazione);
    }

    public Fermata cercaFermata(String nomeFermata) throws FermataNonTrovataException {
        for (Fermata fermata : fermate) {
            if (fermata.getNome().equals(nomeFermata)) {
                return fermata;
            }
        }
        throw new FermataNonTrovataException("La fermata " + nomeFermata + " non è stata trovata.");
    }
}
