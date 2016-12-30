package com.nni.gamevate.pixelwizard.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.nni.gamevate.pixelwizard.PixelWizard;

/** 
 * 
 * @author Marcus Garmon 12/29/2016
 *
 */
public class SplashScreen extends AbstractScreen {

	public SplashScreen(final PixelWizard pixelWizard) {
		super(pixelWizard);
		System.out.println("On Splash Screen");
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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
