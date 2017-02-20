package com.nni.gamevate.perlerwizard.object.hero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.nni.gamevate.perlerwizard.object.Collidable;
import com.nni.gamevate.perlerwizard.object.GameObject;

/**
 * 
 * @author Marcus Garmon 11/27/2016
 *
 */
public abstract class Hero extends GameObject {
	protected final float MAX_SPEED_MULTIPLIER = 1.25f;

	protected float _speed;
	protected int _hitPoints;

	protected float _healthMultiplier;
	protected float _speedMultiplier;

	protected int _level;
	
	public Hero(int width, int height, float x, float y, int level) {
		super(width, height, x, y);

		_healthMultiplier = 1.0f;
		_speedMultiplier = 1.0f;

		_level = level;
	}

	abstract void attack();

	abstract void castSpecial();

	abstract void castDefense();

	public void setHealthMultiplier(float healthMultiplier) {
		_healthMultiplier = healthMultiplier;
	}

	public void setSpeedMultiplier(float speedMultiplier) {
		_speedMultiplier = speedMultiplier;
	}

	public void setLevel(int level) {
		_level = level;
	}

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

}