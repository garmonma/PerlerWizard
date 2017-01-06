package com.nni.gamevate.pixelwizard;

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
import com.nni.gamevate.pixelwizard.object.enemies.Enemy;
import com.nni.gamevate.pixelwizard.object.spells.Spell;
import com.nni.gamevate.pixelwizard.utils.InputHandler;
import com.nni.gamevate.pixelwizard.world.GameWorld;

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
	private static final int SKILL_BAR_CIRCLE_RADIUS_PIXELS = 16;

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
		_shapeRenderer.setProjectionMatrix(_camera.combined);

		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/blocky_font.TTF"));

		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 14;
		_font = generator.generateFont(parameter);

		generator.dispose();

		_batch = new SpriteBatch();
		_batch.setProjectionMatrix(_camera.combined);
	}

	public void render(float delta) {
		// Gdx.app.log("GameRenderer", "render");
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		ViewportUtils.drawGrid(_viewport, _shapeRenderer);
		drawInputData();

		drawGameBounds();
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

	private void drawInputData() {
		_batch.begin();
		int mouseX = Gdx.input.getX();
		int mouseY = Gdx.input.getY();

		_font.draw(_batch, "Mouse X : " + mouseX, 1.5f, GameConstants.WORLD_HEIGHT - 1.5f);
		_font.draw(_batch, "Mouse Y : " + mouseY, 1.5f, GameConstants.WORLD_HEIGHT - 3f);

		_batch.end();
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

		_shapeRenderer.circle(_world.getAnalogLeft().getX(), _world.getAnalogLeft().getY(),
				_world.getAnalogLeft().getWidth() / 2);

		_shapeRenderer.circle(_world.getAnalogRight().getX(), _world.getAnalogRight().getY(),
				_world.getAnalogRight().getWidth() / 2);

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
				_shapeRenderer.circle(spell.getX(), spell.getY(), spell.getHeight() / 2);
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
			_shapeRenderer.circle(_world.getSpellBox().getX(), 
					_world.getSpellBox().getY(), 
					_world.getSpellBox().getWidth() / 2);
		
		
		
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