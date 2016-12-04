package com.nni.gamevate.pixelwizard.object.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.nni.gamevate.pixelwizard.object.GameObject;

public class Hero extends GameObject {

	public Hero(int width, int height, float x, float y) {
		super(width, height, x, y);

	}

	@Override
	public void update(float delta) {
		
		onKeyPress();
		if (getX() < 150)
			_position.x = 150;

		if (getX() > 650 - 64)
			_position.x = 650 - 64;
	}

	public void onKeyPress() {
		if (Gdx.input.isKeyPressed(Keys.LEFT))
			_position.x -= 200 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Keys.RIGHT))
			_position.x += 200 * Gdx.graphics.getDeltaTime();
		
		if(Gdx.input.getX() == 700 && Gdx.input.getY() == 40){
			_position.x -= 200 * Gdx.graphics.getDeltaTime();
		}
		
		if(Gdx.input.getX() == 800 && Gdx.input.getY() == 40){
			_position.x += 200 * Gdx.graphics.getDeltaTime();
		}
	}
	
	public void onClick(){
		
	}

	public boolean isCasting() {
		return true;
	}
}