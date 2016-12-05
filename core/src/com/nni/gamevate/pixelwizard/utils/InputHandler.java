package com.nni.gamevate.pixelwizard.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.nni.gamevate.pixelwizard.world.GameWorld;

public class InputHandler implements InputProcessor {

	private boolean _dragging;
	private GameWorld _world;
	private Vector3 _touchCords;
	private OrthographicCamera _camera;


	public InputHandler(GameWorld world, OrthographicCamera camera){
		_world = world;
		_dragging = false;
		_touchCords = new Vector3();
		_camera = camera;
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		_touchCords.set(screenX, screenY, 0);
		_camera.unproject(_touchCords);

		if(_touchCords.x > 54 && _touchCords.x < 88
				&& _touchCords.y > 20 && _touchCords.y < 70){
			if( _world.getSpells().size <= 8)
				_world.castSpell();
	
			return true;
		}

		// TODO dragging shapes
		if(true){
			_dragging = true;
			return true;
		}

		// TODO dragging colors
		if(true){
			_dragging = true;
			return true;
		}

		// TODO dragging analog
		if(true){
			_dragging = true;
			return true;
		}

		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		_dragging = false;
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		
		_touchCords.set(screenX, screenY, 0);
		_camera.unproject(_touchCords);
		
		if(!_dragging)
			return false;

		// TODO dragging color
		if(true){
			return true;
		} else if(true) {
			return true;
		}

		// TODO dragging shape
		if(true){
			return true;
		} else if(true) {
			return true;
		}

		// TODO dragging analog
		if(true){
			return true;
		} else if(true) {
			return true;
		}

		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
