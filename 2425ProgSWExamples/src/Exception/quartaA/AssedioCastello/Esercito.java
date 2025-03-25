package Exception.quartaA.AssedioCastello;

import Exception.quartaA.AssedioCastello.SiegeExceptions.AttaccoRespintoException;
import Exception.quartaA.AssedioCastello.SiegeExceptions.MalattiaException;
import Exception.quartaA.AssedioCastello.SiegeExceptions.MunizioniTerminateException;

import java.util.ArrayList;

public class Esercito {
    private ArrayList<Soldato> soldati;
    private Catapulta[] catapulte;

    public Esercito(int numeroSoldati, int numeroCatapulte, int munizioniPerCatapulta) {
        this.soldati = new ArrayList<>();
        this.catapulte = new Catapulta[numeroCatapulte];
        for (int i = 0; i < numeroSoldati; i++) {
            this.soldati.add(new Soldato());
        }
        for (int i = 0; i < numeroCatapulte; i++) {
            this.catapulte[i] = new Catapulta("CAT-" + (i + 1), munizioniPerCatapulta);
        }
    }

    public int attacca() throws MalattiaException, MunizioniTerminateException, AttaccoRespintoException {
        if (Math.random() < 0.1) { // 10% di probabilità
            throw new MalattiaException("Una malattia colpisce l'esercito! Perdite tra le truppe.");
        }
        if (Math.random() < 0.2) { // 20% di probabilità
            throw new AttaccoRespintoException("I difensori hanno respinto l'attacco!");
        }

        int dannoTotale = 0;
        ArrayList<Soldato> sopravvissuti = new ArrayList<>();
        for (Soldato soldato : soldati) {
            dannoTotale += soldato.attacca();
            if (!soldato.subisciDanno()) {
                sopravvissuti.add(soldato);
            }
        }
        soldati = sopravvissuti;

        for (Catapulta catapulta : catapulte) {
            try {
                dannoTotale += catapulta.attacca();
            } catch (MunizioniTerminateException e) {
                System.out.println(e.getMessage());
            }
        }

        return dannoTotale;
    }

    public boolean isDistrutto() {
        return soldati.isEmpty();
    }
}
