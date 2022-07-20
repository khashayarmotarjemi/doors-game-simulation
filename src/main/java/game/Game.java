package game;

import agent.Agent;
import agent.Counter;
import helper.Constants;

import java.util.ArrayList;

public class Game {
    private final ArrayList<Agent> agents;
    private final ArrayList<DoorController> doorCtrls;
    public final Counter counter;

    public Game(ArrayList<DoorController> controllers, ArrayList<Agent> agents, Counter counter) {
        this.agents = agents;
        this.doorCtrls = controllers;
        this.counter = counter;
    }

    public void start(int inspection, int rounds) {

        for (int round = 0; round < rounds; round++) {
            for (int i = 0; i < Constants.agentCount; i++) {
                final Agent agent = agents.get(i);
                final DoorController doorController = doorCtrls.get(i);

                doorController.resetWindow();
                final GameState state = doorController.getState();
                agent.reset(state.window);

                for (int step = 0; step < inspection; step++) {
                    final Door randomDoor = agent.randomSelect();
                    final boolean won = doorController.evaluate(randomDoor.number);
                    agent.updateMemory(new Result(won, randomDoor.number));
                }

                agent.select();

            }


        }
    }

}

