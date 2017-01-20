package com.nni.gamevate.perlerwizard.object.walls;

import com.nni.gamevate.perlerwizard.object.Collidable;
import com.nni.gamevate.perlerwizard.object.GameObject;

/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class Wall extends GameObject implements Collidable {

	private String _side;
	
	public Wall(float width, float height, float x, float y, String side) {
		super(width, height, x, y);
		_side = side;
	}

	@Override
	public boolean collided(Collidable object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}
	
	public String getSide(){
		return _side;
	}
	
	public void setDirection(float degrees){
		_direction.set(_position).setAngle(degrees);
	}

}
