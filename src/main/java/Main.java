import run.Counter;
import game.model.Window;
import run.*;
import run.model.Plot;
import run.model.RunResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        final PlotSerializer serializer = new PlotSerializer();

        final ArrayList<Map<Integer, ArrayList<Integer>>> result = new ArrayList<>();
        final ArrayList<Window> controllers = new ArrayList<>();
        final ArrayList<ArrayList<Double>> probs = new ArrayList<>();

        final Window windowController1 = new Window();
        final Window windowController2 = new Window();

        controllers.add(windowController1);
        controllers.add(windowController2);

        final ArrayList<Double> probs1 = new ArrayList<>(List.of(0.7, 0.2, 0.1));
        final ArrayList<Double> probs2 = new ArrayList<>(List.of(0.333, 0.333, 0.333));

        probs.add(probs1);
        probs.add(probs2);

        windowController1.updateWindowProbs(probs1);
        windowController2.updateWindowProbs(probs2);

        final Counter counter = new Counter(controllers.size());

        final GameRunner runner = new GameRunner(counter, controllers);

        for (int i = 0; i < 50; i++) {
            runner.run(10, 100);
            result.add(Map.copyOf(Counter.doorSelection));
        }

        System.out.println(result);

        ArrayList<RunResult> plotResults = new ArrayList<>();

        int id = 0;

        for (ArrayList<Double> prob : probs) {
            ArrayList<ArrayList<Integer>> agentResults = new ArrayList<>();
            int finalId = id;
            result.forEach(item -> {
                agentResults.add((ArrayList<Integer>) (item.values().toArray()[finalId]));
            });
            final RunResult runRes = new RunResult(id, prob, new ArrayList<>(agentResults));
            plotResults.add(runRes);
            agentResults.clear();
            id++;
        }


        Plot plot = new Plot(plotResults);

        final boolean success = serializer.saveToFile(plot);
        if (success) {
            showPlot();
        } else {
            throw new Error("Saving file unsuccessful");
        }

    }

    public static void showPlot() {
        try {
            new ProcessBuilder("python", "plot_result.py").start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

