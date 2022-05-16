package game.state;

public class Door {
    public final int cost;
    public final int reward;
    public final double probability;

    public Door(int cost, int reward, double possibility) {
        this.cost = cost;
        this.reward = reward;
        this.probability = possibility;
    }
}
