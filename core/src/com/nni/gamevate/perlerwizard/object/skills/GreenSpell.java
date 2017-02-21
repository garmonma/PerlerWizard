package com.nni.gamevate.perlerwizard.object.skills;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * @author Marcus Garmon 12/29/2016
 * 
 *         The GreenSpell travels slower than other spell colors but it has the
 *         ability to absorb life from those it hit and heals the caster upon
 *         touching it.
 */
public class GreenSpell extends Spell {
	
	public GreenSpell(float x, float y){
		super(x, y);
		
		_speed = 4.0f;
		_velocity.set(_direction).scl(_speed);
	}

	public GreenSpell(float width, float height, float x, float y) {
		super(width, height, x, y);
		_speed = 4.0f;
		_velocity.set(_direction).scl(_speed);
	}

}