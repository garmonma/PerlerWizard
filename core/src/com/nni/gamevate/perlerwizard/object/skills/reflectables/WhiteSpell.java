package com.nni.gamevate.perlerwizard.object.skills.reflectables;

import com.badlogic.gdx.utils.TimeUtils;

/**
 * 
 * @author Marcus Garmon 11/27/2016
 * 
 *         The most basic spell color. It travels at a normal speed and has a
 *         cooldown of 3 seconds.
 *
 */
public class WhiteSpell extends Spell {
	
	public WhiteSpell(float x, float y){
		super(x, y);
	}

	public WhiteSpell(float width, float height, float x, float y) {
		super(width, height, x, y);
	
	}

}