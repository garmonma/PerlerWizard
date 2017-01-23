package com.nni.gamevate.perlerwizard.controllers;

import com.nni.gamevate.perlerwizard.GameConstants;
import com.nni.gamevate.perlerwizard.object.Background;

public class GameWorldController {
	
	private Background _castleBackground;

	public GameWorldController(){
		
		
		init();
	}
	
	public void update(float delta){
		
	}
	
	private void init(){
		_castleBackground = new Background();
		_castleBackground.setPosition(0, 0);
		_castleBackground.setDimensions(
				(int)GameConstants.SCREEN_WIDTH, 
				(int)GameConstants.SCREEN_WIDTH);
	}
	

	
	public Background getCastleBackground(){
		return _castleBackground;
	}
}
