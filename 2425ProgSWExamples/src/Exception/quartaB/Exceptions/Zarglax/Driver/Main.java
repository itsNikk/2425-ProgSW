package Exception.quartaB.Exceptions.Zarglax.Driver;

public class Main {
    public static void main(String[] args) {
        try {
            DistributoreGalattico distributore = new DistributoreGalattico();
            distributore.opera();
        } catch (InterruptedException e) {
            System.out.println("\n🚨 Programma interrotto improvvisamente!");
        }
    }
}
