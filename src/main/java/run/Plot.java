package run;

import java.util.ArrayList;
import java.util.Map;

public class Plot {
    final PlotType type;
    final ArrayList<RunResult> results;


    public Plot(ArrayList<RunResult> results, PlotType type) {
        this.results = results;
        this.type = type;
    }
}
