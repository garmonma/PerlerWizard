package com.nni.gamevate.perlerwizard.object.skills.rushables;

import com.badlogic.gdx.math.Vector2;
import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.object.Attacker;
import com.nni.gamevate.perlerwizard.object.GameObject;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.hero.Hero;
import com.nni.gamevate.perlerwizard.object.skills.Skill;

public class SpearRush extends Skill {

	private GameObject caster;
	private float angle;
	
	private Vector2 originalPosition;  
	
	public SpearRush(float x, float y, GameObject caster) {
		super(x, y);
		width = 0;
		height = 0;
		
		this.caster = caster;
		if(caster instanceof Hero){
			speed = ((Hero)caster).getSpeed() + 1;
		} else {
			speed = ((Enemy)caster).getSpeed() + 1;
		}	
		
		originalPosition = new Vector2(caster.getPosition());
	}

	public SpearRush(float width, float height, float x, float y, GameObject caster) {
		super(width, height, x, y);
		
		this.caster = caster;
		if(caster instanceof Hero){
			speed = ((Hero)caster).getSpeed() + 1;
		} else {
			speed = ((Enemy)caster).getSpeed() + 1;
		}	
		
		originalPosition = new Vector2(caster.getPosition());
	}
		

	@Override
	public void update(float delta) {
		direction.set(position).setAngle(angle).nor();
		velocity.set(direction).scl(speed);
		movement.set(velocity).scl(delta);
		position.add(movement);	
		
		caster.setPosition(position);
		//_caster.update(delta);
		
		if (position.y < GameConfig.LOWER_VOID || position.y > GameConfig.UPPER_WALL) {
			caster.setPosition(originalPosition);
			((Attacker)caster).castingSpecial(false);
		}
	
	}

}
