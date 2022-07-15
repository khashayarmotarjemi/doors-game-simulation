package agent;

import game.Result;
import game.Door;

public class Agent {
    private final Memory memory;

    public Agent(Memory memory) {
        this.memory = memory;
    }


    public Door select() {
        Door bestOption = null;

        for (Door door : memory.probWindow.doors) {
            if (bestOption == null) {
                bestOption = door;
            } else {
                if (bestOption.probability < door.probability) {
                    bestOption = door;
                }
            }
        }
        return bestOption;
    }

    public void reset(Window newWindow) {
        memory.reset(newWindow);
    }

    public Door randomSelect() {
        return memory.probWindow.doors.get((int) (Math.random() * (3)));
    }

    public void updateMemory(Result result) {
        memory.updateMem(result);
    }

}


