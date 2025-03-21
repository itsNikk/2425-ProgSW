package Exception.quartaB.Exceptions.Ristorante;

import Exception.quartaB.Exceptions.Ristorante.RitoranteExceptions.BlackoutException;
import Exception.quartaB.Exceptions.Ristorante.RitoranteExceptions.IngredientiInsufficientiException;
import Exception.quartaB.Exceptions.Ristorante.RitoranteExceptions.RifornimentoAvvenutoException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Ristorante ristorante = new Ristorante(30);

        while (true) {
            try {
                ristorante.serviPiatto("Pasta");
            } catch (BlackoutException blackoutException) {
                System.out.println(blackoutException.getMessage());
                break;
            } catch (IngredientiInsufficientiException iie) {
                System.out.println(iie.getMessage());
            } catch (RifornimentoAvvenutoException rae){
                System.out.println(rae.getMessage());
                ristorante.addIngredienti(5);
                System.out.println("Ingredienti disponibili: "+ristorante.getIngredientiDisponibili());
            }
        }
    }
}
