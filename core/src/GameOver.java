
import com.badlogic.gdx.Gdx;
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
public class GameOver {

    Texture gameOver;

    public GameOver() {
         gameOver = new Texture(Gdx.files.internal("images.png"));
    }
    
    public void render(SpriteBatch batch){
        batch.draw(gameOver, x, y);
    }
    }
