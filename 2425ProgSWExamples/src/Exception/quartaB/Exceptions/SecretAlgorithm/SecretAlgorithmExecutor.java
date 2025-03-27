package Exception.quartaB.Exceptions.SecretAlgorithm;

public class SecretAlgorithmExecutor {
    private DataContainer dataContainer;
    private final int SIM_SPEED = 5;

    public SecretAlgorithmExecutor(int size) {
        dataContainer = new DataContainer(size);
    }

    public void executeAlgorithm(int iterations) throws EmptyListException, DataCorruptionException, CannotRemoveElementException, CriticalDataFailureException, InterruptedException {
        for (int i = 0; i < iterations; i++) {
            Thread.sleep(SIM_SPEED);
            System.out.println("S.E.C.R.E.T. A.L.G.O. ITER " + (i + 1));
            double prob = Math.random();

            if (prob < 0.6) {
                System.out.println("Corruption initiated...");
                dataContainer.corruptData();
            } else if (prob < 0.9) {
                System.out.println("Scambio elementi!");
                dataContainer.swapElements();
            }

            double p2 = Math.random();
            if (p2 < 0.7) {
                System.out.println("Check corruption state initiated..");
                dataContainer.resetIfCorrupted();
            } else {
                System.out.println("Random rem initiated..");
                dataContainer.removeRandomElement();
            }

            dataContainer.getInfo();
        }
    }
}
