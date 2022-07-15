package game;

import agent.Window;

import java.util.ArrayList;
import java.util.List;

public class DoorController {
    int step = 0;
    Window window;
    private final Door[] allDoors;
    private final ArrayList<Window> windows = new ArrayList<>();

    public DoorController() {

        allDoors = new Door[]{
                new Door(1, 0.24),
                new Door(2, 0.21),
                new Door(3, 0.19),
                new Door(4, 0.20),
                new Door(5, 0.16),
        };

        // 3, 4, 5
        windows.add(new Window(new ArrayList<>(List.of(allDoors[2], allDoors[3], allDoors[4]))));

        // 1,2, 3|5
        windows.add(new Window(new ArrayList<>(List.of(allDoors[0], allDoors[1], allDoors[2]))));
        windows.add(new Window(new ArrayList<>(List.of(allDoors[0], allDoors[1], allDoors[4]))));

        // 1,2,4
        windows.add(new Window(new ArrayList<>(List.of(allDoors[0], allDoors[1], allDoors[3]))));


        this.window = windows.get(0);
    }

    public GameState getState() {
        return new GameState(allDoors, window);
    }

    public void resetWindow() {
        this.window = windows.get((int) (Math.random() * 4));
    }

    public boolean evaluate(Door door) {
        return Math.random() < door.probability;
    }
}

