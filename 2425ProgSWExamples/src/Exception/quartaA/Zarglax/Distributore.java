package Exception.quartaA.Zarglax;

public class Distributore {
    private double height;
    private int flavorIndex;
    private double temperature;

    private final String[] FLAVORS = {"vaniglia", "cioccolato", "fragola", "menta", "anice"};
    private final int EXPAND_RATIO = 5;
    private final int MAX_HEIGHT = 25;
    private int cicliSenzaEventi;

    public Distributore() {
        this.cicliSenzaEventi = 0;
        this.height = 5.0;
        this.temperature = -10.0;
        this.flavorIndex = 0;
    }

    public void simulate() throws InterruptedException, GelatoOverloadException {
        if (height + EXPAND_RATIO < MAX_HEIGHT) {
            System.out.println("Sto espandendo il distributore...");
            height += (int) (Math.random() * (20 - 2)) + 2;
        } else throw new GelatoOverloadException("Altezza massima superata!!");

        double prob = Math.random();
        if (prob < 0.2) {
            flavorIndex = (int) (Math.random() * FLAVORS.length);
        } else if (prob < 0.35) {

        } else if (prob < 0.40) {

        } else {
            cicliSenzaEventi++;
        }

        System.out.println("Altezza: " + height + " | Gusto: " + FLAVORS[flavorIndex]);
        Thread.sleep(1000);
    }

    public void enableCriogenicProtocol() {
        this.height /= 2;
    }
}
