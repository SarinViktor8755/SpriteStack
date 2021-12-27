package com.mygdx.game.sprite.stacking.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.sprite.stacking.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "HotLINE D";
		config.width = 1280/2;
		config.height = 720 /2  ;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
