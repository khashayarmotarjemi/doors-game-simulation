package run;

import java.util.ArrayList;
import java.util.List;

public class RunResult {
    final int agentId;
    final ArrayList<Double> probs;
    final List<ArrayList<Integer>> results;

    public RunResult(int agentId, ArrayList<Double> probs, List<ArrayList<Integer>> results) {
        this.agentId = agentId;
        this.probs = probs;
        this.results = results;
    }
}
