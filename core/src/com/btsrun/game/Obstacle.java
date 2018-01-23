package com.btsrun.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author simon7323
 */
public class Obstacle {

    Texture car;
    Texture building;
    float cx, cy;
    float cx1;
    float bx, by;
    float bx1;
    public static int randNum;
    private float elapsed;
    private final int speed = 300;

    public Obstacle() {
        car = new Texture(Gdx.files.internal("Car.png"));
        building = new Texture(Gdx.files.internal("house.png"));
        cx = 0;
        cy = 0;
        cx1 = 0;

        bx = 0;
        by = 0;
        bx1 = 0;
        elapsed = 0;

    }

    public void render(SpriteBatch batch) {
        batch.draw(car, cx, cy, 80, 70);
        batch.draw(building, bx, by, 100, 100);
    }

    public void randomCar(int cx) {
        cx = (int) (Math.random() * 2);
    }

    public void randomBuild(int bx) {
        bx = (int) (Math.random() * 2);
    }

    public float getCX() {
        return cx;
    }

    public float getBX() {
        return bx;
    }

    public void update(float deltaTime) {
        cx -= deltaTime * speed;
        bx -= deltaTime * speed;
        if (cx + car.getWidth() < 0) {
            cx = cx1 + car.getWidth();
        }
        if (cx1 + car.getWidth() < 0) {
            cx1 = cx + car.getWidth();
        }
        if (bx + building.getWidth() < 0) {
            bx = bx1 + building.getWidth();
        }
        if (bx1 + building.getWidth() < 0) {
            bx1 = bx + building.getWidth();
        }
    }

    public void dispose() {
        car.dispose();
        building.dispose();
    }
}
