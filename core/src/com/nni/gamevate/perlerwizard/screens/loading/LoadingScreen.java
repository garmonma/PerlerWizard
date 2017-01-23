package com.nni.gamevate.perlerwizard.screens.loading;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.perlerwizard.GameConstants;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;
import com.nni.gamevate.perlerwizard.screens.game.MainWorldScreen;

public class LoadingScreen extends ScreenAdapter {
	
	private static final float PROGRESS_BAR_WIDTH = GameConstants.UI_SCREEN_WIDTH / 2f; // world units
    private static final float PROGRESS_BAR_HEIGHT = 60; // world units
    
	private PerlerWizard _perlerWizard;
	private AssetManager _assetManager;
	
	private OrthographicCamera _camera;
	private Viewport _viewport;
	private ShapeRenderer _renderer;
	
	private float _progress;
    private float _waitTime = 0.75f;
    private boolean _changeScreen;
	
	public LoadingScreen(PerlerWizard perlerWizard){
		_perlerWizard = perlerWizard;
		_assetManager = perlerWizard.getAssetManager();
	}
	
	@Override
	public void render(float delta) {
		update(delta);
		
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        _viewport.apply();
        _renderer.setProjectionMatrix(_camera.combined);
        _renderer.begin(ShapeRenderer.ShapeType.Filled);
        
        draw();
        
        _renderer.end();
        
        if(_changeScreen){
        	_perlerWizard.setScreen(new MainWorldScreen(_perlerWizard));
        }
	}
	
	@Override
	public void show() {
		_camera = new OrthographicCamera();
		_viewport = new FitViewport(GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT, _camera);
		_renderer = new ShapeRenderer();
		
		_assetManager.load(AssetDescriptors.UI_SKIN);
		_assetManager.load(AssetDescriptors.CASTLE_BACKGROUND);
		
	}
	
	@Override
	public void resize(int width, int height) {
		_viewport.update(width, height, true);
	}
	
	@Override
	public void hide() {
		Gdx.app.log("Loading Screen", "Hide()");
		dispose();
	}
	
	@Override
	public void dispose() {
		Gdx.app.log("LoadingScreen", "dispose()");
		_renderer.dispose();
		_renderer = null;
	}
	
	private void update(float delta){
		_progress = _assetManager.getProgress();
		
		if(_assetManager.update()){
			_waitTime -= delta;
			
			if(_waitTime <= 0){
				_changeScreen = true;
			}
		}
	}
	
	private void draw(){
		float progressBarX = (GameConstants.UI_SCREEN_WIDTH - PROGRESS_BAR_WIDTH) / 2f;
        float progressBarY = (GameConstants.UI_SCREEN_HEIGHT - PROGRESS_BAR_HEIGHT) / 2f;

        _renderer.rect(progressBarX, progressBarY,
                _progress * PROGRESS_BAR_WIDTH, PROGRESS_BAR_HEIGHT
        );
	}
	
	//private static void waitMillis(long millis)
	
	
}