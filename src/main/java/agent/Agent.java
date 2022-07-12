package agent;

import game.state.GameState;
import agent.memory.Memory;

public class Agent {
    private final int doorCount;
    private final Memory memory;


    public Agent(int doorCount, Memory memory) {
        this.doorCount = doorCount;
        this.memory = memory;
    }


    public int select(GameState state) {
        //TODO make the agent select based on memory or other variables, for now selects the first door always

        double[] memSnap = memory.get();

        return 0;
    }

    public void updateMemory(int doorIndx, boolean result) {
        memory.update(doorIndx, result);
    }

}


