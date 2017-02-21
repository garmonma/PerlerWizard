package com.nni.gamevate.perlerwizard.object.skills;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * 
 * @author Marcus Garmon 12/29/2016
 * 
 * The Yellow Spell travels at a very fast speed. It has the ability
 * to paralyze the first enemy that it hits. special effect
 * resets after bouncing off of the shield.
 *
 */
public class YellowSpell extends Spell {
	
	public YellowSpell(float x, float y){
		super(x, y);
		
		_speed = 10;
		_velocity.set(_direction).scl(_speed);
	}

	public YellowSpell(float width, float height, float x, float y) {
		super(width, height, x, y);
		
		_speed = 10;
		_velocity.set(_direction).scl(_speed);
	}

}