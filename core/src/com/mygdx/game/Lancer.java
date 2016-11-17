package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by harit on 11/13/2016.
 */
public class Lancer {
    Animation lancerAnimation,attackAnimation,animation;
    TextureAtlas textureAtlas,textureAtlas2;
    Rectangle lancer;
    int HP;

    public Lancer() {
        lancer = new Rectangle();
        textureAtlas = new TextureAtlas(Gdx.files.internal("ninja_run/ninja_run.pack"));
        textureAtlas2 = new TextureAtlas(Gdx.files.internal("ninja_attack/ninja_attack.pack"));
        lancerAnimation = new Animation(1f / 10f, textureAtlas.getRegions());
        HP = 50;

    }

    public Lancer(Rectangle e) {
        lancer = e;
        textureAtlas = new TextureAtlas(Gdx.files.internal("ninja_run/ninja_run.pack"));
        textureAtlas2 = new TextureAtlas(Gdx.files.internal("ninja_attack/ninja_attack.pack"));
        lancerAnimation = new Animation(0.5f / 10f, textureAtlas.getRegions());
        attackAnimation = new Animation(0.5f / 10f, textureAtlas2.getRegions());
        animation = lancerAnimation;
        HP = 450;
    }

    public int getHP() {
        return HP;
    }

    public Rectangle getRectangle() {
        return lancer;
    }

    public void changeAnimation(int i)
    {
        if(i==1)
        {
            animation = attackAnimation;
        }else
        {
            animation = lancerAnimation;
        }
    }

    public Animation getLancerAnimation() {
        return animation;
    }
}
