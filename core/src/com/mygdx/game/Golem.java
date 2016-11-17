package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by harit on 11/15/2016.
 */
public class Golem {
    Animation golemAnimation, attackAnimation, animation, dieAnimation;
    TextureAtlas textureAtlas, textureAtlas2, textureAtlas3;
    Rectangle golem;
    int HP;

    public Golem(Rectangle e) {
        golem = e;
        textureAtlas = new TextureAtlas(Gdx.files.internal("golem_walk/golem_walk.pack"));
        textureAtlas2 = new TextureAtlas(Gdx.files.internal("golem_attack/golem_attack.pack"));
        textureAtlas3 = new TextureAtlas(Gdx.files.internal("golem_die/golem_die.pack"));
        golemAnimation = new Animation(1f / 10f, textureAtlas.getRegions());
       // attackAnimation = new Animation(1f / 10f, textureAtlas2.getRegions());
        dieAnimation = new Animation(1f / 8f, textureAtlas3.getRegions());
        animation = golemAnimation;
        HP = 1000;
    }

    public int getHP() {
        return HP;
    }

    public Rectangle getRectangle() {
        return golem;
    }

    public void changeAnimation(int i) {
        if (i == 1) {
            animation = attackAnimation;
        } else if (i == 3) {
            animation = dieAnimation;
        } else {
            animation = golemAnimation;
        }
    }

    public Animation getGolemAnimation() {
        return animation;
    }
}
