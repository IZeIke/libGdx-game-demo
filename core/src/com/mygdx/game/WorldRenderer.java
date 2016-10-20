package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by harit on 10/20/2016.
 */
public class WorldRenderer {
    DemoGame demoGame;
    World world;
    SpriteBatch batch;
    float elapsedTime;
    private BitmapFont font;

    WorldRenderer(DemoGame demoGame,World world)
    {
        this.demoGame = demoGame;
        batch = demoGame.batch;
        this.world = world;
        font = new BitmapFont();
    }

    public void render(float delta,int status) {
        Vector2 pos =world.getStickman().getPosition();
        elapsedTime+= Gdx.graphics.getDeltaTime();
        batch.begin();
        batch.draw(world.getStickman().Status(status).getKeyFrame(elapsedTime,true),pos.x,pos.y);
        font.draw(batch, "Hello", 700, 60);
        batch.end();

    }




}
