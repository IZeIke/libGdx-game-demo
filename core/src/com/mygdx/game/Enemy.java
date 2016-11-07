package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by harit on 10/31/2016.
 */
public class Enemy {
    Animation zombieanimation;
    TextureAtlas textureAtlas;
    Rectangle zombie;


    public Enemy()
    {
        zombie=new Rectangle();
        zombie.x=1500;
        zombie.y=300;
        zombie.width=80;
        zombie.height=128;
        textureAtlas = new TextureAtlas(Gdx.files.internal("zombiepack-2/zombiepack.pack"));
        zombieanimation = new Animation(1f/10f, textureAtlas.getRegions());
    }

    public Rectangle getposition()
    {
        return  zombie;
    }

    public Animation Status()
    {
        return  zombieanimation;
    }
}
