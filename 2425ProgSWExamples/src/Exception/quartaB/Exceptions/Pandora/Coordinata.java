package Exception.quartaB.Exceptions.Pandora;

public class Coordinata {
    private double latitudine;
    private double longitudine;

    public Coordinata(double latitudine, double longitudine) {
        setLatitudine(latitudine);
        setLongitudine(longitudine);
    }

    public double getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(double latitudine) {
        if (latitudine < -90.0 || latitudine > 90.0) {
            throw new IllegalArgumentException("Latitudine non valida. Deve essere tra -90.0 e 90.0.");
        }

        this.latitudine = latitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(double longitudine) {
        if (longitudine < -180.0 || longitudine > 180.0) {
            throw new IllegalArgumentException("Longitudine non valida. Deve essere tra -180.0 e 180.0.");
        }

        this.longitudine = longitudine;
    }

    @Override
    public String toString() {
        return "(" + latitudine + ", " + longitudine + ")";
    }
}
