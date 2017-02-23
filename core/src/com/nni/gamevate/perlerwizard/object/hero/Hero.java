package com.nni.gamevate.perlerwizard.object.hero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.nni.gamevate.perlerwizard.object.Collidable;
import com.nni.gamevate.perlerwizard.object.GameObject;
import com.nni.gamevate.perlerwizard.object.skills.Skill;

/**
 * 
 * @author Marcus Garmon 11/27/2016
 *
 */
public abstract class Hero extends GameObject {
	protected final float MAX_SPEED_MULTIPLIER = 1.25f;
	protected final float MAX_SPEED = 10.0f;

	protected float _speed;
	protected int _hitPoints;
	protected int _defense;
	protected int _attack;
	protected float _dodge;
	
	protected float _currentHealthPct;

	protected float _healthMultiplier;
	protected float _speedMultiplier;

	protected int _level;
	
	public Hero(int width, int height, float x, float y, int level) {
		super(width, height, x, y);

		_healthMultiplier = 1.0f;
		_speedMultiplier = 1.0f;

		_level = level;
	}

	public abstract Skill attack(int selectedSkill);

	public abstract Skill castSpecial();

	public abstract Skill castDefense();
	
	abstract void setEquipmentSlotOne(Equipment item);
	
	abstract void setEquipmentSlotTwo(Equipment item);
	
	abstract void setEquipmentSlotThree(Equipment item);

	@Override
	public void update(float delta) {
		move();

		if (getX() < 4) {
			_position.x = 4;
		}

		if (getX() > 15) {
			_position.x = 15;
		}
	}

	@Override
	public boolean collided(Collidable object) {
		return false;
	}

	private void move() {
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.getAccelerometerY() < 0) {
			_position.x -= _speed * _speedMultiplier * Gdx.graphics.getDeltaTime();
		}

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.getAccelerometerY() > 0)
			_position.x += _speed * _speedMultiplier * Gdx.graphics.getDeltaTime();

	}

	public boolean isCasting() {
		return true;
	}
	
	public void setHealthMultiplier(float healthMultiplier) {
		_healthMultiplier = healthMultiplier;
	}

	public void setSpeedMultiplier(float speedMultiplier) {
		_speedMultiplier = speedMultiplier;
		
		if(_speedMultiplier > MAX_SPEED_MULTIPLIER){
			_speedMultiplier = MAX_SPEED_MULTIPLIER;
		}
		
		setSpeed(_speed, _speedMultiplier);
	}

	public void setLevel(int level) {
		_level = level;
	}
	
	public void setDodge(float dodge){
		_dodge = dodge;
	}
	
	public void setSpeed(float speed){
		setSpeed(speed, _speedMultiplier);
	}
	
	public void setSpeed(float speed, float speedMultiplier){
		_speed = speed * speedMultiplier;
		
		if(_speed > MAX_SPEED){
			_speed = MAX_SPEED;
		}
	}
	
	public void setAttack(int attack){
		_attack = attack;
	}
	
	public void setDefense(int defense){
		_defense = defense;
	}
	
	public void setCurrentHealthPct(float healthPct){
		_currentHealthPct = healthPct;
	}
	
	public int getHitPoints(){
		return _hitPoints;
	}
	
	public float getCurrentHealthPct(){
		return _currentHealthPct;
	}
	
	public int getDefense(){
		return _defense;
	}
	
	public int getAttack(){
		return _attack;
	}
	
	public float getSpeed(){
		return _speed;
	}
	
	public float getDodge(){
		return _dodge;
	}

	@Override
	public String toString() {
		return String.format(
				"Hero [MAX_SPEED_MULTIPLIER=%s, MAX_SPEED=%s, _speed=%s, _hitPoints=%s, _defense=%s, _attack=%s, _dodge=%s, _currentHealthPct=%s, _healthMultiplier=%s, _speedMultiplier=%s, _level=%s]",
				MAX_SPEED_MULTIPLIER, MAX_SPEED, _speed, _hitPoints, _defense, _attack, _dodge, _currentHealthPct,
				_healthMultiplier, _speedMultiplier, _level);
	}
	
	

}