package com.nni.gamevate.perlerwizard.object.enemies;

import com.nni.gamevate.perlerwizard.object.Collidable;
import com.nni.gamevate.perlerwizard.object.GameObject;
import com.nni.gamevate.perlerwizard.object.skills.Skill;

/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public abstract class Enemy extends GameObject{
	
	protected double _health;
	
	public Enemy(int width, int height, float x, float y) {
		super(width, height, x, y);
		
	}

	public abstract Skill attack();
	
	public abstract Skill castSpecial();
	
	public abstract Skill castDefense();
	
	public abstract boolean isDead(double damage);
	
	public abstract void move();
	
	public double getHealth(){
		return _health;
	}

	@Override
	public void update(float delta) {
		
	}
	
	@Override
	public boolean collided(Collidable object) {
		// TODO Auto-generated method stub
		return false;
	}
}