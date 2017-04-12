package com.nni.gamevate.perlerwizard.controllers;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.network.gamedata.GameCharacter;
import com.nni.gamevate.perlerwizard.network.gamedata.Spawn;
import com.nni.gamevate.perlerwizard.network.gamedata.Wave;
import com.nni.gamevate.perlerwizard.object.Wall;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;
import com.nni.gamevate.perlerwizard.object.hero.BattleMage;
import com.nni.gamevate.perlerwizard.object.hero.Hero;
import com.nni.gamevate.perlerwizard.object.hero.HeroTypes;
import com.nni.gamevate.perlerwizard.object.hero.Knight;
import com.nni.gamevate.perlerwizard.object.hero.Wizard;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.object.skills.reflectables.Spell;
import com.nni.gamevate.perlerwizard.object.skills.throwables.JavelinThrow;
import com.nni.gamevate.perlerwizard.utils.UIElement;

/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class GamePlayController {

	private Hero _hero;

	private Wall _upperWall;
	private Wall _lowerWall;
	private Wall _rightWall;
	private Wall _leftWall;

	private UIElement _heroHealthNode;

	private List<UIElement> _skillSlots;
	private UIElement _skillSlotTwo;
	private UIElement _skillSlotThree;
	private UIElement _skillSlotFour;
	private UIElement _skillSlotOne;
	private UIElement _skillSlotFive;
	
	private UIElement _defenseCastBox;

	private UIElement _sigilButton;

	private Array<Skill> _skills;
	private Array<Enemy> _enemies;

	private Spawn _level;

	private boolean _playerWon;
	private boolean _gameOver;
	
	private NetworkController _networkController;
	private GameCharacter _gameCharacter;
	private int _heroLevel;
	
	private int _selectedSkill;

	public GamePlayController(NetworkController networkController) {
		// _level = LevelLoader.load(Gdx.files.internal("levels/level_0.json"));
		
		if(PerlerWizard.DEBUG == false){			
			_networkController = networkController;		
			_gameCharacter = _networkController.getCharacter();
		}else{
			_gameCharacter = new GameCharacter();
		}
		
		if(_gameCharacter.attack == 0){
			_gameCharacter.attack = 10;
			_gameCharacter.defense = 10;
			_gameCharacter.dodge = 10;
			_gameCharacter.experience = 120;
			_gameCharacter.healthPct = 50;
			_gameCharacter.job = 1;
			_gameCharacter.level = 10;
			_gameCharacter.speed = 7;
			_gameCharacter.gold = 13000;
		}
		
		System.out.println(_gameCharacter);
		_heroLevel = _gameCharacter.level;
		
		init();	
	}
	
	public void init(){
		_upperWall = new Wall(GameConfig.RIGHT_WALL - GameConfig.LEFT_WALL, .10f, GameConfig.LEFT_WALL,
				GameConfig.WORLD_HEIGHT, "upper");
		_upperWall.setDirection(90);
		
		_rightWall = new Wall(.10f, GameConfig.WORLD_HEIGHT, GameConfig.RIGHT_WALL, 0, "right");

		_leftWall = new Wall(.10f, GameConfig.WORLD_HEIGHT, GameConfig.LEFT_WALL, 0, "left");

		_skillSlots = new ArrayList<UIElement>();
		_skillSlots.add(_skillSlotOne = new UIElement(.5f, 6.5f, 1, 1));
		_skillSlots.add(_skillSlotTwo = new UIElement(.5f, 5.25f, 1, 1));
		_skillSlots.add(_skillSlotThree = new UIElement(.5f, 4f, 1, 1));
		_skillSlots.add(_skillSlotFour = new UIElement(.5f, 2.75f, 1, 1));
		_skillSlots.add(_skillSlotFive = new UIElement(.5f, 1.5f, 1, 1));
		
		_defenseCastBox = new UIElement(17f, 1.5f, 2.5f, .75f);

		_sigilButton = new UIElement(17f, 9f, 2, 2);

		_heroHealthNode = new UIElement(0.5f, 11f, 3f, .5f);
			
		if(_gameCharacter.job == HeroTypes.WIZARD){
			_hero = new Wizard(1, 1, GameConfig.WORLD_WIDTH / 2, 0, _heroLevel);
		} else if(_gameCharacter.job == HeroTypes.KNIGHT) {
			_hero = new Knight(1, 1, GameConfig.WORLD_WIDTH / 2, 0, _heroLevel);
		} else if(_gameCharacter.job == HeroTypes.BATTLEMAGE){
			_hero = new BattleMage(1, 1, GameConfig.WORLD_WIDTH / 2,  0, _heroLevel);
		}
		
		System.out.println(_hero);
		
		_hero.setCurrentHealthPct(_gameCharacter.healthPct);
		

		_skills = new Array<Skill>();
		_enemies = new Array<Enemy>();
		loadEnemies();

		_playerWon = false;
		_gameOver = false;
	}

	public void update(float delta) {

		for (Skill skill : _skills) {

			if (skill.isEvaporated()) {
				Gdx.app.log("Spell Evaporate", "Spell Evaporated!");
				removeSpell(skill);
			}

			for (Enemy enemy : _enemies) {
				if (!skill.enemySkill() && skill.collided(enemy)) {
					if(skill instanceof Spell){
						((Spell) skill).bounce(enemy);
					}
					
					if(skill instanceof JavelinThrow){
						skill.evaporate();
					}
						
					if (enemy.isDead(skill.getDamage())) {
						removeEnemy(enemy);
					}
				}
				
			}

			//TODO - Create a bounceable interface
			if(skill instanceof Spell){
				if (skill.collided(_hero) && skill.enemySkill()) {
					// Damage hero
				}
				
				if(skill.collided(_hero) && !skill.enemySkill()){
					((Spell)skill).bounce(_hero);
				}
	
				if (skill.collided(_upperWall)) {
					((Spell)skill).bounce(_upperWall);
				}
	
				if (skill.collided(_leftWall)) {
					((Spell)skill).bounce(_leftWall);
				}
	
				if (skill.collided(_rightWall)) {
					((Spell)skill).bounce(_rightWall);
				}
			}

			skill.update(delta);
		}
		
		for (Enemy enemy : _enemies) {
			
			enemy.update(delta);
		}
		
		
		
		processEnemyAttack();

		_hero.update(delta);

		if (_enemies.size == 0) {
			_playerWon = true;
			_gameOver = true;
		}

		if (_gameOver) {

		}
	}
	
	public void attack(){
		Skill attack = _hero.attack(_selectedSkill);
		
		if(attack != null){
			_skills.add(attack);
		}	
	}
	
	public void castSpecial(){
		_hero.castSpecial();
	}

	public void castDefense(){
		Skill defense = _hero.castDefense();
		
		if(defense != null){
			_skills.add(defense);
		};
	}
	
	public Hero getHero() {
		return _hero;
	}

	public Array<Enemy> getEnemies() {
		return _enemies;
	}

	public Array<Skill> getSkills() {
		return _skills;
	}

	public Wall getUpperWall() {
		return _upperWall;
	}

	public Wall getLowerWall() {
		return _lowerWall;
	}

	public Wall getRightWall() {
		return _rightWall;
	}

	public Wall getLeftWall() {
		return _leftWall;
	}

	public UIElement getSkillSlotOne() {
		return _skillSlotOne;
	}

	public UIElement getSkillSlotThree() {
		return _skillSlotThree;
	}

	public UIElement getSkillSlotFour() {
		return _skillSlotFour;
	}

	public UIElement getSkillSlotFive() {
		return _skillSlotFive;
	}

	public UIElement getSkillSlotTwo() {
		return _skillSlotTwo;
	}
	
	public UIElement getDefenseCastBox(){
		return _defenseCastBox;
	}
	
	public List<UIElement> getSkillSlots(){
		return _skillSlots;
	}

	public UIElement getSigilButton() {
		return _sigilButton;
	}

	public UIElement getHealthNode() {
		return _heroHealthNode;
	}

	private void loadEnemies() {
//		Enemy enemy1 = new Goblin(1, 1, 6, 7);
//		Enemy enemy2 = new Goblin(1, 1, 7.5f, 7);
//		Enemy enemy3 = new Orc(1, 1, 9, 7);
//
//		Enemy enemy1a = new Goblin(1, 1, 6, 8.5f);
//		Enemy enemy2a = new Goblin(1, 1, 7.5f, 8.5f);
//		Enemy enemy3a = new Orc(1, 1, 9, 8.5f);
//
//		Enemy enemy1b = new Goblin(1, 1, 6, 10);
//		Enemy enemy2b = new Goblin(1, 1, 7.5f, 10);
//		Enemy enemy3b = new Orc(1, 1, 9, 10);
//
//		_enemies.add(enemy1);
//		_enemies.add(enemy2);
//		_enemies.add(enemy3);
//		_enemies.add(enemy1a);
//		_enemies.add(enemy2a);
//		_enemies.add(enemy3a);
//		_enemies.add(enemy1b);
//		_enemies.add(enemy2b);
//		_enemies.add(enemy3b);
	}

	private void removeEnemy(Enemy e) {
		_enemies.removeValue(e, false);
	}

	private void removeSpell(Skill skill) {
		_skills.removeValue(skill, false);

	}
	
	private void processEnemyAttack(){
		for(Enemy enemy: _enemies){
			//Skill attack = enemy.attack();
			Skill special = enemy.castSpecial();
			
//			if(attack != null){
//				_skills.add(attack);
//			}
			
			if(special != null){
				_skills.add(special);
			}
			
		}
	}

	private void processLevel() {
		List<Wave> waves = _level.getWaves();
		for (Wave wave : waves) {

		}

	}

	public void setSelectedSkill(int selectedSkill) {
		_selectedSkill = selectedSkill;
		
	}
	
	public int getSelectedSkill(){
		return _selectedSkill;
	}
	
}