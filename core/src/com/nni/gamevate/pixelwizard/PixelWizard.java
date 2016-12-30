package com.nni.gamevate.pixelwizard;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nni.gamevate.pixelwizard.screens.SplashScreen;
import com.nni.gamevate.pixelwizard.utils.AssetLoader;


/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class PixelWizard extends Game {

	public SpriteBatch batch;
	public BitmapFont font;

	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		AssetLoader.load();
		this.setScreen(new SplashScreen(this));

	}

	public void render() {
		super.render();
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}