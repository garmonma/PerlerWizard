package com.nni.gamevate.perlerwizard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.perlerwizard.controllers.GamePlayController;
import com.nni.gamevate.perlerwizard.object.UIElement;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.spells.Spell;
import com.nni.gamevate.perlerwizard.utils.InputHandler;

/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class GamePlayRenderer {

	private GamePlayController _controller;
	private OrthographicCamera _camera;
	private OrthographicCamera _hudCamera;
	private Viewport _viewport;
	private Viewport _hudViewport;

	private ShapeRenderer _shapeRenderer;
	private SpriteBatch _batch;
	
	private BitmapFont _font;
	private InputHandler _inputHandler;
	private InputMultiplexer _inputMultiplexer;
	
	private int _shapePosition;
	
	private AssetManager _assetManager;

	public GamePlayRenderer(GamePlayController controller, SpriteBatch batch, AssetManager assetManager) {
		_controller = controller;
		_batch = batch;
		_assetManager = assetManager;
		
		init();
	}
	
	private void init(){
		_camera = new OrthographicCamera();

		_inputHandler = new InputHandler(_controller, _camera);
		_inputMultiplexer = new InputMultiplexer();
		_inputMultiplexer.addProcessor(_inputHandler.getSkillBarProcessor());
		_inputMultiplexer.addProcessor(_inputHandler.getAnalogProcessor());
		Gdx.input.setInputProcessor(_inputMultiplexer);

		_viewport = new FitViewport(GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT, _camera);

		_shapeRenderer = new ShapeRenderer();
		
		
		_batch = new SpriteBatch();
		//_batch.setProjectionMatrix(_camera.combined);

		//FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/blocky_font.TTF"));
		//FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		//int scale = generator.scaleToFitSquare(40, 40, 10);
		//Gdx.app.log("Font Scale", "" + scale);
		
		//_font = generator.generateFont(parameter);

		//generator.dispose();

	}

	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		_shapeRenderer.setProjectionMatrix(_camera.combined);
		
		//ViewportUtils.drawGrid(_viewport, _shapeRenderer);
		drawGameBounds();
		drawShapeRefreshers();
		drawSigilButton();
		drawHeroUIComponents();

		drawSkillBar();
		drawAnalogControl();
		drawHero();
		drawEnemies();
		drawSpells();
	}

	

	public void resize(int width, int height) {
		_viewport.update(width, height, true);
		// hudViewport.update(width, height, true);
		// ViewportUtils.debugPixelPerUnit(viewport);
	}

	private void drawShapeRefreshers(){
		_shapeRenderer.begin(ShapeType.Filled);
		_shapeRenderer.setColor(Color.WHITE);

		_shapeRenderer.rect(
				_controller.getCircleRefresher().getX(),
				_controller.getCircleRefresher().getY(),
				_controller.getCircleRefresher().getWidth(),
				_controller.getCircleRefresher().getHeight()
		);

		_shapeRenderer.rect(
				_controller.getSquareRefresher().getX(),
				_controller.getSquareRefresher().getY(),
				_controller.getSquareRefresher().getWidth(),
				_controller.getSquareRefresher().getHeight()
		);
		_shapeRenderer.rect(
				_controller.getRectangleRefresher().getX(),
				_controller.getRectangleRefresher().getY(),
				_controller.getRectangleRefresher().getWidth(),
				_controller.getRectangleRefresher().getHeight()
		);
		_shapeRenderer.rect(
				_controller.getTriangleRefresher().getX(),
				_controller.getTriangleRefresher().getY(),
				_controller.getTriangleRefresher().getWidth(),
				_controller.getTriangleRefresher().getHeight()
		);
		_shapeRenderer.rect(
				_controller.getTrapazoidRefresher().getX(),
				_controller.getTrapazoidRefresher().getY(),
				_controller.getTrapazoidRefresher().getWidth(),
				_controller.getTrapazoidRefresher().getHeight()
		);

		_shapeRenderer.end();
	}

	private void drawSigilButton() {
		_shapeRenderer.begin(ShapeType.Filled);
		_shapeRenderer.setColor(Color.CHARTREUSE);

		_shapeRenderer.rect(
				_controller.getSigilButton().getX(),
				_controller.getSigilButton().getY(),
				_controller.getSigilButton().getWidth(),
				_controller.getSigilButton().getHeight()
		);

		_shapeRenderer.end();
	}
	
	private void drawHeroUIComponents() {
		_shapeRenderer.begin(ShapeType.Line);
		_shapeRenderer.setColor(Color.GREEN);
		
		for(UIElement node: _controller.getHealthNodes()){
			_shapeRenderer.ellipse(node.getX(), node.getY(), node.getWidth(), node.getHeight());
		}
		
		_shapeRenderer.end();
		
		_shapeRenderer.begin(ShapeType.Filled);
		_shapeRenderer.setColor(Color.GREEN);
		
		
		_shapeRenderer.end();
		
	}

	private void drawHero() {
		// Drawing hero
		_shapeRenderer.begin(ShapeType.Line);
		_shapeRenderer.setColor(Color.BLUE);

		_shapeRenderer.rect(_controller.getHero().getX(), _controller.getHero().getY(), _controller.getHero().getWidth(),
				_controller.getHero().getHeight());

		_shapeRenderer.rect(_controller.getHero().getShield().getX(), _controller.getHero().getShield().getY(),
				_controller.getHero().getShield().getWidth(), _controller.getHero().getShield().getHeight());

		_shapeRenderer.end();
	}

	private void drawEnemies() {
		_shapeRenderer.begin(ShapeType.Line);
		_shapeRenderer.setColor(Color.RED);
		for (Enemy enemy : _controller.getEnemies()) {
			_shapeRenderer.rect(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());

			_shapeRenderer.rect(enemy.getCollisionBounds().x, enemy.getCollisionBounds().y,
					enemy.getCollisionBounds().width, enemy.getCollisionBounds().height);
		}

		_shapeRenderer.end();
	}

	private void drawGameBounds() {
		_shapeRenderer.begin(ShapeType.Filled);
		_shapeRenderer.setColor(Color.SLATE);

		_shapeRenderer.rectLine(_controller.getLeftWall().getX(), _controller.getLeftWall().getY(), _controller.getLeftWall().getX(),
				_controller.getLeftWall().getY() + _controller.getLeftWall().getHeight(), _controller.getLeftWall().getWidth());

		_shapeRenderer.rectLine(_controller.getRightWall().getX(), _controller.getRightWall().getY(),
				_controller.getRightWall().getX(), _controller.getRightWall().getY() + _controller.getRightWall().getHeight(),
				_controller.getRightWall().getWidth());

		_shapeRenderer.rectLine(_controller.getUpperWall().getX(), _controller.getUpperWall().getY(),
				_controller.getUpperWall().getX() + _controller.getUpperWall().getWidth(), _controller.getUpperWall().getY(),
				_controller.getUpperWall().getHeight());

		_shapeRenderer.end();
	}

	private void drawAnalogControl() {
		_shapeRenderer.begin(ShapeType.Filled);
		_shapeRenderer.setColor(Color.WHITE);

		_shapeRenderer.ellipse(
				_controller.getAnalogLeft().getX(), 
				_controller.getAnalogLeft().getY(),
				_controller.getAnalogLeft().getWidth(),
				_controller.getAnalogLeft().getWidth());

		_shapeRenderer.ellipse(
				_controller.getAnalogRight().getX(), 
				_controller.getAnalogRight().getY(),
				_controller.getAnalogRight().getWidth(),
				_controller.getAnalogRight().getHeight());

		_shapeRenderer.end();
	}

	private void drawSpells() {
		_shapeRenderer.begin(ShapeType.Line);

		for (Spell spell : _controller.getSpells()) {
			if (spell.getSpellColor().equalsIgnoreCase("red")) {
				_shapeRenderer.setColor(Color.RED);
			} else if (spell.getSpellColor().equalsIgnoreCase("white")) {
				_shapeRenderer.setColor(Color.WHITE);
			}

			if (spell.getSpellShape().equalsIgnoreCase("circle")) {
				_shapeRenderer.ellipse(spell.getX(), 
						spell.getY(), 
						spell.getWidth(),
						spell.getHeight());
			} else if (spell.getSpellShape().equalsIgnoreCase("rectangle")) {
				_shapeRenderer.rect(spell.getX(), spell.getY(), spell.getWidth(), spell.getHeight());
			}
		}

		_shapeRenderer.end();
	}

	private void drawSkillBar() {
		_shapeRenderer.begin(ShapeType.Line);
		_shapeRenderer.end();

		_shapeRenderer.begin(ShapeType.Line);
		_shapeRenderer.setColor(_controller.getColorSelector().getSpellColor().getColor());
		_shapePosition = _controller.getShapeSelector().getSelectedPosition();

		if (_controller.getShapeSelector().getSpellShape(_shapePosition).toString().equalsIgnoreCase("circle"))
			_shapeRenderer.ellipse(_controller.getSpellBox().getX(), 
					_controller.getSpellBox().getY(), 
					_controller.getSpellBox().getWidth(), 
					_controller.getSpellBox().getHeight());
		
		
		
		if (_controller.getShapeSelector().getSpellShape(_shapePosition).toString().equalsIgnoreCase("rectangle"))
			_shapeRenderer.rect(_controller.getSpellBox().getX(), 
					_controller.getSpellBox().getY(), 
					_controller.getSpellBox().getWidth(),
					_controller.getSpellBox().getHeight());

		_shapeRenderer.end();

		_shapeRenderer.begin(ShapeType.Filled);
		_shapeRenderer.setColor(Color.WHITE);

		_shapeRenderer.triangle(_controller.getBottomArrow().getX() - _controller.getBottomArrow().getWidth(),
				_controller.getBottomArrow().getY() + _controller.getBottomArrow().getHeight(),
				_controller.getBottomArrow().getX() + _controller.getBottomArrow().getWidth(),
				_controller.getBottomArrow().getY() + _controller.getBottomArrow().getHeight(), _controller.getBottomArrow().getX(),
				_controller.getBottomArrow().getY());

		_shapeRenderer.triangle(_controller.getTopArrow().getX() - _controller.getTopArrow().getWidth(),
				_controller.getTopArrow().getY() - _controller.getTopArrow().getHeight(),
				_controller.getTopArrow().getX() + _controller.getTopArrow().getWidth(),
				_controller.getTopArrow().getY() - _controller.getTopArrow().getHeight(), _controller.getTopArrow().getX(),
				_controller.getTopArrow().getY());

		_shapeRenderer.triangle(_controller.getLeftArrow().getX() + _controller.getLeftArrow().getWidth(),
				_controller.getLeftArrow().getY() - _controller.getLeftArrow().getHeight(),
				_controller.getLeftArrow().getX() + _controller.getLeftArrow().getWidth(),
				_controller.getLeftArrow().getY() + _controller.getLeftArrow().getHeight(), _controller.getLeftArrow().getX(),
				_controller.getLeftArrow().getY());

		_shapeRenderer.triangle(_controller.getRightArrow().getX() - _controller.getRightArrow().getWidth(),
				_controller.getRightArrow().getY() - _controller.getRightArrow().getHeight(),
				_controller.getRightArrow().getX() - _controller.getRightArrow().getWidth(),
				_controller.getRightArrow().getY() + _controller.getRightArrow().getHeight(), _controller.getRightArrow().getX(),
				_controller.getRightArrow().getY());

		_shapeRenderer.end();

	}
}