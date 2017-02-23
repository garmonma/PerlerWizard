package com.nni.gamevate.perlerwizard.object.skills;

import com.badlogic.gdx.utils.TimeUtils;
import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.object.Collidable;

public class JavelinThrow extends Skill {
	
	private float _angle;
	
	public long _timeCounter;
	
	public static Long JAVELIN_THROW_LAST_CAST;
	public static long JAVELIN_THROW_REFRESH_TIMER = 1500;
	
	public static Long getLastCast(){
		return JAVELIN_THROW_LAST_CAST;
	}

	public JavelinThrow(float x, float y) {
		super(x, y);
		JAVELIN_THROW_LAST_CAST = TimeUtils.millis();
		_width = .20f;
		_height = 1.25f;
		_speed = 6;
		
		_angle = 90;
		_direction.set(_position).setAngle(_angle).nor();
		_velocity.set(_direction).scl(_speed);
	}

	public JavelinThrow(float width, float height, float x, float y) {
		super(width, height, x, y);
		_speed = 6;
		
		_angle = 90;
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
