package com.nni.gamevate.perlerwizard.object.hero;

public class HeroSprite {
	
	private int _currentNode;
	
	private float _x, _y, _width, _height;
	
	public HeroSprite(float x, float y, float width, float height) {
		_x = x;
		_y = y;
		_width = width;
		_height = height;
	}
	
	public float getX() {
		return _x;
	}

	public float getY() {
		return _y;
	}

	public float getWidth() {
		return _width;
	}

	public float getHeight() {
		return _height;
	}
	
	public void changeNode(int node){
		_currentNode = node;
	}
	
	public int getNode(){
		return _currentNode;
	}

}
