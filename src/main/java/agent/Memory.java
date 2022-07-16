package agent;

import agent.Window;
import game.Result;
import game.Door;

import java.util.ArrayList;

public class Memory {
    public Window probWindow = new Window(new ArrayList<>());
    private static final double epsilon = 0.01;

    public void reset(Window newWindow) {
        final ArrayList<Door> doors = new ArrayList<>();
        for(Door door : newWindow.doors) {
            doors.add(new Door(door.number, 1.0/3));
        }
        this.probWindow = new Window(doors);
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
