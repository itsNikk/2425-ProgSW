package Exception.quartaB.Exceptions.SecretAlgorithm;

import java.util.ArrayList;

public class DataContainer {
    private ArrayList<Integer> list1;
    private ArrayList<Integer> list2;

    public DataContainer(int initialSize) {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();

        for (int i = 0; i < initialSize; i++) {
            list1.add((int) ((Math.random() * 100) + 1));
            list2.add((int) ((Math.random() * 100) + 1));
        }
    }


    public void getInfo() {
        System.out.println("Lista 1: " + list1);
        System.out.println("Lista 2: " + list2);
    }

    public void swapElements() throws EmptyListException {
        if (list1.isEmpty() || list2.isEmpty()) {
            throw new EmptyListException("Impossibile scambiare elementi. Una delle due liste è vuota");
        }

        int index1 = (int) (Math.floor(Math.random() * list1.size()));
        int index2 = (int) (Math.floor(Math.random() * list2.size()));

        int tempElem = list1.get(index1);
        list1.set(index1, list1.get(index2));
        list1.set(index2, tempElem);

    }

    public void corruptData() throws DataCorruptionException {
        if (list1.isEmpty() && list2.isEmpty())
            throw new DataCorruptionException("Impossibile corrompere i dati. Le lsite sono vuote");

        ArrayList<Integer> targetList = null;
        if (Math.random() < 0.5) targetList = list1;
        else targetList = list2;

        if (!targetList.isEmpty()) {
            int rndIndex = (int) (Math.random() * targetList.size());
            targetList.set(rndIndex, -1);
        }

        //Calcolare percentuale corruzione dati
        if (computeCorruptionRate(targetList) > 0.7)
            throw new DataCorruptionException("Troppi dati corrotti nella lista!");


    }

    public void removeRandomElement() throws CannotRemoveElementException {
        ArrayList<Integer> targetList = Math.random() < 0.5 ? list1 : list2;
        if (targetList.isEmpty()) {
            throw new CannotRemoveElementException("Impossibile rimuovere elementi: lista vuota.");
        }
        targetList.remove((int) (Math.random() * targetList.size()));
    }

    private double computeCorruptionRate(ArrayList<Integer> targetList) {
        if (targetList.isEmpty()) return 0;
        //Contare i -1
        int corruptedElemCount = 0;
        for (Integer i : targetList) if (i == -1) corruptedElemCount++;
        return (double) corruptedElemCount / targetList.size();
    }

    public void resetIfCorrupted() throws CriticalDataFailureException {
        if (computeCorruptionRate(list1) > 0.7) {
            list1.clear();
            for (int i = 0; i < 5; i++) list1.add((int) (Math.random() * 100) + 1);
            throw new CriticalDataFailureException("Lista 1 troppo corrotta, reset eseguito.");
        }
        if (computeCorruptionRate(list2) > 0.7) {
            list2.clear();
            for (int i = 0; i < 5; i++) list2.add((int) (Math.random() * 100) + 1);
            throw new CriticalDataFailureException("Lista 2 troppo corrotta, reset eseguito.");
        }
    }
}
