package com.btsrun.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import java.awt.Font;

public class Btsrun implements Screen {

    //create player variable
    private Runner p1;
    SpriteBatch batch;
    private Background img;
    private Obstacle trouble;
    private OrthographicCamera camera;
    private Viewport view;
    private Music musicPlay;

    //gameover screen
    private boolean GameOver;
    private GameOver end;

    //game screen
    private boolean Game;

    //score
    private int score;
    private String scoreCount;
    private BitmapFont scoreFont;
    private CharSequence scrFont;

    //create game screen
    private final int HEIGHT = 300;
    private final int WIDTH = 800;

    //
    private btsgame gameControl;

    public Btsrun(btsgame game) {
        //initialize Sprite Batch
        this.batch = game.getBatch();

        //game manage
        this.gameControl = game;
        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //centre camera view
        this.camera.position.set(WIDTH / 2, HEIGHT / 2, 0);
        this.camera.update();
        this.view = new FitViewport(WIDTH, HEIGHT, camera);
        view.apply();

        //initialize game assets
        img = new Background();
        p1 = new Runner(0, 0);
        trouble = new Obstacle();

        //font for score
        scoreCount = "Score :";
        score = 0;
        scoreFont = new BitmapFont();
        scoreFont.getData().setScale(2);
        scrFont = "0";

        //music added
        musicPlay = Gdx.audio.newMusic(Gdx.files.internal("RUN.mp3"));
        musicPlay.play();

        //initialize Game over screen 
        end = new GameOver();
    }

    @Override
    public void render(float deltaTime) {

        p1.update(deltaTime);
        img.update(deltaTime);
        trouble.update(deltaTime);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //moves the camera view with player
        if (p1.getX() > 410) {
            camera.position.x = p1.getX();
        } else {
            camera.position.x = 410;
        }
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        //start image animations
        batch.begin();
            img.render(batch);
            p1.render(batch);
            trouble.render(batch);
            trouble.randomCar(WIDTH);
            trouble.randomBuild(WIDTH);
        
        //score counter
        scoreFont.setColor(Color.MAGENTA);
        score = score + 1;
        scoreFont.draw(batch, scrFont, 650, 280);
        scrFont = "score: " + Integer.toString(score + 1);

         if(score==1000){
           trouble.getSpeed();
         }
         
        //collision detection
        //when player hits obstacle
        //game over screen should pop up
        if (trouble.collidesBuilding(p1)) {
            end.render(batch);

        } else if (trouble.collidesCar(p1)) {
            end.render(batch);
        }
        
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
