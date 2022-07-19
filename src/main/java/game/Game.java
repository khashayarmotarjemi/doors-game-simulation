package game;

import agent.Agent;
import agent.Counter;

import java.util.ArrayList;

public class Game {
    private final ArrayList<Agent> agents;
    private final DoorController doorCtrl;
    public final Counter counter;

    public Game(DoorController controller, ArrayList<Agent> agent, Counter counter) {
        this.agents = agent;
        this.doorCtrl = controller;
        this.counter = counter;
    }

    public void start(int inspection, int rounds ) {

        for (int round = 0; round < rounds; round++) {
            doorCtrl.resetWindow();
            final GameState state = doorCtrl.getState();
            agents.forEach(agent -> {
                agent.reset(state.window);

                for (int step = 0; step < inspection; step++) {
                    final Door randomDoor = agent.randomSelect();
                    final boolean won = doorCtrl.evaluate(randomDoor.number);
                    agent.updateMemory(new Result(won, randomDoor.number));
                }

                agent.select();
            });

        }
    }

}

