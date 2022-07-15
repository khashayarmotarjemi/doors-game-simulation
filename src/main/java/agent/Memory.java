package agent;

import agent.Window;
import game.Result;
import game.Door;

import java.util.ArrayList;

public class Memory {
    public Window probWindow = new Window(new ArrayList<>());
    private final double epsilon = 0.001;

    public void reset(Window newWindow) {
        this.probWindow = newWindow;
    }

    public void updateMem(Result result) {
        for (Door door : probWindow.doors) {
            if (door.number == result.doorNo) {
                if (result.won) {
                    door.probability += epsilon;
                } else {
                    door.probability -= epsilon;
                }
            } else {
                if (result.won) {
                    door.probability -= epsilon / 4;
                } else {
                    door.probability += epsilon / 4;
                }
            }
        }
    }

}
