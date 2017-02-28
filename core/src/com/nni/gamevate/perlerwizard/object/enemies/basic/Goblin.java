package com.nni.gamevate.perlerwizard.object.enemies.basic;

import com.badlogic.gdx.utils.TimeUtils;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.object.skills.throwables.RockThrow;

public class Goblin extends Enemy {
	
	private final int ROCK_THROW_COOLDOWN = 5000;
	private final int AXE_THROW_COOLDOWN = 15000;
	
	private long rockThrowLastAttack;
	private long axeThrowLastAttack;

	public Goblin(int width, int height, float x, float y) {
		super(width, height, x, y);
		rockThrowLastAttack = 0;
		axeThrowLastAttack = 0;
		_health = 1;
	}

	@Override
	public Skill attack() {
		if(rockThrowLastAttack == 0 
				|| TimeUtils.millis() - rockThrowLastAttack > ROCK_THROW_COOLDOWN ){
			
			rockThrowLastAttack = TimeUtils.millis();
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
