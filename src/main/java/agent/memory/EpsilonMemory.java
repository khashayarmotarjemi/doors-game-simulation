package agent.memory;

public class EpsilonMemory implements Memory {
    private final double[] probs;
    private final int doorCount;
    private final double epsilon = 0.001;


    public EpsilonMemory(int doorCount) {
        this.doorCount = doorCount;
        probs = new double[doorCount];

        for (int i = 0; i < doorCount; i++) {
            probs[i] = (double) 1 / doorCount;
        }
    }


    @Override
    public void update(int doorIndx, boolean won) {
        for (int i = 0; i < doorCount; i++) {
            if (i == doorIndx) {
                if (won) {
                    probs[i] += epsilon;
                } else {
                    probs[i] -= epsilon;
                }
            } else {
                if (won) {
                    probs[i] -= epsilon;
                } else {
                    probs[i] += epsilon;
                }
            }
        }
    }

    @Override
    public double[] get() {
        return probs;
    }
}
