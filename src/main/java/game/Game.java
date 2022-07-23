package game;

import agent.Agent;
import run.Counter;
import game.model.Door;
import game.model.GameState;
import game.model.Result;

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
            for (Agent agent : agents) {

                final DoorController doorController = doorCtrls.get(agents.indexOf(agent));

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

