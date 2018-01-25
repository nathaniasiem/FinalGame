package com.btsrun.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author simon7323
 */
public class GameOver implements Screen {

    Texture gameOver;
    float x,y;

    public GameOver() {
         gameOver = new Texture(Gdx.files.internal("images.png"));
    }
     public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    public void render(SpriteBatch batch){
        batch.draw(gameOver, x, y);
    }
    public void dispose() {
        gameOver.dispose();
        

    }

    @Override
    public void show() {
       
    }

    public void render() {
        
    }

    @Override
    public void resize(int i, int i1) {
        
    }

    @Override
    public void pause() {
        
    }
    @Override
    public void resume() {
      
    }

    @Override
    public void hide() {
  
    }

    @Override
    public void render(float f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    }
