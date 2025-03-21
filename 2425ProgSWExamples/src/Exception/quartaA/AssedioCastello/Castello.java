package Exception.quartaA.AssedioCastello;

import Exception.quartaA.AssedioCastello.SiegeExceptions.ProvvisteEsauriteException;

public class Castello {
    private int difensori;
    private int provviste;

    public Castello(int difensori, int provviste) {
        this.difensori = difensori;
        this.provviste = provviste;
    }

    public void subisciAttacco(int danni) throws ProvvisteEsauriteException {
        difensori -= danni;
        provviste -= 5;
        if (provviste <= 0) {
            throw new ProvvisteEsauriteException("Le provviste del castello sono finite! Il castello si arrende.");
        }
    }

    public boolean isCaduto() {
        return difensori <= 0;
    }
}