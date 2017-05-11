package com.nni.gamevate.perlerwizard.object.enemies.basic;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.utils.TimeUtils;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.object.skills.throwables.RockThrow;

public class Goblin extends Enemy {
	
	private final int ROCK_THROW_COOLDOWN = 5000;
	private final int AXE_THROW_COOLDOWN = 15000;
	
	private long rockThrowLastAttack;
	private long axeThrowLastAttack;
	
	
	public Goblin(float x, float y, int waveNumber){
		this(0.7f,0.7f, x, y,waveNumber);
	}

	public Goblin(float width, float height, float x, float y,int waveNumber) {
		super(width, height, x, y,waveNumber);
		rockThrowLastAttack = 0;
		axeThrowLastAttack = 0;
		_health = 1;
		
		idleAnimation = new Animation(0.10f, 
				PerlerWizard.assetManager.get(AssetDescriptors.ENEMIES).findRegions("goblin_idle"), 
				PlayMode.LOOP);
	}

	@Override
	public Skill attack() {
		if(rockThrowLastAttack == 0 
				|| TimeUtils.millis() - rockThrowLastAttack > ROCK_THROW_COOLDOWN ){
			
			rockThrowLastAttack = TimeUtils.millis();
			Skill rockThrow =  new RockThrow(getX() + getWidth() / 2, getY() + getHeight());
			//rockThrow.isEnemySpell(true);
			return rockThrow;
			
		}
		return null;
	}

	@Override
	public Skill castSpecial() {
		return null;
	}

	@Override
	public Skill castDefense() {
		return null;

	}

}
