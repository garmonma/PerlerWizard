package com.nni.gamevate.perlerwizard.object.hero;

import java.util.Set;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.object.Attacker;
import com.nni.gamevate.perlerwizard.object.Equiper;
import com.nni.gamevate.perlerwizard.object.GameObject;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.object.skills.SkillManager;
import com.nni.gamevate.perlerwizard.object.skills.Skills;
import com.nni.gamevate.perlerwizard.utils.Logger;

/**
 * 
 * @author Marcus Garmon 11/27/2016
 *
 */
public abstract class Hero extends GameObject implements Attacker, Equiper{
	
	protected final float MAX_SPEED_MULTIPLIER = 1.25f;
	protected final float MAX_SPEED = 10.0f;

	protected float _speed;

	protected int maxHealth;
	protected float currentHealth;
	
	protected float _healthMultiplier;
	protected float _speedMultiplier;

	protected int _level;
	
	protected boolean _castingSpecial;
	protected boolean _castingAttack;
	
	
	protected SkillManager skillManager;
	
	
	
	
	public Hero(int width, int height, float x, float y, int level) {
		super(width, height, x, y);
		skillManager = new SkillManager();
		_healthMultiplier = 1.0f;
		_speedMultiplier = 1.0f;
		currentHealth = 5;

		_level = level;
		color = Color.BROWN;
	}
	

	


	@Override
	public void update(float delta) {
		position.x += _speed  * delta * direction.x;
		position.y += _speed  * delta * direction.y;
		
		position.y = MathUtils.clamp(position.y, 0, GameConfig.WORLD_HEIGHT - height);
		position.x = MathUtils.clamp(position.x, world.camXPos - GameConfig.WORLD_WIDTH/2, world.forwardLine);
		
	}

	
	
	@Deprecated
	public abstract Skill attack(int selectedSkill);
	
	public  Skill attack(Skills skill){
		return skillManager.useSkill(skill, position.x + width/2, position.y + height /2);
	}

	private void move() {
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.getAccelerometerY() < 0) {
			position.x -= _speed * _speedMultiplier * Gdx.graphics.getDeltaTime();
		}

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.getAccelerometerY() > 0)
			position.x += _speed * _speedMultiplier * Gdx.graphics.getDeltaTime();

	}

	public boolean isCasting() {
		return true;
	}
	
	public void setHealthMultiplier(float healthMultiplier) {
		_healthMultiplier = healthMultiplier;
	}

	public void setSpeedMultiplier(float speedMultiplier) {
		_speedMultiplier = speedMultiplier;
		
		if(_speedMultiplier > MAX_SPEED_MULTIPLIER){
			_speedMultiplier = MAX_SPEED_MULTIPLIER;
		}
		
		setSpeed(_speed, _speedMultiplier);
	}

	public void setLevel(int level) {
		_level = level;
	}
		
	
	public void setSpeed(float speed){
		setSpeed(speed, _speedMultiplier);
	}
	
	public void setSpeed(float speed, float speedMultiplier){
		_speed = speed * speedMultiplier;
		
		if(_speed > MAX_SPEED){
			_speed = MAX_SPEED;
		}
	}
	public void setDirection(Vector2 direction){
		this.direction = direction;
	}

	
	public void damage(float damage){
		currentHealth -= damage;
		
		Logger.log("Current Health: " +currentHealth);
		if(currentHealth <= 0)
			alive = false;		
	}
	
	public void castingSpecial(boolean casting){
		_castingSpecial = false;
	}
	
	public void castingAttack(boolean casting){
		_castingAttack = false;
	}
	
	public float getCurrentHealthPct(){
		return currentHealth;
	}
	
	
	public float getSpeed(){
		return _speed;
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
	public void SelectSkill(int ammount){
		Set<Skills> skills = skillManager.getSkills();
		Skills[] array = new Skills[skills.size()];
		array = skills.toArray(array);
	}
	

	public SkillManager getSkillManager() {
		return skillManager;
	}

	@Override
	public String toString() {
		return String.format(
				"Hero [MAX_SPEED_MULTIPLIER=%s, MAX_SPEED=%s, _speed=%s, _hitPoints=%s, _defense=%s, _attack=%s, _dodge=%s, _currentHealthPct=%s, _healthMultiplier=%s, _speedMultiplier=%s, _level=%s]",
				MAX_SPEED_MULTIPLIER, MAX_SPEED, _speed, maxHealth, 0 ,0 ,0 , currentHealth,
				_healthMultiplier, _speedMultiplier, _level);
	}

	

}