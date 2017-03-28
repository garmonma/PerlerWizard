package com.nni.gamevate.perlerwizard.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class WaveInputHandler extends InputAdapter {
	private static final String tag = WaveInputHandler.class.getSimpleName();
	
	private Vector3 _touchCords;
	private OrthographicCamera _camera;

	public boolean up;
	public boolean down;
	public boolean right;
	public boolean left;
	public boolean fire;

	public WaveInputHandler(OrthographicCamera camera) {
		
		_touchCords = new Vector3();
		_camera = camera;

		
	}

	public void tick(float delta){
		up = Gdx.input.isKeyPressed(Input.Keys.UP);
		down = Gdx.input.isKeyPressed(Input.Keys.DOWN);
		left = Gdx.input.isKeyPressed(Input.Keys.LEFT);
		right = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
		
		fire = Gdx.input.isKeyPressed(Input.Keys.SPACE);
	}
	
	
	
	@Override
	public boolean keyDown(int keyCode){
		Gdx.app.log(tag, "KeyDown: " + keyCode);
				return true;
	}
}
