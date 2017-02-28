package com.nni.gamevate.perlerwizard.screens.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nni.gamevate.perlerwizard.GamePlayRenderer;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.controllers.GamePlayController;
import com.nni.gamevate.perlerwizard.controllers.NetworkController;
import com.nni.gamevate.perlerwizard.screens.ScreenAdaptar;

public class MatchResultsScreen extends ScreenAdaptar {

	private PerlerWizard _perlerWizard;
	private GamePlayController _gamePlayController;
	private GamePlayRenderer _renderer;
	
	private SpriteBatch _batch;
	private AssetManager _assetManager;
	private NetworkController _networkController;
	
	public MatchResultsScreen(PerlerWizard perlerWizard) {
		_perlerWizard = perlerWizard;
		_batch = _perlerWizard.getSpriteBatch();
		_assetManager = _perlerWizard.getAssetManager();
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
