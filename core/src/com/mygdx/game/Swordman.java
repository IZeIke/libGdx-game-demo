package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by harit on 11/9/2016.
 */
public class Swordman {
    Animation swordmanAnimation,attackAnimation,animation;
    TextureAtlas textureAtlas,textureAtlas2;
    Rectangle swordman;
    int HP;

    public Swordman() {
        swordman = new Rectangle();
        textureAtlas = new TextureAtlas(Gdx.files.internal("run_R/Knight.pack"));
        textureAtlas2 = new TextureAtlas(Gdx.files.internal("knight_attack/knight_attack.pack"));
        swordmanAnimation = new Animation(1f / 10f, textureAtlas.getRegions());
        HP = 50;
    }

    public Swordman(Rectangle e) {
        swordman = e;
        textureAtlas = new TextureAtlas(Gdx.files.internal("run_R/Knight.pack"));
        textureAtlas2 = new TextureAtlas(Gdx.files.internal("knight_attack/knight_attack.pack"));
        swordmanAnimation = new Animation(1f / 10f, textureAtlas.getRegions());
        attackAnimation = new Animation(1f / 10f, textureAtlas2.getRegions());
        animation=swordmanAnimation;
        HP = 500;
    }

    public int getHP() {
        return HP;
    }

    public Rectangle getRectangle() {
        return swordman;
    }

    public void changeAnimation(int i)
    {
        if(i==1)
        {
            animation = attackAnimation;
        }else
        {
            animation = swordmanAnimation;
        }
    }

    public Animation getSwordmanAnimation() {
        return animation;
    }
}
