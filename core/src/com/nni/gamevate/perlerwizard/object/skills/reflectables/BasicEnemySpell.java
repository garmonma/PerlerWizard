package com.nni.gamevate.perlerwizard.object.skills.reflectables;

import com.badlogic.gdx.graphics.Color;

public class BasicEnemySpell extends Spell {

	public BasicEnemySpell(float x, float y) {
		super(.25f,.25f,x, y);
		color = Color.WHITE;
		speed = - BASE_SPEED;
		//TODO fix this
		velocity.set(direction).scl(speed);
	}

}
