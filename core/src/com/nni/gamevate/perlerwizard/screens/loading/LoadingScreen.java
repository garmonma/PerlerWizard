package com.nni.gamevate.perlerwizard.screens.loading;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;
import com.nni.gamevate.perlerwizard.screens.game.GameWorldScreen;

public class LoadingScreen extends ScreenAdapter {
	
	private static final float PROGRESS_BAR_WIDTH = GameConfig.UI_SCREEN_WIDTH / 2f; // world units
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
        	_perlerWizard.setScreen(new GameWorldScreen(_perlerWizard));
        }
	}
	
	@Override
	public void show() {
		_camera = new OrthographicCamera();
		_viewport = new FitViewport(GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT, _camera);
		_renderer = new ShapeRenderer();
		
		_assetManager.load(AssetDescriptors.UI_SKIN);
		_assetManager.load(AssetDescriptors.CASTLE_BACKGROUND);
		_assetManager.load(AssetDescriptors.ENERGY_SHIELD_BOX);
		_assetManager.load(AssetDescriptors.REFLECT_SKILL_BOX);
		_assetManager.load(AssetDescriptors.FONT);
		
		_assetManager.load(AssetDescriptors.EVENTS_BUTTON);
		_assetManager.load(AssetDescriptors.EVENTS_BUTTON_PRESSED);
		_assetManager.load(AssetDescriptors.EQUIPMENT_BUTTON);
		_assetManager.load(AssetDescriptors.EQUIPMENT_BUTTON_PRESSED);
		_assetManager.load(AssetDescriptors.MENU_BUTTON);
		_assetManager.load(AssetDescriptors.MENU_BUTTON_PRESSED);
		
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
		float progressBarX = (GameConfig.UI_SCREEN_WIDTH - PROGRESS_BAR_WIDTH) / 2f;
        float progressBarY = (GameConfig.UI_SCREEN_HEIGHT - PROGRESS_BAR_HEIGHT) / 2f;

        _renderer.rect(progressBarX, progressBarY,
                _progress * PROGRESS_BAR_WIDTH, PROGRESS_BAR_HEIGHT
        );
	}
	
	//private static void waitMillis(long millis)
	
	
}