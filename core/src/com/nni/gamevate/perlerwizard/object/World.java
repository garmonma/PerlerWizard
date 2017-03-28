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
		
	private WaveInputHandler _inputHandler;
	
	public World(WaveInputHandler inputHandler) {
		_hero = new Wizard(1, 1, 0, 0, 1);
		_inputHandler = inputHandler;
		// TODO Auto-generated constructor stub
		
	}
	
	public void tick(float delta){
		
		updateHero(delta);
		updateSkills(delta);
	}
	
	public void updateHero(float delta){
		Vector2 dir = new Vector2();
		if(_inputHandler.up)
			dir.y++;
		if(_inputHandler.down)
			dir.y--;
		if(_inputHandler.left)
			dir.x--;
		if(_inputHandler.right)
			dir.x++;
		
		
		if(_inputHandler.fire){
			Skill s = _hero.attack(Skills.WHITE_SPELL);
			if(s != null)
				skills.add(s);
		}
		
		_hero.update(delta,dir);
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
