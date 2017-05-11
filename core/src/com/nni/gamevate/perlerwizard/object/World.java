package com.nni.gamevate.perlerwizard.object;

import java.util.ArrayList;
import java.util.Iterator;

import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.events.Event;
import com.nni.gamevate.perlerwizard.events.Event.EventType;
import com.nni.gamevate.perlerwizard.events.EventManager;
import com.nni.gamevate.perlerwizard.events.Subscriber;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.hero.Hero;
import com.nni.gamevate.perlerwizard.object.hero.Wizard;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.screens.game.WaveGameScreen;
import com.nni.gamevate.perlerwizard.utils.Logger;
import com.nni.gamevate.perlerwizard.waves.Level;

public class World implements Subscriber {
	
	private ArrayList<Skill> skills = new ArrayList<Skill>();
	private ArrayList<Skill> enemySkills = new ArrayList<Skill>();
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();

	private Hero _hero;
	public float camXPos;
	public float forwardLine;
	public float lastCamDelta;
	private float camSpeed = 2;
	private float chaseSpeed = -.5f;
	private float runSpeed = 2;
	private float encroachSpeed = 0.25f;
	private Level loadedLevel;
	
	public World(Level level) {
		_hero = new Wizard(1, 1, 0, GameConfig.WORLD_HEIGHT/2, 1);		
		Logger.log("init World");
		_hero.setWorld(this);
		Logger.log(_hero.getWorld() + "");
		createWave(level);
		EventManager.addSubscriber(EventType.ENEMY_ATTACKED, this);
		EventManager.addSubscriber(EventType.ENEMY_DEATH, this);
	}
	
	public void tick(float delta){
		if(WaveGameScreen.gameOver == true){
			return;
		}

		
		
		moveCamPos(delta);
		updateHero(delta);
		updateSkills(delta);
		updateEnemies(delta);
		updateEnemySkills(delta);
		checkCollisions();
	}
	
	public Hero getHero(){
		return _hero;
	}
	public void updateHero(float delta){	
		
		//_hero.setX(x);
		if(WaveGameScreen.victory == false)
			_hero._position.x += lastCamDelta;
		
		_hero.update(delta);
		if(_hero.alive == false){
			WaveGameScreen.gameOver = true;
		}
	}
	
	// these are here so we don't spam the event system. 
	private boolean metWave1 = false;
	private boolean metWave2 = false;
	private boolean metWave3 = false;

	public void moveCamPos(float delta){
		
		if(WaveGameScreen.victory == true)
			return;
		
		if(camSpeed < 0 && camXPos <= 4){
			lastCamDelta = 0;
			if (forwardLine <= -5.5f){
				//Logger.log("Game over");
				//TODO only game over if more than 2 enemies are left
				WaveGameScreen.gameOver = true;
				
			}else{
				forwardLine -= encroachSpeed * delta;
				
			}
			return;
		}
		
		lastCamDelta = camSpeed * delta;
		camXPos += lastCamDelta;
		forwardLine = camXPos - 2;
		
		
		
		if(metWave1 == false && camXPos + 1 >= Level.wave1Start){
			metWave1 = true;
			Event e = new Event(EventType.ENEMY_ATTACKED,1+"");			
			EventManager.publish(e._type,e );			
			
		}else if(metWave2 == false && camXPos + 1 >= Level.wave2Start){
			metWave2 = true;
			Event e = new Event(EventType.ENEMY_ATTACKED,2+"");			
			EventManager.publish(e._type,e );
		}else if(metWave3 == false && camXPos + 1 >= Level.wave3Start){
			metWave3 = true;
			Event e = new Event(EventType.ENEMY_ATTACKED,3+"");			
			EventManager.publish(e._type,e );
		}
	}
	public void addSkill(Skill s){
		if(s != null){
			s.sound(SoundType.SKILL_CAST);
			skills.add(s);
		}
	}
	public void addEnemySkill(Skill s){
		if(s != null){
			enemySkills.add(s);
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
					s.sound(SoundType.SKILL_HIT);
					s.setAlive(false);
				}
			}
		}
		
		for(Skill s : enemySkills){
			if(s.alive == true && _hero.collided(s)){
				_hero.damage(s.getDamage());
				s.setAlive(false);
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
	public void updateEnemySkills(float delta){
		Iterator<Skill> sItor = enemySkills.iterator();
		while(sItor.hasNext()){
			Skill s = sItor.next();			
			
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
				switch (e._waveNumber) {
				// TODO figure out a better way to do this
				case 1:
					loadedLevel.wave1.remove(e);	
					break;
				case 2:
					loadedLevel.wave2.remove(e);	
					break;
				case 3:
					loadedLevel.wave3.remove(e);	
					break;
				default:
					break;
				}
				
				Event event = new Event(EventType.ENEMY_DEATH, e._waveNumber + "");
				EventManager.publish(event._type, event);
				eItor.remove();
			}else{
				e.update(delta);
			}
		}		
	}
	
	public ArrayList<GameObject> getGameObjects(){
		ArrayList<GameObject> list = new ArrayList<GameObject>(skills);
		list.addAll(enemySkills);
		list.add(_hero);
		list.addAll(enemies);
		
		return list;
	}
	
	public void createWave(Level level){
		
		for(Enemy e :level.wave1){
			e.setWorld(this);
			enemies.add(e);			
		}
		
		for(Enemy e :level.wave2){
			e.setWorld(this);
			enemies.add(e);
		}
		
		for(Enemy e :level.wave3){
			e.setWorld(this);
			enemies.add(e);
		}
		
		loadedLevel = level;
	}

	@Override
	public void handleEvent(Event e) {
		
		switch (e._type) {
		case ENEMY_ATTACKED:
			handleEnemyAttacked(e);
			break;
		case ENEMY_DEATH:
			handleEnemyDeath(e);
			break;
		case JOINED_GROUP:
			break;
		default:
			break;		
		}
		
	}
	
	private void handleEnemyAttacked(Event e){
		switch(e._message){
		case "1":
			if(loadedLevel.wave1.isEmpty() == false){
				camSpeed = chaseSpeed;	
			}
			break;
		case "2":
			if(loadedLevel.wave2.isEmpty() == false){
				camSpeed = chaseSpeed;	
			}
			break;
		case "3":
			if(loadedLevel.wave3.isEmpty() == false){
				camSpeed = chaseSpeed;	
			}
			break;
		}
	}

	private void handleEnemyDeath(Event e) {
		switch (e._message) {
		case "1":
			Logger.log("wave 1 enemy Death. enemies Remain:  " + loadedLevel.wave1.size());
			
			if(metWave1 && loadedLevel.wave1.isEmpty()){
				Logger.log("empty");
				camSpeed = runSpeed;	
			}
			break;
		case "2":
			if(metWave2 && loadedLevel.wave2.isEmpty() && loadedLevel.wave1.isEmpty()){
				camSpeed = runSpeed;	
			}
			break;
		case "3":
			if(metWave3 && loadedLevel.wave3.isEmpty() && loadedLevel.wave2.isEmpty()){
				WaveGameScreen.victory = true;
			}
			break;
		default:
			break;
		}
		
	}
}
