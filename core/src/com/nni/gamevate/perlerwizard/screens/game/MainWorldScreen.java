package com.nni.gamevate.perlerwizard.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.perlerwizard.GameConstants;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;
import com.nni.gamevate.perlerwizard.screens.UIScreen;

/**
 * 
 * @author Marcus Garmon 12/29/2016
 *
 */
public class MainWorldScreen extends UIScreen {


	
	Button textButton;

	public MainWorldScreen(PerlerWizard perlerWizard) {
		super(perlerWizard);
		System.out.println("On Main Menu Screen");
	}

	@Override
	public void render(float delta) {
		super.render(delta);

	}

	@Override
	protected Actor createUi() {
		Skin skin = _assetManager.get(AssetDescriptors.UI_SKIN);
	
		Touchpad tp = new Touchpad(1f, skin);
		tp.setBounds(150, 150, 200, 50);

	    textButton = new Button(skin);
		textButton.setSize(64, 32);
		textButton.setPosition(800/2, 480/2);

		return tp;
	}
}