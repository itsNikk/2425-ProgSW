package Exception.quartaB.Exceptions.SpaceMission;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Spaceship spaceship = new Spaceship("Eden", "Explorer", 5);
        Coordinata coordinata = new Coordinata(0, 0);
        MissionController missionController = new MissionController(100, coordinata, spaceship);

        System.out.println("Missione iniziata con " + spaceship.getNome());
        while (true) {
            try {
                missionController.travelWithRandomEvents(125);
            } catch (OutOfFuelException e) {
                System.out.println(e.getMessage());
                break;
            } catch (SpaceDebrisEncounterException e) {
                System.out.println(e.getMessage());
                spaceship.setBaseSpeed(spaceship.getBaseSpeed() / 2);
            } catch (SolarStormEncounteredException e) {
                System.out.println(e.getMessage());
                Thread.sleep(3000);
                spaceship.boostSpeed();
            }
        }
    }
}
