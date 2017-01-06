package com.nni.gamevate.pixelwizard.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.nni.gamevate.pixelwizard.PixelWizard;

/**
 * 
 * @author Marcus Garmon 12/29/2016
 *
 */
public class MainMenuScreen extends AbstractScreen {

	private OrthographicCamera _camera;
	private PixelWizard _pixelWizard;
	
	public MainMenuScreen(final PixelWizard pixelWizard) {
		System.out.println("On Main Menu Screen");
		_pixelWizard = pixelWizard;
		_camera = new OrthographicCamera();
		//_camera.setToOrtho(false, 800, 480);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		_camera.update();
		_pixelWizard.getSpriteBatch().setProjectionMatrix(_camera.combined);

		_pixelWizard.getSpriteBatch().begin();
		_pixelWizard.getFont().draw(_pixelWizard.getSpriteBatch(), "Welcome to Pixel Wizard", 1, 3);
		_pixelWizard.getFont().draw(_pixelWizard.getSpriteBatch(), "Tap anyhere to begin!", 1, 3.5f);
		_pixelWizard.getSpriteBatch().end();

		if (Gdx.input.justTouched())
			_pixelWizard.setScreen(new GameScreen(_pixelWizard));

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

}