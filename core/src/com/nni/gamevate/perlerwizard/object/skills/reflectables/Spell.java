package com.nni.gamevate.perlerwizard.object.skills.reflectables;

import com.badlogic.gdx.math.Vector2;
import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.object.Collidable;
import com.nni.gamevate.perlerwizard.object.GameObject;
import com.nni.gamevate.perlerwizard.object.Wall;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.hero.Hero;
import com.nni.gamevate.perlerwizard.object.skills.Castable;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.object.skills.defense.EnergyShield;


/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public abstract class Spell extends Skill implements Castable {

	private static final int DEFAULT_BOUNCE_COUNT = 3;

	protected int _bounceCount;
	protected int _bounceCounter;
	protected long _spellRefreshTimer;
	
	
	protected float _bounceAngle;
	
	//TODO this shouldn't be static... need to change the constructor on the spells
	private static float defaultSize = 0.25f;
	/**
	 * Centers the projectile
	 * @param x
	 * @param y
	 */
	public Spell(float x, float y){			
		this(defaultSize,defaultSize,x -defaultSize/2,y -defaultSize/2);		
	}


	public Spell(float width, float height, float x, float y) {
		super(width, height, x, y);
		
		_damage = 1;
		
		_bounceCount = DEFAULT_BOUNCE_COUNT;
		_bounceCounter = _bounceCount;
		_bounceAngle = 0;
		
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
		
		if(getX() - getStartX() > GameConfig.WORLD_WIDTH /2  )
			alive = false;
		
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
//		if(collidable instanceof Shield){
//			return bounceOffShield((Shield)collidable);
//		}
		
		if(collidable instanceof Enemy){
			return bounceOffEnemy((Enemy)collidable);
		}
		
//		if(collidable instanceof Hero){
//			return bounceOffHero((Hero)collidable);
//		}
		
		if(collidable instanceof Wall){
			return bounceOffWall(spell, (Wall)collidable);
		}
		
		if(collidable instanceof EnergyShield){
			
		}
		
		//if(collidable instanceof Reflect)
		
		return null;
	}
	
//	protected Vector2 bounceOffShield(Shield shield) {
//		float shieldMaxX = shield.getX() + shield.getWidth();
//		float difference = shieldMaxX - getX();
//		float pct = (100 * difference) / shield.getWidth();
//		// Gdx.app.log("Bounce Difference", difference + "");
//		// Gdx.app.log("BouncePct", pct + "");
//
//		_bounceAngle = ((pct * 1.4f) + 20f);// * -1f;
//		
//		Vector2 reflectionAngle = getVelocity().cpy();
//		Vector2 wallVector = shield.getPosition().cpy().rotate90(0);
//		
//		float dot = reflectionAngle.dot(wallVector);
//		dot *= -2.0f;
//		wallVector.scl(dot);
//		wallVector.add(reflectionAngle);
//
//		reflectionAngle.set(wallVector).nor().setAngle(_bounceAngle);
//
//		return reflectionAngle;
//	}

	
	protected Vector2 bounceOffEnemy(Enemy enemy) {
		Vector2 reflectionAngle = getVelocity().cpy();
		Vector2 enemyVector = enemy.getPosition().cpy().rotate90(0);
		
		float dot = reflectionAngle.dot(enemyVector);
		dot *= -2.0f;
		enemyVector.scl(dot);
		enemyVector.add(reflectionAngle);

		reflectionAngle.set(enemyVector).nor();
		
		return reflectionAngle;
	}

	protected Vector2 bounceOffWall(Spell spell, Wall wall) {
		Vector2 reflectionAngle = getVelocity().cpy();
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

	
	protected Vector2 bounceOffHero(Hero hero) {
		float heroMaxX = hero.getX() + hero.getWidth();
		float difference = heroMaxX - getX();
		float pct = (100 * difference) / hero.getWidth();
		// Gdx.app.log("Bounce Difference", difference + "");
		// Gdx.app.log("BouncePct", pct + "");

		_bounceAngle = ((pct * 1.4f) + 20f);// * -1f;
		
		Vector2 reflectionAngle = hero.getVelocity().cpy();
		Vector2 wallVector = hero.getPosition().cpy().rotate90(0);
		
		float dot = reflectionAngle.dot(wallVector);
		dot *= -2.0f;
		wallVector.scl(dot);
		wallVector.add(reflectionAngle);

		reflectionAngle.set(wallVector).nor().setAngle(_bounceAngle);

		return reflectionAngle;

	}

	public double getSpeed() {
		return _speed;
	}

	
}