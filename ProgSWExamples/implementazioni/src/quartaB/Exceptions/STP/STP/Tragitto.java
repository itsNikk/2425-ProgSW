package quartaB.Exceptions.STP.STP;

public class Tragitto {
    private Fermata partenza;
    private Fermata arrivo;

    public Tragitto(Fermata partenza, Fermata arrivo) {
        this.partenza = partenza;
        this.arrivo = arrivo;
    }

    public Fermata getPartenza() {
        return partenza;
    }

    public Fermata getArrivo() {
        return arrivo;
    }
}
