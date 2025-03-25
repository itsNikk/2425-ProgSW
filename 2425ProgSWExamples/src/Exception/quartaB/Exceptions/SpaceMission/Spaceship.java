package Exception.quartaB.Exceptions.SpaceMission;

public class Spaceship {
    private String nome;
    private String tipo;
    private int baseSpeed;

    public Spaceship(String nome, String tipo, int baseSpeed) {
        this.nome = nome;
        this.tipo = tipo;
        this.baseSpeed = baseSpeed;
    }

    public void boostSpeed() {
        this.baseSpeed *= 2;
    }

    @Override
    public String toString() {
        return nome + ", " + tipo + ": Velocità " + baseSpeed;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getBaseSpeed() {
        return baseSpeed;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setBaseSpeed(int baseSpeed) {
        this.baseSpeed = baseSpeed;
    }
}
