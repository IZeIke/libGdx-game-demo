package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by harit on 10/20/2016.
 */
public class Stickman {

    private Vector2 position;
    Texture walk_cycle,walk_cycle_R;
    TextureRegion[] animationframe_L,animationframe_R;
    Animation Run_animation_Left;
    Animation Run_animation_Right;
    int LEFT=2;
    int RIGHT=1;
    int STAND=0;

    public Stickman()
    {
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

    public Animation Status(int status)
    {
        if(status==LEFT)
        {
            return Run_animation_Left;
        }else
        {
            return  Run_animation_Right;
        }
    }

    public Stickman(int x,int y)
    {
        position = new Vector2(x,y);
    }

    public Vector2 getPosition() {
        return position;
    }
}
