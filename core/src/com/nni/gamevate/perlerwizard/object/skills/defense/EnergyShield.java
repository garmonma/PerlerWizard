package com.nni.gamevate.perlerwizard.object.skills.defense;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.TimeUtils;
import com.nni.gamevate.perlerwizard.object.Collidable;
import com.nni.gamevate.perlerwizard.object.GameObject;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.hero.Hero;
import com.nni.gamevate.perlerwizard.object.skills.Skill;

public class EnergyShield extends Skill {
	private long _timeCounter;
		
	public EnergyShield(float x, float y, GameObject caster) {
		super(x, y);
		
		_timeCounter = TimeUtils.millis();
		
		_width = 1.2f;
		_height = .25f;
		
		if(caster instanceof Hero){
			_speed = ((Hero)caster).getSpeed();
		} else {
			_speed = ((Enemy)caster).getSpeed();
		}
	}

	@Override
	public boolean collided(Collidable object) {
		return false;
	}

	@Override
	public void update(float delta) {
		
		if(TimeUtils.millis() - _timeCounter > 10000){
			evaporate();
		}
		
		move();
		
		if (getX() < 3.90f) {
			_position.x = 3.90f;
		}

		if (getX() > 14.90f) {
			_position.x = 14.90f;
		}

	}
	
	private void move() {
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.getAccelerometerY() < 0) {
			_position.x -= _speed * Gdx.graphics.getDeltaTime();
		}

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.getAccelerometerY() > 0)
			_position.x += _speed * Gdx.graphics.getDeltaTime();

	}

}
