import java.util.Arrays;

import agent.Agent;
import agent.Memory;
import game.Game;
import game.DoorController;

public class Main {
    public static void main(String[] args) {

        final Memory mem = new Memory();
        final Agent agent = new Agent(mem);
        final DoorController doorController = new DoorController();
        final Game game = new Game(doorController, agent);

        game.start();

        Arrays.stream(game.selections).forEach(System.out::println);
    }
}
