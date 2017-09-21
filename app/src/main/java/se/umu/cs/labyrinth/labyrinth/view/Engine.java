package se.umu.cs.labyrinth.labyrinth.view;

import se.umu.cs.labyrinth.labyrinth.view.Object.GraphicObject;
import se.umu.cs.labyrinth.labyrinth.view.Object.PhysicObject;

/**
 * Created by timmy on 21/09/17.
 */

public interface Engine {
    public interface Game {

    }

    public interface Graphics {
        public void update(GraphicObject obj);
    }

    public interface Physics {
        public void update(PhysicObject obj);
    }
}
