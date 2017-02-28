package com.nni.gamevate.perlerwizard.object.enemies;

import com.nni.gamevate.perlerwizard.object.Attacker;
import com.nni.gamevate.perlerwizard.object.Collidable;
import com.nni.gamevate.perlerwizard.object.GameObject;
import com.nni.gamevate.perlerwizard.object.skills.Skill;

/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public abstract class Enemy extends GameObject implements Attacker{
	
	protected int _health;
	protected float _speed;
	
	protected boolean _castingSpecial;
	protected boolean _castingAttack;
	
	public Enemy(int width, int height, float x, float y) {
		super(width, height, x, y);
		
	}

	public abstract boolean isDead(double damage);
	
	public abstract void move();
	
	public int getHealth(){
		return _health;
	}
	
	public float getSpeed(){
		return _speed;
	}
	
	@Override
	public void castingSpecial(boolean casting) {
		_castingSpecial = casting;
		
	}
	
	@Override
	public void castingAttack(boolean casting) {
		_castingAttack = casting;
		
	}

	@Override
	public boolean isCastingSpecial() {
		return _castingSpecial;
	}

	@Override
	public boolean isCastingAttack() {
		// TODO Auto-generated method stub
		return _castingAttack;
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