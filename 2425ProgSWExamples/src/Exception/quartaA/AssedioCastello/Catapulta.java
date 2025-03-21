package Exception.quartaA.AssedioCastello;

import Exception.quartaA.AssedioCastello.SiegeExceptions.MunizioniTerminateException;

class Catapulta {
    private final String name;
    private static final int DANNO = 2; //solo per avere un danno standard...
    private int munizioni;

    public Catapulta(String name, int munizioni) {
        this.name = name;
        this.munizioni = munizioni;
    }

    public int attacca() throws MunizioniTerminateException {
        if (munizioni <= 0) {
            throw new MunizioniTerminateException("La catapulta " + getName() + " ha esaurito le munizioni!");
        }
        munizioni--;
        return DANNO;
    }

    private String getName() {
        return name;
    }
}
