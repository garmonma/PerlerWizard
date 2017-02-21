package com.nni.gamevate.perlerwizard.object.skills;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.object.Collidable;
import com.nni.gamevate.perlerwizard.object.GameObject;
import com.nni.gamevate.perlerwizard.object.Wall;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.hero.Hero;
import com.nni.gamevate.perlerwizard.object.hero.Shield;


/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public abstract class Spell extends Skill implements Castable {
	private static final int DEFAULT_BOUNCE_COUNT = 3;

	protected int _bounceCount;
	protected int _bounceCounter;
	private long _spellTimer;
	
	protected float _bounceAngle;
	
	public Spell(float x, float y){
		super(x, y);
		
		_width = 0.5f;
		_height = 0.5f;
		
		_bounceCount = DEFAULT_BOUNCE_COUNT;
		_bounceCounter = _bounceCount;
		_bounceAngle = 90;
		
		_direction.set(_position).setAngle(_bounceAngle).nor();
		_velocity.set(_direction).scl(_speed);
	}


	public Spell(float width, float height, float x, float y) {
		super(width, height, x, y);
		_bounceCount = DEFAULT_BOUNCE_COUNT;
		_bounceCounter = _bounceCount;
		_bounceAngle = 90;
		
		_direction.set(_position).setAngle(_bounceAngle).nor();
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

		if (_position.y < GameConfig.LOWER_VOID) {
			evaporate();
		}
	}
	
	@Override
	public void transfiguration(Castable spell) {

		}
	
	public void bounce(Collidable object){
		Vector2 change = bounce(this, object);
			
		if(change != null){
			//_velocity.set(change).scl(_speed)
			change.scl(_speed);
			_velocity = change;
		}
	}
	
	private Vector2 bounce(Spell spell, Collidable collidable){
		if(collidable instanceof Shield){
			return bounceOffShield(spell, (Shield)collidable);
		}
		
		if(collidable instanceof Enemy){
			return bounceOffEnemy(spell, (Enemy)collidable);
		}
		
		if(collidable instanceof Hero){
			bounceOffHero(spell, (Hero)collidable);
		}
		
		if(collidable instanceof Wall){
			return bounceOffWall(spell, (Wall)collidable);
		}
		
		return null;
	}
	
	protected Vector2 bounceOffShield(Spell spell, Shield shield) {
		float shieldMaxX = shield.getX() + shield.getWidth();
		float difference = shieldMaxX - spell.getX();
		float pct = (100 * difference) / shield.getWidth();
		// Gdx.app.log("Bounce Difference", difference + "");
		// Gdx.app.log("BouncePct", pct + "");

		_bounceAngle = ((pct * 1.4f) + 20f);// * -1f;
		
		Vector2 reflectionAngle = spell.getVelocity().cpy();
		Vector2 wallVector = shield.getPosition().cpy().rotate90(0);
		
		float dot = reflectionAngle.dot(wallVector);
		dot *= -2.0f;
		wallVector.scl(dot);
		wallVector.add(reflectionAngle);

		reflectionAngle.set(wallVector).nor().setAngle(_bounceAngle);

		return reflectionAngle;
	}

	
	protected Vector2 bounceOffEnemy(Spell spell, Enemy enemy) {
		Vector2 reflectionAngle = spell.getVelocity().cpy();
		Vector2 wallVector = enemy.getPosition().cpy().rotate90(0);
		
		float dot = reflectionAngle.dot(wallVector);
		dot *= -2.0f;
		wallVector.scl(dot);
		wallVector.add(reflectionAngle);

		reflectionAngle.set(wallVector).nor();
		
		return reflectionAngle;

	}

	protected Vector2 bounceOffWall(Spell spell, Wall wall) {
		Vector2 reflectionAngle = spell.getVelocity().cpy();
		Vector2 wallVector = wall.getPosition().cpy();
			
		wallVector.nor();
		float dot = reflectionAngle.dot(wallVector);
		dot *= -2.0f;
		wallVector.scl(dot);
		wallVector.add(reflectionAngle).nor();

		reflectionAngle.set(wallVector).nor();
		
		//_bounceAngle = reflectionAngle.angle();
		
		return reflectionAngle;
	}

	
	protected void bounceOffHero(Spell spell, Hero hero) {
		// TODO Auto-generated method stub

	}

	public double getSpeed() {
		return _speed;
	}

	public double getSpellTimer() {
		return _spellTimer;
	}
}