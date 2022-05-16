package game.state;

public class GameState {
    final int doorCount;
    public final Door[] doors;

    public GameState(int doorsCount, Door[] doors) {
        this.doorCount = doorsCount;
        this.doors = doors;
    }

    public double getProbability(int doorIndx) {
        return doors[doorIndx].probability;
    }
}
