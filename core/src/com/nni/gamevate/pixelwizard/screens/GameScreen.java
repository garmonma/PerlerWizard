package com.nni.gamevate.pixelwizard.screens;


import com.nni.gamevate.pixelwizard.GameRenderer;
import com.nni.gamevate.pixelwizard.PixelWizard;
import com.nni.gamevate.pixelwizard.world.GameWorld;

/**
 * @author Marcus Garmon 12/29/2016
 */
public class GameScreen extends AbstractScreen {
	
	private PixelWizard _pixelWizard;
	private GameWorld _world;
	private GameRenderer _renderer;
	
	
	public GameScreen(final PixelWizard pixelWizard) {
		_pixelWizard = pixelWizard;
	}
	
	@Override
	public void render(float delta) {
		_world.update(delta);
		_renderer.render(delta);	
	}
		
	@Override
	public void show() {
		System.out.println("On Game Screen");
		_world = new GameWorld();
		_renderer = new GameRenderer(_world);

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