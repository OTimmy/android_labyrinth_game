package se.umu.cs.labyrinth.labyrinth.controller;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;

import se.umu.cs.labyrinth.labyrinth.model.GameLogic;
import se.umu.cs.labyrinth.labyrinth.model.Level;
import se.umu.cs.labyrinth.labyrinth.model.Parser;
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
    private Level level;
    private static Activity activity;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        try {
            level  = Parser.parseLevel();
            sensor = setupSensor();

            gameLogic  = new GameLogic();
            gameEngine = new GameEngine();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }

    private void setupPlayerData() {
        playerData = new PlayerData();
    }

    private SpeedSensor setupSensor() {
        return new SpeedSensor();
    }

    private GameLogic setupGameLogic() {
        return null;
    }

    /**
     * @return Game engine observing the sensor.
     */
    private GameEngine setupGameEngine() {
        GameEngine gameEngine = new GameEngine();
        sensor.registerOb(gameEngine);
        return gameEngine;
    }


    public static Activity getActivity() {
        return activity;
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensor.registerListener();
    }
}
