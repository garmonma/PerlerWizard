package com.nni.gamevate.pixelwizard.utils;

import com.badlogic.gdx.InputProcessor;
import com.nni.gamevate.pixelwizard.world.GameWorld;

public class InputHandler implements InputProcessor {

	private boolean _dragging;
	private boolean _moveLeft;
	private boolean _moveRight;
	private GameWorld _world;


	public InputHandler(GameWorld world){
		_world = world;
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
		_world.castSpell();

		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		if(!_dragging) return false;
		
		if(pointer == 1){
			
		}

		return true;
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
