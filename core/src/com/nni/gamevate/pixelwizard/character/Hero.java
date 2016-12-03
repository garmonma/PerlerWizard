package com.nni.gamevate.pixelwizard.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class Hero {
	private Vector2 _position;

	private int _width;
	private int _height;

	public Hero(float x, float y, int width, int height) {
		_width = width;
		_height = height;
		_position = new Vector2(x, y);

	}

	public void update(float delta) {
		
		onKeyPress();
		if (_position.x < 150)
			_position.x = 150;

		if (_position.x > 650 - 64)
			_position.x = 650 - 64;
	}

	public void onKeyPress() {
		if (Gdx.input.isKeyPressed(Keys.LEFT))
			_position.x -= 200 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Keys.RIGHT))
			_position.x += 200 * Gdx.graphics.getDeltaTime();
	}
	
	public void onClick(){
		
	}

	public boolean isCasting() {
		return true;
	}

	public float getX() {
		return _position.x;
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
