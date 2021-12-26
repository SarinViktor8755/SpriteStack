package com.mygdx.game.sprite.stacking;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img, img1, img2, img3,imgk1,imgk2;
    OrthographicCamera camera;
    Viewport viewport;

    float timer = 0;

    MyInputProcessor inputProcessor;


    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("12.png");
        img1 = new Texture("1.png");
        img2 = new Texture("2.png");
        img3 = new Texture("3.png");

        imgk1 = new Texture("11.png");
        imgk2 = new Texture("21.png");


        inputProcessor = new MyInputProcessor();
        Gdx.input.setInputProcessor(inputProcessor);


        camera = new OrthographicCamera(800, 480);
        camera.position.set(inputProcessor.getX(),inputProcessor.getY(), 0);
        viewport = new FitViewport(800, 480, camera);
        viewport.apply(); // true = center camera

    }

    @Override
    public void render() {
        camera.position.set(inputProcessor.getX(),inputProcessor.getY(),0);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        timer += Gdx.graphics.getDeltaTime() * 2;
        ScreenUtils.clear(.3f, .3f, .3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        //	batch.draw(img, 0, 0);
        float x, y;

        batch.setProjectionMatrix(camera.combined);
        batch.draw(img, -250, -300, 800, 800);
        for (int xp = 0; xp < 10; xp++) {
            for (int yp = 0; yp < 10; yp++) {
                x = xp * 150;
                y =  yp * 150;
                float dx, dy;
                dx = (camera.position.x - x) / -40;
                dy = (camera.position.y - y) / -40;
                //   System.out.println(dx);

                for (int i = 0; i < 5; i++) {
                    batch.draw(img1, x + i * dx, y + i * dy, 100, 100);
                }

                for (int i = 5; i < 10; i++) {
                    batch.draw(img3, x + i * dx, y + i * dy, 100, 100);
                }

            }

        }
        ////////////////////////kresty

        x = - 50; y = - 100;
        float dx, dy;
        dx = (camera.position.x - x) / -40;
        dy = (camera.position.y - y) / -40;
        for (int i = 0; i < 20; i++) {
            batch.draw(imgk1, x + i * dx, y + i * dy, 100, 100);
        }

        for (int i = 20; i < 24; i++) {
            batch.draw(imgk2, x + i * dx, y + i * dy, 100, 100);
        }

        for (int i = 24; i < 35; i++) {
            batch.draw(imgk1, x + i * dx, y + i * dy, 100, 100);
        }


//		batch.draw(img3, 0, 0,100,100);
            batch.end();

    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
