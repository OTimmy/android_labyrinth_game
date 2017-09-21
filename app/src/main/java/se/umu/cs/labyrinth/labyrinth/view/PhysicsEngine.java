package se.umu.cs.labyrinth.labyrinth.view;

import se.umu.cs.labyrinth.labyrinth.controller.Observer;
import se.umu.cs.labyrinth.labyrinth.controller.Subject;
import se.umu.cs.labyrinth.labyrinth.model.GameObject;
import se.umu.cs.labyrinth.labyrinth.model.player.Ball;
import se.umu.cs.labyrinth.labyrinth.view.Object.PhysicObject;

/**
 * Created by timmy on 07/08/17.
 */

public class PhysicsEngine implements Engine.Physics, Subject{

    private Observer observer;


    private int getCollisionCode(int nx, int ny) {

        return 0;
    }


    @Override
    public void registerOb(Observer... observer) {
        this.observer = observer[0];
    }

    @Override
    public void notifyObserver() {
        observer.update();
    }


    @Override
    public void update(PhysicObject obj) {
        // if something happens to ball; going over an edge, going up in flames etc etc
        // notifyObserver();
    }
}
