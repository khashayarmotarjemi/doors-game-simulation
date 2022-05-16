package game;

import agent.Agent;
import game.state.StateGenerator;

public class Game {
    private final Agent agent;
    private final StateGenerator states;

    public Game(StateGenerator states, Agent agent) {
        this.agent = agent;
        this.states = states;
    }

    public void start() {
        final int steps = 100;

        for (int step = 0; step < steps; step++) {
            final int selectedDoorIndx = agent.select(states.current());
            final boolean result = evaluate(selectedDoorIndx);
            agent.updateMemory(selectedDoorIndx, result);
            states.next();
        }
    }

    public boolean evaluate(int doorIndx) {
        return Math.random() < states.current().doors[doorIndx].probability;
    }

}

