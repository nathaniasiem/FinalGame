package com.btsrun.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;



public class Btsrun implements Screen {
    
    private Runner p1;                   //create player variable   
    SpriteBatch batch;                   //create a variable for the sprite batch
    private Background img;             //create a variable for the background image
    private OrthographicCamera camera;  //create a variable for the camera
    private Viewport view;              //create a variable for the viewport
    private final int HEIGHT = 300;     //create  the height game screen
    private final int WIDTH = 800;      //create the width of the game scree
    
    
    public Btsrun(btsgame game) {
        
        //initialize Sprite Batch
        this.batch = game.getBatch();       
        
        //intiliaze the camera to the width and height of the game screen
        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        
        //centre camera view
        this.camera.position.set(WIDTH / 2, HEIGHT / 2, 0);
        this.camera.update();
        this.view = new FitViewport(WIDTH, HEIGHT, camera);
        view.apply();
        
        img = new Background();
        
        //intiliaze the runner image
        p1 = new Runner(0, 0);
        
    }
    
    @Override
    public void render(float deltaTime) {
        
        p1.update(deltaTime);
        
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //moves the camera view with player
        if (p1.getX() > 410) {
            camera.position.x = p1.getX();
        } else {
            camera.position.x = 410;
        }

        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
       //img.render(batch);
        p1.render(batch);
        batch.end();
    }
    
    @Override
    public void dispose() {
        batch.dispose();
        //img.dispose();
    }
    
    @Override
    public void show() {
    }
    
    @Override
    public void resize(int width, int height) {
        view.update(width, height);
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
}

