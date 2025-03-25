package Exception.quartaB.Exceptions.SpaceMission;

public class MissionController {
    private int fuelLevel;
    private Coordinata currentPosition;
    private Spaceship spaceship;

    public MissionController(int fuelLevel, Coordinata currentPosition, Spaceship spaceship) {
        this.fuelLevel = fuelLevel;
        this.currentPosition = currentPosition;
        this.spaceship = spaceship;
    }

    public void travelWithRandomEvents(int distanceToTravel) throws InterruptedException, OutOfFuelException, SpaceDebrisEncounterException, SolarStormEncounteredException {
        while (fuelLevel > 0 && distanceToTravel > 0) {
            Thread.sleep(1000);
            if (Math.random() < 0.3) {
                generateRandomEvent();
            }

            int speed = spaceship.getBaseSpeed();

            currentPosition.move(speed, speed);
            fuelLevel -= speed;
            distanceToTravel -= speed;

            showCurrentPosition();

            if (fuelLevel <= 0)
                throw new OutOfFuelException("Le riserve di carburante sono esaurite. Il viaggio termina");
        }
    }

    private void showCurrentPosition() {
        System.out.println("Posizione attuale: " + currentPosition + " | Velocità: " + spaceship.getBaseSpeed() + " | Carburante: " + fuelLevel);
    }

    private void generateRandomEvent() throws SpaceDebrisEncounterException, OutOfFuelException, SolarStormEncounteredException {
        double prob = Math.random();
        if (prob < 0.3) {
            throw new SpaceDebrisEncounterException("💥 Attenzione! Detriti spaziali rilevati.");
        } else if (prob < 0.6) {
            fuelLevel = 0;
            throw new OutOfFuelException("🚨 Il carburante si è esaurito improvvisamente!");
        } else {
            throw new SolarStormEncounteredException("🌪 Tempesta solare in corso! Sospensione del viaggio e attivazione del boost...");
        }
    }


}
