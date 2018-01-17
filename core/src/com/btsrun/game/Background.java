/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btsrun.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author simon7323
 */
public class Background {

    //variable for the background
    Texture background;
    
    //variable for the X and Y value of the background
    private float bgX1, bgY2;
    
    //variable for the animation
    private float elapsed;
    
    //variable for the speed for the background
    private final int speed = 100;

    public Background() {
        background = new Texture(Gdx.files.internal("seoul.png"));
        

        bgX1 = 0;
        bgY2 = 0;
        

        //no animation at starting point
        this.elapsed = 0;

    }
/**
 * Getting the X position of the background
 * @return the x value
 */
    public float getBGX1() {
        return bgX1;
    }
/**
 * Drawing our background image
 * @param batch 
 */
    public void render(SpriteBatch batch) {
        batch.draw(background, bgX1, bgY2);


    }
/**
 * This method is how the background will make the scrolling
 * @param deltaTime 
 */
    public void update(float deltaTime) {
        bgX1 -= deltaTime * speed;

        if (bgX1 + background.getWidth() < 0) {
            bgX1 = bgX1 + background.getWidth();
            this.elapsed = bgX1 + this.elapsed;
            
        }
        
    }

    public void dispose() {
        background.dispose();


    }
}
