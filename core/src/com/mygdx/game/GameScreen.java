package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by harit on 10/18/2016.
 */
public class GameScreen extends ScreenAdapter {
    private DemoGame demoGame;
    private World world;
    int status =0;
    int SPEED=5;
    float elapsedTime;

    public GameScreen(DemoGame demoGame)
    {
        this.demoGame=demoGame;
        world = new World(demoGame);
    }

    public void render(float delta) {
        Vector2 pos =world.getStickman().getPosition();
        update(delta);
        elapsedTime+=Gdx.graphics.getDeltaTime();
        SpriteBatch batch= demoGame.batch;
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(world.getStickman().Status(status).getKeyFrame(elapsedTime,true),pos.x,pos.y);
        batch.end();

    }

    private void update(float delta) {
        Vector2 pos =world.getStickman().getPosition();
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            status=world.getStickman().LEFT;
            pos.x-=SPEED;

        }else
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            status=world.getStickman().RIGHT;
            pos.x+=SPEED;
        }else
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            pos.y+=SPEED;
        }
        else
        {
            status=world.getStickman().STAND;
        }
    }




}
