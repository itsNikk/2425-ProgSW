package quartaB;

public class Pasta extends Piatto {

    private Sugo sugo;
    private String tipoPasta;

    @Override
    public void prepara() {
        System.out.println("Si sta preparando la pasta " + tipoPasta + " con il sugo " + sugo.getNome());
    }
}
