package com.nni.gamevate.perlerwizard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;
import com.nni.gamevate.perlerwizard.controllers.GameWorldController;
import com.nni.gamevate.perlerwizard.controllers.NetworkController;
import com.nni.gamevate.perlerwizard.object.Background;
import com.nni.gamevate.perlerwizard.object.MapNode;
import com.nni.gamevate.perlerwizard.utils.ViewportUtils;

public class GameWorldRenderer implements Disposable{
	private GameWorldController _controller;
	private NetworkController _networkController;
	private OrthographicCamera _camera;
	private OrthographicCamera _hudCamera;
	private Viewport _viewport;
	private Viewport _hudViewport;
	
	private SpriteBatch _batch;
	private ShapeRenderer _shapeRenderer;
	private AssetManager _assetManager;
	
	private Texture _castleBackground;
	
	private boolean showDebug = false;
	
	
	public GameWorldRenderer(GameWorldController controller, NetworkController networkController, 
			SpriteBatch batch, AssetManager assetManager){
		_controller = controller;
		_networkController = networkController;
		_batch = batch;
		_assetManager = assetManager;
		
		init();
	}
	
	private void init(){
		_camera = new OrthographicCamera();
		_hudCamera = new OrthographicCamera();
		
		_viewport = new FitViewport(GameConfig.WORLD_WIDTH, 
				GameConfig.WORLD_HEIGHT, _camera);
		
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
		_batch.draw(_castleBackground, 
				background.getX(), background.getY(), 
				background.getWidth(), background.getHeight());		
		
		_batch.end();
		
		if(Gdx.input.isKeyPressed(Keys.G)){
			showDebug = !showDebug;
		}
		
		if(showDebug){
			ViewportUtils.drawGrid(_viewport, _shapeRenderer);
		}
		
		_shapeRenderer.setProjectionMatrix(_camera.combined);
		_shapeRenderer.begin(ShapeType.Filled);
		_shapeRenderer.setColor(Color.YELLOW);
		
		for(MapNode mapNode: _controller.getMapNodes()){
			_shapeRenderer.ellipse(
					mapNode.getX(), 
					mapNode.getY(), 
					mapNode.getWidth(), 
					mapNode.getHeight());
		}
		
		
		_shapeRenderer.end();
	}
	
	private void renderUI(){
		_hudViewport.apply();
		
		_batch.setProjectionMatrix(_hudCamera.combined);
		_batch.begin();
		
		_batch.end();
	}
}