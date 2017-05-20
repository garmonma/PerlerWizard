package com.nni.gamevate.perlerwizard.screens.menu;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.screens.UIScreen;
import com.nni.gamevate.perlerwizard.screens.game.GameWorldScreen;

public class MainMenuScreen extends UIScreen {
	
	public MainMenuScreen(PerlerWizard game) {
		super(game);
	}

	@Override
	protected Actor createUi() {
		return new Actor();
	}

	@Override
	protected void back() {
        perlerWizard.setScreen(new GameWorldScreen(perlerWizard));
		
	}

}
