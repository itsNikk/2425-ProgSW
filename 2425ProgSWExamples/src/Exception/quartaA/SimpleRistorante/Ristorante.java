package Exception.quartaA.SimpleRistorante;

import Exception.quartaA.SimpleRistorante.RistoranteExceptions.BlackoutException;
import Exception.quartaA.SimpleRistorante.RistoranteExceptions.IngredientiException;
import Exception.quartaA.SimpleRistorante.RistoranteExceptions.RIfornimentoException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ristorante {
    private List<Piatto> menu;

    private int ingredientiDisponibili;

    public Ristorante(int ingredientiDisponibili) {
        menu = new ArrayList<>();
        this.ingredientiDisponibili = ingredientiDisponibili;
        menu.add(new Piatto("Pasta", 1000, 5));
        menu.add(new Piatto("Dolce", 3500, 12));
        menu.add(new Piatto("Carne", 2500, 7));
    }

    public void simula(String piatto) throws BlackoutException, InterruptedException, IngredientiException, RIfornimentoException {

        //10%
        double prob = Math.random();
        if (prob < 0.1) {
            throw new BlackoutException("Si è verificato un BlackOut. stop per 7 secondi");
        }

        if (prob < 0.3) {
            throw new RIfornimentoException("Aggiungo ingredienti al ristorante");
        }

        if (menu.isEmpty()) {
            System.out.println("Il MENU è VUOUT");
        }

        for (Piatto p : menu) {
            if (p.getName().equals(piatto)) {
                if (ingredientiDisponibili > p.getIngredientiRichiesti()) {
                    //lo pre
                    ingredientiDisponibili -= p.getIngredientiRichiesti();
                    System.out.println("Sto preparando " + p.getName() + "...");
                    Thread.sleep(p.getTempoDiPreprazione());
                    System.out.println("Servo..." + p.getName() + "! Ingredienti disponibili: " + ingredientiDisponibili);
                } else {
                    throw new IngredientiException("Non ci sono abbastanza ingredienti per " + p.getName());
                }
            }
        }


    }

    public void updateIngredienti(int ingredientiDisponibili) {
        this.ingredientiDisponibili += ingredientiDisponibili;
    }
}
