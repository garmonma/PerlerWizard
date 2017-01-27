package com.nni.gamevate.perlerwizard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;
import com.nni.gamevate.perlerwizard.controllers.GameWorldController;
import com.nni.gamevate.perlerwizard.object.Background;

public class GameWorldRenderer implements Disposable{

	private GameWorldController _controller;
	private OrthographicCamera _camera;
	private OrthographicCamera _hudCamera;
	private Viewport _viewport;
	private Viewport _hudViewport;
	
	private SpriteBatch _batch;
	private ShapeRenderer _shapeRenderer;
	private AssetManager _assetManager;
	
	private Texture _castleBackground;
	
	
	public GameWorldRenderer(GameWorldController controller, SpriteBatch batch, AssetManager assetManager){
		_controller = controller;
		_batch = batch;
		_assetManager = assetManager;
		
		init();
	}
	
	private void init(){
		_camera = new OrthographicCamera();
		_hudCamera = new OrthographicCamera();
		
		_viewport = new FitViewport(GameConfig.SCREEN_WIDTH, 
				GameConfig.SCREEN_HEIGHT, _camera);
		
		_hudViewport = new FitViewport(GameConfig.UI_SCREEN_WIDTH, 
				GameConfig.UI_SCREEN_HEIGHT, _hudCamera);
		
		_shapeRenderer = new ShapeRenderer();
		_castleBackground = _assetManager.get(AssetDescriptors.CASTLE_BACKGROUND);
	}
	
	public void render(float detla){
		renderGameWorld();
		
		renderUI();
		
	}
	
	public void resize(int width, int height){
		_viewport.update(width, height, true);
        _hudViewport.update(width, height, true);
		
	}

	@Override
	public void dispose() {
		_shapeRenderer.dispose();
		
	}
	
	private void renderGameWorld(){
		_viewport.apply();
		
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		_batch.setProjectionMatrix(_camera.combined);
		_batch.begin();
		
		Background background = _controller.getCastleBackground();
		_batch.draw(_castleBackground, background.getX(), background.getY());
		
		
		_batch.end();
	}
	
	private void renderUI(){
		_hudViewport.apply();
		
		_batch.setProjectionMatrix(_hudCamera.combined);
		_batch.begin();
		
		_batch.end();
	}
}
