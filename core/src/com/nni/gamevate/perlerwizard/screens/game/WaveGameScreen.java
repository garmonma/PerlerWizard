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

public class WaveGameScreen extends ScreenAdaptar {

	private static final String TAG = WaveGameScreen.class.getSimpleName();
	
	private PerlerWizard _perlerWizard;
	private GamePlayController _gamePlayController;
	private WaveRenderer _waveRenderer;
	
	private SpriteBatch _batch;
	private AssetManager _assetManager;
	private NetworkController _networkController;
	private World _world;
	private WaveInputHandler _inputHandler;
	
	private OrthographicCamera _camera;
	
	public WaveGameScreen(PerlerWizard perlerWizard) {
		_perlerWizard = perlerWizard;
		_batch = _perlerWizard.getSpriteBatch();
		_assetManager = _perlerWizard.getAssetManager();
	}
	
	@Override
	public void show() {
		Gdx.app.log(TAG, "Strarting Wave Screeen");
		_networkController = _perlerWizard.getNetworkController();
		_gamePlayController = new GamePlayController(_networkController);
		_camera = new OrthographicCamera();
		_world = new World();
		_inputHandler = new WaveInputHandler(_camera,_world);		
		
		_waveRenderer = new WaveRenderer(_gamePlayController, _networkController, _batch, _assetManager,_camera,_world);
		Gdx.input.setInputProcessor(_inputHandler);
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		//_gamePlayController.
		_inputHandler.tick(delta);
		_world.tick(delta);
		_waveRenderer.render(delta);
		
		
		
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
