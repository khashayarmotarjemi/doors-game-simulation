package agent;

import helper.Constants;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Counter {
    static public ArrayList<Integer> windowSelections = new ArrayList<>();
    static public Map<Integer, ArrayList<Integer>> doorSelection = new HashMap<>();
    static public ArrayList<Integer> doorFrequency = new ArrayList<>();

    public Counter() {
        clear();
    }

    public static void addWindow(int index) {
        windowSelections.set(index, windowSelections.get(index) + 1);
    }

    public static void addSelection(@NotNull Agent agent, int index) {
        final ArrayList<Integer> row = doorSelection.get(agent.id);
        row.set(index, row.get(index) + 1);
    }

    public static void addDoorFreq(Window window) {
        window.doors.forEach((door) -> {
            doorFrequency.set(door.number - 1, doorFrequency.get(door.number - 1) + 1);
        });
    }

    public void print() {
        windowSelections.forEach(System.out::println);
    }

    public static void clear() {
        windowSelections.clear();
        doorSelection.clear();
        doorFrequency.clear();

        windowSelections.addAll(Arrays.asList(0, 0, 0));
        doorFrequency.addAll(Arrays.asList(0, 0, 0, 0, 0));

        for (int i = 0; i < Constants.agentCount; i++) {
            doorSelection.put(i, new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0)));
        }
    }
}
