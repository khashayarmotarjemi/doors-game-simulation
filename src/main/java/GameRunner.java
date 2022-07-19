import agent.Agent;
import agent.Counter;
import agent.Memory;
import game.DoorController;
import game.Game;
import helper.Nudging;

import java.util.ArrayList;

public class GameRunner {
    final Counter counter;
    final Nudging nudging;

    final ArrayList<Agent> agents = new ArrayList();

    public GameRunner(Counter counter, Nudging nudging) {
        this.counter = counter;
        this.nudging = nudging;
    }

    public void run(int inspection, int rounds) {
        Counter.clear();

        for(int i = 0; i<3; i++) {
            final Memory mem = new Memory();
            final Agent agent = new Agent(i, mem);
            agents.add(agent);

        }

        final DoorController doorController = new DoorController(nudging);
        final Game game = new Game(doorController, agents, counter);

        game.start(inspection, rounds);
    }
}
