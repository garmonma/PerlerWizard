package com.nni.gamevate.perlerwizard.screens.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nni.gamevate.perlerwizard.GameWorldRenderer;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;
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
	
	private Music _backgroundTrack;
	
	public GameWorldScreen(PerlerWizard perlerWizard) {
		_perlerWizard = perlerWizard;
		_batch = _perlerWizard.getSpriteBatch();
		_assetManager = _perlerWizard.getAssetManager();
	}
	
	@Override
	public void show() {
		_worldController = new GameWorldController();
		_networkController = _perlerWizard.getNetworkController();
		_renderer = new GameWorldRenderer(_worldController, _networkController, _batch, _assetManager);
		
		_backgroundTrack = _assetManager.get(AssetDescriptors.QUINT_SOUND_TRACK);
		_backgroundTrack.setLooping(true);
		_backgroundTrack.play();
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
			_perlerWizard.setScreen(new WaveGameScreen(_perlerWizard));
		}
		
		_worldController.update(delta);
		_renderer.render(delta);
	}
	
	
	@Override
	public void resize(int width, int height) {
		_renderer.resize(width, height);
	}
	
	@Override
	public void hide() {
		super.hide();
		
		_backgroundTrack.stop();
	}
	
	@Override
	public void dispose() {
		super.dispose();
		
		_backgroundTrack.dispose();
	}
}