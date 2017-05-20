package com.nni.gamevate.perlerwizard.screens.menu;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.screens.UIScreen;
import com.nni.gamevate.perlerwizard.screens.game.GameWorldScreen;

public class EventScreen extends UIScreen {

	public EventScreen(PerlerWizard game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Actor createUi() {
		// TODO Auto-generated method stub
		return new Actor();
	}
	
	@Override
	protected void back() {
        perlerWizard.setScreen(new GameWorldScreen(perlerWizard));
		
	}


}
