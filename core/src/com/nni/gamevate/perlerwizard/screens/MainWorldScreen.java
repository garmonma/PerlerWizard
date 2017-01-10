package com.nni.gamevate.perlerwizard.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.perlerwizard.GameConstants;
import com.nni.gamevate.perlerwizard.PerlerWizard;

/**
 * 
 * @author Marcus Garmon 12/29/2016
 *
 */
public class MainWorldScreen extends AbstractScreen {

	private OrthographicCamera _camera;
	private PerlerWizard _perlerWizard;
	private Viewport _viewport;
	private ShapeRenderer _shapeRenderer;
	private SpriteBatch _batch;
	private BitmapFont _font;
	
	public MainWorldScreen(final PerlerWizard perlerWizard) {
		System.out.println("On Main Menu Screen");
		_perlerWizard = perlerWizard;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		_camera.update();
		_batch.setProjectionMatrix(_camera.combined);

		_batch.begin();
		_font.draw(_batch, "Welcome to Perler Wizard", 1, 30);
		_font.draw(_batch, "Tap anyhere to begin!", 1, -30);
		_batch.end();

		if (Gdx.input.justTouched())
			_perlerWizard.setScreen(new GameScreen(_perlerWizard));

	}

	@Override
	public void show() {
		_camera = new OrthographicCamera();
		_viewport = new FitViewport(800, 480, _camera);
		_shapeRenderer = new ShapeRenderer();
		_batch = new SpriteBatch();
		_font = new BitmapFont();
		

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void resize(int width, int height) {
		_viewport.update(width, height);
	}

}