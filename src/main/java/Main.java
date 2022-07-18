import java.util.Arrays;

import agent.Agent;
import agent.Memory;
import agent.Counter;
import game.Game;
import game.DoorController;
import helper.Nudging;

public class Main {
    public static void main(String[] args) {
        final Counter counter = new Counter();
        final Nudging nudging = new Nudging();

        final Memory mem = new Memory();
        final Agent agent = new Agent(mem);
        final DoorController doorController = new DoorController( counter, nudging);
        final Game game = new Game(doorController, agent, counter);

        game.start();


//        plot.pack();
//        plot.setVisible(true);



        Arrays.stream(counter.doorSelection).forEach(System.out::println);
        System.out.println();
        Arrays.stream(counter.doorFrequency).forEach(System.out::println);
        System.out.println();
        counter.print();
    }
}
