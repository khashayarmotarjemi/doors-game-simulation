import agent.Agent;
import agent.Counter;
import helper.WindowController;
import run.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final PlotSerializer serializer = new PlotSerializer();

        final ArrayList<Map<Integer, ArrayList<Integer>>> result = new ArrayList<>();

        final Counter counter = new Counter();
        final WindowController windowController1 = new WindowController();
//        final WindowController windowController2 = new WindowController();

        final GameRunner runner = new GameRunner(counter, new ArrayList<>(List.of(windowController1/*, windowController2*/)));

        final ArrayList<Double> probs1 = new ArrayList<>(List.of(0.7, 0.2, 0.1));
//        final ArrayList<Double> probs2 = new ArrayList<>(List.of(0.333, 0.333, 0.333));
        final ArrayList<ArrayList<Double>> probs = new ArrayList<>();

        probs.add(probs1);
//        probs.add(probs2);

        windowController1.updateWindowProbs(probs1);
//        windowController2.updateWindowProbs(probs2);

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
//            item.forEach((key,value) -> {
//                if(plotResults.size() <= key) {
//                    plotResults.add()
//                }
//            });
            });
            final RunResult runRes = new RunResult(id, prob, new ArrayList<>(agentResults));
            plotResults.add(runRes);
            agentResults.clear();
            id++;
        }


//        final ArrayList<RunResult> plotRes = result.

        Plot plot = new Plot(plotResults, PlotType.TWO_AGENT);

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

    public static void printResult(Counter counter) {
        Counter.doorSelection.forEach((index, agent) -> {
            agent.forEach(System.out::println);
            System.out.println();
        });
    }
}

