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
    
	private PerlerWizard perlerWizard;
	private AssetManager assetManager;
	
	private OrthographicCamera camera;
	private Viewport viewport;
	private ShapeRenderer renderer;
	
	private float progress;
    private float waitTime = 0.75f;
    private boolean changeScreen;
	
	public LoadingScreen(PerlerWizard perlerWizard){
		this.perlerWizard = perlerWizard;
		this.assetManager = perlerWizard.getAssetManager();
	}
	
	@Override
	public void render(float delta) {
		update(delta);
		
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        viewport.apply();
        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        
        draw();
        
        renderer.end();
        
        if(changeScreen){
        	//_perlerWizard.setScreen(new WaveGameScreen(_perlerWizard,new Level_01()));
        	perlerWizard.setScreen(new GameWorldScreen(perlerWizard));

        }
	}
	
	@Override
	public void show() {
		camera = new OrthographicCamera();
		viewport = new FitViewport(GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT, camera);
		renderer = new ShapeRenderer();
		
		//Texture Atlas
		assetManager.load(AssetDescriptors.SPELLS);
		assetManager.load(AssetDescriptors.ENEMIES);
		assetManager.load(AssetDescriptors.OBJECTS);
		
		
		//Misc
		assetManager.load(AssetDescriptors.UI_SKIN);
		assetManager.load(AssetDescriptors.CASTLE_BACKGROUND);
		assetManager.load(AssetDescriptors.ENERGY_SHIELD_BOX);
		assetManager.load(AssetDescriptors.REFLECT_SKILL_BOX);
		//TODO remove for real background... lol
		assetManager.load(AssetDescriptors.FLOOR_BACKGROUND);
		assetManager.load(AssetDescriptors.FONT);
		
		
		// Game World Screen Assets
		assetManager.load(AssetDescriptors.EVENTS_BUTTON);
		assetManager.load(AssetDescriptors.EVENTS_BUTTON_PRESSED);
		assetManager.load(AssetDescriptors.EQUIPMENT_BUTTON);
		assetManager.load(AssetDescriptors.EQUIPMENT_BUTTON_PRESSED);
		assetManager.load(AssetDescriptors.MENU_BUTTON);
		assetManager.load(AssetDescriptors.MENU_BUTTON_PRESSED);
		assetManager.load(AssetDescriptors.GAME_NODE_BASIC);
		assetManager.load(AssetDescriptors.DIRT_ROAD_HORIZONTAL);
		assetManager.load(AssetDescriptors.DIRT_ROAD_VERTICAL);
		
		
		assetManager.load(AssetDescriptors.OVERWORLD_SOUNDTRACK);
		
		assetManager.load(AssetDescriptors.WIZARD);
		
		//Enemies
		assetManager.load(AssetDescriptors.GOBLIN_ATTACK);
		assetManager.load(AssetDescriptors.ORC_STEP_ONE);
		
		// Sound Effects
		assetManager.load(AssetDescriptors.FIRE_SPELL_CAST);
		assetManager.load(AssetDescriptors.FIRE_SPELL_HIT);
		assetManager.load(AssetDescriptors.WATER_SPELL_CAST);
		assetManager.load(AssetDescriptors.WATER_SPELL_HIT);
		assetManager.load(AssetDescriptors.LIGHTNING_SPELL_CAST);
		assetManager.load(AssetDescriptors.LIGHTNING_SPELL_HIT);
		assetManager.load(AssetDescriptors.DEFAULT_SPELL_CAST);
		assetManager.load(AssetDescriptors.DEFAULT_SPELL_HIT);
		assetManager.load(AssetDescriptors.FOREST_SPELL_CAST);
		assetManager.load(AssetDescriptors.FOREST_SPELL_HIT);
	}
	
	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
	}
	
	@Override
	public void hide() {
		Gdx.app.log("Loading Screen", "Hide()");
		dispose();
	}
	
	@Override
	public void dispose() {
		Gdx.app.log("LoadingScreen", "dispose()");
		renderer.dispose();
		renderer = null;
	}
	
	private void update(float delta){
		progress = assetManager.getProgress();
		
		if(assetManager.update()){
			waitTime -= delta;
			
			if(waitTime <= 0){
				changeScreen = true;
			}
		}
	}
	
	private void draw(){
		float progressBarX = (GameConfig.UI_SCREEN_WIDTH - PROGRESS_BAR_WIDTH) / 2f;
        float progressBarY = (GameConfig.UI_SCREEN_HEIGHT - PROGRESS_BAR_HEIGHT) / 2f;

        renderer.rect(progressBarX, progressBarY,
                progress * PROGRESS_BAR_WIDTH, PROGRESS_BAR_HEIGHT
        );
	}
	
	//private static void waitMillis(long millis)
	
	
}