package com.nni.gamevate.perlerwizard.object.skills.defense;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.TimeUtils;
import com.nni.gamevate.perlerwizard.object.hero.Hero;
import com.nni.gamevate.perlerwizard.object.skills.Skill;

public class Reflect extends Skill {
	
	public long _timeCounter;
	
	public static Long REFLECT_LAST_CAST;
	public static long REFLECT_REFRESH_TIMER = 500;
	
	public static Long getLastCast(){
		return REFLECT_LAST_CAST;
	}

	public Reflect(float x, float y, Hero hero) {
		super(x, y);
		REFLECT_LAST_CAST = TimeUtils.millis();
		_timeCounter = TimeUtils.millis();
		
		_width = 1.2f;
		_height = .25f;
		_speed = hero.getSpeed();
	}

	public Reflect(float width, float height, float x, float y) {
		super(width, height, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float delta) {
		if(TimeUtils.millis() - _timeCounter > 100){
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
