package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by harit on 11/17/2016.
 */
public class Robot {
    Animation robotAnimation, attackAnimation, animation;
    TextureAtlas textureAtlas, textureAtlas2;
    Rectangle robot;
    int HP;

    public Robot(Rectangle e) {
        robot = e;
        textureAtlas = new TextureAtlas(Gdx.files.internal("robot_walk/robot_run.pack"));
        textureAtlas2 = new TextureAtlas(Gdx.files.internal("robot-attack/robot_attack.pack"));
        robotAnimation = new Animation(1f / 10f, textureAtlas.getRegions());
        attackAnimation = new Animation(1f / 10f, textureAtlas2.getRegions());
        animation = robotAnimation;
        HP = 700;
    }

    public int getHP() {
        return HP;
    }

    public Rectangle getRectangle() {
        return robot;
    }

    public void changeAnimation(int i) {
        if (i == 1) {
            animation = attackAnimation;
        } else {
            animation = robotAnimation;
        }
    }

    public Animation getRobotAnimation() {
        return animation;
    }
}
