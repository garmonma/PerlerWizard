package com.nni.gamevate.perlerwizard.screens.loading;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.perlerwizard.GameConstants;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;
import com.nni.gamevate.perlerwizard.screens.ScreenAdaptar;
import com.nni.gamevate.perlerwizard.screens.game.MainWorldScreen;

/**
 * 
 * @author Marcus Garmon 12/29/2016
 *
 */
public class SplashScreen extends ScreenAdaptar {

	private PerlerWizard _perlerWizard;
	private OrthographicCamera _camera;
	private Viewport _viewport;
	private Texture _splashBackground;
	private AssetManager _assetManager;
	
	private final SpriteBatch _batch;
	
	private long _startTime;

	public SplashScreen(PerlerWizard perlerWizard) {
		System.out.println("On Splash Screen");
		
		_perlerWizard = perlerWizard;
		_batch = _perlerWizard.getSpriteBatch();
		_assetManager = perlerWizard.getAssetManager();

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		_batch.setProjectionMatrix(_camera.combined);
		_batch.begin();
		_batch.draw(_splashBackground, 0, 0);
		_batch.end();
		
		if(TimeUtils.millis() - _startTime > 3000){
			_perlerWizard.setScreen(new MainWorldScreen(_perlerWizard));	
		}		
	}

	@Override
	public void show() {
		_camera = new OrthographicCamera();
		_viewport = new FitViewport(GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT, _camera);
		_startTime = TimeUtils.millis();
		
		_assetManager.load(AssetDescriptors.UI_SKIN);
		_assetManager.load(AssetDescriptors.SPLASH_BACKGROUND);
		_assetManager.finishLoading();
		
		_splashBackground = _assetManager.get(AssetDescriptors.SPLASH_BACKGROUND);
	}

	@Override
	public void hide() {

	}
	
	@Override
	public void resize(int width, int height) {
		_viewport.update(width, height, true);
	}
	
	@Override
	public void dispose() {
		
	}

}