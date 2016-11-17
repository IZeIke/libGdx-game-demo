package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by harit on 11/17/2016.
 */
public class Gunner {
    Animation GunnerAnimation, attackAnimation, animation;
    TextureAtlas textureAtlas, textureAtlas2;
    Rectangle gunner;
    int HP;


    public Gunner(Rectangle e) {
        gunner = e;
        textureAtlas = new TextureAtlas(Gdx.files.internal("gunner_walk/gunner_walk.pack"));
        textureAtlas2 = new TextureAtlas(Gdx.files.internal("gunner_shoot/gunner_shoot.pack"));
        GunnerAnimation = new Animation(1f / 8f, textureAtlas.getRegions());
        attackAnimation = new Animation(0.5f / 3f, textureAtlas2.getRegions());
        animation = GunnerAnimation;
        HP = 400;
    }

    public int getHP() {
        return HP;
    }

    public Rectangle getRectangle() {
        return gunner;
    }

    public void changeAnimation(int i) {
        if (i == 1) {
            animation = attackAnimation;
        } else {
            animation = GunnerAnimation;
        }
    }

    public Animation getGunnerAnimation() {
        return animation;
    }
}
