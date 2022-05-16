package agent.memory;

import java.util.Deque;
import java.util.LinkedList;

public class SimpleMemory implements Memory {
    private static final int maxMemEvents = 20;
    private double[] probs;
    private int doorCount;

    /***
     * The events are represented in integer
     * the selected door number denotes the door number!
     * and the sign represents if the selection
     * was correct or not (the agent won or lost)
     * like so:
     *  1 : the first door was selected ,and it was correct
     * -1 : the first door was selected ,and it was incorrect
     */
    private Deque<Integer> events = new LinkedList<>();


    private double[] updateProbs() {
        //TODO should return the probability distribution based on the events list
        // returns equal probabilities now
        double[] probabilities = new double[doorCount];
        for (int i = 0; i < doorCount; i++) {
            probabilities[i] = 1.0 / doorCount;
        }

        probs = probabilities;
        return probabilities;
    }

    public SimpleMemory(int doorCount) {
        this.doorCount = doorCount;
        probs = new double[doorCount];
    }


    @Override
    public void update(int doorIndx, boolean result) {
        int event = result ? doorIndx + 1 : -(doorIndx + 1);
        events.add(event);
        updateProbs();
    }


    @Override
    public double[] get() {
        return probs;
    }
}
