package com.nni.gamevate.perlerwizard.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.controllers.NetworkController;
import com.nni.gamevate.perlerwizard.object.World;
import com.nni.gamevate.perlerwizard.renderers.WaveRenderer;
import com.nni.gamevate.perlerwizard.screens.ScreenAdaptar;
import com.nni.gamevate.perlerwizard.utils.WaveInputHandler;
import com.nni.gamevate.perlerwizard.waves.Level;

public class WaveGameScreen extends ScreenAdaptar {

	private static final String TAG = WaveGameScreen.class.getSimpleName();
	
	public static World world;	
	public static boolean gameOver;
	public static boolean victory;
	
	private PerlerWizard perlerWizard;
	
	private WaveRenderer waveRenderer;
	
	private SpriteBatch batch;
	private AssetManager assetManager;
	private NetworkController networkController;
	private WaveInputHandler inputHandler;
	
	private OrthographicCamera camera;
	
	public WaveGameScreen(PerlerWizard perlerWizard,Level level) {
		this.perlerWizard = perlerWizard;
		batch = this.perlerWizard.getSpriteBatch();
		assetManager = this.perlerWizard.getAssetManager();
		gameOver = false;
		victory = false;

		world = new World(level);

	}
	
	@Override
	public void show() {
		Gdx.app.log(TAG, "Strarting Wave Screeen");
		networkController = perlerWizard.getNetworkController();		
		camera = new OrthographicCamera();	

		inputHandler = new WaveInputHandler(camera,world);		
		
		waveRenderer = new WaveRenderer(networkController, batch, assetManager,camera,world);
		Gdx.input.setInputProcessor(inputHandler);
		
	}

	@Override
	public void render(float delta) {		
		//_gamePlayController.
		
		world.tick(delta);
		inputHandler.tick(delta);

		
		waveRenderer.render(delta);
		
		if((gameOver || victory) && inputHandler.fire == true){
			perlerWizard.setScreen(new GameWorldScreen(perlerWizard));
		}
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {		
		//super.resize(width, height);
		waveRenderer.resize(width, height);
	}
}
