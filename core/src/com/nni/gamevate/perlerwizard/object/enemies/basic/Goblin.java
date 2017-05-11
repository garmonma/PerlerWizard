package com.nni.gamevate.perlerwizard.object.enemies.basic;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.utils.TimeUtils;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy.State;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.object.skills.Skills;
import com.nni.gamevate.perlerwizard.object.skills.Wand;
import com.nni.gamevate.perlerwizard.object.skills.throwables.RockThrow;

public class Goblin extends Enemy {
	
	private Wand rockWand;
	
	public Goblin(float x, float y, int waveNumber){
		this(0.7f,0.7f, x, y, waveNumber);
	}

	public Goblin(float width, float height, float x, float y,int waveNumber) {
		super(width, height, x, y, waveNumber);
		_health = 1;
		
		idleAnimation = new Animation(0.10f, 
				PerlerWizard.assetManager.get(AssetDescriptors.ENEMIES).findRegions("goblin_idle"), 
				PlayMode.LOOP);
		
		attackAnimation = new Animation(1.0f, 
				PerlerWizard.assetManager.get(AssetDescriptors.ENEMIES).findRegions("goblin_idle"), 
				PlayMode.LOOP);
		
		rockWand = new Wand(Skills.ROCK_THROW.getType(), Skills.ROCK_THROW.getRefreshTime());
	}

	@Override
	public Skill attack() {
		state = State.ATTACKING;
		return rockWand.fire(position.x + width/2, position.y + height /2, 180.0f);
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