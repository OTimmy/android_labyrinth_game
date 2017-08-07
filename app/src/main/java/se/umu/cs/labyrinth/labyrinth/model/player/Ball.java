package se.umu.cs.labyrinth.labyrinth.model.player;

import se.umu.cs.labyrinth.labyrinth.controller.Observer;
import se.umu.cs.labyrinth.labyrinth.controller.Subject;

/**
 * Created by timmy on 07/08/17.
 */
public class Ball implements Subject{

    private Speed speed;
    private Position position;
    private Observer observer;

    public Ball() {
        speed = new Speed();
        position = new Position(0,0);
    }

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public void registerOb(Observer... observer) {
        this.observer = observer[0];
    }

    @Override
    public void notifyObserver() {
        observer.update();
    }
}
