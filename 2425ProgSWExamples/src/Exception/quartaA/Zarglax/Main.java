package Exception.quartaA.Zarglax;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Distributore distributore = new Distributore();

        while (true) {
            try {
                distributore.simulate();
            } catch (GelatoOverloadException goe) {
                System.out.println(goe.getMessage());
                distributore.enableCriogenicProtocol();
            }
        }
    }
}
