import java.util.Arrays;

import agent.Agent;
import agent.memory.CountingMemory;
import agent.memory.EpsilonMemory;
import game.Game;
import game.state.SimpleStateGenerator;
import game.state.StateGenerator;
import agent.memory.Memory;

public class Main {
    public static void main(String[] args) {

        final int doorsCount = 3;

        final Memory agentMem = new EpsilonMemory(doorsCount);
        final Agent agent = new Agent(doorsCount, agentMem);
        final StateGenerator stateGenerator = new SimpleStateGenerator(doorsCount);
        final Game game = new Game(stateGenerator, agent);

        Arrays.stream(agentMem.get()).forEach(prob -> {
            System.out.println(prob);
        });

        game.start();
    }
}
