package com.nni.gamevate.pixelwizard.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.nni.gamevate.pixelwizard.PixelWizard;

/**
 * 
 * @author Marcus Garmon
 *
 */
public abstract class AbstractScreen implements Screen {

	final PixelWizard _pixelWizard;

	

	public AbstractScreen(final PixelWizard pixelWizard) {
		_pixelWizard = pixelWizard;
		
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

	public PixelWizard getGame() {
		return _pixelWizard;
	}

}