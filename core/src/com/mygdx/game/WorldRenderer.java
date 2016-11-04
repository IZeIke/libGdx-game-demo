package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

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
    Array<Rectangle> ZombieArray;
    long lastDropTime;
    Texture bear;
    int money;
    int timer;
    Enemy Zombie;
    Rectangle stickman;
    Vector2 pos;
    int zombieTime;
    Texture background;

    WorldRenderer(DemoGame demoGame,World world)
    {
        stickman = new Rectangle();
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
        zombieTime=0;
        background = new Texture("background.jpg");
    }

    public void render(float delta,int status) {
        elapsedTime+= Gdx.graphics.getDeltaTime();
        batch.begin();
        //batch.draw(world.getStickman().Status(status).getKeyFrame(elapsedTime, true), pos.x, pos.y);
        batch.draw(background,0,0);
        for(Rectangle stickman: stickmanArray) {
            batch.draw(world.getStickman().Status(status).getKeyFrame(elapsedTime, true), stickman.x, stickman.y, 128,128);

        }

        for(Rectangle zombie: ZombieArray) {
            batch.draw(Zombie.Status().getKeyFrame(elapsedTime, true), zombie.x, zombie.y, 80,128);
        }

        font.draw(batch,""+money,50,690);
        batch.end();
        if(Gdx.input.justTouched()) {
            if(money>50){
                spawnstrick();
                money-=50;
            }
        }

        update();
    }

    private  void  update()
    {
        Iterator<Rectangle> iter = stickmanArray.iterator();
        while(iter.hasNext()) {
            Rectangle stickman = iter.next();
            stickman.x += 150 * Gdx.graphics.getDeltaTime();

        }

        Iterator<Rectangle> iter_zombie = ZombieArray.iterator();
        while(iter_zombie.hasNext()) {
            Rectangle zombie = iter_zombie.next();
            zombie.x -= 80 * Gdx.graphics.getDeltaTime();
            if(zombie.overlaps(stickman))
            {
                System.out.print("555555");
            }
        }

        timer++;
        if(timer>10) {
            money++;
            timer=0;
        }

        if(zombieTime>500)
        {
            spawnzombie();
            zombieTime=0;
        }
        zombieTime++;


    }

    private void spawnstrick() {
        Vector2 pos =world.getStickman().getPosition();
        Rectangle stickman = new Rectangle();
        stickman.x = -100;
        stickman.y = 300;
        stickman.width=128;
        stickman.height=128;
        stickmanArray.add(stickman);
    }

    private void spawnzombie() {
        Rectangle zombie = new Rectangle();
        zombie.x = 1500;
        zombie.y = 300;
        zombie.width=80;
        zombie.height=128;
        ZombieArray.add(zombie);
    }



}
