package com.nni.gamevate.perlerwizard.object.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.nni.gamevate.perlerwizard.object.Attacker;
import com.nni.gamevate.perlerwizard.object.Collidable;
import com.nni.gamevate.perlerwizard.object.GameObject;
import com.nni.gamevate.perlerwizard.object.skills.Skill;

/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public abstract class Enemy extends GameObject implements Attacker{
	
	protected int _health = 1;
	protected float _speed;
	
	protected boolean _castingSpecial;
	protected boolean _castingAttack;
	
	protected boolean cycleCompleted = false;
	private Vector2 _originalPosition;
	
	public Enemy(int width, int height, float x, float y) {
		super(width, height, x, y);
		
		_originalPosition = new Vector2(_position);
		
	}

	public  boolean isDead(int damage){
		_health = _health - damage;
		
		if(_health <= 0){
			alive = false;
			return true;
		} 
		
		return false;
	};
	
	public void move(float delta){
		Gdx.app.log("_position.x", _position.x + "");
		Gdx.app.log("_position.y", _position.y + "");
	
		if(_position.x < _originalPosition.x + 2 && !cycleCompleted){
			_position.x += _speed * delta; // move right by 2 units;
			
			if(_position.x >= _originalPosition.x + 2){
				cycleCompleted = true;
			}
		} else {
			_position.x -= _speed * delta; // move left by 2 units;
			
			if(_position.x <= _originalPosition.x){
				cycleCompleted = false;
			}
		}
	}
	
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
		move(delta);
		
	}
	
	@Override
	public boolean collided(Collidable object) {
		return super.collided(object);
		
	}
}