package com.nni.gamevate.pixelwizard.object.character;

import com.nni.gamevate.pixelwizard.object.Collidable;
import com.nni.gamevate.pixelwizard.object.GameObject;

/**
 * 
 * @author Marcus Garmon 11/27/2016
 *
 */
public class Shield extends GameObject {

	public Shield(float width, float height, float x, float y) {
		super(width, height, x, y);
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

}
