package Exception.quartaB.Exceptions.SecretAlgorithm;

public class SecretAlgorithmExecutor {
    private DataContainer dataContainer;

    public SecretAlgorithmExecutor(int size) {
        dataContainer = new DataContainer(size);
    }

    public void executeAlgorithm(int iterations) throws EmptyListException, DataCorruptionException, CannotRemoveElementException, CriticalDataFailureException, InterruptedException {
        for (int i = 0; i < iterations; i++) {
            Thread.sleep(1000);
            System.out.println("SAlgo ITER " + (i + 1));
            double prob = Math.random();

            if (prob < 0.3) {
                System.out.println("Scambio elementi!");
                dataContainer.swapElements();
            } else if (prob < 0.8) {
                System.out.println("Corruption initiated...");
                dataContainer.corruptData();
            } else if (prob < 0.99) {
                System.out.println("Random event removal intiated...");
                dataContainer.removeRandomElement();
            } else {
                System.out.println("Corruption state check initiated...");
                dataContainer.resetIfCorrupted();
            }

            dataContainer.getInfo();
        }
    }
}
