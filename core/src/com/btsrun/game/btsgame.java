/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btsrun.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author simon7323
 */
public class btsgame extends Game {
    
    private SpriteBatch batch;
    
    /**
     * set up game screen
     */
    @Override
    public void create() {
        batch = new SpriteBatch();
        Btsrun game = new Btsrun(this);
        this.setScreen(game);
    }

    public SpriteBatch getBatch(){
        return batch;
    }
    
    @Override
    public void render(){
        super.render();
    }
    
}
