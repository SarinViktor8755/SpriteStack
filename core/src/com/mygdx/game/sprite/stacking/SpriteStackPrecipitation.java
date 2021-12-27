package com.mygdx.game.sprite.stacking;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

public class SpriteStackPrecipitation {
    SpriteBatch sb;
    Texture texture;

    float x, y; // позиция
    float dx, dy; // смещение слоев
    float hide; /// высота
    // float viewingAngle; // угол обзора


    public SpriteStackPrecipitation(float x, float y, SpriteBatch sb, float viewingAngle) {
        this.sb = sb;
        this.x = x;
        this.y = y;
        this.hide = 150;
        //this.viewingAngle = viewingAngle;
    }

    public SpriteStackPrecipitation(float x, float y, SpriteBatch sb) {
        this.sb = sb;

        this.x = x;
        this.y = y;
        // this.viewingAngle = 45; // 0 вид сверху
    }

    public void randerSpriteStack(float camX, float camY, Vector3 angelCamera, float viewingAngle, float deltaTime) {
        // System.out.println(angelCamera);
        this.hide -= 150 * deltaTime;
        if (hide < 0) restart(camX, camY);
        // System.out.println(hide);

        this.x += MathUtils.random(-15*deltaTime,+15*deltaTime);

        dx = ((camX - x) / -300) + (angelCamera.x * viewingAngle / 10);
        if (Math.abs(camX - x) > 600) return;
        dy = ((camY - y) / -300) + (angelCamera.y * viewingAngle / 10);
        if (Math.abs(camY - y) > 600) return;
        float h = 10 / (150 / hide);

        sb.setColor(1, 1, 1, .8f);
        sb.draw(texture, (x + dx * dx) - h / 2, (y + dx * dy), h, h);
        sb.setColor(1, 1, 1, 1);
    }

    public void addTexture(Texture texture) {
        this.texture = texture;
    }

    private void restart(float camX, float camY) {
        this.hide = MathUtils.random(150, 250);
        this.x = camX + MathUtils.random(-300, 300);
        this.y = camY + MathUtils.random(-300, 300);
    }


}
