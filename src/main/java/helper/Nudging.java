package helper;

import agent.Window;
import game.Door;

import java.util.ArrayList;
import java.util.List;

public class Nudging {
    public final ArrayList<Double> windowProbs = new ArrayList<>();

    public void updateProbs(double k, double l) {
        double x = (double) 1 / (k * l + k + 1);
        final ArrayList<Double> probs = new ArrayList<>();
        probs.add(l * k * x);
        probs.add(k * x);
        probs.add(x);

        updateProbs(probs);

    }

    public void updateProbs( ArrayList<Double> probs) {
      windowProbs.clear();
      windowProbs.addAll(probs);
    }

}
