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
    SpriteBatch batch;
    Texture img;
    private OrthographicCamera camera;
    private Viewport view;
    //create game screen
    private final int HEIGHT = 300;
    private final int WIDTH = 800;

    public Btsrun(btsgame game) {

        p1 = new Runner(100, 100);
        //initialize Sprite Batch
        this.batch = game.getBatch();
        //setup camera
        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //centre camera view
        this.camera.position.set(WIDTH/2,HEIGHT/2,0);
        this.camera.update();
        this.view = new FitViewport(WIDTH,HEIGHT,camera);
        view.apply();
    }

    public void create() {
        batch = new SpriteBatch();
        img = new Texture("seoul.png");


    }

    @Override
    public void render(float deltaTime) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //moves the camera view with player
        if(p1.getX()>200){
            camera.position.x = p1.getX();
        }else{
            camera.position.x = 200;
        }
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        
        batch.draw(img, 0, 0);
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
