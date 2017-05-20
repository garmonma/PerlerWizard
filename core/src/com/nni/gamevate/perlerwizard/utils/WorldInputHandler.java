package com.nni.gamevate.perlerwizard.utils;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.nni.gamevate.perlerwizard.controllers.GameWorldController;

/**
 * 
 * @author Marcus Garmon 12/29/2016
 *
 */
public class WorldInputHandler {

	private GameWorldController controller;
	private Vector3 touchCords;
	private OrthographicCamera camera;
	private OrthographicCamera hudCamera;

	private InputAdapter inputAdapter;
	private InputAdapter hudInputAdapter;

	public WorldInputHandler(GameWorldController controller, OrthographicCamera camera, OrthographicCamera hudCamera) {
		this.controller = controller;
		this.touchCords = new Vector3();
		this.camera = camera;
		this.hudCamera = hudCamera;
		
		initWorldAdapter();
		initHudAdapter();

	}
	
	public InputAdapter getWorldAdapter(){
		return inputAdapter;
	}
	
	public InputAdapter getHudAdapter(){
		return hudInputAdapter;
	}

	private void initWorldAdapter() {
		inputAdapter = new InputAdapter() {

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {

				touchCords.set(screenX, screenY, 0);
				camera.unproject(touchCords);

				for (GameElement gameElement : controller.getMapNodes()) {
					MapNode mapNode;
					
					if(gameElement instanceof MapNode){
						mapNode = (MapNode) gameElement;
					
					
						if (touchCords.x >= mapNode.getX() 
								&& touchCords.x <= mapNode.getX() + mapNode.getWidth()
								&& touchCords.y >= mapNode.getY()
								&& touchCords.y <= mapNode.getY() + mapNode.getHeight()) {
	
							controller.selectNode(mapNode);
							controller.initializedMatch(true);
							
							return true;
						}
					}
				}

				return false;
			}
		};
	}

	private void initHudAdapter(){
		hudInputAdapter = new InputAdapter(){
			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				
				touchCords.set(screenX, screenY, 0);
				hudCamera.unproject(touchCords);
				
				
				if (touchCords.x >= controller.getEquipmentButton().getX() 
						&& touchCords.x <= controller.getEquipmentButton().getX() + controller.getEquipmentButton().getWidth()
						&& touchCords.y >= controller.getEquipmentButton().getY() 
						&& touchCords.y <= controller.getEquipmentButton().getY() + controller.getEquipmentButton().getHeight()) {

					controller.pressedEquipmentButton(true);
					return true;
				}

				if (touchCords.x >= controller.getEventsButton().getX() 
						&& touchCords.x <= controller.getEventsButton().getX() + controller.getEventsButton().getWidth()
						&& touchCords.y >= controller.getEventsButton().getY() 
						&& touchCords.y <= controller.getEventsButton().getY() + controller.getEventsButton().getHeight()) {

					controller.pressedEventButton(true);
					return true;
				}

				if (touchCords.x >= controller.getMenuButton().getX() 
						&& touchCords.x <= controller.getMenuButton().getX() + controller.getMenuButton().getWidth()
						&& touchCords.y >= controller.getMenuButton().getY() 
						&& touchCords.y <= controller.getMenuButton().getY() + controller.getMenuButton().getHeight()) {

					controller.pressedMenuButton(true);
					return true;
				}

				return false;
			}
			
		};
	}


}
