package com.nni.gamevate.perlerwizard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
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
import com.nni.gamevate.perlerwizard.utils.UIElement;
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
	private Texture _eventButton, _eventButtonPressed;
	private Texture _equipmentButton, _equipmentButtonPressed;
	private Texture _menuButton, _menuButtonPressed;
	
	private boolean showDebug = false;
	private final GlyphLayout _layout = new GlyphLayout();
	private BitmapFont _font;
	
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
		
		_eventButton = _assetManager.get(AssetDescriptors.EVENTS_BUTTON);
		_eventButtonPressed = _assetManager.get(AssetDescriptors.EVENTS_BUTTON_PRESSED);
		_equipmentButton = _assetManager.get(AssetDescriptors.EQUIPMENT_BUTTON);
		_equipmentButtonPressed = _assetManager.get(AssetDescriptors.EQUIPMENT_BUTTON_PRESSED);
		_menuButton = _assetManager.get(AssetDescriptors.MENU_BUTTON);
		_menuButtonPressed = _assetManager.get(AssetDescriptors.MENU_BUTTON_PRESSED);

		_font = _assetManager.get(AssetDescriptors.FONT); 
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
		
//		for(MapNode mapNode: _controller.getMapNodes()){
//			_shapeRenderer.ellipse(
//					mapNode.getX(), 
//					mapNode.getY(), 
//					mapNode.getWidth(), 
//					mapNode.getHeight());
//		}
		
		_shapeRenderer.end();
	}
	
	private void renderUI(){
		_hudViewport.apply();
		
		_batch.setProjectionMatrix(_hudCamera.combined);
		_batch.begin();
		
		String levelText = "" + _controller.getHeroLevel();
        _layout.setText(_font, levelText);
        
        _font.setColor(Color.PURPLE);
        _font.getData().setScale(.3f);
        _font.draw(_batch, levelText,
                20,
                GameConfig.UI_SCREEN_HEIGHT - _layout.height
        );

        String coinText = "" + _controller.getHeroGold();
        _layout.setText(_font, coinText);

        _font.setColor(Color.GOLD);
        _font.getData().setScale(1);
        _font.draw(_batch, coinText,
                20,
                GameConfig.UI_SCREEN_HEIGHT - 30 - _layout.height
        );
        
        
        UIElement eventsButton = _controller.getEventsButton();
        UIElement equipmentButton = _controller.getEquipmentButton();
        UIElement menuButton = _controller.getMenuButton();
        
        _batch.draw(_eventButton, 
        		eventsButton.getX(), eventsButton.getY(), 
        		eventsButton.getWidth(), eventsButton.getHeight());		
        
        _batch.draw(_equipmentButton, 
        		equipmentButton.getX(), equipmentButton.getY(), 
        		equipmentButton.getWidth(), equipmentButton.getHeight());
        
        _batch.draw(_menuButton, 
        		menuButton.getX(), menuButton.getY(), 
        		menuButton.getWidth(), menuButton.getHeight());	
        
        
        _batch.end();
		
	}
	
}