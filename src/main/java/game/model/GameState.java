package game.model;

import agent.model.DoorList;

public class GameState {
    public final DoorList window;
    public final Door[] doors;

    public GameState(Door[] doors, DoorList window) {
        this.doors = doors;
        this.window = window;
    }
}
