package com.nni.gamevate.perlerwizard.object.skills.reflectables;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * 
 * @author Marcus Garmon 11/27/2016
 * 
 *         The RedSpell has a faster speed than regular spells but it requires a
 *         larger cooldown to use again. A special effect that it could have is
 *         burn which could destroy shields or lower defense.
 *
 */
public class RedSpell extends Spell {

	public RedSpell(float x, float y) {
		super(x, y);
		color = Color.RED;
		_speed = 7.5f;
		_velocity.set(_direction).scl(_speed);
	}

	public RedSpell(float width, float height, float x, float y) {
		super(width, height, x, y);
		
		_speed = 7.5f;
		_velocity.set(_direction).scl(_speed);
	}

}