package com.nni.gamevate.perlerwizard.object.enemies.basic;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;
import com.nni.gamevate.perlerwizard.object.GameObject;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy.State;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.object.skills.Skills;
import com.nni.gamevate.perlerwizard.object.skills.Wand;

public class Imp extends Enemy{
	
	private Wand rushWand;


	public Imp( float x, float y,int waveNumber) {
		this(0.7f,0.7f, x, y,waveNumber);
	}
	
	public Imp(float width, float height, float x, float y,int waveNumber) {
		super(width, height, x, y,waveNumber);
		
		_health = 1;
		
		idleAnimation = new Animation(0.10f, 
				PerlerWizard.assetManager.get(AssetDescriptors.ENEMIES).findRegions("imp_idle"), 
				PlayMode.LOOP);
		
		attackAnimation = new Animation(0.10f, 
				PerlerWizard.assetManager.get(AssetDescriptors.ENEMIES).findRegions("imp_idle"), 
				PlayMode.LOOP);
		
		rushWand = new Wand(Skills.RUSH.getType(), Skills.RUSH.getRefreshTime());
	}
	
	@Override
	public Skill attack() {
		state = State.ATTACKING;
		return rushWand.rush(position.x , position.y, 180.0f, (GameObject) this);
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

}
