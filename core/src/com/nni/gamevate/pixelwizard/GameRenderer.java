package com.nni.gamevate.pixelwizard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.nni.gamevate.pixelwizard.object.enemies.Enemy;
import com.nni.gamevate.pixelwizard.object.spells.Spell;
import com.nni.gamevate.pixelwizard.world.GameWorld;

public class GameRenderer {

	private GameWorld _world;
	private OrthographicCamera _camera;
	
	private ShapeRenderer _shapeRenderer;
	private int _colorPosition;
	private int _shapePosition;
	private static final int SKILL_BAR_CIRCLE_RADIUS_PIXELS = 16;

	
	public GameRenderer(GameWorld world){
		_world = world;	
		_camera = new OrthographicCamera();
		_camera.setToOrtho(false, 800, 480);

		_shapeRenderer = new ShapeRenderer();
		_shapeRenderer.setProjectionMatrix(_camera.combined);
	}
	
	public void render(){
		//Gdx.app.log("GameRenderer", "render");
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		drawGameBounds();		
		drawSkillBar();
		drawAnalogControl();
		drawHero();
		drawEnemies();
		drawSpells();
		
	}
	
	private void drawHero(){
		//Drawing hero
		_shapeRenderer.begin(ShapeType.Line);
		_shapeRenderer.setColor(Color.BLUE);
		
		_shapeRenderer.rect(_world.getHero().getX(), _world.getHero().getY(),
				_world.getHero().getWidth(), _world.getHero().getHeight());
		
		_shapeRenderer.rect(_world.getHero().getShield().getX(), _world.getHero().getShield().getY(),
				_world.getHero().getShield().getWidth(), _world.getHero().getShield().getHeight());
		
		
		_shapeRenderer.end();
	}
	
	private void drawEnemies(){
		_shapeRenderer.begin(ShapeType.Line);
		_shapeRenderer.setColor(Color.RED);
		for(Enemy enemy: _world.getEnemies()){
			_shapeRenderer.rect(enemy.getX(), enemy.getY(), 
					enemy.getWidth(), enemy.getHeight());
			
			_shapeRenderer.rect(enemy.getCollisionBounds().x, enemy.getCollisionBounds().y, 
					enemy.getCollisionBounds().width, enemy.getCollisionBounds().height);
		}
		
		_shapeRenderer.end();
	}
	
	
	private void drawGameBounds(){
		_shapeRenderer.begin(ShapeType.Filled);
		_shapeRenderer.setColor(Color.SLATE);
		
		_shapeRenderer.rectLine(150 - 4, 1, 150 - 4, 480, 5);
		_shapeRenderer.rectLine(655, 1, 655, 480, 4);
		_shapeRenderer.rectLine(150 - 4, 480-4, 655, 480-4, 5);
		
		_shapeRenderer.end();
	}
	
	private void drawAnalogControl(){
		_shapeRenderer.begin(ShapeType.Filled);
		_shapeRenderer.setColor(Color.WHITE);
		
		_shapeRenderer.circle(700, 40, 10);
		_shapeRenderer.circle(800, 40, 10);
		
		_shapeRenderer.end();
	}
	
	private void drawSpells(){
		_shapeRenderer.begin(ShapeType.Line);
		
		for(Spell spell: _world.getSpells()){
			if(spell.getSpellColor().equalsIgnoreCase("red")){
				_shapeRenderer.setColor(Color.RED);
			} else if(spell.getSpellColor().equalsIgnoreCase("white")) {
				_shapeRenderer.setColor(Color.WHITE);
			}
			
			if(spell.getSpellShape().equalsIgnoreCase("circle")){
				_shapeRenderer.circle(spell.getX(), spell.getY(), spell.getHeight() / 2);
			} else if(spell.getSpellShape().equalsIgnoreCase("rectangle")){
				_shapeRenderer.rect(spell.getX(), spell.getY(), spell.getWidth(), spell.getHeight());
			}
		}
	
		_shapeRenderer.end();
	}
	
