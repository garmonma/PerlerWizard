package com.nni.gamevate.perlerwizard.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nni.gamevate.perlerwizard.GameWorldRenderer;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.controllers.GameWorldController;
import com.nni.gamevate.perlerwizard.controllers.NetworkController;
import com.nni.gamevate.perlerwizard.screens.menu.EquipmentScreen;
import com.nni.gamevate.perlerwizard.screens.menu.EventScreen;
import com.nni.gamevate.perlerwizard.screens.menu.MainMenuScreen;

/**
 * @author Marcus Garmon 12/29/2016
 */
public class GameWorldScreen extends ScreenAdapter {
	private PerlerWizard _perlerWizard;
	private GameWorldController _worldController;
	private GameWorldRenderer _renderer;
	
	private SpriteBatch _batch;
	private AssetManager _assetManager;
	private NetworkController _networkController;
	
	public GameWorldScreen(PerlerWizard perlerWizard) {
		_perlerWizard = perlerWizard;
		_batch = _perlerWizard.getSpriteBatch();
		_assetManager = _perlerWizard.getAssetManager();
	}

	@Override
	public void render(float delta) {
		
		if(_worldController.navigateEquipmentScreen()){
			_perlerWizard.setScreen(new EquipmentScreen(_perlerWizard));
		}
		
		if(_worldController.navaigateEventScreen()){
			_perlerWizard.setScreen(new EventScreen(_perlerWizard));
		}
		
		if(_worldController.navigateMenuScreen()){
			_perlerWizard.setScreen(new MainMenuScreen(_perlerWizard));
		}
		
		if(_worldController.navigateGameScreen()){
			_perlerWizard.setScreen(new GameScreen(_perlerWizard));
		}
		
		_worldController.update(delta);
		_renderer.render(delta);
	}
	
	@Override
	public void show() {
		_worldController = new GameWorldController();
		_networkController = _perlerWizard.getNetworkController();
		_renderer = new GameWorldRenderer(_worldController, _networkController, _batch, _assetManager);
	}
	
	@Override
	public void resize(int width, int height) {
		_renderer.resize(width, height);
	}
}