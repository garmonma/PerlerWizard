package com.nni.gamevate.perlerwizard.utils;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.nni.gamevate.perlerwizard.controllers.GamePlayController;
import com.nni.gamevate.perlerwizard.controllers.GameWorldController;
import com.nni.gamevate.perlerwizard.object.MapNode;

/**
 * 
 * @author Marcus Garmon 12/29/2016
 *
 */
public class WorldInputHandler {

	private GameWorldController _controller;
	private Vector3 _touchCords;
	private OrthographicCamera _camera;

	private InputAdapter _inputAdaptar;

	public WorldInputHandler(GameWorldController controller, OrthographicCamera camera) {
		_controller = controller;
		_touchCords = new Vector3();
		_camera = camera;
		
		initWorldAdaptar();
	}
	
	private void initWorldAdaptar(){
		_inputAdaptar = new InputAdapter(){
			
			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button){
				
				_touchCords.set(screenX, screenY, 0);
				_camera.unproject(_touchCords);
				
				_controller.getMapNodes();
				
				for(MapNode mapNode: _controller.getMapNodes()){
					if(_touchCords.x >= mapNode.getX() 
							&& _touchCords.x <= mapNode.getX() + mapNode.getWidth()
							&& _touchCords.y >= mapNode.getY()
							&& _touchCords.y <= mapNode.getY() + mapNode.getHeight()){
						
						_controller.selectNode(mapNode);
						
						return true;
					}
				}
				
				return false;
			}
		};
	}
}
