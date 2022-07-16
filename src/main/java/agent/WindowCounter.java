package agent;

import java.util.Arrays;

public class WindowCounter {
    public final int[] selections;

    public WindowCounter() {
        this.selections = new int[]{0, 0, 0,};
    }

    public void add(int index) {
        selections[index]++;
    }

    public void print() {
        Arrays.stream(selections).forEach(System.out::println);
    }
}
