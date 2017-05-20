package com.nni.gamevate.perlerwizard.object.enemies.basic;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.skills.Skill;

public class Pixie extends Enemy {
	
	public Pixie(float x, float y, int waveNumber){
		this(0.7f, 0.7f, x, y, waveNumber);
	}

	public Pixie(float width, float height, float x, float y,int waveNumber) {
		super(width, height, x, y,waveNumber);
		_health = 1;
		
		idleAnimation = new Animation(0.10f, 
				PerlerWizard.assetManager.get(AssetDescriptors.ENEMIES).findRegions("pixie_idle"), 
				PlayMode.LOOP);
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
	public void move(float delta) {
		// TODO Auto-generated method stub

	}

}
