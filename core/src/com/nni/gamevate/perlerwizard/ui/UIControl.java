package com.nni.gamevate.perlerwizard.ui;
/**
 * 
 * @author Marcus Garmon
 * @date Jan 1, 2017
 */
public class UIControl {

	private float _x;
	private float _y;
	private float _width;
	private float _height;

	public UIControl(float x, float y, float width, float height) {
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
}