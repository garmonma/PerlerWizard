package com.nni.gamevate.perlerwizard.renderers;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;
import com.nni.gamevate.perlerwizard.controllers.NetworkController;
import com.nni.gamevate.perlerwizard.network.gamedata.MatchResult;
import com.nni.gamevate.perlerwizard.object.GameObject;
import com.nni.gamevate.perlerwizard.object.World;
import com.nni.gamevate.perlerwizard.object.hero.Hero;
import com.nni.gamevate.perlerwizard.screens.game.WaveGameScreen;
import com.nni.gamevate.perlerwizard.utils.Logger;

public class WaveRenderer {
	
	private static final String tag = WaveRenderer.class.getSimpleName();
	
	
	private NetworkController networkController;
	private OrthographicCamera camera;
	private OrthographicCamera hudCamera;
	private Viewport viewport;
	private Viewport hudViewport;
	
	private OrthographicCamera textCam;
	private Viewport textViewport;

	private ShapeRenderer shapeRenderer;
	
	private SpriteBatch batch;
	
	private BitmapFont font;
	
	private World world;
	
	//private Hero _hero;
	
	private AssetManager assetManager;	
	private Texture _background;
	private TextureRegion _backgroundRegion;
	
	//Network Instances;
	private MatchResult matchResult;	
	private boolean matchRendering;
	
	
	//TODO change to global config
	private int x = (int) GameConfig.WORLD_WIDTH;
	private int y = (int) GameConfig.WORLD_HEIGHT;
	
	private Mesh mesh;
	private ShaderProgram shader;

	public WaveRenderer( NetworkController networkController, SpriteBatch batch, AssetManager assetManager, OrthographicCamera camera,World world) {
		
		this.networkController = networkController;
		this.batch = batch;
		this.assetManager = assetManager;
		this.camera = camera;
		this.world = world;
		init();
	}
	
	private void init(){		
		Logger.log("init");

		camera = new OrthographicCamera(GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT);
		viewport = new FitViewport(x, y, camera);
		viewport.apply(false);
		
		hudCamera =  new OrthographicCamera(GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT);
		hudViewport = new FitViewport(x, y,hudCamera);
		hudViewport.apply(false);
		
		textCam = new OrthographicCamera(Gdx.app.getGraphics().getWidth(),Gdx.app.getGraphics().getHeight());
		

		shapeRenderer = new ShapeRenderer();

		batch = new SpriteBatch();		
		
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		//_font.getData().setScale(2);

		
		_background = assetManager.get(AssetDescriptors.FLOOR_BACKGROUND);
		shader = new ShaderProgram(DefaultShader.getDefaultVertexShader()
				,DefaultShader.getDefaultFragmentShader());
		
		_background.setWrap(TextureWrap.Repeat, TextureWrap.Repeat);
		_backgroundRegion = new TextureRegion(_background);
		_backgroundRegion.setRegion(0,0,_background.getWidth() *3,_background.getHeight());
	}

	public void render(float delta) {
		camera.update();
		hudCamera.update();
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		//
		
	

		drawBackGround();
		
		drawGameObjects();
		//updateCamera(delta);
		updateCamera();
		drawUI();
		
	}
	
	public void updateCamera(){
		camera.position.x = world.camXPos;
		camera.update();
	}
	
	
	public void updateCamera(float delta){
		//Logger.log(_world.getHero().getX() + " ");
		float lerp = 4f;
		float offset = 7;
		Vector3 pos = camera.position;
		Hero hero = world.getHero();
		
		//Logger.log("cam.x: "+ pos.x + " hero.x: "+ hero.getX());
		pos.x -= offset;
		if(hero.getX() - pos.x > 4 ){
		//	Logger.log("Front");
			pos.x += (hero.getX() -4 - pos.x) * lerp * delta ;
		}
		else if(hero.getX() - pos.x < -2){
			//Logger.log("Back");
			pos.x += (hero.getX() +2 - pos.x) * lerp * delta;
		}
		
		pos.x += offset;
		
		camera.position.set(pos);
		camera.update();
		
		
		
	}
	public void drawBackGround(){
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		
		//_batch.draw(_background, 0, 0);
		batch.draw(_backgroundRegion, -9, 0, 0, 0, _backgroundRegion.getRegionWidth(), _backgroundRegion.getRegionHeight(), .01f, .01f, 0);
		//_batch.draw(_background, -9, 0, 0, 0, _background.getWidth(), _background.getHeight(), .01f, .01f, 0,0,0,_background.getWidth(),_background.getHeight(), false, false);
		batch.end();
		
//		_shapeRenderer.begin(ShapeType.Filled);
//		_shapeRenderer.setColor(Color.GRAY);
//		_shapeRenderer.rect(0,0, _viewport.getWorldWidth(), _viewport.getWorldHeight());
//		_shapeRenderer.end();
	}

	
	public void drawUI(){
		shapeRenderer.setProjectionMatrix(hudCamera.combined);
		shapeRenderer.begin(ShapeType.Filled);
		
		shapeRenderer.setColor(world.getHero().getSkillManager().getSelectedSkillColor());
		shapeRenderer.rect(x-1.1f,0.1f , 1,1);
		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.setColor(Color.BLUE);		
		shapeRenderer.rect(world.forwardLine+1,0,.1f,GameConfig.WORLD_HEIGHT);
		shapeRenderer.end();
		
		
		if(WaveGameScreen.gameOver == true){
			// TODO figure out better text solution
			batch.setProjectionMatrix(textCam.combined);
			batch.begin();			
			font.draw(batch, "Game Over\nClick to Return Home", 1, 5);
			batch.end();
		}else if(WaveGameScreen.victory == true){
			batch.setProjectionMatrix(textCam.combined);
			batch.begin();			
			font.draw(batch, "Victory! Congrats\nClick to Return Home", 1, 5);
			batch.end();
		}
	}
	
	
	
	public void drawGameObjects(){
		ArrayList<GameObject> list = world.getGameObjects();
		
		
		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.begin(ShapeType.Filled);
		
		for(GameObject g :list){
			g.draw(shapeRenderer);		
		}
		shapeRenderer.end();
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		
		for(GameObject g :list){
			g.draw(batch);			
//			if(g instanceof Hero)
//				_batch.draw(_wizard, g.getX(), g.getY(), g.getWidth(), g.getHeight());			
		}
		
		batch.end();
	}

	public void resize(int width, int height) {
		Gdx.app.log(tag, "Resized");
		viewport.update(width ,height, false);
		viewport.apply();
		camera.position.set((float)x /2, (float) y/2, 0);
		
		hudViewport.update(width ,height, false);
		hudViewport.apply();
		hudCamera.position.set((float)x /2, (float) y/2, 0);
		
		
	}
	
}
