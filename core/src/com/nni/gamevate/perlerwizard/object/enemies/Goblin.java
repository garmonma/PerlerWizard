package com.nni.gamevate.perlerwizard.object.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;
import com.nni.gamevate.perlerwizard.object.skills.RockThrow;
import com.nni.gamevate.perlerwizard.object.skills.Skill;

public class Goblin extends Enemy {
	
	public long lastAttack;

	public Goblin(int width, int height, float x, float y) {
		super(width, height, x, y);
		
	}

	@Override
	public Skill attack() {
		if(RockThrow.getLastCast() == null 
				|| TimeUtils.millis() - RockThrow.ROCK_THROW_LAST_CAST 
				> RockThrow.ROCK_THROW_REFRESH_TIMER ){
			Gdx.app.log("Enemy Casting", "Rock Throw");
			
			Skill rockThrow =  new RockThrow(getX() + getWidth() / 2, getY() + getHeight());
			rockThrow.isEnemySpell(true);
			return rockThrow;
		}
		
		return null;
	}

	@Override
	public Skill castSpecial() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Skill castDefense() {
		return null;

	}

	@Override
	public boolean isDead(double damage) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

}
