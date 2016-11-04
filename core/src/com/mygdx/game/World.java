package com.mygdx.game;

/**
 * Created by harit on 10/20/2016.
 */
public class World {

    private Stickman stickman;
    private DemoGame demoGame;

    World(DemoGame demoGame) {
        this.demoGame = demoGame;
        stickman = new Stickman(0,50);
    }

    Stickman getStickman() {
        return stickman;
    }
}
