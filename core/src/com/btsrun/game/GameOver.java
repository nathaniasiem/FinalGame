package com.btsrun.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author simon7323
 */
public class GameOver {

    //initial variable of game over screen
    Texture gameOver;
    float x, y;

    /**
     * game over screen constructor
     */
    public GameOver() {
        gameOver = new Texture(Gdx.files.internal("images.png"));
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    /**
     *
     * @param batch- draw out game over image
     */
    public void render(SpriteBatch batch) {
        batch.draw(gameOver, 300, 80);
    }

    /**
     * gets rid of heavy objects
     */
    public void dispose() {
        gameOver.dispose();

    }

}
