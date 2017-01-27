package com.nni.gamevate.perlerwizard.object.spells;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.nni.gamevate.perlerwizard.GameConfig;
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
	
	private Vector2 _bounceChange;


	public Spell(float width, float height, float x, float y, SpellColor color, SpellShape shape) {
		super(width, height, x, y);
		_color = color;
		_shape = shape;

		_speed = BASE_SPEED * _color.getSpeedMultiplier();
		_dmg = DEFAULT_DAMAGE * _shape.getDmgMultiplier();
		_spin = DEFAULT_SPIN;
		_bounceCount = DEFAULT_BOUNCE_COUNT;
		_bounceCounter = _bounceCount;
		//_position.setAngle(90);

		_spellTimer = _color.getCooldown();

		_isEvaporated = false;

		_bounceChange = new Vector2();
		
		_direction.set(_position).setAngle(_shape.getBounceAngle()).nor();
		_velocity.set(_direction).scl(_speed);
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

		
		_movement.set(_velocity).scl(delta);
		_position.add(_movement);
		
//		if((int)delta % 10 == 0){
//			Gdx.app.log("Angle", _direction.angle() + "");
//			Gdx.app.log("Radians", _direction.angleRad() + "");
//			Gdx.app.log("P Angle", _position.angle() + "");
//			Gdx.app.log("P Radians", _position.angleRad() + "");
//		}
		

		if (_position.y < GameConfig.LOWER_VOID) {
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
		Vector2 change = _shape.bounce(this, object);
		
		Gdx.app.log("Change", change + "");
		
		
		if(change != null){
			Gdx.app.log("Change Angle", change.angle() + "");
			
			
			Gdx.app.log("before velocity", _velocity + "");
			Gdx.app.log("before position", _position + "");
			Gdx.app.log("Before Angle", _position.angle() + "");
			//_velocity.set(change).scl(_speed)
			change.scl(_speed);
			_velocity = change;
			
			Gdx.app.log("velocity", _velocity + "");
			Gdx.app.log("position", _position + "");
			Gdx.app.log("After Angle", _position.angle() + "");
		}
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