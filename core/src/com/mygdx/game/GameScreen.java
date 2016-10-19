package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by harit on 10/18/2016.
 */
public class GameScreen extends ScreenAdapter {
    private DemoGame demoGame;
    Texture pedobear_img,miku_img;
    private Miku miku;
    int SPEED =2;

    public GameScreen(DemoGame demoGame)
    {
        this.demoGame=demoGame;
        miku =new Miku(100,100);
        pedobear_img=new Texture("pedobear3.png");
        miku_img=new Texture("miku.png");
    }

    public void render(float delta) {
        SpriteBatch batch= demoGame.batch;
        batch.begin();
        Vector2 pos =miku.getPosition();
        batch.draw(miku_img,pos.x,pos.y);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.end();
        update();
    }

    public void update()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            miku.move(Miku.DIRECTION_LEFT);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            miku.move(Miku.DIRECTION_RIGHT);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            miku.move(Miku.DIRECTION_UP);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            miku.move(Miku.DIRECTION_DOWN);
        }
    }


}
