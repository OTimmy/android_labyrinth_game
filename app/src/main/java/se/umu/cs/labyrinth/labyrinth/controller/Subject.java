package se.umu.cs.labyrinth.labyrinth.controller;

/**
 * Created by timmy on 07/08/17.
 */

public interface Subject {

    void registerOb( Observer... observer);
    void notifyObserver();
}
