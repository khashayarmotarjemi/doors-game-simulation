package game;

import agent.Window;
import agent.Counter;
import helper.Nudging;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DoorController {
    final Counter counter;
    int step = 0;
    final private Nudging nudging;
    Window window;
    private final Door[] allDoors;
    private final ArrayList<Window> windows = new ArrayList<>();

    public DoorController(Counter counter, Nudging nudging) {
        this.nudging = nudging;
        nudging.updateProbs();
        this.counter = counter;

        allDoors = new Door[]{
                new Door(1, 0.27),
                new Door(2, 0.23),
                new Door(3, 0.15),
                new Door(4, 0.22),
                new Door(5, 0.13),
        };

        // 3, 4, 5
        windows.add(new Window(new ArrayList<>(List.of(allDoors[2], allDoors[3], allDoors[4]))));

        // 1,2, 3|5
        windows.add(new Window(new ArrayList<>(List.of(allDoors[0], allDoors[1], allDoors[2]))));
        windows.add(new Window(new ArrayList<>(List.of(allDoors[0], allDoors[1], allDoors[4]))));

        // 1,2,4
        windows.add(new Window(new ArrayList<>(List.of(allDoors[0], allDoors[1], allDoors[3]))));

        resetWindow();
    }

    public GameState getState() {
        return new GameState(allDoors, window);
    }

    public void resetWindow() {
        final ArrayList<Double> windowProbs = nudging.windowProbs;

        double rnd = Math.random();

        if (rnd < windowProbs.get(2)) {
            this.window = windows.get(3);
            counter.addWindow(2);
        } else if (rnd < windowProbs.get(1)) {
            counter.addWindow(1);

            if (Math.random() < 0.5) {
                this.window = windows.get(2);
            } else {
                this.window = windows.get(1);
            }
        } else {
            counter.addWindow(0);

            this.window = windows.get(0);
        }
        counter.addDoorFreq(this.window);

    }

    public boolean evaluate(int doorNo) {
        return Math.random() < allDoors[doorNo - 1].probability;
    }
}

