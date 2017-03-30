package com.nni.gamevate.perlerwizard.object;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;


/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public abstract class GameObject implements Collidable, Drawable {

	protected float _width;
	protected float _height;
	protected Vector2 _position;
	protected Vector2 _direction;
	protected Vector2 _velocity;
	protected Vector2 _movement;
	
	// Temp var untill we get sprites
	protected Color color = Color.PURPLE;
	 
	
	public GameObject(float x, float y){
		_position = new Vector2(x, y);
		_direction = new Vector2();
		_velocity = new Vector2();
		_movement = new Vector2();
	}
	
	public GameObject(float width, float height, float x, float y){
		_width = width;
		_height = height;
		_position = new Vector2(x, y);
		_direction = new Vector2();
		_velocity = new Vector2();
		_movement = new Vector2();
	}
	
	//doing this here assumes everything is a box
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
	
	public void setY(float y){
		_position.y = 9;
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
	
	public void setPosition(Vector2 newPosition){
		_position.set(newPosition);
	}
	
	@Override
	public void draw(Batch batch) {
		// TODO Auto-generated method stub				
	}
	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public String toString() {
		return String.format(
				"GameObject [_width=%s, _height=%s, _position=%s, _direction=%s, _velocity=%s, _movement=%s]", _width,
				_height, _position, _direction, _velocity, _movement);
	}
	
	
}
