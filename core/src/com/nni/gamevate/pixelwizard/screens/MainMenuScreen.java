package com.nni.gamevate.pixelwizard.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.nni.gamevate.pixelwizard.PixelWizard;

/**
 * 
 * @author Marcus Garmon
 *
 */
public class MainMenuScreen extends AbstractScreen {

	public MainMenuScreen(final PixelWizard pixelWizard) {
		super(pixelWizard);
		System.out.println("On Main Menu Screen");
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		_camera.update();
		_pixelWizard.batch.setProjectionMatrix(_camera.combined);

		_pixelWizard.batch.begin();
		_pixelWizard.font.draw(_pixelWizard.batch, "Welcome to Pixel Wizard", 100, 150);
		_pixelWizard.font.draw(_pixelWizard.batch, "Tap anyhere to begin!", 100, 100);
		_pixelWizard.batch.end();

		if (Gdx.input.justTouched())
			getGame().setScreen(new GameScreen(getGame()));

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

}