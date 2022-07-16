package game;

import agent.Window;
import agent.WindowCounter;

import java.util.ArrayList;
import java.util.List;

public class DoorController {
    final int k;
    final int l;
    final WindowCounter counter;
    final ArrayList<Double> windowProbs = new ArrayList<>();
    int step = 0;
    Window window;
    private final Door[] allDoors;
    private final ArrayList<Window> windows = new ArrayList<>();

    public DoorController(int k, int l, WindowCounter counter) {
        this.k = k;
        this.l = l;
        this.counter = counter;

        double x = (double) 1 / (k*l + k + 1);

        windowProbs.add(l * k * x);
        windowProbs.add(k * x);
        windowProbs.add(x);

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
        double rnd = Math.random();

        if (rnd < windowProbs.get(2)) {
            this.window = windows.get(3);
            counter.add(2);
        } else if (rnd < windowProbs.get(1)) {
            counter.add(1);

            if (Math.random() < 0.5) {
                this.window = windows.get(2);
            } else {
                this.window = windows.get(1);
            }
        } else {
            counter.add(0);

            this.window = windows.get(0);
        }
    }

    public boolean evaluate(int doorNo) {
        return Math.random() < allDoors[doorNo - 1]. probability;
    }
}

