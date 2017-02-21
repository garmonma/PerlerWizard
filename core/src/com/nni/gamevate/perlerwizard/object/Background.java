package com.nni.gamevate.perlerwizard.object;

public class Background {

	private int _x;
	private int _y;
	private int _width;
	private int _height;
	
	public Background(){
		
	}
	
	public void setPosition(int x, int y){
		_x = x;
		_y = y;
	}
	
	public void setDimensions(int width, int height){
		_width = width;
		_height = height;
	}
	
	public int getX(){
		return _x;
	}
	
	public int getY(){
		return _y;
	}
	
	public int getWidth(){
		return _width;
	}
	
	public int getHeight(){
		return _height;
	}
}
