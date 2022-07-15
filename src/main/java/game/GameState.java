package game;

import agent.Window;
import game.Door;

public class GameState {
    public final Window window;
    public final Door[] doors;

    public GameState(Door[] doors, Window window) {
        this.doors = doors;
        this.window = window;
    }
}
