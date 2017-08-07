package se.umu.cs.labyrinth.labyrinth.model;

import se.umu.cs.labyrinth.labyrinth.model.player.PlayerData;

/**
 * Created by timmy on 07/08/17.
 */

public class Parser {
    private static final int NUMB_TILES_WIDTH = 20;
    private static final int NUMB_TILES_HEIGHT = 30;

    /**
     * @return Parsed map, based upon what level the player currently is.
     */
    public static Level parseLevel() {
        int levelNr = PlayerData.getLevelStatus();

        return null;
    }
}
