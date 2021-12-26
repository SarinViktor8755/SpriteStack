package com.mygdx.game.sprite.stacking;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class SpriteStack {
    SpriteBatch sb;
    ArrayList<Texture> sprite;

    public SpriteStack( float x, float y,SpriteBatch sb) {
        this.sb = sb;
        this.sprite = new ArrayList<>();
        this.x = x;
        this.y = y;
    }

    float x, y; // позиция
    float dx, dy; // смещение слоев


    public void randerSpriteStack(float camX, float camY) {
        dx = (camX - x) / -40;
        dy = (camY - y) / -40;

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
