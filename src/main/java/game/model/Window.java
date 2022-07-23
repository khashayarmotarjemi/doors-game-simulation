package game.model;

import java.util.ArrayList;

public class Window {
    public final ArrayList<Double> windowProbs = new ArrayList<>();

    public void updateWindowProbs(double k, double l) {
        double x = (double) 1 / (k * l + k + 1);
        final ArrayList<Double> probs = new ArrayList<>();
        probs.add(l * k * x);
        probs.add(k * x);
        probs.add(x);

        updateWindowProbs(probs);

    }

    public void updateWindowProbs(ArrayList<Double> probs) {
        windowProbs.clear();
        windowProbs.addAll(probs);
    }

}
