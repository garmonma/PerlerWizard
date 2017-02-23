package com.nni.gamevate.perlerwizard.object.skills;

import com.nni.gamevate.perlerwizard.object.Collidable;
import com.nni.gamevate.perlerwizard.object.GameObject;

public abstract class Skill extends GameObject {
	protected static final float BASE_SPEED = 5f;
	
	private boolean _isEvaporated;
	private boolean _isEnemySkill;
	protected int _damage;
	protected float _speed;
	
	public Skill(float x, float y){
		super(x, y);
		
		_speed = BASE_SPEED;
		_isEnemySkill = false;
		
	}
	
	@Override
	public boolean collided(Collidable object) {
		if (getX() >= ((GameObject) object).getX()
				&& getX() <= ((GameObject) object).getX() + ((GameObject) object).getWidth()
				&& getY() >= ((GameObject) object).getY()
				&& getY() <= ((GameObject) object).getY() + ((GameObject) object).getHeight()) {
			
			return true;
		}
		return false;
	}
	
	public Skill(float width, float height, float x, float y) {
		super(width, height, x, y);
		
		_speed = BASE_SPEED;
	}
	
	public void evaporate(){
		_isEvaporated = true;
	}
	
	public boolean isEvaporated(){
		return _isEvaporated;
	}
	
	public void isEnemySpell(boolean t){
		_isEnemySkill = t;
	}
	
	public boolean enemySkill(){
		return _isEnemySkill;
	}
	
	public int getDamage(){
		return _damage;
	}

}