package com.nni.gamevate.perlerwizard;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nni.gamevate.perlerwizard.controllers.NetworkController;
import com.nni.gamevate.perlerwizard.network.ClientConnection;
import com.nni.gamevate.perlerwizard.screens.game.WaveGameScreen;
import com.nni.gamevate.perlerwizard.screens.loading.SplashScreen;

/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class PerlerWizard extends Game {
	
	private SpriteBatch _spriteBatch;
	private AssetManager _assetManager;
	private ClientConnection connection;
	private NetworkController networkController;
	
	public static boolean DEBUG = true;
		
	@Override
	public void create() {
		_spriteBatch = new SpriteBatch();
		_assetManager = new AssetManager();
		//TODO Check for internet connection. If no connection close app.
		if(DEBUG == false){
			connection = new ClientConnection();
			networkController = new NetworkController(connection.getClient());			
		}
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
	
	public NetworkController getNetworkController(){
		return networkController;
	}
}