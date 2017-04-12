package com.nni.gamevate.perlerwizard.object.skills;

import java.util.HashMap;
import java.util.Set;

import com.badlogic.gdx.graphics.Color;

public class SkillManager {
	
	
	HashMap<Skills, Wand> wandBag = new HashMap<Skills, Wand>();
	
	
	int skillIndex = 0;
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
	public void selectPrevious(){
		skillIndex++;
		if(skillIndex >= wandBag.size()){
			skillIndex = 0;
		}
	}
	
	public void selectNext(){
		skillIndex--;
		if(skillIndex == -1){
			skillIndex = wandBag.size() -1;
		}
	}
	public Skills getSelectedSkill(){
		int i= 0;
		for(Skills s: wandBag.keySet()){
			if(i == skillIndex)
				return s;
			i++;
		}
		return null;
	}
	
	public Set<Skills> getSkills(){
		return wandBag.keySet();
	}
	
	public Color getSelectedSkillColor(){
		Skills s = getSelectedSkill();
		Wand w = wandBag.get(s);
		return w.getSkillColor();

		
		
	}
}
