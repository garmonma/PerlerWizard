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
import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;
import com.nni.gamevate.perlerwizard.screens.ScreenAdaptar;
import com.nni.gamevate.perlerwizard.utils.Logger;

/**
 * @author Marcus Garmon 12/29/2016
 *
 */
public class SplashScreen extends ScreenAdaptar {

	private PerlerWizard perlerWizard;
	private OrthographicCamera camera;
	private Viewport viewport;
	private Texture splashBackground;
	private AssetManager assetManager;
	
	private final SpriteBatch batch;
	
	private long _startTime;

	public SplashScreen(PerlerWizard perlerWizard) {
		Logger.log("On Splash Screen");
		
		this.perlerWizard = perlerWizard;
		batch = perlerWizard.getSpriteBatch();
		assetManager = perlerWizard.getAssetManager();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(splashBackground, 0, 0, 1600, 960);
		batch.end();
		
		if(TimeUtils.millis() - _startTime > 3000){
			perlerWizard.setScreen(new LoadingScreen(perlerWizard));	
		}		
	}

	@Override
	public void show() {
		camera = new OrthographicCamera();
		viewport = new FitViewport(GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT, camera);
		_startTime = TimeUtils.millis();
		
		assetManager.load(AssetDescriptors.SPLASH_BACKGROUND);
		assetManager.finishLoading();
		
		splashBackground = assetManager.get(AssetDescriptors.SPLASH_BACKGROUND);
	}

	@Override
	public void hide() {
		dispose();
	}
	
	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
	}
	
	@Override
	public void dispose() {
		
	}
}