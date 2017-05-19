package com.nni.gamevate.perlerwizard.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
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
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;
import com.nni.gamevate.perlerwizard.controllers.GameWorldController;
import com.nni.gamevate.perlerwizard.controllers.NetworkController;
import com.nni.gamevate.perlerwizard.object.Background;
import com.nni.gamevate.perlerwizard.utils.ElementType;
import com.nni.gamevate.perlerwizard.utils.GameElement;
import com.nni.gamevate.perlerwizard.utils.UIElement;
import com.nni.gamevate.perlerwizard.utils.ViewportUtils;
import com.nni.gamevate.perlerwizard.utils.WorldInputHandler;

public class GameWorldRenderer implements Disposable{
	private GameWorldController controller;
	private NetworkController networkController;
	private OrthographicCamera camera;
	private OrthographicCamera hudCamera;
	private Viewport viewport;
	private Viewport hudViewport;
	
	private SpriteBatch batch;
	private ShapeRenderer shapeRenderer;
	private AssetManager assetManager;
	
	private Texture castleBackground;
	private Texture eventButton, eventButtonPressed;
	private Texture equipmentButton, equipmentButtonPressed;
	private Texture menuButton, menuButtonPressed;
	
	private Texture gameNodeBasic;
	
	private Texture verticalDirtRoad;
	private Texture horizontalDirtRoad;
	
	private boolean showDebug = false;
	private final GlyphLayout layout = new GlyphLayout();
	private BitmapFont font;
	
	private WorldInputHandler inputHandler;
	
	public GameWorldRenderer(GameWorldController controller, NetworkController networkController, 
			SpriteBatch batch, AssetManager assetManager){
		this.controller = controller;
		this.networkController = networkController;
		this.batch = batch;
		this.assetManager = assetManager;
		
		init();
	}
	
	private void init(){
		camera = new OrthographicCamera();
		hudCamera = new OrthographicCamera();
		
		viewport = new FitViewport(GameConfig.WORLD_WIDTH, 
				GameConfig.WORLD_HEIGHT, camera);
		
		hudViewport = new FitViewport(GameConfig.UI_SCREEN_WIDTH, 
				GameConfig.UI_SCREEN_HEIGHT, hudCamera);
		
		shapeRenderer = new ShapeRenderer();
		castleBackground = assetManager.get(AssetDescriptors.CASTLE_BACKGROUND);
		
		eventButton = assetManager.get(AssetDescriptors.EVENTS_BUTTON);
		eventButtonPressed = assetManager.get(AssetDescriptors.EVENTS_BUTTON_PRESSED);
		equipmentButton = assetManager.get(AssetDescriptors.EQUIPMENT_BUTTON);
		equipmentButtonPressed = assetManager.get(AssetDescriptors.EQUIPMENT_BUTTON_PRESSED);
		menuButton = assetManager.get(AssetDescriptors.MENU_BUTTON);
		menuButtonPressed = assetManager.get(AssetDescriptors.MENU_BUTTON_PRESSED);
		gameNodeBasic = assetManager.get(AssetDescriptors.GAME_NODE_BASIC);
		
		horizontalDirtRoad = assetManager.get(AssetDescriptors.DIRT_ROAD_HORIZONTAL);
		verticalDirtRoad = assetManager.get(AssetDescriptors.DIRT_ROAD_VERTICAL);
		
		font = assetManager.get(AssetDescriptors.FONT); 
		
		inputHandler = new WorldInputHandler(controller, camera, hudCamera);
		
		InputMultiplexer im = new InputMultiplexer();
		im.addProcessor(inputHandler.getWorldAdapter());
		im.addProcessor(inputHandler.getHudAdapter());
		Gdx.input.setInputProcessor(im);
	}
	
	public void render(float detla){
		renderGameWorld();
		renderUI();
	}
	
	public void resize(int width, int height){
		viewport.update(width, height, true);
        hudViewport.update(width, height, true);
	}

	@Override
	public void dispose() {
		shapeRenderer.dispose();
	}
	
	private void renderGameWorld(){
		viewport.apply();
		
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		
		Background background = controller.getCastleBackground();
//		_batch.draw(_castleBackground, 
//				background.getX(), background.getY(), 
//				background.getWidth(), background.getHeight());		
		
		for(GameElement mapNode: controller.getMapNodes()){
			drawNodes(mapNode);
		}
		
		batch.end();
		
		if(Gdx.input.isKeyPressed(Keys.G)){
			showDebug = !showDebug;
		}
		
		if(showDebug){
			ViewportUtils.drawGrid(viewport, shapeRenderer);
		}
	}
	
	private void renderUI(){
		hudViewport.apply();
		
		batch.setProjectionMatrix(hudCamera.combined);
		batch.begin();
		
		String levelText = "" + controller.getHeroLevel();
        layout.setText(font, levelText);
        
        font.setColor(Color.PURPLE);
        font.getData().setScale(.3f);
        font.draw(batch, levelText,
                20,
                GameConfig.UI_SCREEN_HEIGHT - layout.height
        );

        String coinText = "" + controller.getHeroGold();
        layout.setText(font, coinText);

        font.setColor(Color.GOLD);
        font.getData().setScale(1);
        font.draw(batch, coinText,
                20,
                GameConfig.UI_SCREEN_HEIGHT - 30 - layout.height
        );
        
        
        UIElement uiEventsButton = controller.getEventsButton();
        UIElement uiEquipmentButton = controller.getEquipmentButton();
        UIElement uiMenuButton = controller.getMenuButton();
        
        batch.draw(eventButton, 
        		uiEventsButton.getX(), uiEventsButton.getY(), 
        		uiEventsButton.getWidth(), uiEventsButton.getHeight());		
        
        batch.draw(equipmentButton, 
        		uiEquipmentButton.getX(), uiEquipmentButton.getY(), 
        		uiEquipmentButton.getWidth(), uiEquipmentButton.getHeight());
        
        batch.draw(menuButton, 
        		uiMenuButton.getX(), uiMenuButton.getY(), 
        		uiMenuButton.getWidth(), uiMenuButton.getHeight());	
        
        
        batch.end();
		
	}
	
	private void drawNodes(GameElement mapNode){
		switch(mapNode.getType()){

		case ElementType.BASIC_NODE:
			batch.draw(gameNodeBasic,
					mapNode.getX(), 
					mapNode.getY(), 
					mapNode.getWidth(), 
					mapNode.getHeight());
			break;
		case ElementType.HORIZONTAL_DIRT_ROAD:
			batch.draw(verticalDirtRoad,
					mapNode.getX(), 
					mapNode.getY(), 
					mapNode.getWidth(), 
					mapNode.getHeight());
			break;
		case ElementType.VERTICAL_DIRT_ROAD:
			batch.draw(horizontalDirtRoad,
					mapNode.getX(), 
					mapNode.getY(), 
					mapNode.getWidth(), 
					mapNode.getHeight());
			break;
		case ElementType.KING_CHAMBER_NODE:
			batch.draw(gameNodeBasic,
					mapNode.getX(), 
					mapNode.getY(), 
					mapNode.getWidth(), 
					mapNode.getHeight());
			break;
		}
	}
	
}