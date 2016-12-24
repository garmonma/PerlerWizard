package com.nni.gamevate.pixelwizard.object.spells;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.nni.gamevate.pixelwizard.object.Collidable;
import com.nni.gamevate.pixelwizard.object.GameObject;
import com.nni.gamevate.pixelwizard.object.character.Hero;
import com.nni.gamevate.pixelwizard.object.character.Shield;
import com.nni.gamevate.pixelwizard.object.enemies.Enemy;
import com.nni.gamevate.pixelwizard.object.spells.color.SpellColor;
import com.nni.gamevate.pixelwizard.object.spells.shape.SpellShape;

public final class Spell extends GameObject implements SpellInterface {
	private static final double BASE_SPEED = 200;
	private static final int DEFAULT_BOUNCE_COUNT = 3;
	private static final int DEFAULT_DAMAGE = 1;
	private static final int DEFAULT_SPIN = 0;
	private static final int MAX_SPIN = 1;
	private static final int MIN_SPIN = -1;

	private SpellColor _color;
	private SpellShape _shape;
	private double _speed;
	private double _dmg;
	private double _spin;
	private int _bounceCount;
	private int _bounceCounter;
	private long _spellTimer;
	private boolean _isEvaporated;
	private boolean _movingUp ;
	
	private Vector2 _velocity;
	private Vector2 _direction;

	public Spell(int width, int height, float x, float y, SpellColor color, SpellShape shape) {
		super(width, height, x, y);
		_color = color;
		_shape = shape;
		_speed = BASE_SPEED * _color.getSpeedMultiplier();
		_spellTimer = _color.getCooldown();
		_dmg = DEFAULT_DAMAGE * _shape.getDmgMultiplier();
		_spin = DEFAULT_SPIN;
		_bounceCount = DEFAULT_BOUNCE_COUNT;
		_bounceCounter = _bounceCount;
		_isEvaporated = false;
		_movingUp = true;
		
	}
	
	@Override
	public boolean collided(Collidable object) {
		if(object instanceof Enemy){
			if(getX() >= ((Enemy) object).getX() 
					&& getX()  <= ((Enemy) object).getWidth() + ((Enemy) object).getX() 
					&& getY() >= ((Enemy) object).getY()
					&& getY() <= ((Enemy) object).getHeight() + ((Enemy) object).getY()
					){
				
				Gdx.app.log("Spell Collision", "Collided with enemy!");				
				return true;	
			}
		}
		
		if(object instanceof Shield){
			if(getX() >= ((Shield) object).getX() 
					&& getX() <= ((Shield) object).getWidth() + ((Shield) object).getX() 
					&& getY() >= ((Shield) object).getY()
					&& getY() <= ((Shield) object).getHeight() + ((Shield) object).getY()
					){
				
				Gdx.app.log("Spell Collision", "Collided with Shield!");				
				return true;	
			}
		}

		return false;
	}

	@Override
	public void update(float delta) {
		if(_movingUp){
			_position.y += _speed * Gdx.graphics.getDeltaTime();
		} else {
			_position.y -= _speed * Gdx.graphics.getDeltaTime();
		}
		
		
		if (_position.x < 150) {
			bounceOffWall("left");
		}

		if (_position.x > 650 - 64) {
			bounceOffWall("right");
		}
		
		if(_position.y > 480){
			bounceOffWall("top");		
		}
		
		if(_position.y < 1){
			evaporate();
		}
	}

	@Override
	public void bounceOffWall(String side) {
		
		if(_bounceCounter-- == 0)
			evaporate();
		

		// Side can be left, right or center when bouncing off an object.
		if (side.equalsIgnoreCase("left")) {
			_spin = _spin + .1;
			if (_spin > MAX_SPIN)
				_spin = MAX_SPIN;
		} else if (side.equalsIgnoreCase("right")) {
			_spin = _spin - .1;
			if (_spin < MIN_SPIN)
				_spin = MIN_SPIN;
		} else if(side.equalsIgnoreCase("top")){
			_movingUp = false;
		}
	}

	@Override
	public void bounceOffEnemy() {
		
		if(_bounceCounter-- == 0)
			evaporate();
		
		if(_movingUp){
			_movingUp = false;
		} else {
			_movingUp = true;
		}

	}
	
	@Override
	public void bounceOffShield(){
		if(_bounceCounter-- == 0)
			evaporate();
		
		_movingUp = true;
	}

	@Override
	public void evaporate() {
		_isEvaporated = true;

	}
	
	public boolean isEvaporated(){
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
	
	public String getSpellColor(){
		return _color.toString();
	}
	
	public String getSpellShape(){
		return _shape.toString();
	}


}