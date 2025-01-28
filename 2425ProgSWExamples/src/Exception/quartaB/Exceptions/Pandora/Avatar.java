package Exception.quartaB.Exceptions.Pandora;

class Avatar {
    private String nome;
    private String arma;
    private int forzaAttacco;

    public Avatar(String nome, String arma, int forzaAttacco) {
        this.nome = nome;
        this.arma = arma;
        this.forzaAttacco = forzaAttacco;
    }

    public void attacca(PostazioneRDA postazione) throws AttaccoFallitoException, ArmaMalfunzionanteException, DifesaInsufficienteException, UnobtaniumEsauritoException {
        double probabilitaAttacco = Math.random();
        if (probabilitaAttacco < 0.3) { // 30% di probabilità che l'attacco fallisca
            throw new AttaccoFallitoException(nome + " ha fallito l'attacco!");
        }

        double probabilitaArma = Math.random();
        if (probabilitaArma < 0.2) { // 20% di probabilità che l'arma si guasti
            throw new ArmaMalfunzionanteException("L'arma di " + nome + " ha malfunzionato durante l'attacco!");
        }
        System.out.println(nome + " esegue l'attacco! (forza: " + forzaAttacco + ")");
        postazione.difendi(forzaAttacco);
    }
}