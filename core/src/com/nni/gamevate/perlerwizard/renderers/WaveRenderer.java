package com.nni.gamevate.perlerwizard.renderers;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
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
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;
import com.nni.gamevate.perlerwizard.controllers.GamePlayController;
import com.nni.gamevate.perlerwizard.controllers.NetworkController;
import com.nni.gamevate.perlerwizard.network.gamedata.MatchResult;
import com.nni.gamevate.perlerwizard.object.GameObject;
import com.nni.gamevate.perlerwizard.object.World;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imp;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Pixie;
import com.nni.gamevate.perlerwizard.object.hero.Hero;
import com.nni.gamevate.perlerwizard.object.skills.reflectables.FireCast;
import com.nni.gamevate.perlerwizard.object.skills.reflectables.Spell;
import com.nni.gamevate.perlerwizard.object.skills.rushables.Rush;
import com.nni.gamevate.perlerwizard.object.skills.throwables.AxeThrow;
import com.nni.gamevate.perlerwizard.object.skills.throwables.RockThrow;
import com.nni.gamevate.perlerwizard.screens.game.WaveGameScreen;
import com.nni.gamevate.perlerwizard.utils.Logger;

public class WaveRenderer {
	
	private static final String tag = WaveRenderer.class.getSimpleName();
	
	
	private NetworkController _networkController;
	private OrthographicCamera _camera;
	private OrthographicCamera _hudCamera;
	private Viewport _viewport;
	private Viewport _hudViewport;
	
	private OrthographicCamera textCam;
	private Viewport textViewport;

	private ShapeRenderer _shapeRenderer;
	
	private SpriteBatch _batch;
	
	private BitmapFont _font;
	
	private World _world;
	
	//private Hero _hero;
	
	private AssetManager _assetManager;
	
	private Texture _energyShieldBox;
	private Texture _reflectBox;
	private Texture _background;
	private TextureRegion _backgroundRegion;
	private Texture _wizard;
	private Texture _goblin;
	private Texture _orc;
	
	//Network Instances;
	private MatchResult _matchResult;
	
	private boolean _matchRendering;
	//TODO change to global config
	private int x = (int) GameConfig.WORLD_WIDTH;
	private int y = (int) GameConfig.WORLD_HEIGHT;
	
	private Mesh mesh;
	private ShaderProgram shader;

	public WaveRenderer( NetworkController networkController, SpriteBatch batch, AssetManager assetManager, OrthographicCamera camera,World world) {
		
		_networkController = networkController;
		_batch = batch;
		_assetManager = assetManager;
		_camera = camera;
		_world = world;
		init();
	}
	
	private void init(){		
		Logger.log("init");

		_camera = new OrthographicCamera(GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT);
		_viewport = new FitViewport(x, y, _camera);
		_viewport.apply(false);
		
		_hudCamera =  new OrthographicCamera(GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT);
		_hudViewport = new FitViewport(x, y,_hudCamera);
		_hudViewport.apply(false);
		
		textCam = new OrthographicCamera(Gdx.app.getGraphics().getWidth(),Gdx.app.getGraphics().getHeight());
		

		_shapeRenderer = new ShapeRenderer();
		
		_energyShieldBox = _assetManager.get(AssetDescriptors.ENERGY_SHIELD_BOX);
		_reflectBox = _assetManager.get(AssetDescriptors.REFLECT_SKILL_BOX);
		
		_batch = new SpriteBatch();		
		
		_font = new BitmapFont();
		_font.setColor(Color.WHITE);
		//_font.getData().setScale(2);
		
		_wizard = _assetManager.get(AssetDescriptors.WIZARD);
		_goblin = _assetManager.get(AssetDescriptors.GOBLIN_ATTACK);
		_orc = _assetManager.get(AssetDescriptors.ORC_STEP_ONE);
		
		_background = _assetManager.get(AssetDescriptors.TEMP_BACKGROUND);
		shader = new ShaderProgram(DefaultShader.getDefaultVertexShader()
				,DefaultShader.getDefaultFragmentShader());
		
		_background.setWrap(TextureWrap.Repeat, TextureWrap.Repeat);
		_backgroundRegion = new TextureRegion(_background);
		_backgroundRegion.setRegion(0,0,_background.getWidth() *3,_background.getHeight());
	}

