import agent.Agent;
import agent.Counter;
import agent.Memory;
import game.DoorController;
import game.Game;
import helper.Constants;
import helper.WindowController;

import java.util.ArrayList;

public class GameRunner {
    final Counter counter;
    final ArrayList<WindowController> windowControllers;


    public GameRunner(Counter counter, ArrayList<WindowController> windowControllers) {
        this.counter = counter;
        this.windowControllers = windowControllers;
    }

    public void run(int inspection, int rounds) {
        final ArrayList<Agent> agents = new ArrayList<>();
        final ArrayList<DoorController> doorControllers = new ArrayList<>();

        Counter.clear();

        for (int i = 0; i < Constants.agentCount; i++) {
            final Memory mem = new Memory();
            final Agent agent = new Agent(i, mem);
            final DoorController doorController = new DoorController(windowControllers.get(i));

            agents.add(agent);
            doorControllers.add(doorController);
        }
//        final Memory mem1 = new Memory();
//        final Memory mem2 = new Memory();
//        final Agent agent1 = new Agent(0,mem1);
//        final Agent agent2 = new Agent(1,mem2);
//
//        agents.add(agent1);
//        agents.add(agent2);


//        final DoorController doorController = new DoorController(windowControllers);
        final Game game = new Game(doorControllers, agents, counter);

        game.start(inspection, rounds);
    }
}
