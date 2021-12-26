package com.mygdx.game.sprite.stacking;

import com.badlogic.gdx.InputProcessor;

public class MyInputProcessor implements InputProcessor {
    float x;
    float y;
    public MyInputProcessor() {
        x = 0;
        y = 0;
    }

    public boolean keyDown (int keycode) {

        if(keycode == 19){
            System.out.println("up");
            y +=10;
        }
        if(keycode == 20){
            System.out.println("down");
            y -=10;
        }
        if(keycode == 21){
            System.out.println("left");
            x -=10;
        }
        if(keycode == 22){
            System.out.println("richt");
            x +=10;
        }

        return false;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean keyUp (int keycode) {
        return false;
    }

    public boolean keyTyped (char character) {

        return false;
    }

    public boolean touchDown (int x, int y, int pointer, int button) {
        System.out.println(button);
        System.out.println("1111");
        return false;
    }

    public boolean touchUp (int x, int y, int pointer, int button) {

        return false;
    }

    public boolean touchDragged (int x, int y, int pointer) {
        this.y = y;
        this.x = x;
        return false;
    }

    public boolean mouseMoved (int x, int y) {
        System.out.println(x);

        return false;
    }

    public boolean scrolled (float amountX, float amountY) {

        return false;
    }
}