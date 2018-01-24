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
    Texture background2;
    
    //variable for the X and Y value of the background
    private float bgX1, bgY2;
    private  float bgX2, bgY2;

    //variable for the animation
    private float elapsed;
    
    //variable for the speed for the background
    private final int speed = 100;

    public Background() {
        //loading the image for the background
        background = new Texture(Gdx.files.internal("seoul.png"));
        background2 = new Texture(Gdx.files.internal("seoul.png"));
        
        //the x and y axis coordinate for the background
        bgX1 = 0;
        bgY2 = 0;
        
         //the x and y axis coordinate for the 2nd background
        bgX2 = 800;
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
 *Getting the X position of the 2nd background
 * @ return the x value
 */
    public float getBGX2() {
        return bgX2;
    }
    
/**
 * Drawing our background image
 * @param batch 
 */
    public void render(SpriteBatch batch) {
        batch.draw(background, bgX1, bgY2);
        batch.draw(background2, bgX2, bgY2);
    }
    
/**
 * This method is how the background will make the scrolling
 * @param deltaTime 
 */
    public void update(float deltaTime) {
        //
        bgX1 -= deltaTime * speed;
        bgX2 -= deltaTime * speed;
        
        //create an if statement for the background 
        //if the X Axis of the backgeound and the background width is less than 0
        // add the second background with the same width
        if (bgX1 + background.getWidth() < 0) {
            bgX1 = bgX1 + background.getWidth();
            
        }
        if( bgX2 + background2.getWidth() < 0){
            bgX2 = bgX1 + background.getWidth();
   
        }

    }

    public void dispose() {
        background.dispose();
        background2.dispose();


    }
}
