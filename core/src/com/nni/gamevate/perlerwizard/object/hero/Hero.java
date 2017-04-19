package com.nni.gamevate.perlerwizard.object.hero;

import java.util.Set;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.object.Attacker;
import com.nni.gamevate.perlerwizard.object.Collidable;
import com.nni.gamevate.perlerwizard.object.Equiper;
import com.nni.gamevate.perlerwizard.object.GameObject;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.object.skills.SkillManager;
import com.nni.gamevate.perlerwizard.object.skills.Skills;

/**
 * 
 * @author Marcus Garmon 11/27/2016
 *
 */
public abstract class Hero extends GameObject implements Attacker, Equiper{
	
	
	protected final float MAX_SPEED_MULTIPLIER = 1.25f;
	protected final float MAX_SPEED = 10.0f;

	protected float _speed;
	protected int _hitPoints;
	protected int _defense;
	protected int _attack;
	protected float _dodge;
	
	protected float _currentHealthPct;

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

		_level = level;
		color = Color.BROWN;
	}
	

	


	@Override
	public void update(float delta) {
		_position.x += _speed  * delta * _direction.x;
		_position.y += _speed  * delta * _direction.y;
		
		_position.y = MathUtils.clamp(_position.y, 0, GameConfig.WORLD_HEIGHT - _height);
		_position.x = MathUtils.clamp(_position.x, world.camXPos - GameConfig.WORLD_WIDTH/2, world.forwardLine);
		
	}

	@Override
	public boolean collided(Collidable object) {
		return false;
	}
	
	@Deprecated
	public abstract Skill attack(int selectedSkill);
	
	public  Skill attack(Skills skill){
		return skillManager.useSkill(skill, _position.x + _width/2, _position.y + _height /2);
	}

	private void move() {
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.getAccelerometerY() < 0) {
			_position.x -= _speed * _speedMultiplier * Gdx.graphics.getDeltaTime();
		}

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.getAccelerometerY() > 0)
			_position.x += _speed * _speedMultiplier * Gdx.graphics.getDeltaTime();

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
	
	public void setDodge(float dodge){
		_dodge = dodge;
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
		_direction = direction;
	}
	
	public void setAttack(int attack){
		_attack = attack;
	}
	
	public void setDefense(int defense){
		_defense = defense;
	}
	
	public void setCurrentHealthPct(float healthPct){
		_currentHealthPct = healthPct;
	}
	
	public void castingSpecial(boolean casting){
		_castingSpecial = false;
	}
	
	public void castingAttack(boolean casting){
		_castingAttack = false;
	}
	
	public int getHitPoints(){
		return _hitPoints;
	}
	
	public float getCurrentHealthPct(){
		return _currentHealthPct;
	}
	
	public int getDefense(){
		return _defense;
	}
	
	public int getAttack(){
		return _attack;
	}
	
	public float getSpeed(){
		return _speed;
	}
	
	public float getDodge(){
		return _dodge;
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
				MAX_SPEED_MULTIPLIER, MAX_SPEED, _speed, _hitPoints, _defense, _attack, _dodge, _currentHealthPct,
				_healthMultiplier, _speedMultiplier, _level);
	}

	

}