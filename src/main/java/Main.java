import agent.Agent;
import game.Game;
import game.state.SimpleStateGenerator;
import game.state.StateGenerator;
import agent.memory.Memory;
import agent.memory.SimpleMemory;

public class Main {
    public static void main(String[] args) {

        final int doorsCount = 3;

        final Memory agentMem = new SimpleMemory(doorsCount);
        final Agent agent = new Agent(doorsCount, agentMem);
        final StateGenerator stateGenerator = new SimpleStateGenerator(doorsCount);
        final Game game = new Game(stateGenerator, agent);

        game.start();
    }
}
