package Exception.quartaA.SimpleRistorante;

public class Piatto {
    private long tempoDiPreprazione;
    private String name;
    private int ingredientiRichiesti;

    public Piatto(String name, long tempoDiPreprazione, int ingredientiRichiesti) {
        this.tempoDiPreprazione = tempoDiPreprazione;
        this.name = name;
        this.ingredientiRichiesti = ingredientiRichiesti;
    }

    public long getTempoDiPreprazione() {
        return tempoDiPreprazione;
    }

    public void setTempoDiPreprazione(long tempoDiPreprazione) {
        this.tempoDiPreprazione = tempoDiPreprazione;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIngredientiRichiesti() {
        return ingredientiRichiesti;
    }

    public void setIngredientiRichiesti(int ingredientiRichiesti) {
        this.ingredientiRichiesti = ingredientiRichiesti;
    }
}
