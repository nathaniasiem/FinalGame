/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btsrun.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 *
 * @author simon7323
 */
public class Runner {
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
        Array<AtlasRegion> runRFrames = atlas.findRegions("character");
        for (int i = 0; i < runRFrames.size; i++) {
            //goes through each image
            runRFrames.get(i).flip(true, false);
        }

        //create the forward animation
        runR = new Animation(1f / 10f, runRFrames);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    /**
     *
     * @param deltaTime
     */
    public void update(float deltaTime) {
        this.elapsed = this.elapsed + deltaTime;

    }

    /**
     *
     * @param batch
     */
    public void render(SpriteBatch batch) {

        batch.draw(run.getKeyFrame(elapsed, true), x, y);

    }

    // get rid of heavy objects
    public void dispose() {
        atlas.dispose();
    }
}
