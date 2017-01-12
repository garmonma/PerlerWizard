package com.nni.gamevate.perlerwizard;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.perlerwizard.screens.SplashScreen;
import com.nni.gamevate.perlerwizard.utils.AssetLoader;


/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class PerlerWizard extends Game {

	@Override
	public void create() {
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

	}
}