	public void render(float delta) {
		_camera.update();
		_hudCamera.update();
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		drawBackGround();
		
		drawGameObjects();
		//updateCamera(delta);
		updateCamera();
		drawUI();
		
	}
	
	public void updateCamera(){
		_camera.position.x = _world.camXPos;
		_camera.update();
	}
	
	
	public void updateCamera(float delta){
		//Logger.log(_world.getHero().getX() + " ");
		float lerp = 4f;
		float offset = 7;
		Vector3 pos = _camera.position;
		Hero hero = _world.getHero();
		
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
		
		_camera.position.set(pos);
		_camera.update();
	}
	
	public void drawBackGround(){
		_batch.setProjectionMatrix(_camera.combined);
		_batch.begin();
		
		//_batch.draw(_background, 0, 0);
		_batch.draw(_backgroundRegion, -9, 0, 0, 0, _backgroundRegion.getRegionWidth(), _backgroundRegion.getRegionHeight(), .01f, .01f, 0);
		//_batch.draw(_background, -9, 0, 0, 0, _background.getWidth(), _background.getHeight(), .01f, .01f, 0,0,0,_background.getWidth(),_background.getHeight(), false, false);
		_batch.end();
		
//		_shapeRenderer.begin(ShapeType.Filled);
//		_shapeRenderer.setColor(Color.GRAY);
//		_shapeRenderer.rect(0,0, _viewport.getWorldWidth(), _viewport.getWorldHeight());
//		_shapeRenderer.end();
	}

	
	public void drawUI(){
		_shapeRenderer.setProjectionMatrix(_hudCamera.combined);
		_shapeRenderer.begin(ShapeType.Filled);
		
		_shapeRenderer.setColor(_world.getHero().getSkillManager().getSelectedSkillColor());
		_shapeRenderer.rect(x-1.1f,0.1f , 1,1);
		_shapeRenderer.setProjectionMatrix(_camera.combined);
		_shapeRenderer.setColor(Color.BLUE);		
		_shapeRenderer.rect(_world.forwardLine+1,0,.1f,GameConfig.WORLD_HEIGHT);
		_shapeRenderer.end();
		
		
		if(WaveGameScreen.gameOver == true){
			// TODO figure out better text solution
			_batch.setProjectionMatrix(textCam.combined);
			_batch.begin();			
			_font.draw(_batch, "Game Over\nClick to Return Home", 1, 5);
			_batch.end();
		}else if(WaveGameScreen.victory == true){
			_batch.setProjectionMatrix(textCam.combined);
			_batch.begin();			
			_font.draw(_batch, "Victory! Congrats\nClick to Return Home", 1, 5);
			_batch.end();
		}
	}
	
	public void drawGameObjects(){
		ArrayList<GameObject> list = _world.getGameObjects();
		
		
		_shapeRenderer.setProjectionMatrix(_camera.combined);
		_shapeRenderer.begin(ShapeType.Filled);
		
		for(GameObject g :list){
			_shapeRenderer.setColor(g.getColor());
			if(g instanceof Hero || g instanceof Goblin 
					|| g instanceof Orc || g instanceof Spell
					|| g instanceof Imp || g instanceof AxeThrow || g instanceof RockThrow
					|| g instanceof Rush || g instanceof Pixie) {
				//_shapeRenderer.setColor(Color.BLUE);				
			}				
			else {
			_shapeRenderer.rect(g.getX(), g.getY(), g.getWidth(), g.getHeight());	
			}
		}
		_shapeRenderer.end();
		
		_batch.setProjectionMatrix(_camera.combined);
		_batch.begin();
		
		for(GameObject g :list){
			if(g instanceof Spell || g instanceof Goblin || g instanceof Imp
					|| g instanceof AxeThrow || g instanceof Orc || g instanceof RockThrow 
					|| g instanceof Rush || g instanceof Pixie)
				g.draw(_batch);
			
			if(g instanceof Hero)
				_batch.draw(_wizard, g.getX(), g.getY(), g.getWidth(), g.getHeight());	
		}
		
		_batch.end();
	}

	public void resize(int width, int height) {
		Gdx.app.log(tag, "Resized");
		_viewport.update(width ,height, false);
		_viewport.apply();
		_camera.position.set((float)x /2, (float) y/2, 0);
		
		_hudViewport.update(width ,height, false);
		_hudViewport.apply();
		_hudCamera.position.set((float)x /2, (float) y/2, 0);
		
		
	}
	
}
