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
    Texture walk_cycle,walk_cycle_R;
    TextureRegion[] animationframe_L,animationframe_R;
    Animation Run_animation_Left;
    Animation Run_animation_Right;
    float elapsedTime;

    public GameScreen(DemoGame demoGame)
    {
        this.demoGame=demoGame;
        walk_cycle=new Texture("walkcycle.png");
        walk_cycle_R=new Texture("walkcycle_R.png");
        TextureRegion[][] tmpframe_L=TextureRegion.split(walk_cycle,256,256);
        TextureRegion[][] tmpframe_R=TextureRegion.split(walk_cycle_R,256,256);
        animationframe_L = new TextureRegion[4];
        animationframe_R = new TextureRegion[4];
        int index=0;
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<2;j++)
            {
                animationframe_L[index++]=tmpframe_L[i][j];
            }
        }
        int index2=0;
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<2;j++)
            {
                animationframe_R[index2++]=tmpframe_R[i][j];
            }
        }
        Run_animation_Right = new Animation(1f/4f,animationframe_R);
        Run_animation_Left = new Animation(1f/4f,animationframe_L);
    }

    public void render(float delta) {
        elapsedTime+=Gdx.graphics.getDeltaTime();
        SpriteBatch batch= demoGame.batch;
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(Run_animation_Right.getKeyFrame(elapsedTime,true),0,0);
        batch.end();

    }




}
