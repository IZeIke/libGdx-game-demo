package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by harit on 10/20/2016.
 */
public class WorldRenderer {
    DemoGame demoGame;
    World world;
    SpriteBatch batch;
    float elapsedTime;
    private BitmapFont font;
    Array<Rectangle> stickmanArray;
    Array<Swordman> swordmanArray;
    Array<Swordman> swordmanOverlapArray;
    Array<Rectangle> ZombieArray;
    int money;
    int timer;
    Enemy Zombie;
    Array<Rectangle> stickman;
    Array<Rectangle> zombie;
    Rectangle pos;
    int zombieTime;
    Texture background;
    ShapeRenderer shapeRenderer;
    OrthographicCamera camera;
    int index;


    WorldRenderer(DemoGame demoGame, World world) {
        camera = new OrthographicCamera();
        shapeRenderer = new ShapeRenderer();
        stickman = new Array<Rectangle>();
        zombie = new Array<Rectangle>();
        swordmanArray = new Array<Swordman>();
        swordmanOverlapArray = new Array<Swordman>();
        Zombie = new Enemy();
        this.demoGame = demoGame;
        batch = demoGame.batch;
        this.world = world;
        font = new BitmapFont();
        font.getData().setScale(2);
        stickmanArray = new Array<Rectangle>();
        ZombieArray = new Array<Rectangle>();
        money = 0;
        timer = 0;
        zombieTime = 0;
        background = new Texture("background.jpg");
    }

    public void getIndex(int i) {
        index = i;
    }


    public void returnSwordman(Swordman rc) {
        swordmanOverlapArray.add(rc);
    }

    public void returnZombie(Rectangle rc) {
        zombie.add(rc);
    }

    public void render(float delta, int status) {
        elapsedTime += Gdx.graphics.getDeltaTime();
        pos = world.getStickman().getPosition();
        batch.begin();
        //batch.draw(world.getStickman().Status(status).getKeyFrame(elapsedTime, true), pos.x, pos.y);
        batch.draw(background, 0, 0);
        for (Swordman swordman : swordmanArray) {
            returnSwordman(swordman);
            batch.draw(swordman.getSwordmanAnimation().getKeyFrame(elapsedTime, true), swordman.getRectangle().x, swordman.getRectangle().y, 128, 128);
        }

        for (Rectangle zombie : ZombieArray) {
            returnZombie(zombie);
            batch.draw(Zombie.Status().getKeyFrame(elapsedTime, true), zombie.x, zombie.y, 80, 128);
        }

        font.draw(batch, "" + money, 50, 690);
        batch.end();
        if (Gdx.input.justTouched()) {
            if (money > 50) {
                spawnSwordman();
                money -= 50;
            }
        }

        update();
    }

    private void update() {
        swordmanUpdate();
        zombieUpdate();
        timeUpdate();
    }

    private void swordmanUpdate() {
        Iterator<Swordman> iter = swordmanArray.iterator();
        while (iter.hasNext()) {
            Swordman swordman = iter.next();
            try {
                for (int i = 0; i < zombie.size; i++) {
                    if (swordman.getRectangle().overlaps(zombie.get(i))) {
                        swordman.getRectangle().x -= 150 * Gdx.graphics.getDeltaTime();
                        //    swordman.HP--;

                    }
                }
            } catch (IllegalStateException e) {

            }
            System.out.println(swordman.HP);
            swordman.getRectangle().x += 150 * Gdx.graphics.getDeltaTime();
            if (swordman.getHP() == 0) {
                iter.remove();
                for (Swordman swordman1 : swordmanOverlapArray) {
                    swordmanOverlapArray.removeValue(swordman1, true);
                }
            }
            if (swordman.getRectangle().x > 1280) {
                iter.remove();
            }
        }
    }

    private void zombieUpdate() {
        Iterator<Rectangle> iter_zombie = ZombieArray.iterator();
        while (iter_zombie.hasNext()) {
            Rectangle zombie = iter_zombie.next();
            try {
                for (int i = 0; i < swordmanOverlapArray.size; i++) {
                    if (zombie.overlaps(swordmanOverlapArray.get(i).getRectangle())) {
                        zombie.x += 150 * Gdx.graphics.getDeltaTime();
                        swordmanOverlapArray.get(i).HP--;
                    }
                }

                zombie.x -= 150 * Gdx.graphics.getDeltaTime();

                if (zombie.x < 0) {
                    iter_zombie.remove();
                }

            } catch (IllegalStateException e) {

            }

        }
    }

    private void timeUpdate() {
        timer++;
        if (timer > 10) {
            money++;
            timer = 0;
        }

        if (zombieTime > 500) {
            spawnzombie();
            zombieTime = 0;
        }
        zombieTime++;
    }


    private void spawnSwordman() {
        Rectangle stickman = new Rectangle();
        stickman.x = -100;
        stickman.y = 300;
        stickman.width = 80;
        stickman.height = 128;
        Swordman swordman = new Swordman(stickman);
        swordmanArray.add(swordman);
        //stickmanArray.add(stickman);
        // Stickman stickman = new Stickman(-100,300);
        // stickmanArray.add(stickman.getPosition());
    }

    private void spawnzombie() {
        Rectangle zombie = new Rectangle();
        zombie.x = 1500;
        zombie.y = 300;
        zombie.width = 80;
        zombie.height = 128;
        ZombieArray.add(zombie);
    }

}
