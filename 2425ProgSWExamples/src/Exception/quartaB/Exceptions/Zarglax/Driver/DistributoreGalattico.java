package Exception.quartaB.Exceptions.Zarglax.Driver;

import Exception.quartaB.Exceptions.Zarglax.ZarglaxExceptions.CosmicSugarStormException;
import Exception.quartaB.Exceptions.Zarglax.ZarglaxExceptions.GelatoOverloadException;
import Exception.quartaB.Exceptions.Zarglax.ZarglaxExceptions.RebellionException;
import Exception.quartaB.Exceptions.Zarglax.ZarglaxExceptions.ThermodynamicViolationException;

import java.util.Random;
import java.util.Scanner;

public class DistributoreGalattico {
    private double altezza;
    private int flavorIndex;
    private double temperatura;
    private int cicliSenzaEventi;

    private static final double ESPANSIONE = 2.5;
    private static final double ALTEZZA_MAX = 20.0;
    private static final double TEMP_MIN = -273.15;

    private static final String[] FLAVORS = {
            "Neutrino alla fragola quantica", "Antimateria alla vaniglia", "Quark al cioccolato oscuro"
    };
    private Random rand;

    public DistributoreGalattico() {
        this.altezza = 5.0;
        this.flavorIndex = 0;
        this.temperatura = -10.0;
        this.cicliSenzaEventi = 0;
        rand = new Random();
    }

    public void opera() throws InterruptedException {
        while (true) {
            try {
                simulaCiclo();
                stampaStato();
                Thread.sleep(1000);
            } catch (GelatoOverloadException e) {
                System.out.println("\n⚠️ GELATO OVERLOAD! Attivando compressione criogenica...");
                altezza /= 2;
            } catch (CosmicSugarStormException e) {
                System.out.println(e.getMessage());
                Thread.sleep(4000);
            } catch (ThermodynamicViolationException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            } catch (RebellionException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    private void stampaStato() {
        System.out.println("Stato: Aletezza = " + altezza + " m. | Sapore = " + FLAVORS[flavorIndex] + " | Temp = " + temperatura);
    }


    private void simulaCiclo() throws GelatoOverloadException, CosmicSugarStormException, ThermodynamicViolationException, RebellionException {
        altezza += ESPANSIONE;
        if (altezza > ALTEZZA_MAX) throw new GelatoOverloadException("Il distributore ha superato l'altezza massima");

        int evento = rand.nextInt(100);
        if (evento < 20) {
            flavorIndex = rand.nextInt(FLAVORS.length);
            System.out.println("🍦 Cambio di gusto: " + FLAVORS[flavorIndex]);
            cicliSenzaEventi = 0;
        } else if (evento < 35) {
            throw new CosmicSugarStormException("❄️ TEMPESTA DI ZUCCHERO SPAZIALE! Distributore congelato per 4 cicli...");
        } else if (evento < 40) {
            temperatura = TEMP_MIN - 1;
            throw new ThermodynamicViolationException("💥 PARADOSSO GELATINOSO! Violazione della termodinamica, reset del sistema...");
        } else {
            cicliSenzaEventi++;
        }

        if (cicliSenzaEventi > 7) {
            throw new RebellionException("🔥 GLI ZARGLAX SI RIBELLANO! Esplosione imminente... 💀");
        }
    }
}
