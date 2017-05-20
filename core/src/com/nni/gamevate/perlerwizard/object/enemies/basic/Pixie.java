package com.nni.gamevate.perlerwizard.object.enemies.basic;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.math.MathUtils;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.skills.Skill;

public class Pixie extends Enemy {
	
	private float foo = 0;
	
	
	public Pixie(float x, float y, int waveNumber){
		super(0.4f, 0.4f, x, y, waveNumber);
		foo = MathUtils.random(0, MathUtils.PI * 2)  ; 
	}

	public Pixie(float width, float height, float x, float y,int waveNumber) {
		super(width, height, x, y,waveNumber);
		health = 1;
		
		idleAnimation = new Animation(0.10f, 
				PerlerWizard.assetManager.get(AssetDescriptors.ENEMIES).findRegions("sprite"), 
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
	protected void uniquePattern(float delta) {
		
		float radius = 0.75f;
		float frequencyModifier = 0.5f;
		foo += delta;
		//Logger.log("hrm");
		position.x = formationPosition.x + MathUtils.cos(foo * frequencyModifier) * radius;
		position.y = formationPosition.y + MathUtils.sin(foo * frequencyModifier) * radius;
		
		//_position.x = formationPosition.x ;
		//_position.y = formationPosition.y + foo ;
		
	}

}
