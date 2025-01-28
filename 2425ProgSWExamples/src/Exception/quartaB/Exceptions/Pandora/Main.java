package Exception.quartaB.Exceptions.Pandora;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Avatar[] avatar = {
                new Avatar("Jake", "Arco", 30),
                new Avatar("Neytiri", "Lancia", 40),
                new Avatar("Tsu'Tey", "Ascia", 35)
        };

        PostazioneRDA postazione = new PostazioneRDA(new Coordinata(0, 0), 10, 3);

        RaidSimulator simulator = new RaidSimulator(avatar, postazione);

        System.out.println("Posizione iniziale postazione RDA:" + postazione);

        simulator.eseguiRaid();
    }
}
