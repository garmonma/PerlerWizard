package com.nni.gamevate.perlerwizard.screens.game;


import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nni.gamevate.perlerwizard.GamePlayRenderer;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.controllers.GamePlayController;
import com.nni.gamevate.perlerwizard.screens.ScreenAdaptar;

/**
 * @author Marcus Garmon 12/29/2016
 */
public class GameScreen extends ScreenAdaptar {
	
	private PerlerWizard _perlerWizard;
	private GamePlayController _world;
	private GamePlayRenderer _renderer;
	
	private SpriteBatch _batch;
	private AssetManager _assetManager;
	
	public GameScreen(PerlerWizard perlerWizard) {
		_perlerWizard = perlerWizard;
		_batch = _perlerWizard.getSpriteBatch();
		_assetManager = _perlerWizard.getAssetManager();
	}
	
	@Override
	public void render(float delta) {
		_world.update(delta);
		_renderer.render(delta);	
	}
		
	@Override
	public void show() {
		_world = new GamePlayController();
		_renderer = new GamePlayRenderer(_world, _batch, _assetManager);

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void resize(int width, int height) {
		_renderer.resize(width, height);
	}
}