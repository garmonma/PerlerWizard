package com.nni.gamevate.perlerwizard.object.enemies.basic;

import com.badlogic.gdx.utils.TimeUtils;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.object.skills.rushables.SpearRush;
import com.nni.gamevate.perlerwizard.object.skills.throwables.RockThrow;

public class Orc extends Enemy {

	private final int ROCK_THROW_COOLDOWN = 5000;
	private final int AXE_THROW_COOLDOWN = 15000;
	private final int SPEAR_RUSH_COOLDOWN = 10000;
	
	private long _rockThrowLastAttack;
	private long _axeThrowLastAttack;
	private long _spearRushLastAttack;
	

	
	public Orc(int width, int height, float x, float y) {
		super(width, height, x, y);
		
		_rockThrowLastAttack = 0;
		_axeThrowLastAttack = 0;
		_spearRushLastAttack = 0;
		_health = 2;
		_speed = 5;
	}

	@Override
	public Skill attack() {
		if(true){
			return null;
		}
		
		if(_rockThrowLastAttack == 0 
				|| TimeUtils.millis() - _rockThrowLastAttack > ROCK_THROW_COOLDOWN ){
			
			_rockThrowLastAttack = TimeUtils.millis();
			Skill rockThrow =  new RockThrow(getX() + getWidth() / 2, getY() + getHeight());
			rockThrow.isEnemySpell(true);
			_castingAttack = true;
			return rockThrow;
			
		}
		return null;
	}

	@Override
	public Skill castSpecial() {
		if(_castingAttack){
			return null;
		}
		
		if(_spearRushLastAttack == 0 
				|| TimeUtils.millis() - _spearRushLastAttack > SPEAR_RUSH_COOLDOWN ){	
			_spearRushLastAttack = TimeUtils.millis();
			Skill spearRsuh =  new SpearRush(getWidth(), getHeight(), getX(), getY(), this);
			spearRsuh.isEnemySpell(true);
			
			_castingSpecial = true;
			return spearRsuh;
		}
		return null;
	}

	@Override
	public Skill castDefense() {
		// TODO Auto-generated method stub
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
