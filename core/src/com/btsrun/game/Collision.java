
package com.btsrun.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 *
 * @author fabed2976
 */
public class Collision {
    
    private Runner p1;
    private Texture house;
    private Texture car;
    
    
    public Collision (){
        house = new Texture(Gdx.files.internal("house.png"));
        car = new Texture(Gdx.files.internal("car.png"));
 
    }
    

}
