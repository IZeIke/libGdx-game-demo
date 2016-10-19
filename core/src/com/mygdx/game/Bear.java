package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by harit on 10/19/2016.
 */
public class Bear {
    private Vector2 position;

    public Bear(int x, int y) {
        position = new Vector2(x,y);
    }

    public Vector2 getPosition() {
        return position;
    }
}
