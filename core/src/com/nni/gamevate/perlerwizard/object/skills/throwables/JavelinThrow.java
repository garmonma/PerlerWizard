package com.nni.gamevate.perlerwizard.object.skills.throwables;

import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.object.skills.Skill;

public class JavelinThrow extends Skill {
	
	private float _angle;
	
	public long _timeCounter;
	
	public JavelinThrow(float x, float y) {
		super(x, y);
		_width = .20f;
		_height = 1.25f;
		_speed = 6;
		_damage = 1;
		
		_angle = 90;
		_direction.set(_position).setAngle(_angle).nor();
		_velocity.set(_direction).scl(_speed);
	}

	public JavelinThrow(float width, float height, float x, float y) {
		super(width, height, x, y);
		_speed = 6;
		_damage = 1;
		
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
