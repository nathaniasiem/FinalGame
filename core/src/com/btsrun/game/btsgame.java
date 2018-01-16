
package com.btsrun.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author fabed2976
 */
public class btsgame extends Game{

    private SpriteBatch batch;
    
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
