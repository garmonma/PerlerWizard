package com.nni.gamevate.perlerwizard;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nni.gamevate.perlerwizard.controllers.NetworkController;
import com.nni.gamevate.perlerwizard.network.ClientConnection;
import com.nni.gamevate.perlerwizard.screens.loading.SplashScreen;

/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class PerlerWizard extends Game {
	
	private SpriteBatch _spriteBatch;
	public static AssetManager assetManager;
	private ClientConnection connection;
	private NetworkController networkController;
	
	//TODO move these settings to another class
	public static boolean DEBUG = true;
	public static boolean DRAW_DEBUG_BOXES = true;
		
	@Override
	public void create() {
		_spriteBatch = new SpriteBatch();
		assetManager = new AssetManager();
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
		assetManager.dispose();
	}
	
	public SpriteBatch getSpriteBatch(){
		return _spriteBatch;
	}
	
	public AssetManager getAssetManager(){
		return assetManager;
	}
	
	public NetworkController getNetworkController(){
		return networkController;
	}
}