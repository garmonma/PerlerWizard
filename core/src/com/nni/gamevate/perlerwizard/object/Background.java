package com.nni.gamevate.perlerwizard.object;

public class Background {

	private int x;
	private int y;
	private int width;
	private int height;
	
	public Background(){
		
	}
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setDimensions(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
}
