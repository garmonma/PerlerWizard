package com.nni.gamevate.perlerwizard.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.nni.gamevate.perlerwizard.PerlerWizard;

/**
 * 
 * @author Marcus Garmon 12/29/2016
 *
 */
public class MainMenuScreen extends AbstractScreen {

	private OrthographicCamera _camera;
	private PerlerWizard _perlerWizard;
	
	public MainMenuScreen(final PerlerWizard perlerWizard) {
		System.out.println("On Main Menu Screen");
		_perlerWizard = perlerWizard;
		_camera = new OrthographicCamera();
		//_camera.setToOrtho(false, 800, 480);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		_camera.update();
		_perlerWizard.getSpriteBatch().setProjectionMatrix(_camera.combined);

		_perlerWizard.getSpriteBatch().begin();
		_perlerWizard.getFont().draw(_perlerWizard.getSpriteBatch(), "Welcome to Perler Wizard", 1, 3);
		_perlerWizard.getFont().draw(_perlerWizard.getSpriteBatch(), "Tap anyhere to begin!", 1, 3.5f);
		_perlerWizard.getSpriteBatch().end();

		if (Gdx.input.justTouched())
			_perlerWizard.setScreen(new GameScreen(_perlerWizard));

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