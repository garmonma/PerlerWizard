package com.nni.gamevate.perlerwizard.object.enemies.objects;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.skills.Skill;

public class VisionShield extends Enemy {
	
	public VisionShield(float x, float y, int waveNumber){
		super(0.5f, 0.5f, x, y, waveNumber);
	}

	public VisionShield(float width, float height, float x, float y, int waveNumber) {
		super(width, height, x, y, waveNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Skill castSpecial() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Skill castDefense() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void uniquePattern(float delta) {
		// TODO Auto-generated method stub
		
	}

}
