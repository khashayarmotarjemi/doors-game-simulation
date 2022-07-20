package game;

import agent.Window;
import agent.Counter;
import helper.WindowController;

import java.util.ArrayList;
import java.util.List;

public class DoorController {
    final private WindowController nudging;
    Window window;
    private final Door[] allDoors;
    private final ArrayList<Window> windows = new ArrayList<>();

    public DoorController(WindowController nudging) {
        this.nudging = nudging;

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

        int i = pickByProbs(windowProbs);

        while (i == -1) {
            i = pickByProbs(windowProbs);
        }

        Counter.addWindow(i);

        if (i == 0) {
            this.window = windows.get(0);
        } if (i == 1) {
            if (Math.random() < 0.5) {
                this.window = windows.get(1);
            } else {
                this.window = windows.get(2);
            }
        } else if (i == 2) {
            this.window = windows.get(3);
        }

        Counter.addDoorFreq(this.window);

    }

    private int pickByProbs(ArrayList<Double> probs) {
        double rnd = Math.random();
        int i = 0;
        double cumulativeProbability = 0.0;
        for (Double prob : probs) {
            cumulativeProbability += prob;
            if (rnd <= cumulativeProbability) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public boolean evaluate(int doorNo) {
        return Math.random() < allDoors[doorNo - 1].probability;
    }
}

