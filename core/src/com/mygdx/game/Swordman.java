package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by harit on 11/9/2016.
 */
public class Swordman {
    Animation SwordmanAnimation;
    TextureAtlas textureAtlas;
    Rectangle swordman;
    int HP;

    public Swordman() {
        swordman = new Rectangle();
        textureAtlas = new TextureAtlas(Gdx.files.internal("run_R/Knight.pack"));
        SwordmanAnimation = new Animation(1f / 10f, textureAtlas.getRegions());
        HP = 5000;

    }

    public Swordman(Rectangle e) {
        swordman = e;
        textureAtlas = new TextureAtlas(Gdx.files.internal("run_R/Knight.pack"));
        SwordmanAnimation = new Animation(1f / 10f, textureAtlas.getRegions());
        HP = 50;
    }

    public int getHP() {
        return HP;
    }

    public Rectangle getRectangle() {
        return swordman;
    }

    public Animation getSwordmanAnimation() {
        return SwordmanAnimation;
    }
}
