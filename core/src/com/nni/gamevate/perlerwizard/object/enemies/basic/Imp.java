package com.nni.gamevate.perlerwizard.object.enemies.basic;

import javax.swing.text.Position;

import com.badlogic.gdx.math.Vector2;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.utils.Logger;

public class Imp extends Enemy{


	public Imp( float x, float y,int waveNumber) {
		super(0.7f,0.7f, x, y,waveNumber);
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
	public void move(float delta) {
		super.move(delta);
		// TODO Auto-generated method stub
		
	}



	@Override
	protected void uniquePattern(float delta) {
		
		// TODO Auto-generated method stub
		
	}

}
