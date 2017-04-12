package com.nni.gamevate.perlerwizard.object.enemies;

import com.badlogic.gdx.math.Vector2;
import com.nni.gamevate.perlerwizard.events.Event;
import com.nni.gamevate.perlerwizard.events.Event.EventType;
import com.nni.gamevate.perlerwizard.events.EventManager;
import com.nni.gamevate.perlerwizard.object.Attacker;
import com.nni.gamevate.perlerwizard.object.Collidable;
import com.nni.gamevate.perlerwizard.object.GameObject;
import com.nni.gamevate.perlerwizard.utils.Logger;
import com.nni.gamevate.perlerwizard.waves.Level;

/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public abstract class Enemy extends GameObject implements Attacker{
	
	
	protected int _health = 1;
	protected float _chaseSpeed = 1;
	protected float _retreatSpeed = 3;
	
	
	protected boolean _castingSpecial;
	protected boolean _castingAttack;
	
	protected boolean cycleCompleted = false;
	
	
	protected boolean sleeping = true;
	protected boolean running = false;
	protected boolean chasing = false;
	
	public int _waveNumber = 0;
	
	public Enemy(float width, float height, float x, float y,int waveNumber) {
		super(width, height, x, y);
		_waveNumber = waveNumber;
		
		
	}

	public  boolean isDead(int damage){
		//TODO Uncomment
//		Event e = new Event(EventType.ENEMY_ATTACKED,_waveNumber + "");		
//		EventManager.publish(EventType.ENEMY_ATTACKED, e);
		_health = _health - damage;
		
		if(_health <= 0){
			alive = false;
			return true;
		} 
		
		return false;
	};
	
	public void move(float delta){
		
			float speed =0;
			if(chasing == true){
				speed = _chaseSpeed;				
			}else if( running == true){
				speed = _retreatSpeed;
			}
		if(sleeping == false){
			_position.x += world.lastCamDelta;
		}
			
			
		//_position.x += speed  * delta * _direction.x;
		//_position.y += speed  * delta * _direction.y;
		
		if(_waveNumber == 1 && _position.x > Level.wave2Start - 3){
			Event e = new Event(EventType.JOINED_GROUP,1+"");			
			EventManager.publish(e._type,e );
		}else if(_waveNumber == 2 && _position.x > Level.wave3Start - 3){
			Event e = new Event(EventType.JOINED_GROUP,2+"");			
			EventManager.publish(e._type,e );
		}
	}
	
 
	public int getHealth(){
		return _health;
	}
	
	
	
	@Override
	public void castingSpecial(boolean casting) {
		_castingSpecial = casting;
		
	}
	
	@Override
	public void castingAttack(boolean casting) {
		_castingAttack = casting;
		
	}

	@Override
	public boolean isCastingSpecial() {
		return _castingSpecial;
	}

	@Override
	public boolean isCastingAttack() {
		// TODO Auto-generated method stub
		return _castingAttack;
	}
	
	@Override
	public void update(float delta) {
		if(sleeping == true)
			return;
		//Logger.log("Update");
		if(chasing == true){
			_direction.set(new Vector2(-1,0));
		}else if(running == true){
			_direction.set(new Vector2(1, 0));
			//Logger.log("Runing");
		}
		
		move(delta);
		
	}
	
	@Override
	public boolean collided(Collidable object) {		
		return super.collided(object);
		
	}

	public boolean isSleeping() {
		return sleeping;
	}

	public void setSleeping(boolean sleeping) {
		this.sleeping = sleeping;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public boolean isChasing() {
		return chasing;
	}
	public float getSpeed(){
		return _chaseSpeed;
	}

	public void setChasing(boolean chasing) {
		this.chasing = chasing;
	}
	
	
}