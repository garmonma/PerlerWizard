package com.nni.gamevate.perlerwizard.object.spells;

import com.nni.gamevate.perlerwizard.GameConstants;
import com.nni.gamevate.perlerwizard.object.Collidable;
import com.nni.gamevate.perlerwizard.object.GameObject;
import com.nni.gamevate.perlerwizard.object.spells.color.SpellColor;
import com.nni.gamevate.perlerwizard.object.spells.shape.SpellShape;


/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public final class Spell extends GameObject implements Castable {
	private static final float BASE_SPEED = 5f;
	private static final int DEFAULT_BOUNCE_COUNT = 3;
	private static final int DEFAULT_DAMAGE = 1;
	private static final int DEFAULT_SPIN = 0;
	private static final int MAX_SPIN = 1;
	private static final int MIN_SPIN = -1;
	
	private SpellColor _color;
	private SpellShape _shape;
	private float _speed;
	private double _dmg;
	private double _spin;
	private int _bounceCount;
	private int _bounceCounter;
	private long _spellTimer;
	private boolean _isEvaporated;


	public Spell(float width, float height, float x, float y, SpellColor color, SpellShape shape) {
		super(width, height, x, y);
		_color = color;
		_shape = shape;

		_speed = BASE_SPEED * _color.getSpeedMultiplier();
		_dmg = DEFAULT_DAMAGE * _shape.getDmgMultiplier();
		_spin = DEFAULT_SPIN;
		_bounceCount = DEFAULT_BOUNCE_COUNT;
		_bounceCounter = _bounceCount;

		_spellTimer = _color.getCooldown();

		_isEvaporated = false;

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

		_direction.set(_position).setAngle(_shape.getBounceAngle()).nor();
		_velocity.set(_direction).scl(_speed);
		_movement.set(_velocity).scl(delta);
		_position.add(_movement);

		if (_position.y < GameConstants.LOWER_VOID) {
			evaporate();
		}
	}

	@Override
	public void evaporate() {
		_isEvaporated = true;

	}

	public boolean isEvaporated() {
		return _isEvaporated;
	}
	
	public void bounce(Collidable object){
		_shape.bounce(this, object);
	}

	@Override
	public void transfiguration(Castable spell) {
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