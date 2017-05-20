package com.nni.gamevate.perlerwizard.object.hero;

public class HeroSprite {
	
	private int currentNode;
	
	private float x, y, width, height;
	
	public HeroSprite(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}
	
	public void changeNode(int node){
		currentNode = node;
	}
	
	public int getNode(){
		return currentNode;
	}

}
