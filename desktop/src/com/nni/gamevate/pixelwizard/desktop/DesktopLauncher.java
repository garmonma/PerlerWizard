package com.nni.gamevate.pixelwizard.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nni.gamevate.pixelwizard.GameConstants;
import com.nni.gamevate.pixelwizard.PixelWizard;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Pixel Wizard";
		config.width = (int) GameConstants.SCREEN_WIDTH;
		config.height = (int) GameConstants.SCREEN_HEIGHT;
		
		new LwjglApplication(new PixelWizard(), config);
	}
}