package se.umu.cs.labyrinth.labyrinth.model.player;

/**
 * Created by timmy on 07/08/17.
 */
public class PlayerData {
    private static  int levelStatus = 1;
    private int time = 0;
    private int retries = 0;

    public static int getLevelStatus() {
        return levelStatus;
    }

    public static void setLevelStatus(int levelStatus) {
        PlayerData.levelStatus = levelStatus;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getRetries() {
        return retries;
    }

    public void setRetries(int retries) {
        this.retries = retries;
    }

}
