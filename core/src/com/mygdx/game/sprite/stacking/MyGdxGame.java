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
    Texture img, img1, img2, img3, imgk1, imgk2;
    OrthographicCamera camera;
    Viewport viewport;

    float timer = 0;

    MyInputProcessor inputProcessor;

    SpriteStack bash, bash1, krest;


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
        camera.position.set(inputProcessor.getX(), inputProcessor.getY(), 0);
        viewport = new FitViewport(800, 480, camera);
        viewport.apply(); // true = center camera


        bash = new SpriteStack(150, 200, batch);
        bash.addTexture(img1, 8);
        bash.addTexture(img3, 5);
        bash.addTexture(img1, 8);
        bash.addTexture(img3, 5);

        bash1 = new SpriteStack(1, 0, batch);
        bash1.addTexture(img1, 8);
        bash1.addTexture(img3, 3);

        krest = new SpriteStack(-50, -100, batch);
        krest.addTexture(imgk1, 20);
        krest.addTexture(imgk2, 4);
        krest.addTexture(imgk1, 10);


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


        this.bash.randerSpriteStack(camera.position.x, camera.position.y, camera.up,inputProcessor.av);
        this.bash1.randerSpriteStack(camera.position.x, camera.position.y, camera.up,inputProcessor.av);
        this.krest.randerSpriteStack(camera.position.x, camera.position.y, camera.up,inputProcessor.av);
        batch.end();

    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
