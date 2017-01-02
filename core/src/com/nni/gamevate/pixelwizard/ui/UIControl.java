package com.nni.gamevate.pixelwizard.ui;
/**
 * 
 * @author Marcus Garmon
 * @date Jan 1, 2017
 */
public class UIControl {

	private int _x;
	private int _y;
	private int _width;
	private int _height;

	public UIControl(int x, int y, int width, int height) {
		_x = x;
		_y = y;
		_width = width;
		_height = height;
	}
	
	
	public int getX() {
		return _x;
	}

	public int getY() {
		return _y;
	}

	public int getWidth() {
		return _width;
	}

	public int getHeight() {
		return _height;
	}
}