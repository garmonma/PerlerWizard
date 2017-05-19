package com.nni.gamevate.perlerwizard.screens.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;
import com.nni.gamevate.perlerwizard.controllers.GameWorldController;
import com.nni.gamevate.perlerwizard.controllers.NetworkController;
import com.nni.gamevate.perlerwizard.renderers.GameWorldRenderer;
import com.nni.gamevate.perlerwizard.screens.menu.EquipmentScreen;
import com.nni.gamevate.perlerwizard.screens.menu.EventScreen;
import com.nni.gamevate.perlerwizard.screens.menu.MainMenuScreen;
import com.nni.gamevate.perlerwizard.waves.chapter01.Chapter_01_01;

/**
 * @author Marcus Garmon 12/29/2016
 */
public class GameWorldScreen extends ScreenAdapter {
	private PerlerWizard perlerWizard;
	private GameWorldController worldController;
	private GameWorldRenderer renderer;
	
	private SpriteBatch batch;
	private AssetManager assetManager;
	private NetworkController networkController;
	
	private Music backgroundTrack;
	
	public GameWorldScreen(PerlerWizard perlerWizard) {
		this.perlerWizard = perlerWizard;
		this.batch = perlerWizard.getSpriteBatch();
		this.assetManager = perlerWizard.getAssetManager();
	}
	
	@Override
	public void show() {
		worldController = new GameWorldController();
		networkController = perlerWizard.getNetworkController();
		renderer = new GameWorldRenderer(worldController, networkController, batch, assetManager);
		
		backgroundTrack = assetManager.get(AssetDescriptors.OVERWORLD_SOUNDTRACK);
		backgroundTrack.setLooping(true);
		backgroundTrack.play();
	}
	

	@Override
	public void render(float delta) {
		
		if(worldController.navigateEquipmentScreen()){
			perlerWizard.setScreen(new EquipmentScreen(perlerWizard));
		}
		
		if(worldController.navaigateEventScreen()){
			perlerWizard.setScreen(new EventScreen(perlerWizard));
		}
		
		if(worldController.navigateMenuScreen()){
			perlerWizard.setScreen(new MainMenuScreen(perlerWizard));
		}
		
		if(worldController.navigateGameScreen()){

			perlerWizard.setScreen(new WaveGameScreen(perlerWizard, new Chapter_01_01()));
		}
		
		worldController.update(delta);
		renderer.render(delta);
	}
	
	
	@Override
	public void resize(int width, int height) {
		renderer.resize(width, height);
	}
	
	@Override
	public void hide() {
		super.hide();
		
		backgroundTrack.stop();
	}
	
	@Override
	public void dispose() {
		super.dispose();
		
		backgroundTrack.dispose();
	}
}