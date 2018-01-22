
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author simon7323
 */
public class Enemy {

    Texture car;
    Texture building;
    Rectangle C;
    Rectangle B;
    float cx, cy;
    float bx, by;
    private float x,y;
    public static int randNum;
    private float elapsed;

    public Enemy() {
        car = new Texture(Gdx.files.internal("Car.png"));
        building = new Texture(Gdx.files.internal("house.png"));
        cx = 0;
        cy = 0;
        bx = 0;
        by = 0;
        x=0;
        y=0;
        elapsed = 0;
        C = new Rectangle(x,y,car.getWidth(),car.getHeight());
        B = new Rectangle (x,y,building.getWidth(),building.getHeight());

    }

    public void RandGen() {
        randNum = (int) (Math.random() * 2);
    }

    public void render(SpriteBatch batch) {
        batch.draw(car, cx, cy);
        batch.draw(building, bx, by);
    }

    public void update(float deltaTime) {
        elapsed += deltaTime;
        C.setPosition(x, y);
        B.setPosition(x, y);
    }

    public void dispose() {
        car.dispose();
        building.dispose();
    }
}
