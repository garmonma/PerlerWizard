package com.nni.gamevate.perlerwizard.object.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.nni.gamevate.perlerwizard.events.Event;
import com.nni.gamevate.perlerwizard.events.Event.EventType;
import com.nni.gamevate.perlerwizard.events.EventManager;
import com.nni.gamevate.perlerwizard.object.Attacker;
import com.nni.gamevate.perlerwizard.object.Collidable;
import com.nni.gamevate.perlerwizard.object.GameObject;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.object.skills.Skills;
import com.nni.gamevate.perlerwizard.object.skills.Wand;
import com.nni.gamevate.perlerwizard.object.skills.throwables.RockThrow;
import com.nni.gamevate.perlerwizard.screens.game.WaveGameScreen;
import com.nni.gamevate.perlerwizard.utils.Logger;
import com.nni.gamevate.perlerwizard.waves.Level;

/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public abstract class Enemy extends GameObject implements Attacker{
	
	public enum ElementType{
		DEFAULT, WATER, FIRE, LIGHTNING, FOREST
	}
	
	public enum State{
		IDLE, ATTACKING, MOVING
	}
	
	public State state = State.IDLE;
	
	protected int _health = 1;
	protected ElementType _elementType = ElementType.DEFAULT;
	protected float _chaseSpeed = 1;
	protected float _retreatSpeed = 3;
	
	
	protected boolean _castingSpecial;
	protected boolean _castingAttack;
    protected boolean cycleCompleted = false;	
	
	protected boolean sleeping = true;
	protected boolean running = false;
	protected boolean chasing = false;
	
	protected Animation attackAnimation, idleAnimation;
	
	public int _waveNumber = 0;
	
	public Vector2  formationPosition;
	public Wand basicWand;
	
	public Enemy(float width, float height, float x, float y,int waveNumber) {
		super(width, height, x, y);
		_waveNumber = waveNumber;
		basicWand  = new Wand(Skills.BASIC_ENEMY_SPELL.getType(), Skills.BASIC_ENEMY_SPELL.getRefreshTime());
		formationPosition = new Vector2(position);
		
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
			formationPosition.x += world.lastCamDelta;
		}
		
		
		//TODO fix wave logic
		if(_waveNumber == 1 && formationPosition.x > Level.wave2Start - 3){
			Event e = new Event(EventType.JOINED_GROUP,1+"");			
			EventManager.publish(e._type,e );
		}else if(_waveNumber == 2 && formationPosition.x > Level.wave3Start - 3){
			Event e = new Event(EventType.JOINED_GROUP,2+"");			
			EventManager.publish(e._type,e );
		}
		
		
		uniquePattern(delta);
	}
	
	protected abstract void uniquePattern(float delta);
	
	public int getHealth(){
		return _health;
	}
	
	@Override
	public void draw(Batch batch) {
		super.draw(batch);
	
		stateTime += Gdx.graphics.getDeltaTime(); 
		TextureRegion currentFrame = null;
	
		if(state == State.IDLE){
			currentFrame = idleAnimation.getKeyFrame(stateTime, true);	
		} else if(state == State.ATTACKING){
			currentFrame = attackAnimation.getKeyFrame(stateTime, true);
	}
	
		batch.draw(currentFrame, getX(), getY(), getWidth(), getHeight());
		
		state = State.IDLE;
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
	public void draw(ShapeRenderer shapeRenderer) {
		shapeRenderer.setColor(getColor());
		shapeRenderer.rect(position.x,position.y, getWidth(), getHeight());
	}
	
	@Override
	public void update(float delta) {
		if(sleeping == true)
			return;
		
		if(chasing == true){
			direction.set(new Vector2(-1,0));
		}else if(running == true){
			direction.set(new Vector2(1, 0));
		
		}
		
		move(delta);
		
		WaveGameScreen._world.addEnemySkill(attack());
	}
	
	@Override
	public boolean collided(Collidable object) {		
		return super.collided(object);
		
	}

	public void setHealth(int health){
		_health = health;
	}
 
	
	public void setElementType(ElementType type){
		_elementType = type;
	}
	
	public ElementType getElementType(){
		return _elementType;
	}

	public boolean isSleeping() {
		return sleeping;
	}

	public void setSleeping(boolean sleeping) {
		if(sleeping == false){			
			basicWand.setInitialCooldown(.5f);
			//Logger.log("No longer sleeping");
		}
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
	
	public Skill attack(){		
		state = State.ATTACKING;
		return basicWand.fire(position.x + width/2, position.y + height /2);
	}
}