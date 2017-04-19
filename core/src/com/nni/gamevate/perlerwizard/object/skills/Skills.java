package com.nni.gamevate.perlerwizard.object.skills;

import com.nni.gamevate.perlerwizard.object.skills.reflectables.BasicEnemySpell;
import com.nni.gamevate.perlerwizard.object.skills.reflectables.BlackSpell;
import com.nni.gamevate.perlerwizard.object.skills.reflectables.BlueSpell;
import com.nni.gamevate.perlerwizard.object.skills.reflectables.GreenSpell;
import com.nni.gamevate.perlerwizard.object.skills.reflectables.RedSpell;
import com.nni.gamevate.perlerwizard.object.skills.reflectables.WhiteSpell;
import com.nni.gamevate.perlerwizard.object.skills.reflectables.YellowSpell;

public  enum  Skills {

	//TODO move speeds into this class too
	
	// Wizard Spells
	WHITE_SPELL(100, WhiteSpell.class),	
	RED_SPELL(5000,RedSpell.class),
	BLUE_SPELL(30000,BlueSpell.class),
	YELLOW_SPELL(1000,YellowSpell.class),
	GREEN_SPELL(60000,GreenSpell.class),
	BLACK_SPELL(25000,BlackSpell.class),
	
	// EnemySpells
	BASIC_ENEMY_SPELL(10000,BasicEnemySpell.class);
	
	
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
