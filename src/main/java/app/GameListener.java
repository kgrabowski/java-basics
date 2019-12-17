package app;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class GameListener extends ApplicationAdapter {
    private SpriteBatch spriteBatch;
    private Texture sprites;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        sprites = new Texture("assets/tiles.png");

        init();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        update();
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        sprites.dispose();
    }

    protected abstract void init();

    protected abstract void update();

    protected void drawPlayerPlane(float x, float y) {
        spriteBatch.draw(sprites, x - 32, y - 32, 136, 400, 65, 65);
    }

    protected void drawEnemyPlane(Vector2 position) {
        spriteBatch.draw(sprites, position.x - 16, position.y - 16, 70, 499, 32, 32);
    }

    protected float getInputX() {
        var x = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            x -= 1;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            x += 1;
        return x;
    }

    protected float getInputY() {
        var y = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            y -= 1;
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            y += 1;
        return y;
    }

    protected void clearScreen(float red, float green, float blue) {
        Gdx.gl.glClearColor(red, green, blue, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    protected boolean isEven(int value) {
        return value % 2 == 0;
    }
}
