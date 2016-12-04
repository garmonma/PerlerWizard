package com.nni.gamevate.pixelwizard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.nni.gamevate.pixelwizard.object.spells.Spell;
import com.nni.gamevate.pixelwizard.world.GameWorld;

public class GameRenderer {

	private GameWorld _world;
	private OrthographicCamera _camera;
	
	private ShapeRenderer _shapeRenderer;

	
	public GameRenderer(GameWorld world){
		_world = world;	
		_camera = new OrthographicCamera();
		_camera.setToOrtho(false, 800, 480);


		
		_shapeRenderer = new ShapeRenderer();
		_shapeRenderer.setProjectionMatrix(_camera.combined);
	}
	
	public void render(){
		Gdx.app.log("GameRenderer", "render");
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Drawing Game Bounds
		_shapeRenderer.begin(ShapeType.Filled);
		_shapeRenderer.setColor(Color.SLATE);
		
		_shapeRenderer.rectLine(150 - 4, 1, 150 - 4, 480, 5);
		_shapeRenderer.rectLine(655, 1, 655, 480, 4);
		_shapeRenderer.rectLine(150 - 4, 480-4, 655, 480-4, 5);
		
		_shapeRenderer.end();
		
				
		// Drawing Skill Bar
		_shapeRenderer.begin(ShapeType.Line);
		_shapeRenderer.setColor(Color.WHITE);
		
		_shapeRenderer.rect(54, 118, 32, 32 );
		_shapeRenderer.rect(88, 50, 32, 32);
		_shapeRenderer.rect(20, 50, 32, 32);
		_shapeRenderer.rect(54, 50, 32, 32);
		_shapeRenderer.rect(54, 84, 32, 32);
		
		_shapeRenderer.end();
		
		
		//Drawing Analog Control
		_shapeRenderer.begin(ShapeType.Filled);
		_shapeRenderer.setColor(Color.WHITE);
		
		_shapeRenderer.circle(700, 40, 10);
		_shapeRenderer.circle(800, 40, 10);
		
		_shapeRenderer.end();
		
		
		
		//Drawing hero
		_shapeRenderer.begin(ShapeType.Line);
		_shapeRenderer.setColor(Color.BLUE);
		
		_shapeRenderer.rect(_world.getHero().getX(), _world.getHero().getY(),
				_world.getHero().getWidth(), _world.getHero().getHeight());
		
		_shapeRenderer.end();
		
		//Drawing active spells
		_shapeRenderer.begin(ShapeType.Filled);
		
		for(Spell spell: _world.getSpells()){
			Gdx.app.log("Spell", "Drawing");
			if(spell.getSpellColor().equalsIgnoreCase("red")){
				_shapeRenderer.setColor(Color.RED);
			} else if(spell.getSpellColor().equalsIgnoreCase("white")) {
				Gdx.app.log("Spell", "White");
				_shapeRenderer.setColor(Color.WHITE);
			}
			
			if(spell.getSpellShape().equalsIgnoreCase("circle")){
				_shapeRenderer.circle(spell.getX(), spell.getY(), spell.getHeight() / 2);
			}
		}
	
		_shapeRenderer.end();
	}
}
