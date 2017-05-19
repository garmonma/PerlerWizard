package com.nni.gamevate.perlerwizard.object.skills.throwables;

import com.nni.gamevate.perlerwizard.object.skills.Skill;

public class JavelinThrow extends Skill {
	
	private float angle;
	
	public long timeCounter;
	
	public JavelinThrow(float x, float y) {
		this(.20f, 1.25f, x, y);
	}

	public JavelinThrow(float width, float height, float x, float y) {
		super(width, height, x, y);
		speed = 6;
		damage = 1;
	}
}
