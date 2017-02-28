package com.nni.gamevate.perlerwizard.object.skills.throwables;

import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.object.skills.Skill;

public class AxeThrow extends Skill {
	
	private float _angle;

	public AxeThrow(float x, float y) {
		super(x, y);
		_width = .20f;
		_height = .20f;
		_speed = 6;
	}

	public AxeThrow(float width, float height, float x, float y) {
		super(width, height, x, y);
		_speed = 6;
	}

	@Override
	public void update(float delta) {
		if(enemySkill()){
			_angle = 270;
		} else {
			_angle = 90;
		}
		
		_direction.set(_position).setAngle(_angle).nor();
		_velocity.set(_direction).scl(_speed);
		_movement.set(_velocity).scl(delta);
		_position.add(_movement);		

		if (_position.y < GameConfig.LOWER_VOID || _position.y > GameConfig.UPPER_WALL) {
			evaporate();
		}

	}

}
