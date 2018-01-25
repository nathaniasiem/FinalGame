package com.btsrun.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author simon7323
 */
public class Obstacle {
    //image for obstacle
    Texture car;
    Texture building;
    
    //rectangle for obstacles to help collsion
    private Rectangle C;
    private Rectangle B;
    
    //coordinates of obstacles
    //car
    float cx, cy;
    float cx1;
    //building
    float bx, by;
    float bx1;
    
    //randomizer
    public static int randNum;
    
    //time of program running
    private float elapsed;
    
    //speed of game
    private int speed = 300;

    public Obstacle() {
        car = new Texture(Gdx.files.internal("Car.png"));
        building = new Texture(Gdx.files.internal("house.png"));
        cx = 0;
        cy = 0;
        cx1 = 0;
        this.C = new Rectangle(cx, cy, car.getWidth(), car.getHeight());
        bx = 0;
        by = 0;
        bx1 = 0;
        this.B = new Rectangle(bx, by, building.getWidth(), building.getHeight());
        elapsed = 0;

    }

    public void render(SpriteBatch batch) {
        batch.draw(car, cx, cy, 80, 70);
        batch.draw(building, bx, by, 100, 100);
    }

    public void randomCar(int cx) {
        cx = (int) (Math.random() * 2);
        this.C.x = (int) (Math.random() * 2);
    }

    public void randomBuild(int bx) {
        bx = (int) (Math.random() * 2);
        this.B.x = (int) (Math.random() * 2);
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
        //update collision rectangle car
        C.setPosition(cx, cy);
        //update collision rectangle building
        B.setPosition(bx, by);
    }

    public Rectangle getC() {
        return C;
    }

    public Rectangle getB() {
        return B;
    }
    public int getSpeed(){
        return speed;
    }
    public boolean collidesCar(Runner R) {

        if (C.overlaps(R.getR())) {
            return true;
        }

        return false;
    }

    public boolean collidesBuilding(Runner R) {
        if (B.overlaps(R.getR())) {
            return true;
        }
        return false;
    }

    public void dispose() {
        car.dispose();
        building.dispose();
    }
}
