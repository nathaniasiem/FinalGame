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
    Texture background1;
    Texture background2;
    float bgX1, bgY1;
    float bgX2, bgY2;

    public Background() {
        background1 = new Texture(Gdx.files.internal("seoul.png"));
        background2 = new Texture(Gdx.files.internal("seoul.png"));
        bgX1 = 0;
        bgY1 = 0;
        bgX2 = 0;
        bgY2 = 0;
    }

    public float getBGX() {
        return bgX1;
    }

    public float getBGY() {
        return bgY1;
    }

    public void render(SpriteBatch batch) {
        batch.draw(background1, bgX1, bgY1);
        batch.draw(background2, bgX2, bgY2);

    }

    public void update(float deltaTime) {
        bgX1 -= deltaTime / 2f;
        bgX2 -= deltaTime / 2f;

        if (bgX1 + background1.getWidth() < 0) {
            bgX1 = bgX2 + background2.getWidth();

        } else if (bgX2 + background2.getWidth() < 0) {
            bgX2 = bgX1 + background1.getWidth();
        }
    }

    public void dispose() {
        background1.dispose();
        background2.dispose();


    }
}
