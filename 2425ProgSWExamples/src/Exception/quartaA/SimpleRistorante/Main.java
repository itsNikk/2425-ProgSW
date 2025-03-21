package Exception.quartaA.SimpleRistorante;

import Exception.quartaA.SimpleRistorante.RistoranteExceptions.BlackoutException;
import Exception.quartaA.SimpleRistorante.RistoranteExceptions.IngredientiException;
import Exception.quartaA.SimpleRistorante.RistoranteExceptions.RIfornimentoException;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Ristorante r = new Ristorante(25);

        while (true) {
            try {
                //TODO: randomizzate il piatto da preparare!
                r.simula("Pasta");
            } catch (BlackoutException e) {
                System.out.println(e.getMessage());
                break;
            } catch (IngredientiException e) {
                System.out.println(e.getMessage());
            } catch (RIfornimentoException ri){
                System.out.println(ri.getMessage());
                r.updateIngredienti(7);
            }
        }
    }
}
