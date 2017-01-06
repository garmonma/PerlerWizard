package com.nni.gamevate.pixelwizard;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.pixelwizard.screens.SplashScreen;
import com.nni.gamevate.pixelwizard.utils.AssetLoader;


/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class PixelWizard extends Game {
	
	public SpriteBatch _batch;
	public BitmapFont _font;

	@Override
	public void create() {
		_batch = new SpriteBatch();
		_font = new BitmapFont();
		
		AssetLoader.load();
		this.setScreen(new SplashScreen(this));

	}

	public void render() {
		super.render();
	}
	
	@Override
	public void resize(int width, int height) {
		
	}

	public void dispose() {
		_batch.dispose();
		_font.dispose();
	}
	
	
	public SpriteBatch getSpriteBatch(){
		return _batch;
	}
	
	public BitmapFont getFont(){
		return _font;
	}
}