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
import com.mygdx.game.sprite.stacking.SpriteStackPack.SpriteStack;
import com.mygdx.game.sprite.stacking.SpriteStackPack.SpriteStackPrecipitation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img, img1, img2, img3, imgk1, imgk2, showT;
    OrthographicCamera camera;
    Viewport viewport;



    float timer = 0;

    MyInputProcessor inputProcessor;

    SpriteStack bash, bash1, krest;
    SpriteStackPrecipitation show;
    ArrayList<SpriteStack> arrSS;

    ArrayList<SpriteStackPrecipitation> precipitations;

    HashMap<Float,SpriteStack> stick;

    @Override
    public void create() {
        arrSS = new ArrayList<>();
        precipitations = new ArrayList<>();
        batch = new SpriteBatch();
        img = new Texture("12.png");
        img1 = new Texture("1.png");
        img2 = new Texture("2.png");
        img3 = new Texture("3.png");

        imgk1 = new Texture("11.png");
        imgk2 = new Texture("21.png");
        showT = new Texture("show.png");


        inputProcessor = new MyInputProcessor();
        Gdx.input.setInputProcessor(inputProcessor);


        camera = new OrthographicCamera(800, 480);
        camera.position.set(inputProcessor.getX(), inputProcessor.getY(), 0);
        viewport = new FitViewport(800, 480, camera);
        viewport.apply(); // true = center camera



        for (int i = 0; i < 50; i++) {
            show = new SpriteStackPrecipitation(0,10,batch);
            show.addTexture(showT);
            precipitations.add(show);
        }

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 2; j++) {
                bash = new SpriteStack(200 * i + MathUtils.random(-30, 30), 200 * j + MathUtils.random(-30, 30), batch);
                bash.addTexture(img1, MathUtils.random(5, 20));
                bash.addTexture(img3, MathUtils.random(3, 10));
                if (MathUtils.randomBoolean()) {
                    bash.addTexture(img1, MathUtils.random(5, 20));
                    bash.addTexture(img3, MathUtils.random(3, 10));
                }
                arrSS.add(bash);
            }
        }


        for (int i = 0; i < 15; i++) {
                bash = new SpriteStack(200 * i + MathUtils.random(-30, 30),  -250 + MathUtils.random(-30, 30), batch);
                    bash.addTexture(imgk1, MathUtils.random(15, 25));
                    bash.addTexture(imgk2, 4);
                    bash.addTexture(imgk1, MathUtils.random(7, 12));
                arrSS.add(bash);
            }

        stick = new HashMap<>();
    }

    @Override
    public void render() {
        camera.position.set(inputProcessor.getX(), inputProcessor.getY(), 0);
        camera.rotate(inputProcessor.rcam);
        //inputProcessor.rcam = 0;
        //   System.out.println(camera.up);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        timer += Gdx.graphics.getDeltaTime() * 2;
        ScreenUtils.clear(.3f, .3f, .3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);

        batch.begin();


        batch.setProjectionMatrix(camera.combined);
        batch.draw(img, -250, -300, 800, 800);

        for (int i = 0; i < precipitations.size()/2; i++) {
            precipitations.get(i).randerSpriteStack(camera.position.x, camera.position.y,camera.up, inputProcessor.av,Gdx.graphics.getDeltaTime());
        }

        stick.clear();
        for (int i = 0; i < arrSS.size(); i++) {
            stick.put(arrSS.get(i).getDistance(camera.position.x, camera.position.y),arrSS.get(i));
//            arrSS.get(i).randerSpriteStack(camera.position.x, camera.position.y, camera.up, inputProcessor.av);
//            System.out.println(arrSS.get(i).getDistance(camera.position.x, camera.position.y));
        }

        for (Float key: stick.keySet()){
            System.out.println(stick.size());
            stick.get(key).randerSpriteStack(camera.position.x, camera.position.y, camera.up, inputProcessor.av);
        }
        System.out.println("-------");


        for (int i = precipitations.size()/2; i < precipitations.size(); i++) {
            precipitations.get(i).randerSpriteStack(camera.position.x, camera.position.y,camera.up, inputProcessor.av,Gdx.graphics.getDeltaTime());
        }



        if(MathUtils.randomBoolean(.01f)){
            System.out.println("randodWindow");
            SpriteStackPrecipitation.randodWindow();}

        batch.end();

    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
