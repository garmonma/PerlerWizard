package com.nni.gamevate.perlerwizard.renderers;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;
import com.nni.gamevate.perlerwizard.controllers.GamePlayController;
import com.nni.gamevate.perlerwizard.controllers.NetworkController;
import com.nni.gamevate.perlerwizard.network.gamedata.MatchResult;
import com.nni.gamevate.perlerwizard.object.GameObject;
import com.nni.gamevate.perlerwizard.object.World;
import com.nni.gamevate.perlerwizard.object.hero.Hero;
import com.nni.gamevate.perlerwizard.object.skills.reflectables.WhiteSpell;
import com.nni.gamevate.perlerwizard.screens.game.WaveGameScreen;
import com.nni.gamevate.perlerwizard.utils.GamePlayInputHandler;

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
	
	//Network Instances;
	private MatchResult _matchResult;
	
	private boolean _matchRendering;
	//TODO change to global config
	private int x = 16;
	private int y = 9;

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

		//_viewport = new FitViewport(GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT, _camera);
		_camera = new OrthographicCamera(1600, 900);
		Gdx.app.log(tag, "init");
		_viewport = new FitViewport(x, y, _camera);
		_viewport.apply(false);
		_shapeRenderer = new ShapeRenderer();
		
		_energyShieldBox = _assetManager.get(AssetDescriptors.ENERGY_SHIELD_BOX);
		_reflectBox = _assetManager.get(AssetDescriptors.REFLECT_SKILL_BOX);
		
		_batch = new SpriteBatch();
		
		
		

	}

	public void render(float delta) {
		_camera.update();
		
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		_shapeRenderer.setProjectionMatrix(_camera.combined);
		//
		
		_shapeRenderer.begin(ShapeType.Filled);

		_shapeRenderer.setColor(Color.GRAY);
		_shapeRenderer.rect(0,0, _viewport.getWorldWidth(), _viewport.getWorldHeight());
//		_shapeRenderer.rect(.5f,.5f,1,1);
//		
//		_shapeRenderer.setColor(Color.RED);
//		_shapeRenderer.rect(-0.5f,-0.5f,1,1);

		ArrayList<GameObject> list = _world.getGameObjects();
		for(GameObject g :list){
			if(g instanceof Hero)
				_shapeRenderer.setColor(Color.BLUE);
			else if (g instanceof WhiteSpell)
				_shapeRenderer.setColor(Color.WHITE);
			else
				_shapeRenderer.setColor(Color.PINK);
			_shapeRenderer.rect(g.getX(), g.getY(), g.getWidth(), g.getHeight());			
		}
		
		_shapeRenderer.end();
		
	
	}

	public void resize(int width, int height) {
		Gdx.app.log(tag, "Resized");
		_viewport.update(width ,height, false);
		_viewport.apply();
		Gdx.app.log(tag, _viewport.getLeftGutterWidth() + "");
		//_viewport.getLeftGutterWidth();
		_camera.position.set((float)x /2, (float) y/2, 0);
		//_viewport = new FitViewport(10, 10, _camera);
		//float aspectRatio = (float) width  / (float) height;
		//_camera = new OrthographicCamera(width,height);
		//_viewport = new FitViewport(x, y);
		//_viewport.apply(true);
		
	}


	

	
	
}
