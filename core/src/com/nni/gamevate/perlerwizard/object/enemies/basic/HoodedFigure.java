package com.nni.gamevate.perlerwizard.object.enemies.basic;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.skills.Skill;

public class HoodedFigure extends Enemy {
	
	public HoodedFigure(float x, float y, int waveNumber){
		super(1.0f, 1.0f, x, y, waveNumber);
	}

	public HoodedFigure(float width, float height, float x, float y, int waveNumber) {
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

}
