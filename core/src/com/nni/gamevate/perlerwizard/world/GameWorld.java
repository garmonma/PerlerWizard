package com.nni.gamevate.perlerwizard.world;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.nni.gamevate.perlerwizard.GameConstants;
import com.nni.gamevate.perlerwizard.levelloader.Level;
import com.nni.gamevate.perlerwizard.levelloader.LevelLoader;
import com.nni.gamevate.perlerwizard.levelloader.Wave;
import com.nni.gamevate.perlerwizard.object.character.Hero;
import com.nni.gamevate.perlerwizard.object.character.Shield;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy.EnemyType;
import com.nni.gamevate.perlerwizard.object.spells.EnemySpell;
import com.nni.gamevate.perlerwizard.object.spells.Spell;
import com.nni.gamevate.perlerwizard.object.spells.color.RedSpell;
import com.nni.gamevate.perlerwizard.object.spells.color.SpellColor;
import com.nni.gamevate.perlerwizard.object.spells.color.WhiteSpell;
import com.nni.gamevate.perlerwizard.object.spells.shape.CircleSpell;
import com.nni.gamevate.perlerwizard.object.spells.shape.RectangleSpell;
import com.nni.gamevate.perlerwizard.object.spells.shape.SpellShape;
import com.nni.gamevate.perlerwizard.object.walls.Wall;
import com.nni.gamevate.perlerwizard.ui.UIControl;

/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class GameWorld {

	private Hero _hero;
	private Shield _shield;

	private Wall _upperWall;
	private Wall _lowerWall;
	private Wall _rightWall;
	private Wall _leftWall;

	private UIControl _leftArrow;
	private UIControl _rightArrow;
	private UIControl _topArrow;
	private UIControl _bottomArrow;
	private UIControl _spellBox;

	private UIControl _analogLeft;
	private UIControl _analogRight;
	
	private UIControl _heroMaxHealthBar;
	private UIControl _heroMaxMagicBar;
	
	private UIControl _heroCurrentHealthBar;
	private UIControl _heroCurrentMagicBar;
		
	private Array<Spell> _spells;
	private Array<Enemy> _enemies;
	private Array<EnemySpell> _enemySpells;

	private ShapeSelector _shapeSelector;
	private ColorSelector _colorSelector;
	private long _lastSpell;
	private Level _level;

	private boolean _playerWon;
	private boolean _gameOver;

	private SpellColor _sc;
	private SpellShape _ss;

	public GameWorld() {
		_level = LevelLoader.load(Gdx.files.internal("levels/level_0.json"));

		_upperWall = new Wall(GameConstants.RIGHT_WALL - GameConstants.LEFT_WALL, 
				.10f, GameConstants.LEFT_WALL, GameConstants.WORLD_HEIGHT, "upper");
		
		_rightWall = new Wall(.10f, GameConstants.WORLD_HEIGHT, 
				GameConstants.RIGHT_WALL, 0, "right");
		
		_leftWall = new Wall(.10f, GameConstants.WORLD_HEIGHT, 
				GameConstants.LEFT_WALL, 0, "left");

		_bottomArrow = new UIControl(2f, 1f, .5f, .5f);
		_topArrow = new UIControl(2f, 3f, .5f, .5f);
		_leftArrow = new UIControl(1f, 2f, .5f, .5f);
		_rightArrow = new UIControl(3f, 2f, .5f, .5f);
		
		_spellBox = new UIControl(1.75f, 1.75f, .5f, .5f);
		
		_analogLeft = new UIControl(17, 2, 1, 1);
		_analogRight = new UIControl(19, 2, 1, 1);
		
		_heroMaxHealthBar = new UIControl(1, GameConstants.WORLD_HEIGHT - 1, 2, .5f);
		_heroMaxMagicBar = new UIControl(1, GameConstants.WORLD_HEIGHT - 1.75f, 2, .5f);
		
		_heroCurrentHealthBar = new UIControl(1, GameConstants.WORLD_HEIGHT - 1, 1.5f, .5f);
		_heroCurrentMagicBar = new UIControl(1, GameConstants.WORLD_HEIGHT - 1.75f, 2, .5f);
		
		_hero = new Hero(1, 1, GameConstants.WORLD_WIDTH/ 2, 0);
		_shield = new Shield(1.20f, .15f, _hero.getX() - .10f, _hero.getY() + _hero.getHeight() + .10f);

		_hero.setShield(_shield);

		_spells = new Array<Spell>();
		_enemies = new Array<Enemy>();
		loadEnemies();

		_enemySpells = new Array<EnemySpell>();

		_shapeSelector = new ShapeSelector();
		_colorSelector = new ColorSelector();
		loadSelectors();

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

			if (spell.collided(_hero.getShield())) {
				spell.bounce(_hero.getShield());
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

				Spell spell = new Spell(.5f, .5f, _hero.getShield().getX() + _hero.getShield().getWidth() / 2,
						_hero.getShield().getY() + _hero.getShield().getHeight() + .05f, _sc, _ss);

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

	public UIControl getLeftArrow() {
		return _leftArrow;
	}

	public UIControl getRightArrow() {
		return _rightArrow;
	}

	public UIControl getTopArrow() {
		return _topArrow;
	}

	public UIControl getBottomArrow() {
		return _bottomArrow;
	}
	
	public UIControl getAnalogLeft(){
		return _analogLeft;
	}
	
	public UIControl getAnalogRight(){
		return _analogRight;
	}
	
	public UIControl getSpellBox(){
		return _spellBox;
	}

	public UIControl getHeroMaxHealthBar() {
		return _heroMaxHealthBar;
	}

	public UIControl getHeroMaxMagicBar() {
		return _heroMaxMagicBar;
	}

	public UIControl getHeroCurrentHealthBar() {
		return _heroCurrentHealthBar;
	}

	public UIControl getHeroCurrentMagicBar() {
		return _heroCurrentMagicBar;
	}

	private void loadSelectors() {
		_shapeSelector.insert(new CircleSpell(), 0);
		_shapeSelector.insert(new RectangleSpell(), 1);
		_shapeSelector.insert(new CircleSpell(), 2);
		_shapeSelector.insert(new RectangleSpell(), 3);

		_colorSelector.insert(new WhiteSpell(), 0);
		_colorSelector.insert(new RedSpell(), 1);
		_colorSelector.insert(new WhiteSpell(), 2);
		_colorSelector.insert(new RedSpell(), 3);
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