package se.umu.cs.labyrinth.labyrinth.model;

import se.umu.cs.labyrinth.labyrinth.model.player.Position;

/**
 * Created by timmy on 07/08/17.
 */

public class Tile {

    private int type;

    public Tile( int type) {
//        position = new Position(x,y);
        this.type = type;
    }

//    public Position getPosition() {
//        return position;
//    }
//
//    public void setPosition(Position position) {
//        this.position = position;
//    }

    private int getType() {
        return type;
    }

    @Override
    public String toString() {
        return Integer.toString(type);
    }
}
