package agent;

import java.util.Arrays;

public class Counter {
    public int[] windowSelections;
    public int[] doorSelection;
    public int[] doorFrequency;

    public Counter() {
        clear();
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

    public void clear() {
        this.windowSelections = new int[]{0, 0, 0,};
        this.doorSelection = new int[]{0, 0, 0, 0, 0};
        this.doorFrequency = new int[]{0, 0, 0, 0, 0};
    }
}
