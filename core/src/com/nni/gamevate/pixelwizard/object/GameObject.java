package com.nni.gamevate.pixelwizard.object;

import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {

	protected int _width;
	protected int _height;
	protected Vector2 _position;
	
	public GameObject(int width, int height, float x, float y){
		_width = width;
		_height = height;
		_position = new Vector2(x, y);
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

	public int getHeight() {
		return _height;
	}

	public int getWidth() {
		return _width;
	}
}
