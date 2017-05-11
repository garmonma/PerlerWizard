package com.nni.gamevate.perlerwizard.object.skills;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.nni.gamevate.perlerwizard.object.Collidable;
import com.nni.gamevate.perlerwizard.object.GameObject;
import com.nni.gamevate.perlerwizard.object.SoundType;

public abstract class Skill extends GameObject {
	protected static final float BASE_SPEED = 5f;
	
	protected int damage;
	protected float speed;
	protected float castAngle;
	
	protected Sound castSound;
	protected Sound hitSound;
	
	protected Animation castAnimation;
	
	public Skill(float x, float y){
		super(x, y);
		
		speed = BASE_SPEED;
	}
	
	public Skill(float width, float height, float x, float y) {
		super(width, height, x, y);
		
		speed = BASE_SPEED;
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
		direction.set(position).setAngle(castAngle).nor();
		velocity.set(direction).scl(speed);
		movement.set(velocity).scl(delta);
		position.add(movement);		
	}
	
	@Override
	public void sound(SoundType st) {
		if(castSound == null || hitSound == null){
			return;
		}
		
		if(st == SoundType.SKILL_CAST){
			castSound.play(1.0f);	
		}
		
		if(st == SoundType.SKILL_HIT){
			hitSound.play(1.0f);
		}
	}
	
	@Override
	public void draw(Batch batch) {
		super.draw(batch);
		
		stateTime += Gdx.graphics.getDeltaTime(); 
		TextureRegion currentFrame = null;

		if(castAnimation != null){
		    currentFrame = castAnimation.getKeyFrame(stateTime, true);
			batch.draw(currentFrame, getX(), getY(), getWidth(), getHeight());	
		}
	}
	
	public int getDamage(){
		return damage;
	}

	public float getStartX() {
		return originalPosition.x;		
	}
	
	public float getCastAngle(){
		return castAngle;
	}
	
	public void setCastAngle(float angle){
		castAngle = angle;
	}

}