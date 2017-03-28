package com.nni.gamevate.perlerwizard.object.skills;

import java.util.HashMap;

public class SkillManager {
	
	
	HashMap<Skills, Wand> wandBag = new HashMap<Skills, Wand>();
	
	public void addSkills(Skills skill){		
		Wand wand = new Wand(skill.getType(), skill.getRefreshTime());
		wandBag.put(skill, wand);
	}
	
	public Skill useSkill(Skills skill,float x, float y){
		
		Wand wand = wandBag.get(skill);
		if(wand != null)
			return wand.fire(x, y);
		
		return null;
	}
}
