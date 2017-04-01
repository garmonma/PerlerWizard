package com.nni.gamevate.perlerwizard.object;

import java.util.ArrayList;
import java.util.Iterator;

import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imps;
import com.nni.gamevate.perlerwizard.object.hero.Hero;
import com.nni.gamevate.perlerwizard.object.hero.Wizard;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.waves.Level;
import com.nni.gamevate.perlerwizard.waves.Level_01;

public class World {
	
	private ArrayList<Skill> skills = new ArrayList<Skill>();
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();

	private Hero _hero;
		
	
	public World() {
		_hero = new Wizard(1, 1, 0, 0, 1);		
		createWave(new Level_01());
	}
	
	public void tick(float delta){		
		updateHero(delta);
		updateSkills(delta);
		updateEnemies(delta);
		checkCollisions();
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
	
	/**
	 * O(n^2)
	 */
	public void checkCollisions(){
		for(Enemy e : enemies){
			for(Skill s : skills){
				if(s.alive == true && e.collided(s)){					
					e.isDead(5);
					s.setAlive(false);
				}
			}
		}
	}
	
	/**
	 * O(n)
	 * @param delta
	 */
	public void updateSkills(float delta){
		Iterator<Skill> sItor = skills.iterator();
		while(sItor.hasNext()){
			Skill s = sItor.next();
			
			if(s.getX() - s.getStartX() > GameConfig.WORLD_WIDTH /2 )
				s.alive = false;
			
			if(s.alive == false){
				sItor.remove();
			}else{
				s.update(delta);
			}
		}

	}
	/**
	 * O(n)
	 * @param delta
	 */
	public void updateEnemies(float delta){
		Iterator<Enemy> eItor = enemies.iterator();
		while(eItor.hasNext()){			
			Enemy e = eItor.next();			
			if(e.alive == false){
				eItor.remove();
			}else{
				e.update(delta);
			}
		}		
	}
	
	public ArrayList<GameObject> getGameObjects(){
		ArrayList<GameObject> list = new ArrayList<GameObject>(skills);
		list.add(_hero);
		list.addAll(enemies);
		return list;
	}
	
	public void createWave(Level level){
		
		for(Enemy e :level.wave1){
			enemies.add(e);
		}
		
		for(Enemy e :level.wave2){
			enemies.add(e);
		}
		
		for(Enemy e :level.wave3){
			enemies.add(e);
		}
		
		
	}
}
