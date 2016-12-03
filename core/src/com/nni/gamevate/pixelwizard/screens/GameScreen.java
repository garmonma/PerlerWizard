package com.nni.gamevate.pixelwizard.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.nni.gamevate.pixelwizard.GameRenderer;
import com.nni.gamevate.pixelwizard.GameWorld;
import com.nni.gamevate.pixelwizard.PixelWizard;

/**
 * 
 * @author Marcus Garmon
 *
 */
public class GameScreen extends AbstractScreen {
	Texture _analogLeftImage;
	Texture _analogRightImage;
	Texture _analogCenterImage;
	
	Texture _heroImage;
	Texture _enemyImage;
	
	Texture _circleSpell;

	Circle circle = new Circle();
	Array<Rectangle> _skills;
	
	Rectangle _hero;
	Array<Rectangle> _enemies;
	
	private GameWorld _world;
	private GameRenderer _renderer;
	

	public GameScreen(final PixelWizard pixelWizard) {
		super(pixelWizard);
		System.out.println("On Game Screen");
		
		_world = new  GameWorld();
		_renderer = new GameRenderer(_world);
		
		//_heroImage = new Texture(Gdx.files.internal("TestHero64b64.png"));
		_enemyImage = new Texture(Gdx.files.internal("TestEnemy32b32.png"));
		//_circleSpell = new Texture(Gdx.files.internal("circle.png"));
		
		//_skills = new Array<Rectangle>();
		_enemies = new Array<Rectangle>();
		
		spawnEnemies();
		//setupSkillBox();
		
	}
	
	private void createSkill(){
		Rectangle skill = new Rectangle();
		
		skill.x = _hero.x;
		skill.y = _hero.y + 40;
		skill.width = 16;
		skill.height = 16;
		
		_skills.add(skill);
	}
	
	private void spawnEnemies(){
		for(int i = 0; i < 20; i++){
			Rectangle enemy = new Rectangle();
			if(i % 5 == 0){
				enemy.x = 225;
			} else if (i % 5 == 1){
				enemy.x = 225 + 64 * (1) + 10 * (1);
			} else if (i % 5 == 2){
				enemy.x = 225 + 64 * (2) + 10 * (2);
			} else if (i % 5 == 3){
				enemy.x = 225 + 64 * (3) + 10 * (3) + 1;
			} else if (i % 5 == 4){
				enemy.x = 225 + 64 * (4) + 10 * (4) - 1;
			}
			
			if( i < 5){
				enemy.y = 300;
			} else if (i < 10){
				enemy.y = 300 + 32 * (1) + 10 * (1);
			} else if ( i < 15){
				enemy.y = 300 + 32 * (2) + 10 * (2);
			} else if (i < 20){
				enemy.y = 300 + 32 * (3) + 10 * (3);
			}
			
			enemy.width = 32;
			enemy.height = 32;
			_enemies.add(enemy);
			System.out.println("Enemy Drawn");
		}
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		_world.update(delta);
		_renderer.render();
		
		
			
		//_pixelWizard.batch.setProjectionMatrix(_camera.combined);
		_pixelWizard.batch.begin();
		
		
		for(Rectangle enemy: _enemies){
			_pixelWizard.batch.draw(_enemyImage, enemy.x, enemy.y, 
					enemy.width, enemy.height);
		}
		
//		for(Rectangle spell: _skills){
//			_pixelWizard.batch.draw(_circleSpell, spell.x, spell.y, 
//					spell.width, spell.height);
//		}
		
		
		_pixelWizard.batch.end();
		
		if(Gdx.input.isTouched()){
			//createSkill();
		}
		
//		if(_skills.get(0).y > 480){
//			_skills.removeIndex(0);
//		} else {
//			_skills.get(0).y += 200 * Gdx.graphics.getDeltaTime();
//		}
	}
		

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}
}