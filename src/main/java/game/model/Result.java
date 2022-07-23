package game.model;

public class Result {
    public final boolean won;
    public final int doorNo;

    public Result(boolean won, int doorNo) {
        this.won = won;
        this.doorNo = doorNo;
    }
}
