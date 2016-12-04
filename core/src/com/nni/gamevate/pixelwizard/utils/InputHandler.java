package com.nni.gamevate.pixelwizard.utils;

import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor {

	private boolean _dragging;
	private boolean _moveLeft;
	private boolean _moveRight;


	public InputHandler(){
		_dragging = false;
		_moveLeft = false;
		_moveRight = false;
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

		if(screenX == 700 && screenY == 40){
			_moveLeft = true;
		}

		if(screenX == 775 && screenY == 40){
			_moveRight = true;
		}

		_dragging = true;

		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		if(!_dragging) return false;

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
