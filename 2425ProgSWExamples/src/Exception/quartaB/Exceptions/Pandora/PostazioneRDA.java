package Exception.quartaB.Exceptions.Pandora;

public class PostazioneRDA {
    private Coordinata posizione;
    private int difesa;
    private int unobtanium;

    public PostazioneRDA(Coordinata posizione, int difesa, int unobtanium) {
        this.posizione = posizione;
        this.difesa = difesa;
        this.unobtanium = unobtanium;
    }

    public void difendi(int attacco) throws DifesaInsufficienteException, UnobtaniumEsauritoException {
        if (unobtanium <= 0) {
            throw new UnobtaniumEsauritoException("Le miniere di unobtanium sono esaurite! Spostare la postazione.");
        }

        if (difesa < attacco) {
            throw new DifesaInsufficienteException("Difesa insufficiente. La postazione deve essere spostata.");
        }

        difesa -= attacco;
        unobtanium--;
        System.out.println("Postazione difesa con successo. Difesa rimanente: " + difesa + ", Unobtanium rimasto: " + unobtanium);
    }

    public void spostaPostazione(Coordinata nuovaPosizione) {
        posizione = nuovaPosizione;
        difesa = (int) (Math.random() * 100) + 50; // Nuova difesa random tra 50 e 150
        unobtanium = (int) (Math.random() * 10) + 1; // Nuovo unobtanium tra 1 e 10
        System.out.println("Postazione spostata a " + posizione + ". Nuova difesa: " + difesa + ", Unobtanium: " + unobtanium);
    }

    @Override
    public String toString() {
        return "Posizione: " + posizione + ", Difesa: " + difesa + ", Unobtanium: " + unobtanium;
    }
}
