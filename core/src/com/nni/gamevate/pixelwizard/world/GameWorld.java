package com.nni.gamevate.pixelwizard.world;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.nni.gamevate.pixelwizard.levelloader.Level;
import com.nni.gamevate.pixelwizard.levelloader.LevelLoader;
import com.nni.gamevate.pixelwizard.levelloader.Wave;
import com.nni.gamevate.pixelwizard.object.character.Hero;
import com.nni.gamevate.pixelwizard.object.character.Shield;
import com.nni.gamevate.pixelwizard.object.enemies.Enemy;
import com.nni.gamevate.pixelwizard.object.enemies.Enemy.EnemyType;
import com.nni.gamevate.pixelwizard.object.spells.EnemySpell;
import com.nni.gamevate.pixelwizard.object.spells.Spell;
import com.nni.gamevate.pixelwizard.object.spells.color.RedSpell;
import com.nni.gamevate.pixelwizard.object.spells.color.SpellColor;
import com.nni.gamevate.pixelwizard.object.spells.color.WhiteSpell;
import com.nni.gamevate.pixelwizard.object.spells.shape.CircleSpell;
import com.nni.gamevate.pixelwizard.object.spells.shape.RectangleSpell;
import com.nni.gamevate.pixelwizard.object.spells.shape.SpellShape;
import com.nni.gamevate.pixelwizard.object.walls.Wall;
import com.nni.gamevate.pixelwizard.ui.UIControl;

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

	private UIControl _analogLeft;
	private UIControl _analogRight;
	
	private UIControl _spellBox;

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

		_upperWall = new Wall(509, 5, 146, 476, "upper");
		_rightWall = new Wall(5, 480, 655, 1, "right");
		_leftWall = new Wall(5, 480, 146, 1, "left");

		_bottomArrow = new UIControl(70, 32, 16, 16);
		_topArrow = new UIControl(70, 100, 16, 16);
		_leftArrow = new UIControl(36, 66, 16, 16);
		_rightArrow = new UIControl(104, 66, 16, 16);
		
		_analogLeft = new UIControl(700, 30, 16, 16);
		_analogRight = new UIControl(764, 30, 16, 16);
		
		_spellBox = new UIControl(54, 50, 32, 32);

		_hero = new Hero(32, 32, 800 / 2 - 64 / 2, 20);
		_shield = new Shield(_hero.getWidth() + 10, 8, _hero.getX() - 5, _hero.getY() + _hero.getWidth() + 3);

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

				Spell spell = new Spell(16, 16, _hero.getShield().getX() + _hero.getShield().getWidth() / 2,
						_hero.getShield().getY() + _hero.getShield().getHeight() + 10, _sc, _ss);

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
		Enemy enemy1 = new Enemy(32, 32, 285, 300, EnemyType.GoblinInitiate);
		Enemy enemy2 = new Enemy(32, 32, 285, 360, EnemyType.GoblinInitiate);
		Enemy enemy3 = new Enemy(32, 32, 285, 420, EnemyType.GoblinInitiate);

		Enemy enemy1a = new Enemy(32, 32, 419, 300, EnemyType.GoblinInitiate);
		Enemy enemy2a = new Enemy(32, 32, 419, 360, EnemyType.GoblinInitiate);
		Enemy enemy3a = new Enemy(32, 32, 419, 420, EnemyType.GoblinInitiate);

		Enemy enemy1b = new Enemy(32, 32, 553, 300, EnemyType.GoblinInitiate);
		Enemy enemy2b = new Enemy(32, 32, 553, 360, EnemyType.GoblinInitiate);
		Enemy enemy3b = new Enemy(32, 32, 553, 420, EnemyType.GoblinInitiate);

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