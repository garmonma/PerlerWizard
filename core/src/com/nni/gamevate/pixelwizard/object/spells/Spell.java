package com.nni.gamevate.pixelwizard.object.spells;

import com.nni.gamevate.pixelwizard.GameConstants;
import com.nni.gamevate.pixelwizard.object.Collidable;
import com.nni.gamevate.pixelwizard.object.GameObject;
import com.nni.gamevate.pixelwizard.object.character.Shield;
import com.nni.gamevate.pixelwizard.object.enemies.Enemy;
import com.nni.gamevate.pixelwizard.object.spells.color.SpellColor;
import com.nni.gamevate.pixelwizard.object.spells.shape.CircleSpell;
import com.nni.gamevate.pixelwizard.object.spells.shape.SpellShape;

public final class Spell extends GameObject implements SpellInterface {
	private static final float BASE_SPEED = 200;
	private static final int DEFAULT_BOUNCE_COUNT = 3;
	private static final int DEFAULT_DAMAGE = 1;
	private static final int DEFAULT_SPIN = 0;
	private static final int MAX_SPIN = 1;
	private static final int MIN_SPIN = -1;
	private static final float DEFAULT_ANGLE = 90;

	private SpellColor _color;
	private SpellShape _shape;
	private float _speed;
	private double _dmg;
	private double _spin;
	private int _bounceCount;
	private int _bounceCounter;
	private long _spellTimer;
	private boolean _isEvaporated;
	private boolean _movingUp;

	private float _angle;

	public Spell(int width, int height, float x, float y, SpellColor color, SpellShape shape) {
		super(width, height, x, y);
		_color = color;
		_shape = shape;
		_angle = DEFAULT_ANGLE;

		_speed = BASE_SPEED * _color.getSpeedMultiplier();
		_dmg = DEFAULT_DAMAGE * _shape.getDmgMultiplier();
		_spin = DEFAULT_SPIN;
		_bounceCount = DEFAULT_BOUNCE_COUNT;
		_bounceCounter = _bounceCount;

		_spellTimer = _color.getCooldown();

		_isEvaporated = false;
		_movingUp = true;

	}

	@Override
	public boolean collided(Collidable object) {
		if (getX() >= ((GameObject) object).getX()
				&& getX() <= ((GameObject) object).getX() + ((GameObject) object).getWidth()
				&& getY() >= ((GameObject) object).getY()
				&& getY() <= ((GameObject) object).getY() + ((GameObject) object).getHeight()) {

			return true;
		}

		return false;
	}

	@Override
	public void update(float delta) {
		if (_position.x <= GameConstants.LEFT_WALL) {

			_angle = 45;
		} else if (_position.x >= GameConstants.RIGHT_WALL - getWidth()) {
			_angle = 135;
		} else if (_position.y >= GameConstants.UPPER_WALL) {
			if (_angle == 45) {
				_angle = 315;
			} else {
				_angle = 225;
			}
		}

		_direction.set(_position).setAngle(_angle).nor();
		_velocity.set(_direction).scl(_speed);
		_movement.set(_velocity).scl(delta);
		_position.add(_movement);

		if (_position.y < GameConstants.LOWER_VOID) {
			evaporate();
		}
	}

	@Override
	public void bounceOffWall(String side) {

		// if(_bounceCounter-- == 0)
		// evaporate();
		//

		// Side can be left, right or center when bouncing off an object.
		if (side.equalsIgnoreCase("left")) {
			_spin = _spin + .1;
			if (_spin > MAX_SPIN)
				_spin = MAX_SPIN;
		} else if (side.equalsIgnoreCase("right")) {
			_spin = _spin - .1;
			if (_spin < MIN_SPIN)
				_spin = MIN_SPIN;
		} else if (side.equalsIgnoreCase("top")) {
			_movingUp = false;
		}
	}

	@Override
	public void bounceOffEnemy(Enemy enemy) {

		if (_bounceCounter-- == 0)
			evaporate();

		_angle = _angle + 180;

	}

	@Override
	public void bounceOffShield(Shield shield) {
		if (_bounceCounter-- == 0)
			evaporate();

		if (getX() <= shield.getX() + ((shield.getWidth() / 3) * 1)) {
			// bounceRight(); angle = 45 degrees;
			_angle = 45;
		} else if (getX() <= shield.getX() + ((shield.getWidth() / 3) * 2)) {
			// bounceStraight angle 90 degrees;
			_angle = 90;
		} else if (getX() <= shield.getX() + ((shield.getWidth() / 3) * 3)) {
			// bounceLeft() angle = 135 degrees;
			_angle = 135;
		}

	}

	@Override
	public void evaporate() {
		_isEvaporated = true;

	}

	public boolean isEvaporated() {
		return _isEvaporated;
	}

	@Override
	public void transfiguration(EnemySpell enemySpell) {
		// TODO Auto-generated method stub

	}

	public double getSpeed() {
		return _speed;
	}

	public double getDmg() {
		return _dmg;
	}

	public double getSpin() {
		return _spin;
	}

	public double getSpellTimer() {
		return _spellTimer;
	}

	public String getSpellColor() {
		return _color.toString();
	}

	public String getSpellShape() {
		return _shape.toString();
	}

}