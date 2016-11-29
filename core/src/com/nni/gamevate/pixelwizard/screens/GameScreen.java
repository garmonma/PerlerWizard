package com.nni.gamevate.pixelwizard.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.nni.gamevate.pixelwizard.PixelWizard;

/**
 * 
 * @author Marcus Garmon
 *
 */
public class GameScreen extends AbstractScreen {
	
	Texture _skillBoxAlphaImage;
	Texture _analogLeftImage;
	Texture _analogRightImage;
	Texture _analogCenterImage;
	
	Texture _heroImage;
	Texture _enemyImage;
	
	ShapeRenderer _gameBounds = new ShapeRenderer();
	
	Rectangle _skillBoxPos1;
	Rectangle _skillBoxPos2;
	Rectangle _skillBoxPos3;
	Rectangle _skillBoxPos4;
	Rectangle _skillBoxPos5;
	
	Rectangle _hero;
	Array<Rectangle> _enemies;
	

	public GameScreen(final PixelWizard pixelWizard) {
		super(pixelWizard);
		System.out.println("On Game Screen");
		
		_skillBoxAlphaImage = new Texture(Gdx.files.internal("alphaBox.png"));
		
		_heroImage = new Texture(Gdx.files.internal("TestHero64b64.png"));
		_enemyImage = new Texture(Gdx.files.internal("TestEnemy32b32.png"));
		
		_hero = new Rectangle();
		_hero.x = 800/2 - 64/2;
		_hero.y = 20;
		_hero.width = 64;
		_hero.height = 64;
		
		_enemies = new Array<Rectangle>();
		spawnEnemies();
		setupSkillBox();
		
		_gameBounds = new ShapeRenderer();
		_gameBounds.setColor(Color.SLATE);
		
		
	}
	
	private void setupSkillBox(){
		
		_skillBoxPos1 = new Rectangle();
		_skillBoxPos1.height = 32;
		_skillBoxPos1.width = 32;
		_skillBoxPos1.y = 118;
		_skillBoxPos1.x = 54;
		
		
		_skillBoxPos2 = new Rectangle();
		_skillBoxPos2.height = 32;
		_skillBoxPos2.width = 32;
		_skillBoxPos2.y = 84;
		_skillBoxPos2.x = 54;
		
		
		_skillBoxPos3 = new Rectangle();
		_skillBoxPos3.height = 32;
		_skillBoxPos3.width = 32;
		_skillBoxPos3.y = 50;
		_skillBoxPos3.x = 54;
		
		
		_skillBoxPos4 = new Rectangle();
		_skillBoxPos4.height = 32;
		_skillBoxPos4.width = 32;
		_skillBoxPos4.y = 50;
		_skillBoxPos4.x = 20;
		
		
		_skillBoxPos5 = new Rectangle();
		_skillBoxPos5.height = 32;
		_skillBoxPos5.width = 32;
		_skillBoxPos5.y = 50;
		_skillBoxPos5.x = 88;
		
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

		_camera.update();
		
		_gameBounds.setProjectionMatrix(_camera.combined);
		_gameBounds.begin(ShapeType.Filled);
		//leftBound
		_gameBounds.rectLine(150 - 4, 1, 150 - 4, 480, 5);
		//rightBound
		_gameBounds.rectLine(655, 1, 655, 480, 4);
		//upperBound
		_gameBounds.rectLine(150 - 4, 480-4, 655, 480-4, 5);
		_gameBounds.end();
		
		_pixelWizard.batch.setProjectionMatrix(_camera.combined);
		_pixelWizard.batch.begin();
		
		_pixelWizard.batch.draw(_heroImage, _hero.x, _hero.y, 
				_hero.width, _hero.height);
		
		_pixelWizard.batch.draw(_skillBoxAlphaImage, _skillBoxPos1.x, _skillBoxPos1.y, 
				_skillBoxPos1.width, _skillBoxPos1.height);
		
		_pixelWizard.batch.draw(_skillBoxAlphaImage, _skillBoxPos2.x, _skillBoxPos2.y, 
				_skillBoxPos2.width, _skillBoxPos2.height);
		
		_pixelWizard.batch.draw(_skillBoxAlphaImage, _skillBoxPos3.x, _skillBoxPos3.y, 
				_skillBoxPos3.width, _skillBoxPos3.height);
		
		_pixelWizard.batch.draw(_skillBoxAlphaImage, _skillBoxPos4.x, _skillBoxPos4.y, 
				_skillBoxPos4.width, _skillBoxPos4.height);
		
		_pixelWizard.batch.draw(_skillBoxAlphaImage, _skillBoxPos5.x, _skillBoxPos5.y, 
				_skillBoxPos5.width, _skillBoxPos5.height);
		
		for(Rectangle enemy: _enemies){
			_pixelWizard.batch.draw(_enemyImage, enemy.x, enemy.y, 
					enemy.width, enemy.height);
		}
		
		
		_pixelWizard.batch.end();
		if (Gdx.input.isKeyPressed(Keys.LEFT))
            _hero.x -= 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Keys.RIGHT))
            _hero.x += 200 * Gdx.graphics.getDeltaTime();
        
        
        if(_hero.x < 150) _hero.x = 150;
        		
        if(_hero.x > 650 - 64) _hero.x = 650 - 64;
	}
	
	private boolean vSkillBarSwipedUp(){
		return true;
	}
	
	private boolean vSkillBarSwipedDown(){
		return true;
	}
	
	private boolean hSkillbarSwipedLeft(){
		return true;
	}
	
	private boolean hSkillbarSwipedRight(){
		return true;
	}
	
	private boolean centerSkillTapped(){
		return true;
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