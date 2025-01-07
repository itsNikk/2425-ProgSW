package quartaB;

public abstract class Piatto {
    private String descrizione;


    public abstract void prepara();

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
