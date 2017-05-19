package com.nni.gamevate.perlerwizard.object;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;


/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public abstract class GameObject implements Collidable, Drawable, Soundable {
	
	protected World world;
	
	public static final String tag = GameObject.class.getSimpleName();
	protected float width;
	protected float height;
	protected Vector2 position;
	protected Vector2 direction;
	protected Vector2 velocity;
	protected Vector2 movement;
	
	protected boolean alive = true;
	protected Vector2 originalPosition;
	
	// Temp var untill we get sprites
	protected Color color = Color.PURPLE;
	 
	protected float stateTime;
	
	
	public GameObject(float x, float y){
		position = new Vector2(x, y);
		direction = new Vector2();
		velocity = new Vector2();
		movement = new Vector2();
		originalPosition = new Vector2(position);
		stateTime = 0f;
		
	}
	
	public GameObject(float width, float height, float x, float y){
		this.width = width;
		this.height = height;
		position = new Vector2(x, y);
		direction = new Vector2();
		velocity = new Vector2();
		movement = new Vector2();
		originalPosition = new Vector2(position);
		stateTime = 0f;
	}
	
	//doing this here assumes everything is a box
	@Override
	public boolean collided(Collidable object) {
		
		GameObject other = (GameObject) object;
		if(getX() < other.getX() + other.getWidth() &&
				getX() + getWidth() > other.getX() &&
				getY() < other.getY() + other.getHeight() &&
				getY() + getHeight()  > other.getY()){
		
			return true;			
		}
		
		return false;
	}
	
	public abstract void update(float delta);
	
	
	public float getX() {
		return position.x;
	}
	
	public void setX(float x){
		position.x = x;
	}

	public float getY() {
		return position.y;
	}
	
	public void setY(float y){
		position.y = 9;
	}

	public float getHeight() {
		return height;
	}

	public float getWidth() {
		return width;
	}
	
	public Vector2 getVelocity(){
		return velocity;
	}
	
	public Vector2 getPosition(){
		return position;
	}
	
	public void setPosition(Vector2 newPosition){
		position.set(newPosition);
	}
	
	@Override
	public void draw(Batch batch) {
		//batch.draw(_wizard, getX(), getY(), getWidth(), getHeight());		
	}
	
	@Override
	public void draw(ShapeRenderer shapeRenderer) {
		// TODO Auto-generated method stub
		shapeRenderer.setColor(getColor());
		shapeRenderer.rect(getX(), getY(), getWidth(), getHeight());
		
	}
	
	@Override
	public void sound(SoundType st){
		
	}
	
	@Override
	public Color getColor() {
		return color;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public World getWorld() {
		return world;
	}


	public void setWorld(World world) {
		this.world = world;
	}
	
	@Override
	public String toString() {
		return String.format(
				"GameObject [_width=%s, _height=%s, _position=%s, _direction=%s, _velocity=%s, _movement=%s]", width,
				height, position, direction, velocity, movement);
	}
}