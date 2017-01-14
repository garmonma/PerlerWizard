package com.nni.gamevate.perlerwizard;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nni.gamevate.perlerwizard.screens.loading.SplashScreen;

/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class PerlerWizard extends Game {
	
	private SpriteBatch _spriteBatch;
	private AssetManager _assetManager;

	@Override
	public void create() {
		_spriteBatch = new SpriteBatch();
		_assetManager = new AssetManager();
		
		this.setScreen(new SplashScreen(this));
	}

	@Override
	public void dispose() {
		_spriteBatch.dispose();
		_assetManager.dispose();
	}
	
	public SpriteBatch getSpriteBatch(){
		return _spriteBatch;
	}
	
	public AssetManager getAssetManager(){
		return _assetManager;
	}
}