package Exception.quartaA.Pandora;

public class RaidSimulator {
    private Avatar[] avatar;
    private PostazioneRDA postazione;

    public RaidSimulator(Avatar[] avatar, PostazioneRDA postazione) {
        this.avatar = avatar;
        this.postazione = postazione;
    }

    public void eseguiRaid() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("\n--- Inizio raid " + (i + 1) + " ---");
            for (Avatar a : avatar) {
                try {
                    a.attacca(postazione);
                } catch (AttaccoFallitoException | ArmaMalfunzionanteException e) {
                    System.out.println(e.getMessage());
                } catch (DifesaInsufficienteException e) {
                    System.out.println(e.getMessage());
                    postazione.spostaPostazione(new Coordinata(Math.random() * 180 - 90, Math.random() * 360 - 180));
                } catch (UnobtaniumEsauritoException e) {
                    System.out.println(e.getMessage());
                    postazione.spostaPostazione(new Coordinata(Math.random() * 180 - 90, Math.random() * 360 - 180));
                }
            }

            Thread.sleep(1000);

        }
    }
}
