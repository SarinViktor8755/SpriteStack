package com.mygdx.game.sprite.stacking;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

public class SpriteStack {
    SpriteBatch sb;
    ArrayList<Texture> sprite;

    float x, y; // позиция
    float dx, dy; // смещение слоев
   // float viewingAngle; // угол обзора


    public SpriteStack( float x, float y,SpriteBatch sb,float viewingAngle) {
        this.sb = sb;
        this.sprite = new ArrayList<>();
        this.x = x;
        this.y = y;
        //this.viewingAngle = viewingAngle;
    }

    public SpriteStack(float x, float y,SpriteBatch sb) {
        this.sb = sb;
        this.sprite = new ArrayList<>();
        this.x = x;
        this.y = y;
       // this.viewingAngle = 45; // 0 вид сверху
    }

    public void randerSpriteStack(float camX, float camY, Vector3 angelCamera,float viewingAngle) {
       // System.out.println(angelCamera);
        dx = ((camX - x) / -300) + (angelCamera.x * viewingAngle/10);
        if(Math.abs(camX- x) > 600) return;
        dy = ((camY - y) / -300) + (angelCamera.y * viewingAngle/10);
        if(Math.abs(camY- y) > 600) return;

        for (int i = 0; i < sprite.size(); i++) {
            sb.draw(sprite.get(i), x + i * dx, y + i * dy, 100, 100);
        }
    }

    public void addTexture(Texture texture) {
        this.sprite.add(texture);
    }

    public void addTexture(Texture texture, int repeat) {
        for (int i = 0; i < repeat; i++) {
            this.sprite.add(texture);
        }
    }





}
