package agent.memory;

public interface Memory {
    void update(int doorIndex, boolean result);

    double[] get();
}
