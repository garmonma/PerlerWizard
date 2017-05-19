package com.nni.gamevate.perlerwizard.object.skills.rushables;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.object.Attacker;
import com.nni.gamevate.perlerwizard.object.GameObject;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.hero.Hero;
import com.nni.gamevate.perlerwizard.object.skills.Skill;

public class SpearRush extends Skill {

	private GameObject _caster;
	private float _angle;
	
	private Vector2 _originalPosition;  
	
	public SpearRush(float x, float y, GameObject caster) {
		super(x, y);
		width = 0;
		height = 0;
		
		_caster = caster;
		if(caster instanceof Hero){
			speed = ((Hero)caster).getSpeed() + 1;
		} else {
			speed = ((Enemy)caster).getSpeed() + 1;
		}	
		
		_originalPosition = new Vector2(_caster.getPosition());
	}

	public SpearRush(float width, float height, float x, float y, GameObject caster) {
		super(width, height, x, y);
		
		_caster = caster;
		if(caster instanceof Hero){
			speed = ((Hero)caster).getSpeed() + 1;
		} else {
			speed = ((Enemy)caster).getSpeed() + 1;
		}	
		
		_originalPosition = new Vector2(_caster.getPosition());
	}
		

	@Override
	public void update(float delta) {
		direction.set(position).setAngle(_angle).nor();
		velocity.set(direction).scl(speed);
		movement.set(velocity).scl(delta);
		position.add(movement);	
		
		_caster.setPosition(position);
		//_caster.update(delta);
		
		if (position.y < GameConfig.LOWER_VOID || position.y > GameConfig.UPPER_WALL) {
			_caster.setPosition(_originalPosition);
			((Attacker)_caster).castingSpecial(false);
		}
	
	}

}
