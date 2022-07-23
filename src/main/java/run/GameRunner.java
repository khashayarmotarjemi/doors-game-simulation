package run;

import agent.Agent;
import agent.Memory;
import game.DoorController;
import game.Game;
import game.model.Window;

import java.util.ArrayList;

public class GameRunner {
    final Counter counter;
    final ArrayList<Window> windowControllers;


    public GameRunner(Counter counter, ArrayList<Window> windowControllers) {
        this.counter = counter;
        this.windowControllers = windowControllers;
    }

    public void run(int inspection, int rounds) {
        final ArrayList<Agent> agents = new ArrayList<>();
        final ArrayList<DoorController> doorControllers = new ArrayList<>();

        Counter.clear(windowControllers.size() );

        int i =0;
        for (Window windowController: windowControllers) {
            final Memory mem = new Memory();
            final Agent agent = new Agent(i, mem);
            final DoorController doorController = new DoorController(windowController);

            agents.add(agent);
            doorControllers.add(doorController);

            i++;
        }

        final Game game = new Game(doorControllers, agents, counter);

        game.start(inspection, rounds);
    }
}
