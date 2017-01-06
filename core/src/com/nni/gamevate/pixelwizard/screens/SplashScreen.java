package com.nni.gamevate.pixelwizard.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.pixelwizard.GameConstants;
import com.nni.gamevate.pixelwizard.PixelWizard;

/**
 * 
 * @author Marcus Garmon 12/29/2016
 *
 */
public class SplashScreen extends AbstractScreen {

	private PixelWizard _pixelWizard;
	private OrthographicCamera _camera;
	private Viewport _viewport;

	public SplashScreen(final PixelWizard pixelWizard) {
		System.out.println("On Splash Screen");
		_pixelWizard = pixelWizard;

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (Gdx.input.justTouched())
			_pixelWizard.setScreen(new MainMenuScreen(_pixelWizard));
	}

	@Override
	public void show() {
		_camera = new OrthographicCamera();
		_viewport = new FitViewport(GameConstants.WORLD_WIDTH, GameConstants.WORLD_HEIGHT, _camera);

	}

	@Override
	public void hide() {

	}
	
	@Override
	public void resize(int width, int height) {
		_viewport.update(width, height);
	}

}