package game.state;

public abstract class StateGenerator {
    protected final int doorCount;

    protected StateGenerator(int doorCount) {
        this.doorCount = doorCount;
    }

    abstract public GameState current();

    abstract public void next();
}
