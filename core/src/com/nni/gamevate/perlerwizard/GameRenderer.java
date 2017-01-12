package com.nni.gamevate.perlerwizard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.spells.Spell;
import com.nni.gamevate.perlerwizard.ui.UIControl;
import com.nni.gamevate.perlerwizard.utils.InputHandler;
import com.nni.gamevate.perlerwizard.world.GameWorld;

/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class GameRenderer {

	private GameWorld _world;
	private OrthographicCamera _camera;
	private Viewport _viewport;

	private ShapeRenderer _shapeRenderer;
	private SpriteBatch _batch;
	private int _shapePosition;

	private BitmapFont _font;
	private InputHandler _inputHandler;
	private InputMultiplexer _inputMultiplexer;

	public GameRenderer(final GameWorld world) {
		_world = world;
		init();
	}
	
	private void init(){
		_camera = new OrthographicCamera();

		_inputHandler = new InputHandler(_world, _camera);
		_inputMultiplexer = new InputMultiplexer();
		_inputMultiplexer.addProcessor(_inputHandler.getSkillBarProcessor());
		_inputMultiplexer.addProcessor(_inputHandler.getAnalogProcessor());
		Gdx.input.setInputProcessor(_inputMultiplexer);

		_viewport = new FitViewport(GameConstants.WORLD_WIDTH, GameConstants.WORLD_HEIGHT, _camera);

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
				_world.getCircleRefresher().getX(),
				_world.getCircleRefresher().getY(),
				_world.getCircleRefresher().getWidth(),
				_world.getCircleRefresher().getHeight()
		);

		_shapeRenderer.rect(
				_world.getSquareRefresher().getX(),
				_world.getSquareRefresher().getY(),
				_world.getSquareRefresher().getWidth(),
				_world.getSquareRefresher().getHeight()
		);
		_shapeRenderer.rect(
				_world.getRectangleRefresher().getX(),
				_world.getRectangleRefresher().getY(),
				_world.getRectangleRefresher().getWidth(),
				_world.getRectangleRefresher().getHeight()
		);
		_shapeRenderer.rect(
				_world.getTriangleRefresher().getX(),
				_world.getTriangleRefresher().getY(),
				_world.getTriangleRefresher().getWidth(),
				_world.getTriangleRefresher().getHeight()
		);
		_shapeRenderer.rect(
				_world.getTrapazoidRefresher().getX(),
				_world.getTrapazoidRefresher().getY(),
				_world.getTrapazoidRefresher().getWidth(),
				_world.getTrapazoidRefresher().getHeight()
		);

		_shapeRenderer.end();
	}

	private void drawSigilButton() {
		_shapeRenderer.begin(ShapeType.Filled);
		_shapeRenderer.setColor(Color.CHARTREUSE);

		_shapeRenderer.rect(
				_world.getSigilButton().getX(),
				_world.getSigilButton().getY(),
				_world.getSigilButton().getWidth(),
				_world.getSigilButton().getHeight()
		);

		_shapeRenderer.end();
	}
	
	private void drawHeroUIComponents() {
		_shapeRenderer.begin(ShapeType.Line);
		_shapeRenderer.setColor(Color.GREEN);
		
		for(UIControl node: _world.getHealthNodes()){
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

		_shapeRenderer.rect(_world.getHero().getX(), _world.getHero().getY(), _world.getHero().getWidth(),
				_world.getHero().getHeight());

		_shapeRenderer.rect(_world.getHero().getShield().getX(), _world.getHero().getShield().getY(),
				_world.getHero().getShield().getWidth(), _world.getHero().getShield().getHeight());

		_shapeRenderer.end();
	}

	private void drawEnemies() {
		_shapeRenderer.begin(ShapeType.Line);
		_shapeRenderer.setColor(Color.RED);
		for (Enemy enemy : _world.getEnemies()) {
			_shapeRenderer.rect(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());

			_shapeRenderer.rect(enemy.getCollisionBounds().x, enemy.getCollisionBounds().y,
					enemy.getCollisionBounds().width, enemy.getCollisionBounds().height);
		}

		_shapeRenderer.end();
	}

	private void drawGameBounds() {
		_shapeRenderer.begin(ShapeType.Filled);
		_shapeRenderer.setColor(Color.SLATE);

		_shapeRenderer.rectLine(_world.getLeftWall().getX(), _world.getLeftWall().getY(), _world.getLeftWall().getX(),
				_world.getLeftWall().getY() + _world.getLeftWall().getHeight(), _world.getLeftWall().getWidth());

		_shapeRenderer.rectLine(_world.getRightWall().getX(), _world.getRightWall().getY(),
				_world.getRightWall().getX(), _world.getRightWall().getY() + _world.getRightWall().getHeight(),
				_world.getRightWall().getWidth());

		_shapeRenderer.rectLine(_world.getUpperWall().getX(), _world.getUpperWall().getY(),
				_world.getUpperWall().getX() + _world.getUpperWall().getWidth(), _world.getUpperWall().getY(),
				_world.getUpperWall().getHeight());

		_shapeRenderer.end();
	}

	private void drawAnalogControl() {
		_shapeRenderer.begin(ShapeType.Filled);
		_shapeRenderer.setColor(Color.WHITE);

		_shapeRenderer.ellipse(
				_world.getAnalogLeft().getX(), 
				_world.getAnalogLeft().getY(),
				_world.getAnalogLeft().getWidth(),
				_world.getAnalogLeft().getWidth());

		_shapeRenderer.ellipse(
				_world.getAnalogRight().getX(), 
				_world.getAnalogRight().getY(),
				_world.getAnalogRight().getWidth(),
				_world.getAnalogRight().getHeight());

		_shapeRenderer.end();
	}

	private void drawSpells() {
		_shapeRenderer.begin(ShapeType.Line);

		for (Spell spell : _world.getSpells()) {
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
		_shapeRenderer.setColor(_world.getColorSelector().getSpellColor().getColor());
		_shapePosition = _world.getShapeSelector().getSelectedPosition();

		if (_world.getShapeSelector().getSpellShape(_shapePosition).toString().equalsIgnoreCase("circle"))
			_shapeRenderer.ellipse(_world.getSpellBox().getX(), 
					_world.getSpellBox().getY(), 
					_world.getSpellBox().getWidth(), 
					_world.getSpellBox().getHeight());
		
		
		
		if (_world.getShapeSelector().getSpellShape(_shapePosition).toString().equalsIgnoreCase("rectangle"))
			_shapeRenderer.rect(_world.getSpellBox().getX(), 
					_world.getSpellBox().getY(), 
					_world.getSpellBox().getWidth(),
					_world.getSpellBox().getHeight());

		_shapeRenderer.end();

		_shapeRenderer.begin(ShapeType.Filled);
		_shapeRenderer.setColor(Color.WHITE);

		_shapeRenderer.triangle(_world.getBottomArrow().getX() - _world.getBottomArrow().getWidth(),
				_world.getBottomArrow().getY() + _world.getBottomArrow().getHeight(),
				_world.getBottomArrow().getX() + _world.getBottomArrow().getWidth(),
				_world.getBottomArrow().getY() + _world.getBottomArrow().getHeight(), _world.getBottomArrow().getX(),
				_world.getBottomArrow().getY());

		_shapeRenderer.triangle(_world.getTopArrow().getX() - _world.getTopArrow().getWidth(),
				_world.getTopArrow().getY() - _world.getTopArrow().getHeight(),
				_world.getTopArrow().getX() + _world.getTopArrow().getWidth(),
				_world.getTopArrow().getY() - _world.getTopArrow().getHeight(), _world.getTopArrow().getX(),
				_world.getTopArrow().getY());

		_shapeRenderer.triangle(_world.getLeftArrow().getX() + _world.getLeftArrow().getWidth(),
				_world.getLeftArrow().getY() - _world.getLeftArrow().getHeight(),
				_world.getLeftArrow().getX() + _world.getLeftArrow().getWidth(),
				_world.getLeftArrow().getY() + _world.getLeftArrow().getHeight(), _world.getLeftArrow().getX(),
				_world.getLeftArrow().getY());

		_shapeRenderer.triangle(_world.getRightArrow().getX() - _world.getRightArrow().getWidth(),
				_world.getRightArrow().getY() - _world.getRightArrow().getHeight(),
				_world.getRightArrow().getX() - _world.getRightArrow().getWidth(),
				_world.getRightArrow().getY() + _world.getRightArrow().getHeight(), _world.getRightArrow().getX(),
				_world.getRightArrow().getY());

		_shapeRenderer.end();

	}
}