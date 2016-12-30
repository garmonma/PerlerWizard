package com.nni.gamevate.pixelwizard.object.walls;

import com.nni.gamevate.pixelwizard.object.Collidable;
import com.nni.gamevate.pixelwizard.object.GameObject;

/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class Wall extends GameObject implements Collidable {

	private String _side;
	
	public Wall(int width, int height, float x, float y, String side) {
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

}
