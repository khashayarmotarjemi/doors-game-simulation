package run;

import com.google.gson.Gson;
import helper.json.FileManager;
import run.model.Plot;

public class PlotSerializer {
    public boolean saveToFile(Plot plot) {
        String json = new Gson().toJson(plot);

        try {
            FileManager.write(json);
            return true;
        } catch (Error e) {
           return false;
        }
    }
}
