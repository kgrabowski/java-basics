package game;

import app.GameListener;

public class MyGame extends GameListener {
    // We define fields directly inside the class, like this:
    float x = 260;
    float y = 200;

    @Override
    protected void init() {
        // The code to run once at the start of the game goes here
    }

    @Override
    protected void update() {
        // The code to run repeatedly during the game goes here
        var dx = getInputX() * 3;
        var dy = getInputY() * 3;
        x = x + dx;
        y = y + dy;
        drawPlayerPlane(x, y);
    }
}
