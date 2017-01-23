package com.nni.gamevate.perlerwizard.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nni.gamevate.perlerwizard.GameWorldRenderer;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.controllers.GameWorldController;

/**
 * 
 * @author Marcus Garmon 12/29/2016
 *
 */
public class MainWorldScreen extends ScreenAdapter {
	private PerlerWizard _perlerWizard;
	private GameWorldController _controller;
	private GameWorldRenderer _renderer;
	
	private SpriteBatch _batch;
	private AssetManager _assetManager;
	
	public MainWorldScreen(PerlerWizard perlerWizard) {
		_perlerWizard = perlerWizard;
		_batch = _perlerWizard.getSpriteBatch();
		_assetManager = _perlerWizard.getAssetManager();
	}

	@Override
	public void render(float delta) {
		if(Gdx.input.isTouched()){
			_perlerWizard.setScreen(new GameScreen(_perlerWizard));
		}
		
		_controller.update(delta);
		_renderer.render(delta);
	}
	
	@Override
	public void show() {
		_controller = new GameWorldController();
		_renderer = new GameWorldRenderer(_controller, _batch, _assetManager);
	}
	
	@Override
	public void resize(int width, int height) {
		_renderer.resize(width, height);
	}
}