package game;

import agent.Agent;

public class Game {
    private final Agent agent;
    private final DoorController doorCtrl;
    public final int[] selections;

    public Game(DoorController controller, Agent agent) {
        this.agent = agent;
        this.doorCtrl = controller;
        this.selections = new int[]{0, 0, 0, 0, 0};
    }

    public void start() {
        final int inspectionSteps = 10;
        final int rounds = 100;

        for (int round = 0; round < rounds; round++) {
            doorCtrl.resetWindow();
            final GameState state = doorCtrl.getState();
            agent.reset(state.window);

            for (int step = 0; step < inspectionSteps; step++) {
                final Door randomDoor = agent.randomSelect();
                final boolean won = doorCtrl.evaluate(randomDoor.number);
                agent.updateMemory(new Result(won, randomDoor.number));
            }

            final Door chosenDoor = agent.select();
            selections[chosenDoor.number - 1]++;
        }
    }
}

