package com.nni.gamevate.perlerwizard.object;

import com.nni.gamevate.perlerwizard.object.skills.Skill;

public interface Attacker {

	public Skill attack();
	
	public Skill castSpecial();
	
	public Skill castDefense();
	
	public void castingSpecial(boolean casting);
	
	public void castingAttack(boolean casting);
	
	public boolean isCastingSpecial();
	
	public boolean isCastingAttack();	

}
