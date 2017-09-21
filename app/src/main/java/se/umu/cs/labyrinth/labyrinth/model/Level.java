package se.umu.cs.labyrinth.labyrinth.model;

/**
 * Created by timmy on 07/08/17.
 */
//Singleton class??
public class Level {
    public static final int NUMB_TILES_WIDTH = 20;
    public static final int NUMB_TILES_HEIGHT = 30;
    public static int timeLimit;
    private Tile[][] tiles;

    public Level(Tile[][] tiles) {
        this.tiles = tiles;
//        timeLimit = //XML
    }

    public Tile[][]  getTiles() {
        return tiles;
    }
}
