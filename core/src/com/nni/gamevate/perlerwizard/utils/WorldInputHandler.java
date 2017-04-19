package com.nni.gamevate.perlerwizard.utils;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.nni.gamevate.perlerwizard.controllers.GamePlayController;
import com.nni.gamevate.perlerwizard.controllers.GameWorldController;

/**
 * 
 * @author Marcus Garmon 12/29/2016
 *
 */
public class WorldInputHandler {

	private GameWorldController _controller;
	private Vector3 _touchCords;
	private OrthographicCamera _camera;
	private OrthographicCamera _hudCamera;

	private InputAdapter _inputAdapter;
	private InputAdapter _hudInputAdapter;

	public WorldInputHandler(GameWorldController controller, OrthographicCamera camera, OrthographicCamera hudCamera) {
		_controller = controller;
		_touchCords = new Vector3();
		_camera = camera;
		_hudCamera = hudCamera;
		
		initWorldAdapter();
		initHudAdapter();

	}
	
	public InputAdapter getWorldAdapter(){
		return _inputAdapter;
	}
	
	public InputAdapter getHudAdapter(){
		return _hudInputAdapter;
	}

	private void initWorldAdapter() {
		_inputAdapter = new InputAdapter() {

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {

				_touchCords.set(screenX, screenY, 0);
				_camera.unproject(_touchCords);

				for (GameElement gameElement : _controller.getMapNodes()) {
					MapNode mapNode;
					
					if(gameElement instanceof MapNode){
						mapNode = (MapNode) gameElement;
					
					
						if (_touchCords.x >= mapNode.getX() 
								&& _touchCords.x <= mapNode.getX() + mapNode.getWidth()
								&& _touchCords.y >= mapNode.getY()
								&& _touchCords.y <= mapNode.getY() + mapNode.getHeight()) {
	
							_controller.selectNode(mapNode);
							_controller.initializedMatch(true);
							
							return true;
						}
					}
				}

				return false;
			}
		};
	}

	private void initHudAdapter(){
		_hudInputAdapter = new InputAdapter(){
			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				
				_touchCords.set(screenX, screenY, 0);
				_hudCamera.unproject(_touchCords);
				
				
				if (_touchCords.x >= _controller.getEquipmentButton().getX() 
						&& _touchCords.x <= _controller.getEquipmentButton().getX() + _controller.getEquipmentButton().getWidth()
						&& _touchCords.y >= _controller.getEquipmentButton().getY() 
						&& _touchCords.y <= _controller.getEquipmentButton().getY() + _controller.getEquipmentButton().getHeight()) {

					_controller.pressedEquipmentButton(true);
					return true;
				}

				if (_touchCords.x >= _controller.getEventsButton().getX() 
						&& _touchCords.x <= _controller.getEventsButton().getX() + _controller.getEventsButton().getWidth()
						&& _touchCords.y >= _controller.getEventsButton().getY() 
						&& _touchCords.y <= _controller.getEventsButton().getY() + _controller.getEventsButton().getHeight()) {

					_controller.pressedEventButton(true);
					return true;
				}

				if (_touchCords.x >= _controller.getMenuButton().getX() 
						&& _touchCords.x <= _controller.getMenuButton().getX() + _controller.getMenuButton().getWidth()
						&& _touchCords.y >= _controller.getMenuButton().getY() 
						&& _touchCords.y <= _controller.getMenuButton().getY() + _controller.getMenuButton().getHeight()) {

					_controller.pressedMenuButton(true);
					return true;
				}

				return false;
			}
			
		};
	}


}
