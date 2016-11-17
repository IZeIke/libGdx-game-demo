package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by harit on 11/15/2016.
 */
public class Dracular {
    Animation dracularAnimation, attackAnimation, animation, dieAnimation;
    TextureAtlas textureAtlas, textureAtlas2, textureAtlas3;
    Rectangle dracular;
    int HP;

    public Dracular(Rectangle e) {
        dracular = e;
        textureAtlas = new TextureAtlas(Gdx.files.internal("zombiepack-2/zombiepack.pack"));
        textureAtlas2 = new TextureAtlas(Gdx.files.internal("knight_attack/knight_attack.pack"));
        textureAtlas3 = new TextureAtlas(Gdx.files.internal("die/zombie_die.pack"));
        dracularAnimation = new Animation(1f / 10f, textureAtlas.getRegions());
        attackAnimation = new Animation(1f / 10f, textureAtlas2.getRegions());
        dieAnimation = new Animation(1f / 8f, textureAtlas3.getRegions());
        animation = dracularAnimation;
        HP = 450;
    }

    public int getHP() {
        return HP;
    }

    public Rectangle getRectangle() {
        return dracular;
    }

    public void changeAnimation(int i) {
        if (i == 1) {
            animation = attackAnimation;
        } else if (i == 3) {
            animation = dieAnimation;
        } else {
            animation = dracularAnimation;
        }
    }

    public Animation getDracularAnimation() {
        return animation;
    }
}
