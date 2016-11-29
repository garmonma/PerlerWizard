package com.nni.gamevate.pixelwizard.enemies;

import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public abstract class Enemy implements Drawable{

	protected int _health;
	protected int _attackSpeed;
	
	public Enemy(){
		
	}
	
	public abstract void attack();
	
	public abstract void despawn();
	
	public abstract void spawn();
	
	public int getHealth(){
		return _health;
	}
	
	public int getAttackSpeed(){
		return _attackSpeed;
	}
}