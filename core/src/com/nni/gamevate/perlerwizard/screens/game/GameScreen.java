package com.nni.gamevate.perlerwizard.screens.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nni.gamevate.perlerwizard.GamePlayRenderer;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.controllers.GamePlayController;
import com.nni.gamevate.perlerwizard.controllers.NetworkController;
import com.nni.gamevate.perlerwizard.screens.ScreenAdaptar;

/**
 * @author Marcus Garmon 12/29/2016
 */
public class GameScreen extends ScreenAdaptar {
	
	private PerlerWizard _perlerWizard;
	private GamePlayController _gamePlayController;
	private GamePlayRenderer _renderer;
	
	private SpriteBatch _batch;
	private AssetManager _assetManager;
	private NetworkController _networkController;
	
	public GameScreen(PerlerWizard perlerWizard) {
		_perlerWizard = perlerWizard;
		_batch = _perlerWizard.getSpriteBatch();
		_assetManager = _perlerWizard.getAssetManager();
	}
	
	@Override
	public void render(float delta) {
			
		
		if(!_renderer.isMatchRendering()){
			//return to gameworld;

				_perlerWizard.setScreen(new MainWorldScreen(_perlerWizard));
			
		} else {
			_gamePlayController.update(delta);
			_renderer.render(delta);
		}
	}
		
	@Override
	public void show() {
		_networkController = _perlerWizard.getNetworkController();
		_gamePlayController = new GamePlayController(_networkController);
		_renderer = new GamePlayRenderer(_gamePlayController, _networkController, _batch, _assetManager);

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void resize(int width, int height) {
		_renderer.resize(width, height);
	}
}