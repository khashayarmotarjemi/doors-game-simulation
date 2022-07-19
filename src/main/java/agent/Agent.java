package agent;

import game.Result;
import game.Door;

public class Agent {
    final int id;
    private final Memory memory;

    public Agent(int id, Memory memory) {
        this.id = id;
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
        assert bestOption != null;
        Counter.addSelection(this,bestOption.number - 1);

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


