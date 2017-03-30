package com.nni.gamevate.perlerwizard.object;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.hero.Hero;
import com.nni.gamevate.perlerwizard.object.hero.Wizard;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.object.skills.Skills;
import com.nni.gamevate.perlerwizard.utils.WaveInputHandler;

public class World {
	
	private ArrayList<Skill> skills = new ArrayList<Skill>();
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();

	private Hero _hero;
		
	
	public World() {
		_hero = new Wizard(1, 1, 0, 0, 1);		
	}
	
	public void tick(float delta){		
		updateHero(delta);
		updateSkills(delta);
	}
	
	public Hero getHero(){
		return _hero;
	}
	public void updateHero(float delta){	
		
		_hero.update(delta);
	}
	
	public void addSkill(Skill s){
		if(s != null){
			skills.add(s);
		}
	}
	public void updateSkills(float delta){
		for(Skill s: skills){
			s.update(delta);
		}
	}
	
	public ArrayList<GameObject> getGameObjects(){
		ArrayList<GameObject> list = new ArrayList<GameObject>(skills);
		list.add(_hero);
		list.addAll(enemies);
		return list;
	}
}
