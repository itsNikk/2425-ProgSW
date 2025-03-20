package Exception.quartaB.Exceptions.Ristorante;

import Exception.quartaB.Exceptions.Ristorante.RitoranteExceptions.BlackoutException;
import Exception.quartaB.Exceptions.Ristorante.RitoranteExceptions.IngredientiInsufficientiException;
import Exception.quartaB.Exceptions.Ristorante.RitoranteExceptions.RifornimentoAvvenutoException;

import java.util.ArrayList;

public class Ristorante {

    private int ingredientiDisponibili;
    private ArrayList<Piatto> menu;

    public Ristorante(int ingredientiDisponibili) {
        this.ingredientiDisponibili = ingredientiDisponibili;
        this.menu = new ArrayList<>();
        menu.add(new Piatto("Pasta", 5, 1000));
        menu.add(new Piatto("Carne", 7, 4300));
        menu.add(new Piatto("Dolce", 12, 5000));
    }

    // Throws = segnalare che un metodo potrebbe lanciare un certo gruppo di exc
    // throw = lancia l'eccezione
    public void serviPiatto(String piatto)
            throws BlackoutException, IngredientiInsufficientiException, InterruptedException, RifornimentoAvvenutoException {

        double prob = Math.random();
        if (prob < 0.1) {
            throw new BlackoutException("Si è verificato un BK");
        } else if (prob < 0.4) {
            throw new RifornimentoAvvenutoException("Arriva un rifornimento");
        }

        for (Piatto p : menu) {
            if (p.getNome().equals(piatto)) {
                //lo preparo se ho abbastanza ingredienti :)
                if (ingredientiDisponibili < p.getIngredientiNecessari()) {
                    throw new IngredientiInsufficientiException("Non ci sono abbastanza ingredienti per preparare " + p.getNome());
                } else {
                    // ingredientiDisponibili = ingredientiDisponibili - piatto.getIngredientiNecessari()
                    ingredientiDisponibili -= p.getIngredientiNecessari();
                    System.out.println("Sto preparando " + p.getNome() + "....");
                    Thread.sleep(p.getTempoDiPreparazione());
                    System.out.println("Servito " + p.getNome()
                            + ". Ingredienti rimanenti: " + ingredientiDisponibili);
                }
            }
        }
    }

    public void addIngredienti(int ingredientiDisponibili) {
        this.ingredientiDisponibili += ingredientiDisponibili;
    }

    public int getIngredientiDisponibili() {
        return ingredientiDisponibili;
    }
}
