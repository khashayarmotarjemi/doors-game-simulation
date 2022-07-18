package agent;

import java.util.Arrays;

public class Counter {
    public final int[] windowSelections;
    public final int[] doorSelection;

    public final int[] doorFrequency;

    public Counter() {
        this.windowSelections = new int[]{0, 0, 0,};
        this.doorSelection = new int[]{0, 0, 0, 0, 0};
        this.doorFrequency = new int[]{0, 0, 0, 0, 0};
    }

    public void addWindow(int index) {
        windowSelections[index]++;
    }
    public void addDoor(int index) {
        doorSelection[index]++;
    }

    public void addDoorFreq(Window window) {
        window.doors.forEach((door) -> {
            doorFrequency[door.number-1]++;
        });
    }

    public void print() {
        Arrays.stream(windowSelections).forEach(System.out::println);
    }
}
