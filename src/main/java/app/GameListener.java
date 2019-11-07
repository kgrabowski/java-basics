package app;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import game.MyGame;

public class GameListener extends ApplicationAdapter {
    private MyGame game;

    @Override
    public void create() {
        game = new MyGame();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.run();
    }
}
