package com.nni.gamevate.perlerwizard.object.skills;

import com.nni.gamevate.perlerwizard.object.Collidable;
import com.nni.gamevate.perlerwizard.object.GameObject;


/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class EnemySpell extends GameObject implements Castable {

	public EnemySpell(int width, int height, float x, float y) {
		super(width, height, x, y);
	}

	@Override
	public void evaporate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transfiguration(Castable spell) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean collided(Collidable object) {
		// TODO Auto-generated method stub
		return false;
	}
}
