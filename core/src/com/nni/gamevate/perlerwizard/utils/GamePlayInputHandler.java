package com.nni.gamevate.perlerwizard.utils;

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

	private GamePlayController _controller;
	private Vector3 _touchCords;
	private OrthographicCamera _camera;

	private InputAdapter _skillBarProcessor;

	public GamePlayInputHandler(GamePlayController controller, OrthographicCamera camera) {
		_controller = controller;
		_touchCords = new Vector3();
		_camera = camera;

		initSkillBarProcessor();
	}

	public InputAdapter getSkillBarProcessor() {
		return _skillBarProcessor;
	}

	private void initSkillBarProcessor() {
		_skillBarProcessor = new InputAdapter() {
			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {

				_touchCords.set(screenX, screenY, 0);
				_camera.unproject(_touchCords);

				if (_touchCords.x >= _controller.getLeftWall().getX()
						&& _touchCords.x <= _controller.getRightWall().getX()
						&& _touchCords.y >= 0
						&& _touchCords.y <= _controller.getUpperWall().getY()) {

					_controller.attack();
					return true;
				}
				
				if(_touchCords.x >= _controller.getSkillSlotOne().getX()
						&& _touchCords.x <= _controller.getSkillSlotOne().getX() + _controller.getSkillSlotOne().getWidth()
						&& _touchCords.y >= _controller.getSkillSlotOne().getY()
						&& _touchCords.y <= _controller.getSkillSlotOne().getY() + _controller.getSkillSlotOne().getHeight()){
					
					_controller.setSelectedSkill(1);
					return true;
				 
				}
				
				if(_touchCords.x >= _controller.getSkillSlotTwo().getX()
						&& _touchCords.x <= _controller.getSkillSlotTwo().getX() + _controller.getSkillSlotTwo().getWidth()
						&& _touchCords.y >= _controller.getSkillSlotTwo().getY()
						&& _touchCords.y <= _controller.getSkillSlotTwo().getY() + _controller.getSkillSlotTwo().getHeight()){
				 
					_controller.setSelectedSkill(2);
					return true;
				}
				
				if(_touchCords.x >= _controller.getSkillSlotThree().getX()
						&& _touchCords.x <= _controller.getSkillSlotThree().getX() + _controller.getSkillSlotThree().getWidth()
						&& _touchCords.y >= _controller.getSkillSlotThree().getY()
						&& _touchCords.y <= _controller.getSkillSlotThree().getY() + _controller.getSkillSlotThree().getHeight()){
					
					_controller.setSelectedSkill(3);
					return true;
				 
				}
				if(_touchCords.x >= _controller.getSkillSlotFour().getX()
						&& _touchCords.x <= _controller.getSkillSlotFour().getX() + _controller.getSkillSlotFour().getWidth()
						&& _touchCords.y >= _controller.getSkillSlotFour().getY()
						&& _touchCords.y <= _controller.getSkillSlotFour().getY() + _controller.getSkillSlotFour().getHeight()){
					
					_controller.setSelectedSkill(4);
					return true;
				 
				}
				
				if(_touchCords.x >= _controller.getSkillSlotFive().getX()
						&& _touchCords.x <= _controller.getSkillSlotFive().getX() + _controller.getSkillSlotFive().getWidth()
						&& _touchCords.y >= _controller.getSkillSlotFive().getY()
						&& _touchCords.y <= _controller.getSkillSlotFive().getY() + _controller.getSkillSlotFive().getHeight()){
					
					_controller.setSelectedSkill(5);
					return true;
				 
				}
				
				if(_touchCords.x >= _controller.getDefenseCastBox().getX()
						&& _touchCords.x <= _controller.getDefenseCastBox().getX() + _controller.getDefenseCastBox().getWidth()
						&& _touchCords.y >= _controller.getDefenseCastBox().getY()
						&& _touchCords.y <= _controller.getDefenseCastBox().getY() + _controller.getDefenseCastBox().getHeight()){
					
					_controller.castDefense();
					return true;
				 
				}
				
				return false;
			}
		};
	}
}
