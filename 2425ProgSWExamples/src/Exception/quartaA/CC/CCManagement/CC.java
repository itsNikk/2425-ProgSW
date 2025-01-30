package Exception.quartaA.CC.CCManagement;

public class CC {
    private String nomeCorrentista;
    private double saldo;


    public CC(String nome, int initialAmount) {

        this.saldo = initialAmount;
    }

    public void preleva(double amount) throws SaldoInsufficienteException {
        if (amount >= saldo)
            throw new SaldoInsufficienteException("Impossibile prelevare " + amount + " euro. Saldo: " + saldo);
        this.saldo -= amount;
    }

    public void deposita(double amount) throws CifraNegativaException {
        if (amount < 0) throw new CifraNegativaException("Inerire cifra positiva per eseguire prelievo");
        this.saldo += amount;
    }

    public String getNomeCorrentista() {
        return nomeCorrentista;
    }

    public void setNomeCorrentista(String nomeCorrentista) {
        this.nomeCorrentista = nomeCorrentista;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
