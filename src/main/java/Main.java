import agent.Counter;
import helper.Nudging;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final Counter counter = new Counter();
        final Nudging nudging = new Nudging();

        final GameRunner runner = new GameRunner(counter, nudging);

        nudging.updateProbs(6,3);
//        nudging.updateProbs(new ArrayList<>(
//                Arrays.asList(0.333, 0.3333, 0.3333)));
        runner.run(10, 100);
    }


}
