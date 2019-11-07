package app;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import game.MyGame;

public class Main {
    public static void main(String[] args) {
        var config = new LwjglApplicationConfiguration();
        config.width = 600;
        config.height = 800;
        config.title = "Java Basics";

        new LwjglApplication(new MyGame(), config);
    }
}