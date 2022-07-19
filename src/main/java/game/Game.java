package game;

import agent.Agent;
import agent.Counter;

public class Game {
    private final Agent agent;
    private final DoorController doorCtrl;
    public final Counter counter;

    public Game(DoorController controller, Agent agent, Counter counter) {
        this.agent = agent;
        this.doorCtrl = controller;
        this.counter = counter;
    }

    public void start(int inspection, int rounds) {
//        final int inspectionSteps = 20;
//        final int rounds = 100;

        for (int round = 0; round < rounds; round++) {
            doorCtrl.resetWindow();
            final GameState state = doorCtrl.getState();
            agent.reset(state.window);

            for (int step = 0; step < inspection; step++) {
                final Door randomDoor = agent.randomSelect();
                final boolean won = doorCtrl.evaluate(randomDoor.number);
                agent.updateMemory(new Result(won, randomDoor.number));
            }

            final Door chosenDoor = agent.select();
            counter.addDoor(chosenDoor.number - 1);
        }
    }
}

