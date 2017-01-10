package com.nni.gamevate.perlerwizard.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.perlerwizard.GameConstants;
import com.nni.gamevate.perlerwizard.PerlerWizard;

/**
 * 
 * @author Marcus Garmon 12/29/2016
 *
 */
public class SplashScreen extends AbstractScreen {

	private PerlerWizard _perlerWizard;
	private OrthographicCamera _camera;
	private Viewport _viewport;

	public SplashScreen(final PerlerWizard perlerWizard) {
		System.out.println("On Splash Screen");
		_perlerWizard = perlerWizard;

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (Gdx.input.justTouched())
			_perlerWizard.setScreen(new MainWorldScreen(_perlerWizard));
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