package com.nni.gamevate.pixelwizard.object.enemies;

import com.badlogic.gdx.math.Rectangle;
import com.nni.gamevate.pixelwizard.object.Collidable;
import com.nni.gamevate.pixelwizard.object.GameObject;

public class Enemy extends GameObject{
	
	
	public enum EnemyType{
		GoblinInitiate(3, 1.0),
		MountedLance(12, 1.5),
		Dragon(25, 2.5);
		
		private final double health;
		private final double attackSpeed;
		
		EnemyType(double health, double attackSpeed){
			this.health = health;
			this.attackSpeed = attackSpeed;
		}
		
		public double getHealth(){
			return health;
		}
		
		public double getAttackSpeed(){
			return attackSpeed;
		}
	}
	
	private Rectangle _collisionBounds;
	private EnemyType _type;
	private double _health;
	private double _attackSpeed;
	
	public Enemy(int width, int height, float x, float y, EnemyType type) {
		super(width, height, x, y);
		_collisionBounds = new Rectangle();
		_type = type;
		_health = type.getHealth();
		_attackSpeed = type.getAttackSpeed();
	}

	public void attack(){
		switch(_type){
		case GoblinInitiate:
			break;
		case MountedLance:
			forwardCharge();
			break;
		case Dragon:
			break;
		}
	

	};
	
	private void forwardCharge(){
		
	}
	
	public void despawn(){
		
	};
	
	public void spawn(){
		
	};
	
	public double getHealth(){
		return _health;
	}
	
	public boolean dead(double damage){
		_health = _health - damage;
		
		if(_health <= 0){
			return true;
		}
		
		return false;
	}
	
	public double getAttackSpeed(){
		return _attackSpeed;
	}

	@Override
	public void update(float delta) {
		_collisionBounds.set(getX(), getY(), getWidth(), getHeight());
		
	}
	
	public Rectangle getCollisionBounds(){
		return _collisionBounds;
	}

	@Override
	public boolean collided(Collidable object) {
		// TODO Auto-generated method stub
		return false;
	}
}