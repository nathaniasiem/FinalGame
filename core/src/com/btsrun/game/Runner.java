package com.btsrun.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;


/**
 *
 * @author fabed2976
 */
public class Runner {
    
   // private float gravity;
   // private final float Maximum_DY = 13.0f;
    private Vector3 pos;
    private Vector3 vel;
    private Rectangle bounds;
    private final float MOVE = 100;
    private float statetime = 0;
    
    //Animation for the Runner to run
    private Animation runnerun;
    
    public Runner(int x, int y){
        pos = new Vector3(x,y,0);
        vel = new Vector3 (MOVE, 0, 0);
       // this.gravity = 0.9f;
        
        Array<TextureRegion> frames = new Array<TextureRegion>();
        for(int  i = 1; i <= 6; i++){
            frames.add(new TextureRegion(new Texture("Chracter" + i + ".png")));
            
        }
        runnerun = new Animation(0.2f , frames);
        runnerun.setPlayMode(Animation.PlayMode.LOOP);
        bounds = new Rectangle(pos.x , pos.y, runnerun.getKeyFrames()[0].getTexture().getWidth() );
       
        
    }
    
    public void update(float deltaTime){
        vel.scl(deltaTime);
        pos.add(vel);
        vel.scl(1 / deltaTime);
        
        bounds.setPosition(pos.x, pos.y);
        statetime += deltaTime;
    }
    public void render(SpriteBatch batch){
        batch.draw(runnerun.getKeyFrame(statetime), pos.x, pos.y);
        
    }
    
    public float getX(){
        return pos.x;
    }
    public float getY(){
        return pos.y;
    }
    
    public Rectangle getBounds(){
        return bounds;
    }
    
    public void dispose(){
        //runner.dispose();
    }

}
