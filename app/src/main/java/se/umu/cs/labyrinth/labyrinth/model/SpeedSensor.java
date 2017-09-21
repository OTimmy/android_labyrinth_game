package se.umu.cs.labyrinth.labyrinth.model;

import android.hardware.SensorManager;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

import se.umu.cs.labyrinth.labyrinth.controller.Game;
import se.umu.cs.labyrinth.labyrinth.controller.Observer;
import se.umu.cs.labyrinth.labyrinth.controller.Subject;

/**
 * Created by timmy on 07/08/17.
 */

public class SpeedSensor implements SensorEventListener, Subject{

    private SensorManager mSensorManager;
    private Sensor accelSensor;
    private Sensor magnetSensor;
    private float mGravity[];                  // Used to get orientation
    private float mGeomagnetic[];
    private Observer observer;

    private int xSpeed = 0;
    private int ySpeed = 0;

    public SpeedSensor() {

        //Start service
        mSensorManager = (SensorManager)
                Game.getActivity().getSystemService(Context.SENSOR_SERVICE);
        accelSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnetSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
    }
    //Inspired by codingforandroid
    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            mGravity = event.values;
        }
        if(event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            mGeomagnetic = event.values;
        }
        int xDeg = 0;
        int yDeg = 0;
        if(mGravity != null && mGeomagnetic != null) {
            float R[] = new float[9];
            float I[] = new float[9];
            boolean success = SensorManager.getRotationMatrix(R,I,mGravity, mGeomagnetic);
            if(success) {
                float orientation[] = new float[3];
                SensorManager.getOrientation(R,orientation);
                xDeg = (int )Math.toDegrees(orientation[1]);
                yDeg = (int) Math.toDegrees(orientation[2]);
                // Calculating a new speed.
                ySpeed =-xDeg/2;
                xSpeed = yDeg/2;
                notifyObserver();
            }
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {}
    public void registerListener() {
        mSensorManager.registerListener(this,accelSensor,SensorManager.SENSOR_DELAY_GAME);
        mSensorManager.registerListener(this,magnetSensor,SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void registerOb(Observer... observer) {
        this.observer = observer[0];
    }

    @Override
    public void notifyObserver() {
        observer.update();
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }
}
