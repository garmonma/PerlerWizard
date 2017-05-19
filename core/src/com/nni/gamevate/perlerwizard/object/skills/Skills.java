package com.nni.gamevate.perlerwizard.object.skills;

import com.nni.gamevate.perlerwizard.object.skills.reflectables.BasicEnemySpell;
import com.nni.gamevate.perlerwizard.object.skills.reflectables.VoidCast;
import com.nni.gamevate.perlerwizard.object.skills.reflectables.WaterCast;
import com.nni.gamevate.perlerwizard.object.skills.rushables.Rush;
import com.nni.gamevate.perlerwizard.object.skills.reflectables.ForestCast;
import com.nni.gamevate.perlerwizard.object.skills.reflectables.FireCast;
import com.nni.gamevate.perlerwizard.object.skills.reflectables.MagicCast;
import com.nni.gamevate.perlerwizard.object.skills.reflectables.LightningCast;
import com.nni.gamevate.perlerwizard.object.skills.throwables.AxeThrow;
import com.nni.gamevate.perlerwizard.object.skills.throwables.RockThrow;

public  enum  Skills {

	//TODO move speeds into this class too
	
	// Wizard Spells
	MAGIC_CAST(100, MagicCast.class),	
	FIRE_CAST(100,FireCast.class),
	WATER_CAST(100,WaterCast.class),
	LIGHTNING_CAST(100,LightningCast.class),
	FOREST_CAST(100,ForestCast.class),
	VOID_CAST(100,VoidCast.class),
	
	// EnemySpells
	BASIC_ENEMY_SPELL(10000,BasicEnemySpell.class),
	AXE_THROW(4000, AxeThrow.class),
	ROCK_THROW(4000, RockThrow.class),
	RUSH(6000, Rush.class);
	
	
	private long _refreshTime;
	private Class<Skill> _type;
	
	/**
	 * This some advanced shit yo
	 * @param refreshTime
	 * @param type must extend Skill
	 */
	@SuppressWarnings("unchecked")
	<T extends Skill> Skills(long refreshTime, Class<T> type){
		_refreshTime = refreshTime;
		_type = (Class<Skill>) type;
	}
	
	public long getRefreshTime(){
		return _refreshTime;
	}

	public Class<Skill> getType() {
		return _type;
	}
}