package com.nni.gamevate.pixelwizard.object.spells;

import com.nni.gamevate.pixelwizard.object.Collidable;
import com.nni.gamevate.pixelwizard.object.GameObject;

public class EnemySpell extends GameObject implements SpellInterface {

	public EnemySpell(int width, int height, float x, float y) {
		super(width, height, x, y);
	}

	@Override
	public void bounceOffWall(String side) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bounceOffEnemy() {
		// TODO Auto-generated method stub
		
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
	public void bounceOffShield() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transfiguration(EnemySpell enemySpell) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean collided(Collidable object) {
		// TODO Auto-generated method stub
		return false;
	}
}
