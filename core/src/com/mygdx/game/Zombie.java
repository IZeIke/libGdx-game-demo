package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by harit on 11/12/2016.
 */
public class Zombie {
    Animation zombieAnimation, attackAnimation, animation, dieAnimation;
    TextureAtlas textureAtlas, textureAtlas2, textureAtlas3;
    Rectangle zombie;
    int HP;

    public Zombie() {
        zombie = new Rectangle();
        textureAtlas = new TextureAtlas(Gdx.files.internal("zombiepack-2/zombiepack.pack"));
        textureAtlas2 = new TextureAtlas(Gdx.files.internal("knight_attack/knight_attack.pack"));
        zombieAnimation = new Animation(1f / 10f, textureAtlas.getRegions());
        HP = 50;

    }

    public Zombie(Rectangle e) {
        zombie = e;
        textureAtlas = new TextureAtlas(Gdx.files.internal("zombiepack-2/zombiepack.pack"));
        textureAtlas2 = new TextureAtlas(Gdx.files.internal("knight_attack/knight_attack.pack"));
        textureAtlas3 = new TextureAtlas(Gdx.files.internal("die/zombie_die.pack"));
        zombieAnimation = new Animation(1f / 10f, textureAtlas.getRegions());
        attackAnimation = new Animation(1f / 10f, textureAtlas2.getRegions());
        dieAnimation = new Animation(1f / 8f, textureAtlas3.getRegions());
        animation = zombieAnimation;
        HP = 450;
    }

    public int getHP() {
        return HP;
    }

    public Rectangle getRectangle() {
        return zombie;
    }

    public void changeAnimation(int i) {
        if (i == 1) {
            animation = attackAnimation;
        } else if (i == 3) {
            animation = dieAnimation;
        } else {
            animation = zombieAnimation;
        }
    }

    public Animation getZombieAnimation() {
        return animation;
    }
}
