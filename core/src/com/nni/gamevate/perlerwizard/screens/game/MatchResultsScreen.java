package com.nni.gamevate.perlerwizard.screens.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nni.gamevate.perlerwizard.GamePlayRenderer;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.controllers.GamePlayController;
import com.nni.gamevate.perlerwizard.controllers.NetworkController;
import com.nni.gamevate.perlerwizard.screens.ScreenAdaptar;

public class MatchResultsScreen extends ScreenAdaptar {

	private PerlerWizard perlerWizard;
	private GamePlayController gamePlayController;
	private GamePlayRenderer renderer;
	
	private SpriteBatch batch;
	private AssetManager assetManager;
	private NetworkController networkController;
	
	public MatchResultsScreen(PerlerWizard perlerWizard) {
		this.perlerWizard = perlerWizard;
		batch = perlerWizard.getSpriteBatch();
		assetManager = perlerWizard.getAssetManager();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

}
