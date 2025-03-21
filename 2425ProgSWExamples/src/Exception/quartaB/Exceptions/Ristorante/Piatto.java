package Exception.quartaB.Exceptions.Ristorante;

public class Piatto {
    private String nome;
    private int ingredientiNecessari;
    private long tempoDiPreparazione;

    public Piatto(String nome, int ingredientiNecessari, long tempoDiPreparazione) {
        this.nome = nome;
        this.ingredientiNecessari = ingredientiNecessari;
        this.tempoDiPreparazione = tempoDiPreparazione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIngredientiNecessari() {
        return ingredientiNecessari;
    }

    public void setIngredientiNecessari(int ingredientiNecessari) {
        this.ingredientiNecessari = ingredientiNecessari;
    }

    public long getTempoDiPreparazione() {
        return tempoDiPreparazione;
    }
}
