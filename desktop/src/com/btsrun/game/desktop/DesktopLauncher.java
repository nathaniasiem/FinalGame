package com.btsrun.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.btsrun.game.btsgame;

public class DesktopLauncher {
	public static void main (String[] arg) {
            TexturePacker.process("raw", "packed","character");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.width = 800;
                config.height = 300;
		new LwjglApplication(new btsgame(), config); 
	}
}
