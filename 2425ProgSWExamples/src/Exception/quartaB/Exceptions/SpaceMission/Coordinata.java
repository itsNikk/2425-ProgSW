package Exception.quartaB.Exceptions.SpaceMission;

public class Coordinata {
    private float x;
    private float y;

    public Coordinata(float y, float x) {

        if (x < 0 || y < 0)
            throw new IllegalArgumentException("Le coordinate devono essere entrambe positive");
        this.y = y;
        this.x = x;
    }

    public void move(float deltaX, float deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    @Override
    public String toString() {
        return "( " + x + " ," + y + " )";
    }
}
