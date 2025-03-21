package Exception.quartaA.AssedioCastello;

import java.util.Random;

class Soldato {
    private static final int FORZA_ATTACCO = 1;
    private int salute;

    public Soldato() {
        this.salute = 3; // Ogni soldato ha 3 punti vita
    }

    public int attacca() {
        return FORZA_ATTACCO;
    }

    public boolean subisciDanno() {
        if (Math.random() < 0.6) { // 30% di probabilità di essere ferito
            salute--;
            return salute <= 0; // Il soldato muore
        }
        return false;
    }
}
