package com.nni.gamevate.perlerwizard.controllers;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.network.gamedata.GameCharacter;
import com.nni.gamevate.perlerwizard.network.gamedata.Spawn;
import com.nni.gamevate.perlerwizard.network.gamedata.Wave;
import com.nni.gamevate.perlerwizard.object.UIElement;
import com.nni.gamevate.perlerwizard.object.Wall;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.enemies.EnemyType;
import com.nni.gamevate.perlerwizard.object.hero.BattleMage;
import com.nni.gamevate.perlerwizard.object.hero.Hero;
import com.nni.gamevate.perlerwizard.object.hero.HeroTypes;
import com.nni.gamevate.perlerwizard.object.hero.Knight;
import com.nni.gamevate.perlerwizard.object.hero.Shield;
import com.nni.gamevate.perlerwizard.object.hero.Wizard;
import com.nni.gamevate.perlerwizard.object.spells.EnemySpell;
import com.nni.gamevate.perlerwizard.object.spells.Spell;
import com.nni.gamevate.perlerwizard.object.spells.color.RedSpell;
import com.nni.gamevate.perlerwizard.object.spells.color.SpellColor;
import com.nni.gamevate.perlerwizard.object.spells.color.WhiteSpell;
import com.nni.gamevate.perlerwizard.object.spells.shape.CircleSpell;
import com.nni.gamevate.perlerwizard.object.spells.shape.RectangleSpell;
import com.nni.gamevate.perlerwizard.object.spells.shape.SpellShape;
import com.nni.gamevate.perlerwizard.spawnloader.SpawnLoader;

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

	private UIElement _leftArrow;
	private UIElement _rightArrow;
	private UIElement _topArrow;
	private UIElement _bottomArrow;
	private UIElement _spellBox;

	private UIElement _heroHealthNode;

	private UIElement _skillSlotTwo;
	private UIElement _skillSlotThree;
	private UIElement _skillSlotFour;
	private UIElement _skillSlotOne;
	private UIElement _skillSlotFive;

	private UIElement _sigilButton;

	private Array<Spell> _spells;
	private Array<Enemy> _enemies;
	private Array<EnemySpell> _enemySpells;

	private ShapeSelector _shapeSelector;
	private ColorSelector _colorSelector;
	private long _lastSpell;
	private Spawn _level;

	private boolean _playerWon;
	private boolean _gameOver;

	private SpellColor _sc;
	private SpellShape _ss;
	
	private NetworkController _networkController;
	private GameCharacter _gameCharacter;
	private int _heroLevel;

	public GamePlayController(NetworkController networkController) {
		// _level = LevelLoader.load(Gdx.files.internal("levels/level_0.json"));
		_networkController = networkController;
		_gameCharacter = _networkController.getCharacter();
		
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

		_skillSlotOne = new UIElement(.5f, 6.5f, 1, 1);
		_skillSlotTwo = new UIElement(.5f, 5.25f, 1, 1);
		_skillSlotThree = new UIElement(.5f, 4f, 1, 1);
		_skillSlotFour = new UIElement(.5f, 2.75f, 1, 1);
		_skillSlotFive = new UIElement(.5f, 1.5f, 1, 1);

		_sigilButton = new UIElement(17f, 9f, 2, 2);

		_bottomArrow = new UIElement(2f, 1f, .5f, .5f);
		_topArrow = new UIElement(2f, 3f, .5f, .5f);
		_leftArrow = new UIElement(1f, 2f, .5f, .5f);
		_rightArrow = new UIElement(3f, 2f, .5f, .5f);

		_spellBox = new UIElement(1.75f, 1.75f, .5f, .5f);

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
		

		_spells = new Array<Spell>();
		_enemies = new Array<Enemy>();
		loadEnemies();

		_enemySpells = new Array<EnemySpell>();

		_shapeSelector = new ShapeSelector();
		_colorSelector = new ColorSelector();
		//loadSelectors();

		_playerWon = false;
		_gameOver = false;
	}

	public void update(float delta) {

		for (Spell spell : _spells) {

			if (spell.isEvaporated()) {
				Gdx.app.log("Spell Evaporate", "Spell Evaporated!");
				removeSpell(spell);
			}

			for (Enemy enemy : _enemies) {
				if (spell.collided(enemy)) {
					spell.bounce(enemy);

					if (enemy.dead(spell.getDmg())) {
						removeEnemy(enemy);
					}
				}

				enemy.update(delta);
			}

			if (spell.collided(_hero)) {
				spell.bounce(_hero);
			}

			if (spell.collided(_upperWall)) {
				spell.bounce(_upperWall);
			}

			if (spell.collided(_leftWall)) {
				spell.bounce(_leftWall);
			}

			if (spell.collided(_rightWall)) {
				spell.bounce(_rightWall);
			}

			spell.update(delta);
		}

		_hero.update(delta);

		if (_enemies.size == 0) {
			_playerWon = true;
			_gameOver = true;
		}

		if (_gameOver) {

		}
	}

	public void castSpell() {
		// 1.5 second global cooldown;

		if (TimeUtils.timeSinceNanos(_lastSpell) > 1500000000) {

			if (!_colorSelector.getSpellColor().isOnCooldown(_colorSelector.getSpellColor().getCooldown())) {

				if (_colorSelector.getSpellColor().toString().equalsIgnoreCase("red")) {
					_sc = new RedSpell();
				} else if (_colorSelector.getSpellColor().toString().equalsIgnoreCase("white")) {
					_sc = new WhiteSpell();
				}

				if (_shapeSelector.getSpellShape().toString().equalsIgnoreCase("circle")) {
					_ss = new CircleSpell();
				} else if (_shapeSelector.getSpellShape().toString().equalsIgnoreCase("rectangle")) {
					_ss = new RectangleSpell();
				}

				Spell spell = new Spell(.5f, .5f, _hero.getX() + _hero.getWidth() / 2,
						_hero.getY() + _hero.getHeight() + .05f, _sc, _ss);

				_colorSelector.rotateDown();
				_shapeSelector.rotateLeft();

				_spells.add(spell);
				_colorSelector.getSpellColor().reset();
				_lastSpell = TimeUtils.nanoTime();
			}
		}
	}

	public Hero getHero() {
		return _hero;
	}

	public Array<Enemy> getEnemies() {
		return _enemies;
	}

	public Array<Spell> getSpells() {
		return _spells;
	}

	public ShapeSelector getShapeSelector() {
		return _shapeSelector;
	}

	public ColorSelector getColorSelector() {
		return _colorSelector;
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

	public UIElement getLeftArrow() {
		return _leftArrow;
	}

	public UIElement getRightArrow() {
		return _rightArrow;
	}

	public UIElement getTopArrow() {
		return _topArrow;
	}

	public UIElement getBottomArrow() {
		return _bottomArrow;
	}

	public UIElement getSpellBox() {
		return _spellBox;
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

	public UIElement getSigilButton() {
		return _sigilButton;
	}

	public UIElement getHealthNode() {
		return _heroHealthNode;
	}

	private void loadEnemies() {
		Enemy enemy1 = new Enemy(1, 1, 6, 7, EnemyType.GoblinInitiate);
		Enemy enemy2 = new Enemy(1, 1, 7.5f, 7, EnemyType.GoblinInitiate);
		Enemy enemy3 = new Enemy(1, 1, 9, 7, EnemyType.GoblinInitiate);

		Enemy enemy1a = new Enemy(1, 1, 6, 8.5f, EnemyType.GoblinInitiate);
		Enemy enemy2a = new Enemy(1, 1, 7.5f, 8.5f, EnemyType.GoblinInitiate);
		Enemy enemy3a = new Enemy(1, 1, 9, 8.5f, EnemyType.GoblinInitiate);

		Enemy enemy1b = new Enemy(1, 1, 6, 10, EnemyType.GoblinInitiate);
		Enemy enemy2b = new Enemy(1, 1, 7.5f, 10, EnemyType.GoblinInitiate);
		Enemy enemy3b = new Enemy(1, 1, 9, 10, EnemyType.GoblinInitiate);

		_enemies.add(enemy1);
		_enemies.add(enemy2);
		_enemies.add(enemy3);
		_enemies.add(enemy1a);
		_enemies.add(enemy2a);
		_enemies.add(enemy3a);
		_enemies.add(enemy1b);
		_enemies.add(enemy2b);
		_enemies.add(enemy3b);
	}

	private void removeEnemy(Enemy e) {
		_enemies.removeValue(e, false);
	}

	private void removeSpell(Spell spell) {
		_spells.removeValue(spell, false);

	}

	private void processLevel() {
		List<Wave> waves = _level.getWaves();
		for (Wave wave : waves) {

		}

	}
}