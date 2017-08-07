package se.umu.cs.labyrinth.labyrinth.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import se.umu.cs.labyrinth.labyrinth.model.GameLogic;
import se.umu.cs.labyrinth.labyrinth.model.SpeedSensor;
import se.umu.cs.labyrinth.labyrinth.model.player.PlayerData;
import se.umu.cs.labyrinth.labyrinth.view.GameEngine;

/**
 * Created by timmy on 07/08/17.
 */
public class Game extends AppCompatActivity{
    private GameLogic gameLogic;
    private GameEngine gameEngine;
    private SpeedSensor sensor;
    private PlayerData playerData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    void setupPlayerData() {

    }

    void setupSensor() {

    }

    void setupGameEngine() {

    }

}
