package com.nni.gamevate.perlerwizard.object.skills.reflectables;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.TimeUtils;

public class BlackSpell extends Spell {
	

	public BlackSpell(float x, float y) {
		super(x, y);
		color = Color.BLACK;
	}

	public BlackSpell(float width, float height, float x, float y) {
		super(width, height, x, y);

	}

}
