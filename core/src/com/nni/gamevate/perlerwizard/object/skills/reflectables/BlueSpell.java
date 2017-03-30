package com.nni.gamevate.perlerwizard.object.skills.reflectables;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * @author Marcus Garmon 12/29/2016
 * 
 *         The Blue Spell travels at normal speed. It has the ability to
 *         explode, breaking off into four smaller pieces.
 */
public class BlueSpell extends Spell {
	
	public BlueSpell(float x, float y){
		super(x, y);
		color = Color.BLUE;

	}

	public BlueSpell(float width, float height, float x, float y) {
		super(width, height, x, y);
		
	}
	
}