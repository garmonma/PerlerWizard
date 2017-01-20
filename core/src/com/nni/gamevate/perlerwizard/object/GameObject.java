package com.nni.gamevate.perlerwizard.object;

import com.badlogic.gdx.math.Vector2;


/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public abstract class GameObject implements Collidable {

	protected float _width;
	protected float _height;
	protected Vector2 _position;
	protected Vector2 _direction;
	protected Vector2 _velocity;
	protected Vector2 _movement;
	
	public GameObject(float width, float height, float x, float y){
		_width = width;
		_height = height;
		_position = new Vector2(x, y);
		_direction = new Vector2();
		_velocity = new Vector2();
		_movement = new Vector2();
	}
	
	
	public abstract void update(float delta);
	
	public float getX() {
		return _position.x;
	}
	
	public void setX(float x){
		_position.x = x;
	}

	public float getY() {
		return _position.y;
	}

	public float getHeight() {
		return _height;
	}

	public float getWidth() {
		return _width;
	}
	
	public Vector2 getVelocity(){
		return _velocity;
	}
	
	public Vector2 getPosition(){
		return _position;
	}
}
