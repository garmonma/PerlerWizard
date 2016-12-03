package com.nni.gamevate.pixelwizard.object.enemies;

import com.nni.gamevate.pixelwizard.object.GameObject;

public abstract class Enemy extends GameObject{

	public Enemy(int width, int height, float x, float y) {
		super(width, height, x, y);
	}

	protected int _health;
	protected int _attackSpeed;
	
	public abstract void attack();
	
	public abstract void despawn();
	
	public abstract void spawn();
	
	public int getHealth(){
		return _health;
	}
	
	public int getAttackSpeed(){
		return _attackSpeed;
	}

	@Override
	public void update(float delta) {
		
		
	}
}