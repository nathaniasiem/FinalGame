package com.btsrun.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Btsrun implements Screen {
    
    //create player variable
    private Runner p1;
    
    //SpriteBatch for the runner
    SpriteBatch batch;
    
    //Call in the class for the background
    private Background img;
    
    //Varaible for the camera
    private OrthographicCamera camera;
    
    //The Viewport for the camera
    private Viewport view;
    
    //Varaible for the Height and Width of the Game Screen
    private final int HEIGHT = 300;
    private final int WIDTH = 800;
    
    public Btsrun(btsgame game) {
        //initialize Sprite Batch
        this.batch = game.getBatch();
        
        //initialize the camera
        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        
        //Centre camera view
        this.camera.position.set(WIDTH / 2, HEIGHT / 2, 0);
        this.camera.update();
        this.view = new FitViewport(WIDTH, HEIGHT, camera);
        view.apply();
        
        //intialize the background varaible
        img = new Background();
        
        //intialize the runner varaible
        p1 = new Runner(0, 0);
        
    }
    
    @Override
    public void render(float deltaTime) {
        
        //update the player
        p1.update(deltaTime);
        img.update(deltaTime);
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
        img.render(batch);
        p1.render(batch);
        batch.end();
    }
    
    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
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
