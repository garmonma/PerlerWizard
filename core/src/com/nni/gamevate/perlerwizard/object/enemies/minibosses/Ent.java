package com.nni.gamevate.perlerwizard.object.enemies.minibosses;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.skills.Skill;

public class Ent extends Enemy {
	
	public enum EntType{
		OAKWOOD,
		IRONWOOD,
		SYCAMORE
	}
	
	private EntType _entType = EntType.OAKWOOD;
	
	public Ent(float x, float y, int waveNumber){
		super(2.0f, 2.0f, x, y, waveNumber);
		 _health = 100;
	}

	public Ent(float width, float height, float x, float y, int waveNumber) {
		super(width, height, x, y, waveNumber);
		
		_health = 100;
		
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
	
	public EntType getEntType(){
		return _entType;
	}
	
	public void setEntType(EntType type){
		_entType = type;
	}

	@Override
	protected void uniquePattern(float delta) {
		// TODO Auto-generated method stub
		
	}
	
	

}
