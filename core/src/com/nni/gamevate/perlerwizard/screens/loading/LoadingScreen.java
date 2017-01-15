package com.nni.gamevate.perlerwizard.screens.loading;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
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

public class LoadingScreen extends ScreenAdapter {
	
	private PerlerWizard _perlerWizard;
	private OrthographicCamera _camera;
	private Viewport _viewport;
	private Texture _splashBackground;
	private AssetManager _assetManager;
	
	private final SpriteBatch _batch;
	
	public LoadingScreen(PerlerWizard perlerWizard){
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
		
	}
	
	@Override
	public void show() {
		_camera = new OrthographicCamera();
		_viewport = new FitViewport(GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT, _camera);
		
		_assetManager.load(AssetDescriptors.UI_SKIN);
		_assetManager.load(AssetDescriptors.SPLASH_BACKGROUND);
		_assetManager.finishLoading();
		
		_splashBackground = _assetManager.get(AssetDescriptors.SPLASH_BACKGROUND);
	}
	

}
