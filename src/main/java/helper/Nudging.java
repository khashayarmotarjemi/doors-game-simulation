package helper;

import agent.Window;
import game.Door;

import java.util.ArrayList;
import java.util.List;

public class Nudging {
    public final ArrayList<Double> windowProbs = new ArrayList<>();


    public void updateProbs() {
        int k = 6;
        int l = 3;

        double x = (double) 1 / (k * l + k + 1);

        windowProbs.add(l * k * x);
        windowProbs.add(k * x);
        windowProbs.add(x);
    }

}
