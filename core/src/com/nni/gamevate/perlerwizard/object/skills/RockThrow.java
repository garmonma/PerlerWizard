package com.nni.gamevate.perlerwizard.object.skills;

import com.badlogic.gdx.utils.TimeUtils;
import com.nni.gamevate.perlerwizard.GameConfig;

public class RockThrow extends Skill {
	
	private float _angle;
	
	public long _timeCounter;
	
	public static Long ROCK_THROW_LAST_CAST;
	public static long ROCK_THROW_REFRESH_TIMER = 1500;
	
	public static Long getLastCast(){
		return ROCK_THROW_LAST_CAST;
	}

	public RockThrow(float x, float y) {
		super(x, y);
		ROCK_THROW_LAST_CAST = TimeUtils.millis();
		
		_width = .20f;
		_height = .20f;
		_speed = 6;
		
		_angle = 270;
		_direction.set(_position).setAngle(_angle).nor();
		_velocity.set(_direction).scl(_speed);
	}

	@Override
	public void update(float delta) {

		_movement.set(_velocity).scl(delta);
		_position.add(_movement);		

		if (_position.y < GameConfig.LOWER_VOID || _position.y > GameConfig.UPPER_WALL) {
			evaporate();
		}
		
	}
}