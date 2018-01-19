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

    OrthographicCamera cam;
    Texture background;
    Texture background2;
    float bgX1, bgY1;
    float bgX2, bgY2;
    private float elapsed;
    private final int speed = 100;

    public Background() {
        background = new Texture(Gdx.files.internal("seoul.png"));
        background2 = new Texture(Gdx.files.internal("seoul.png"));
        bgX1 = 0;
        bgY1 = 0;
        bgX2 = 800;
        bgY2 = 0;
        //no animation at starting point
        this.elapsed = 0;

    }

    public float getBGX1() {
        return bgX1;
    }

    public float getBGX2() {
        return bgX2;
    }

    public void render(SpriteBatch batch) {
           batch.draw(background, bgX1, bgY1);
           batch.draw(background2, bgX2, bgY2);
             
    }

    public void update(float deltaTime) {
        bgX1 -= deltaTime * speed;
        bgX2 -= deltaTime * speed;
        if (bgX1 + background.getWidth() < 0 && bgX2 + background.getWidth() < 0) {
            bgX1 = bgX1 + background.getWidth();
            this.elapsed = bgX1 + this.elapsed;
            bgX2 = bgX2 + background.getWidth();
            this.elapsed = bgX2 + this.elapsed;
        }if(bgX1==background.getWidth()){
            bgX1 =bgX1+bgX2;
        }
    }

    public void dispose() {
        background.dispose();
        background2.dispose();

    }
}
