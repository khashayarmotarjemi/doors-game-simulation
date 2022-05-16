package game.state;

public class SimpleStateGenerator extends StateGenerator {

    public SimpleStateGenerator(int doorCount) {
        super(doorCount);
    }

    @Override
    public GameState current() {
        Door[] doors = new Door[this.doorCount];

        for (int i = 0; i < doorCount; i++) {
            doors[i] = new Door(3, 4, 1.0 / doorCount);
        }

        return new GameState(3, doors);
    }

    @Override
    public void next() {

    }
}
