package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by harit on 10/18/2016.
 */
public class GameScreen extends ScreenAdapter {
    private DemoGame demoGame;
    World world;
    WorldRenderer worldRenderer;
    int status=0;
    int SPEED=5;

    public GameScreen(DemoGame demoGame)
    {
        this.demoGame=demoGame;
        world = new World(demoGame);
        worldRenderer = new WorldRenderer(demoGame,world);
    }

    public void render(float delta) {
        update(delta);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        worldRenderer.render(delta,getStatus());
    }

    private void update(float delta) {
        Rectangle pos =world.getStickman().getPosition();
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
        }else
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            pos.y-=SPEED;
        }
        else
        {
            status=world.getStickman().STAND;

        }
    }

    /*private  void update(float delta)
    {
        Vector2 pos =world.getStickman().getPosition();
        status=world.getStickman().RIGHT;
        pos.x+=SPEED;

    } */

    private int getStatus()
    {
        return  status;
    }





}
