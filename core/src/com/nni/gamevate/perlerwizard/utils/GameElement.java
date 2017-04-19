package com.nni.gamevate.perlerwizard.utils;

public abstract class GameElement {
	
	protected float _x;
	protected float _y;
	
	protected float _width;
	protected float _height;
	
	protected int _type;

	public GameElement(float x, float y, int type) {
		_x = x;
		_y = y;
		_type = type;
	}
	
	public void setWidth(float width){
		_width = width;
	}
	
	public void setHeight(float height){
		_height = height;
	}
	
	public float getX(){
		return _x;
	}
	
	public float getY(){
		return _y;
	}

	public float getWidth() {
		return _width;
	}

	public float getHeight() {
		return _height;
	}
	
	public int getType(){
		return _type;
	}

	@Override
	public String toString() {
		return String.format("GameElement [_x=%s, _y=%s, _width=%s, _height=%s, _type=%s]", _x, _y, _width, _height,
				_type);
	}
	
	
	
}