	private void drawSkillBar(){
		_shapeRenderer.begin(ShapeType.Line);
		
		_colorPosition = (_world.getColorSelector().getSelectedPosition() + 1) % 4;	
		_shapeRenderer.setColor(_world.getColorSelector().getSpellColor(_colorPosition).getColor());
		if(_world.getShapeSelector().getSpellShape().toString().equalsIgnoreCase("circle"))
			_shapeRenderer.circle(54 + SKILL_BAR_CIRCLE_RADIUS_PIXELS, 
					84 + SKILL_BAR_CIRCLE_RADIUS_PIXELS, SKILL_BAR_CIRCLE_RADIUS_PIXELS);
		if(_world.getShapeSelector().getSpellShape().toString().equalsIgnoreCase("rectangle"))
			_shapeRenderer.rect(54, 84, 32, 32);
		
		_colorPosition = (_world.getColorSelector().getSelectedPosition() + 2) % 4;
		_shapeRenderer.setColor(_world.getColorSelector().getSpellColor(_colorPosition).getColor());
		if(_world.getShapeSelector().getSpellShape().toString().equalsIgnoreCase("circle"))
			_shapeRenderer.circle(54 + SKILL_BAR_CIRCLE_RADIUS_PIXELS, 
					118 + SKILL_BAR_CIRCLE_RADIUS_PIXELS, SKILL_BAR_CIRCLE_RADIUS_PIXELS);
		if(_world.getShapeSelector().getSpellShape().toString().equalsIgnoreCase("rectangle"))
			_shapeRenderer.rect(54, 118, 32, 32 );
		
		_shapeRenderer.end();
		
		
		// Draw the spell shapes
		_shapeRenderer.begin(ShapeType.Line);
		_shapeRenderer.setColor(_world.getColorSelector().getSpellColor().getColor());
		_shapePosition = _world.getShapeSelector().getSelectedPosition();
		
		if(_world.getShapeSelector().getSpellShape(_shapePosition).toString().equalsIgnoreCase("circle"))
			_shapeRenderer.circle(54 + SKILL_BAR_CIRCLE_RADIUS_PIXELS, 
					50 + SKILL_BAR_CIRCLE_RADIUS_PIXELS, SKILL_BAR_CIRCLE_RADIUS_PIXELS);
		if(_world.getShapeSelector().getSpellShape(_shapePosition).toString().equalsIgnoreCase("rectangle"))
			_shapeRenderer.rect(54, 50, 32, 32);
		
		_shapePosition = (_world.getShapeSelector().getSelectedPosition() + 4 - 1) % 4;
		if(_world.getShapeSelector().getSpellShape(_shapePosition).toString().equalsIgnoreCase("circle"))
			_shapeRenderer.circle(20 + SKILL_BAR_CIRCLE_RADIUS_PIXELS, 
					50 + SKILL_BAR_CIRCLE_RADIUS_PIXELS, SKILL_BAR_CIRCLE_RADIUS_PIXELS);
		if(_world.getShapeSelector().getSpellShape(_shapePosition).toString().equalsIgnoreCase("rectangle"))
			_shapeRenderer.rect(20, 50, 32, 32);
		
		_shapePosition = (_world.getShapeSelector().getSelectedPosition() + 1) % 4;
		if(_world.getShapeSelector().getSpellShape(_shapePosition).toString().equalsIgnoreCase("circle"))
			_shapeRenderer.circle(88 + SKILL_BAR_CIRCLE_RADIUS_PIXELS, 
					50 + SKILL_BAR_CIRCLE_RADIUS_PIXELS, SKILL_BAR_CIRCLE_RADIUS_PIXELS);
		if(_world.getShapeSelector().getSpellShape(_shapePosition).toString().equalsIgnoreCase("rectangle"))
			_shapeRenderer.rect(88, 50, 32, 32);

		_shapeRenderer.end();
	}

	public OrthographicCamera getCamera() {
		// TODO Auto-generated method stub
		return _camera;
	}
}
