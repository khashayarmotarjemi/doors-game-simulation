import agent.Counter;
import com.google.gson.Gson;
import helper.FileManager;
import helper.Nudging;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        final Counter counter = new Counter();
        final Nudging nudging = new Nudging();

        final GameRunner runner = new GameRunner(counter, nudging);

        nudging.updateWindowProbs(6, 3);

        for (int i = 0; i < 1; i++) {
            runner.run(10, 100);
        }

        String json = new Gson().toJson(Counter.doorSelection);
        showPlot(json);
        printCounter(counter);

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
//        Counter.doorFrequency.forEach(System.out::println);
//        System.out.println();
//        counter.print();
//        System.out.println("-------------------------");
    }
}

