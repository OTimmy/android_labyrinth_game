package se.umu.cs.labyrinth.labyrinth.view;

import android.app.Activity;
import se.umu.cs.labyrinth.labyrinth.controller.Observer;
import se.umu.cs.labyrinth.labyrinth.controller.Subject;
import se.umu.cs.labyrinth.labyrinth.model.GameObject;

/**
 * Created by timmy on 07/08/17.
 */
public class GameEngine implements Observer, Subject{
    final Object lock = new Object();
    private Thread gameThread;

    private PhysicsEngine physics;
    private GraphicsEngine graphics;
    private boolean runGameEngine = true;

    private GameObject gameObject;

    public GameEngine(GameObject gameObject, Activity activity) {
        this.gameObject = gameObject;
        gameThread      = setupThread();
        gameThread.start();
    }

    private void setup() {
        graphics = new GraphicsEngine();
        physics = new PhysicsEngine();
    }

    private void gameLoop() {
        while(runGameEngine) {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            physics.update(gameObject); //GameObject { Physics, Graphics }
            graphics.update(gameObject);
        }
    }

    @Override
    public void update() {

        synchronized (lock) {
            lock.notify();
        }

    }

    private Thread setupThread() {
        Thread t = new Thread() {
            public void run() {
                gameLoop();
            }
        };

        return t;
    }

    @Override
    public void registerOb(Observer... observer) {
        physics.registerOb(observer);
    }

    @Override
    public void notifyObserver() {}
}
