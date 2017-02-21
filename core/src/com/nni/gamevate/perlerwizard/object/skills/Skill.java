package com.nni.gamevate.perlerwizard.object.skills;

import com.nni.gamevate.perlerwizard.object.GameObject;

public abstract class Skill extends GameObject {
	protected static final float BASE_SPEED = 5f;
	
	private boolean _isEvaporated;
	protected int _damage;
	protected float _speed;
	
	public Skill(float x, float y){
		super(x, y);
		
		_speed = BASE_SPEED;
		
	}

	public Skill(float width, float height, float x, float y) {
		super(width, height, x, y);
		
		_speed = BASE_SPEED;
	}
	
	public  void evaporate(){
		_isEvaporated = true;
	}
	
	public boolean isEvaporated(){
		return _isEvaporated;
	}
	
	public int getDamage(){
		return _damage;
	}

}
