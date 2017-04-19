package com.nni.gamevate.perlerwizard.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.controllers.GamePlayController;
import com.nni.gamevate.perlerwizard.controllers.NetworkController;
import com.nni.gamevate.perlerwizard.object.World;
import com.nni.gamevate.perlerwizard.renderers.WaveRenderer;
import com.nni.gamevate.perlerwizard.screens.ScreenAdaptar;
import com.nni.gamevate.perlerwizard.utils.WaveInputHandler;
import com.nni.gamevate.perlerwizard.waves.Level;

public class WaveGameScreen extends ScreenAdaptar {

	private static final String TAG = WaveGameScreen.class.getSimpleName();
	
	public static World _world;	
	public static boolean gameOver;
	public static boolean victory;
	
	private PerlerWizard _perlerWizard;
	
	private WaveRenderer _waveRenderer;
	
	private SpriteBatch _batch;
	private AssetManager _assetManager;
	private NetworkController _networkController;
	private WaveInputHandler _inputHandler;
	
	private OrthographicCamera _camera;
	
	public WaveGameScreen(PerlerWizard perlerWizard,Level level) {
		_perlerWizard = perlerWizard;
		_batch = _perlerWizard.getSpriteBatch();
		_assetManager = _perlerWizard.getAssetManager();
		gameOver = false;
		victory = false;

		_world = new World(level);

	}
	
	@Override
	public void show() {
		Gdx.app.log(TAG, "Strarting Wave Screeen");
		_networkController = _perlerWizard.getNetworkController();		
		_camera = new OrthographicCamera();	

		_inputHandler = new WaveInputHandler(_camera,_world);		
		
		_waveRenderer = new WaveRenderer(_networkController, _batch, _assetManager,_camera,_world);
		Gdx.input.setInputProcessor(_inputHandler);
		
	}

	@Override
	public void render(float delta) {		
		//_gamePlayController.
		
		_world.tick(delta);
		_inputHandler.tick(delta);

		
		_waveRenderer.render(delta);
			// TODO do something different
		if((gameOver || victory) && _inputHandler.fire == true){
			_perlerWizard.setScreen(new GameWorldScreen(_perlerWizard));
		}
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {		
		//super.resize(width, height);
		_waveRenderer.resize(width, height);
	}
}
