package com.nni.gamevate.perlerwizard.utils;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.nni.gamevate.perlerwizard.controllers.GamePlayController;

/**
 * 
 * @author Marcus Garmon 12/29/2016
 *
 */
public class GamePlayInputHandler {

	private GamePlayController _world;
	private Vector3 _touchCords;
	private OrthographicCamera _camera;

	private InputAdapter _skillBarProcessor;
	private InputAdapter _analogProcessor;

	public GamePlayInputHandler(GamePlayController world, OrthographicCamera camera) {
		_world = world;
		_touchCords = new Vector3();
		_camera = camera;

		initSkillBarProcessor();
		initAnalogProcessor();
	}

	public InputAdapter getSkillBarProcessor() {
		return _skillBarProcessor;
	}

	public InputAdapter getAnalogProcessor() {
		return _analogProcessor;
	}

	private void initSkillBarProcessor() {
		_skillBarProcessor = new InputAdapter() {
			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {

				_touchCords.set(screenX, screenY, 0);
				_camera.unproject(_touchCords);

				if (_touchCords.x >= _world.getLeftWall().getX()
						&& _touchCords.x <= _world.getRightWall().getX()
						&& _touchCords.y >= 0
						&& _touchCords.y <= _world.getUpperWall().getY()) {

					_world.castSpell();
					return true;
				}

				if(_touchCords.x >= _world.getTopArrow().getX() - _world.getTopArrow().getWidth()
						&& _touchCords.x <= _world.getTopArrow().getX() + _world.getTopArrow().getWidth()
						&& _touchCords.y <= _world.getTopArrow().getY()
						&& _touchCords.y >= _world.getTopArrow().getY() - _world.getTopArrow().getHeight()){
					
					_world.getColorSelector().rotateUp();
					return true;
				}
				
				if(_touchCords.x >= _world.getBottomArrow().getX() - _world.getTopArrow().getWidth()
						&& _touchCords.x <= _world.getBottomArrow().getX() + _world.getTopArrow().getWidth()
						&& _touchCords.y >= _world.getBottomArrow().getY()
						&& _touchCords.y <= _world.getBottomArrow().getY() + _world.getTopArrow().getHeight()){
					
					_world.getColorSelector().rotateDown();
					return true;
				}
				
				
				if(_touchCords.x >= _world.getLeftArrow().getX()
						&& _touchCords.x <= _world.getLeftArrow().getX() + _world.getLeftArrow().getWidth()
						&& _touchCords.y <= _world.getLeftArrow().getY() + _world.getLeftArrow().getHeight()
						&& _touchCords.y >= _world.getLeftArrow().getY() - _world.getLeftArrow().getHeight()){
					
					_world.getShapeSelector().rotateLeft();
					return true;
				}
				
				if(_touchCords.x <= _world.getRightArrow().getX()
						&& _touchCords.x >= _world.getRightArrow().getX() - _world.getRightArrow().getWidth()
						&& _touchCords.y >= _world.getRightArrow().getY() - _world.getRightArrow().getHeight()
						&& _touchCords.y <= _world.getRightArrow().getY() + _world.getRightArrow().getHeight()){
					
					_world.getShapeSelector().rotateRight();
					return true;
				}

				return false;
			}
		};
	}

	private void initAnalogProcessor() {
		_analogProcessor = new InputAdapter() {
			
			
			
		};
	}
}
