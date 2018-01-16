package com.btsrun.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class btrsrun extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img, img2;
        
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("seoul.png");
                img2 = new Texture("character.png");
                
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
                batch.draw(img2, 2, 10,100, 40);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}