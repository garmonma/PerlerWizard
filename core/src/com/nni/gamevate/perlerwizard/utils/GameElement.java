package com.nni.gamevate.perlerwizard.utils;

public abstract class GameElement {
	
	protected float x;
	protected float y;
	
	protected float width;
	protected float height;
	
	protected int type;

	public GameElement(float x, float y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	public void setWidth(float width){
		this.width = width;
	}
	
	public void setHeight(float height){
		this.height = height;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}
	
	public int getType(){
		return type;
	}

	@Override
	public String toString() {
		return String.format("GameElement [_x=%s, _y=%s, _width=%s, _height=%s, _type=%s]", x, y, width, height,
				type);
	}
	
	
	
}