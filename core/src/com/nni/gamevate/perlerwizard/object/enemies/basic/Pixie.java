package com.nni.gamevate.perlerwizard.object.enemies.basic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.utils.Logger;

public class Pixie extends Enemy {
	
	private float foo = 0;
	
	
	public Pixie(float x, float y, int waveNumber){
		super(0.4f, 0.4f, x, y, waveNumber);
		foo = MathUtils.random(0, MathUtils.PI * 2)  ; 
	}

	public Pixie(int width, int height, float x, float y,int waveNumber) {
		super(width, height, x, y,waveNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Skill attack() {
		// TODO Auto-generated method stub
		return null;
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
		
		float radius = 0.75f;
		float frequencyModifier = 0.5f;
		foo += delta;
		//Logger.log("hrm");
		_position.x = formationPosition.x + MathUtils.cos(foo * frequencyModifier) * radius;
		_position.y = formationPosition.y + MathUtils.sin(foo * frequencyModifier) * radius;
		
		//_position.x = formationPosition.x ;
		//_position.y = formationPosition.y + foo ;
		
	}

}
