package app;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameListener extends ApplicationAdapter {
    private SpriteBatch spriteBatch;
    private Texture sprites;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        sprites = new Texture("assets/tiles.png");
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

    protected abstract void update();

    protected void drawPlayerPlane(float x, float y) {
        spriteBatch.draw(sprites, x, y, 136, 400, 65, 65);
    }
}
