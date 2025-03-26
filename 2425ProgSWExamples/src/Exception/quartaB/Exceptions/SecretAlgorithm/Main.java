package Exception.quartaB.Exceptions.SecretAlgorithm;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SecretAlgorithmExecutor secretAlgorithmExecutor = new SecretAlgorithmExecutor(10);
        try {
            secretAlgorithmExecutor.executeAlgorithm(20);
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        } catch (DataCorruptionException e) {
            System.out.println(e.getMessage());
        } catch (CannotRemoveElementException e) {
            System.out.println(e.getMessage());
        } catch (CriticalDataFailureException e) {
            System.out.println(e.getMessage());
        }
    }
}
