import agent.Agent;
import agent.Counter;
import agent.Memory;
import game.DoorController;
import game.Game;
import helper.Nudging;

import java.util.Arrays;

public class GameRunner {
    final Counter counter;
    final Nudging nudging;

    public GameRunner(Counter counter, Nudging nudging) {
        this.counter = counter;
        this.nudging = nudging;
    }

    public void run(int inspection, int rounds) {
        counter.clear();

        final Memory mem = new Memory();
        final Agent agent = new Agent(mem);
        final DoorController doorController = new DoorController( counter, nudging);
        final Game game = new Game(doorController, agent, counter);

        game.start(inspection, rounds);

        Arrays.stream(counter.doorSelection).forEach(System.out::println);
        System.out.println();
        Arrays.stream(counter.doorFrequency).forEach(System.out::println);
        System.out.println();
        counter.print();
        System.out.println("-------------------------");

    }
}
