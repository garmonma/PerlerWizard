package com.nni.gamevate.perlerwizard.object.enemies.basic;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.utils.TimeUtils;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.object.skills.Skills;
import com.nni.gamevate.perlerwizard.object.skills.Wand;

public class Orc extends Enemy {

	public enum OrcType{
		MALE,
		FEMALE,
		GIANT
	}
	
	private OrcType orcType = OrcType.MALE;
	
	public Wand axeWand, rockWand, shockWaveWand;
	
	public Orc(float x, float y, int waveNumber){
		this(1.0f, 1.0f, x, y, waveNumber);
	}
	
	public Orc(float width, float height, float x, float y,int waveNumber) {
		super(width, height, x, y,waveNumber);
		
		_health = 2;
		
		idleAnimation = new Animation(0.10f, 
				PerlerWizard.assetManager.get(AssetDescriptors.ENEMIES).findRegions("orc_idle"), 
				PlayMode.LOOP);
		
		attackAnimation = new Animation(1.0f, 
				PerlerWizard.assetManager.get(AssetDescriptors.ENEMIES).findRegions("orc_attack"), 
				PlayMode.LOOP);
		
		axeWand = new Wand(Skills.AXE_THROW.getType(), Skills.AXE_THROW.getRefreshTime());
		
		
	}
//
	@Override
	public Skill attack() {
		state = State.ATTACKING;
		return axeWand.fire(position.x + width/2, position.y + height /2, 180.0f);
	}

	@Override
	public Skill castSpecial() {
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
	
	public OrcType getOrcType(){
		return orcType;
	}


	
	public void setOrcType(OrcType type){
		orcType = type;
		
		if(orcType == OrcType.GIANT){
			_health = 50;
		} else if(orcType == OrcType.FEMALE){
			_health = 25;
			rockWand = new Wand(Skills.ROCK_THROW.getType(), Skills.ROCK_THROW.getRefreshTime());
		}
	}
}