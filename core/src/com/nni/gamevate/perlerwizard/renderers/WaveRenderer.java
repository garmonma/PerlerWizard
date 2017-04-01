package com.nni.gamevate.perlerwizard.renderers;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
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
import com.nni.gamevate.perlerwizard.object.hero.Hero;
import com.nni.gamevate.perlerwizard.utils.Logger;

public class WaveRenderer {
	
	private static final String tag = WaveRenderer.class.getSimpleName();
	
	private GamePlayController _controller;
	private NetworkController _networkController;
	private OrthographicCamera _camera;
	private OrthographicCamera _hudCamera;
	private Viewport _viewport;
	private Viewport _hudViewport;

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
	
	//Network Instances;
	private MatchResult _matchResult;
	
	private boolean _matchRendering;
	//TODO change to global config
	private int x = (int) GameConfig.WORLD_WIDTH;
	private int y = (int) GameConfig.WORLD_HEIGHT;
	
	private Mesh mesh;
	private ShaderProgram shader;

	public WaveRenderer(GamePlayController controller, NetworkController networkController, SpriteBatch batch, AssetManager assetManager, OrthographicCamera camera,World world) {
		_controller = controller;
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

		_shapeRenderer = new ShapeRenderer();
		
		_energyShieldBox = _assetManager.get(AssetDescriptors.ENERGY_SHIELD_BOX);
		_reflectBox = _assetManager.get(AssetDescriptors.REFLECT_SKILL_BOX);
		
		_batch = new SpriteBatch();		
		
		
		_background = _assetManager.get(AssetDescriptors.FLOOR_BACKGROUND);
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
		
		
		//
		
	

		drawBackGround();
		
		drawGameObjects();
		updateCamera(delta);
		drawUI();
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
		
		_shapeRenderer.end();
	}
	
	
	
	public void drawGameObjects(){
		_shapeRenderer.setProjectionMatrix(_camera.combined);
		_shapeRenderer.begin(ShapeType.Filled);
		ArrayList<GameObject> list = _world.getGameObjects();
		for(GameObject g :list){
			_shapeRenderer.setColor(g.getColor());
//			if(g instanceof Hero)
//				_shapeRenderer.setColor(Color.BLUE);
//			else if (g instanceof WhiteSpell)
//				_shapeRenderer.setColor(Color.WHITE);
//			else
//				_shapeRenderer.setColor(Color.PINK);
			_shapeRenderer.rect(g.getX(), g.getY(), g.getWidth(), g.getHeight());			
		}
		_shapeRenderer.end();
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
