package app;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
    public static void main(String[] args) {
        var config = new LwjglApplicationConfiguration();
        config.width = 640;
        config.height = 480;
        config.title = "Java Basics";

        new LwjglApplication(new GameListener(), config);
    }
}