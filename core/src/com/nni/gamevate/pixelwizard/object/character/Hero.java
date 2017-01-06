package com.nni.gamevate.pixelwizard.object.character;

import com.badlogic.gdx.Gdx;
import com.nni.gamevate.pixelwizard.object.Collidable;
import com.nni.gamevate.pixelwizard.object.GameObject;

/**
 * 
 * @author Marcus Garmon 11/27/2016
 *
 */
public class Hero extends GameObject {
	
	private Shield _shield;
	private boolean _moving;
	private String _movingDirection;

	public Hero(int width, int height, float x, float y) {
		super(width, height, x, y);
		
		_moving = false;
		_movingDirection = "";

	}
	
	public void setShield(Shield shield){
		_shield = shield;
	}
	
	public Shield getShield(){
		return _shield;
	}

	@Override
	public void update(float delta) {
		
		if(_moving)
			move();
		
		if (getX() < 4){
			_position.x = 4;
		}

		if (getX() > 15){
			_position.x = 15;
			
		}
		
		_shield.setX(_position.x - .10f);
	}
	
	@Override
	public boolean collided(Collidable object) {
		// TODO Auto-generated method stub
		return false;
	}

	private void move() {
		if (_movingDirection.equalsIgnoreCase("left"))	
			_position.x -= 4 * Gdx.graphics.getDeltaTime();
		
		if (_movingDirection.equalsIgnoreCase("right"))
			_position.x += 4 * Gdx.graphics.getDeltaTime();
		
	}

	public boolean isCasting() {
		return true;
	}
	
	public boolean isMoving(){
		return _moving;
	}
	
	public void setMoving(boolean moving ){
		_moving = moving;
		
	}
	
	public void setDirection(String direction){
		_movingDirection = direction;
	}

	
}