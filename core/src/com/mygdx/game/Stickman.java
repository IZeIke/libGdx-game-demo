package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;

/**
 * Created by harit on 10/20/2016.
 */
public class Stickman {

    private Vector2 position;
    TextureAtlas textureAtlas;
    Texture walk_cycle,walk_cycle_R,stand;
    TextureRegion[] animationframe_L,animationframe_R,animationframe_S,zombieframe_L;
    Animation Run_animation_Left,zombieanimation;
    Animation Run_animation_Right,Run_animation_Stand;
    int LEFT=2;
    int RIGHT=1;
    int STAND=0;
    Enemy zombie;


    public Vector2 getPosition() {
        return position;
    }

    public Stickman(int x,int y)
    {
        position = new Vector2(x,y);
        walk_cycle=new Texture("walkcycle.png");
        walk_cycle_R=new Texture("walkcycle_R (2).png");
        stand = new Texture("stand.png");
        TextureRegion[][] tmpframe_L=TextureRegion.split(walk_cycle,256,256);
        TextureRegion[][] tmpframe_R=TextureRegion.split(walk_cycle_R,128,128);
        TextureRegion[][] tmpframe_S=TextureRegion.split(stand,256,256);
        animationframe_L = new TextureRegion[4];
        animationframe_R = new TextureRegion[4];
        animationframe_S = new TextureRegion[1];
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
        animationframe_S[0]=tmpframe_S[0][0];
        Run_animation_Right = new Animation(1f/4f,animationframe_R);
        Run_animation_Left = new Animation(1f/4f,animationframe_L);
        Run_animation_Stand = new Animation(1f/1f,animationframe_S);
    }

    public Animation Status(int status)
    {
        if(status==LEFT)
        {
            return Run_animation_Left;
        }else
        if(status==RIGHT)
        {
            return  Run_animation_Right;

        }else
        {
            return  Run_animation_Stand;
        }
    }


}
