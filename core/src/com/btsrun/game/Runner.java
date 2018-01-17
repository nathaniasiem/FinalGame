/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btsrun.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

/**
 *
 * @author simon7323
 */
public class Runner {
    
    //Runner gravity
    private float gravity;
    
    //the max of y axis that the runner can jump
    private final float Max_dy = 15.0f;
    
    //character location
    private float x;
    private float y;
    //character animation
    private float dx;
    private float dy;
    //time of program running
    private float elapsed;
    //animation variables to allow player movement
    private Animation<TextureRegion> run;
    private Animation<TextureRegion> runR;
    //pictures of standing character
    private TextureRegion stand;
    //create texture atlas to help load images of character
    private TextureAtlas atlas;
    


    /**
     * character constructor
     *
     * @param x
     * @param y
     */
    public Runner(float x, float y) {
        
        this.gravity = 0.7f;
        //set starting point
        this.x = x;
        this.y = y;
        

        //character standing position
        this.dx = 0;
        this.dy = 0;

        //no animation at starting point
        this.elapsed = 0;

        //load images into texture atlas
        this.atlas = new TextureAtlas("packed/runner.atlas");

        //find standing image and load to program
        this.stand = atlas.findRegion("character2");

        //create a run animation by finding each character image
        run = new Animation(1f / 10f, atlas.findRegions("character"));

        //load character images again but this time enables them to be flipped through
        Array<TextureRegion> runRFrames = new Array<TextureRegion>();
        for (int i = 1; i <= 6; i++) {
            //goes through each image
            runRFrames.add(atlas.findRegion("character" + i));
        }

        //create the forward animation
        runR = new Animation(1f / 10f, runRFrames);
    }
/**
 * Getting the X position of the runner
 * @return the x value
 */
    public float getX() {
        return x;
    }

    /**
     * Getting the Y position of the runner
     * @return the y value;
     */
    public float getY() {
        return y;
    }

    /**
     *updates program by adding the program time to the time 
     * @param deltaTime
     */
    public void update(float deltaTime) {
        this.elapsed = this.elapsed + deltaTime;
        
        //if the user clicked the up keys the runner will jump over the car and house
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            this.x = this.x - this.dx;
            this.y = this.y + this.dy;
            this.dy = gravity;
            this.dx = 0;
        }
    }

    /**
     *displays character during the program as animation
     * @param batch
     */
    public void render(SpriteBatch batch) {
        batch.draw(runR.getKeyFrame(elapsed, true), x, y, 90,90);

    }
    

    // get rid of heavy objects
    public void dispose() {
        atlas.dispose();
    }
}
