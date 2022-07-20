import agent.Counter;
import com.google.gson.Gson;
import game.DoorController;
import helper.FileManager;
import helper.WindowController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        final ArrayList<Map<Integer, ArrayList<Integer>>> result = new ArrayList<>();

        final Counter counter = new Counter();
        final WindowController windowController1 = new WindowController();
        final WindowController windowController2 = new WindowController();

        final GameRunner runner = new GameRunner(counter, new ArrayList<>(List.of(windowController1, windowController2)));

        final ArrayList<Double> probs1 = new ArrayList<>(List.of(0.7, 0.2, 0.1));
        final List<Double> probs2 = probs1.stream().map(e -> 1 - e).toList();

        windowController1.updateWindowProbs(probs1);
        windowController2.updateWindowProbs(new ArrayList<>(probs2));

        for (int i = 0; i < 50; i++) {
            runner.run(10, 100);
            result.add(Map.copyOf(Counter.doorSelection));
        }

        String json = new Gson().toJson(result);
        showPlot(json);

    }

    public static void showPlot(String json) {
        FileManager.write(json);

        try {
            new ProcessBuilder("python", "plot_result.py").start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printCounter(Counter counter) {
        Counter.doorSelection.forEach((index, agent) -> {
            agent.forEach(System.out::println);
            System.out.println();

        });
    }
}

