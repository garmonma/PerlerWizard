package com.nni.gamevate.pixelwizard.object.character;

import com.nni.gamevate.pixelwizard.object.Collidable;
import com.nni.gamevate.pixelwizard.object.GameObject;

public class Shield extends GameObject {

	public Shield(int width, int height, float x, float y) {
		super(width, height, x, y);
		// TODO Auto-generated constructor stub
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
