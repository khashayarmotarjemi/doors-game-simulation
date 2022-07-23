package agent;

import agent.model.DoorList;
import game.model.Result;
import game.model.Door;

import java.util.ArrayList;

public class Memory {
    public DoorList doorList = new DoorList(new ArrayList<>());
    private static final double epsilon = 1.0/6;

    public void reset(DoorList newWindow) {
        final ArrayList<Door> doors = new ArrayList<>();
        for(Door door : newWindow.doors) {
            doors.add(new Door(door.number, 1.0/3));
        }
        this.doorList = new DoorList(doors);
    }

    public void updateMem(Result result) {
        for (Door door : doorList.doors) {
            if (door.number == result.doorNo) {
                if (result.won) {
                    door.probability += epsilon;
                } else {
                    door.probability -= epsilon;
                }
            } else {
                if (result.won) {
                    door.probability -= epsilon / 2;
                } else {
                    door.probability += epsilon / 2;
                }
            }
        }
    }
}
