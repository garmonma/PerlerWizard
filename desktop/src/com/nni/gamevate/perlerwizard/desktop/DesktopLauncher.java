package com.nni.gamevate.perlerwizard.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nni.gamevate.perlerwizard.GameConstants;
import com.nni.gamevate.perlerwizard.PerlerWizard;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Perler Wizard";
		config.width = (int) GameConstants.SCREEN_WIDTH;
		config.height = (int) GameConstants.SCREEN_HEIGHT;
		
		new LwjglApplication(new PerlerWizard(), config);
	}
}