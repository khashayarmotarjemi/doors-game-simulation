package agent.memory;

public class CountingMemory implements Memory {
    private final double[] probs;
    private final int doorCount;
    private final int[] winCount;
    private final int[] allTries;


    private void updateProbs() {
        for (int i = 0; i < doorCount; i++) {
            probs[i] = (double) winCount[i] / allTries[i];
        }
    }

    public CountingMemory(int doorCount) {
        this.doorCount = doorCount;
        probs = new double[doorCount];
        winCount = new int[doorCount];
        allTries = new int[doorCount];
        for (int i = 0; i < doorCount; i++) {
            winCount[i] = 0;
            allTries[i] = 0;
        }
    }


    @Override
    public void update(int doorIndx, boolean won) {
        allTries[doorIndx]++;
        if (won) {
            winCount[doorIndx]++;
        }
        updateProbs();
    }


    @Override
    public double[] get() {
        return probs;
    }
}
