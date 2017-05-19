package com.nni.gamevate.perlerwizard.object.hero;

import java.util.Set;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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

	protected float speed;

	protected int maxHealth;
	protected float currentHealth;
	
	protected float healthMultiplier;
	protected float speedMultiplier;

	protected int level;
	
	protected boolean castingSpecial;
	protected boolean castingAttack;
	
	protected Animation idleAnimation;
	protected Texture texture;
	
	protected SkillManager skillManager;
	
	
	
	
	public Hero(int width, int height, float x, float y, int level) {
		super(width, height, x, y);
		skillManager = new SkillManager();
		healthMultiplier = 1.0f;
		speedMultiplier = 1.0f;
		currentHealth = 5;

		this.level = level;
		color = Color.BROWN;
	}
	

	


	@Override
	public void update(float delta) {
		position.x += speed  * delta * direction.x;
		position.y += speed  * delta * direction.y;
		
		position.y = MathUtils.clamp(position.y, 0, GameConfig.WORLD_HEIGHT - height);
		position.x = MathUtils.clamp(position.x, world.camXPos - GameConfig.WORLD_WIDTH/2, world.forwardLine);
		
	}
	
	@Override
	public void draw(ShapeRenderer shapeRenderer) {
		if(texture == null){			
			shapeRenderer.setColor(getColor());
			shapeRenderer.rect(getX(), getY(), getWidth(), getHeight());
		}
	}

	@Override
	public void draw(Batch batch) {
	
		batch.draw(texture, getX(), getY(), getWidth(), getHeight());
	}
	
	@Deprecated
	public abstract Skill attack(int selectedSkill);
	
	public  Skill attack(Skills skill){
		return skillManager.useSkill(skill, position.x + width/2, position.y + height /2);
	}

	private void move() {
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.getAccelerometerY() < 0) {
			position.x -= speed * speedMultiplier * Gdx.graphics.getDeltaTime();
		}

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.getAccelerometerY() > 0)
			position.x += speed * speedMultiplier * Gdx.graphics.getDeltaTime();

	}

	public boolean isCasting() {
		return true;
	}
	
	public void setHealthMultiplier(float healthMultiplier) {
		this.healthMultiplier = healthMultiplier;
	}

	public void setSpeedMultiplier(float speedMultiplier) {
		this.speedMultiplier = speedMultiplier;
		
		if(this.speedMultiplier > MAX_SPEED_MULTIPLIER){
			this.speedMultiplier = MAX_SPEED_MULTIPLIER;
		}
		
		setSpeed(speed, this.speedMultiplier);
	}

	public void setLevel(int level) {
		this.level = level;
	}
		
	
	public void setSpeed(float speed){
		setSpeed(speed, speedMultiplier);
	}
	
	public void setSpeed(float speed, float speedMultiplier){
		this.speed = speed * speedMultiplier;
		
		if(this.speed > MAX_SPEED){
			this.speed = MAX_SPEED;
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
		castingSpecial = false;
	}
	
	public void castingAttack(boolean casting){
		castingAttack = false;
	}
	
	public float getCurrentHealthPct(){
		return currentHealth;
	}
	
	
	public float getSpeed(){
		return speed;
	}
	

	@Override
	public boolean isCastingSpecial() {
		return castingSpecial;
	}

	@Override
	public boolean isCastingAttack() {		
		return castingAttack;
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
				MAX_SPEED_MULTIPLIER, MAX_SPEED, speed, maxHealth, 0 ,0 ,0 , currentHealth,
				healthMultiplier, speedMultiplier, level);
	}

	

}