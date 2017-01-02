package com.nni.gamevate.pixelwizard.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.nni.gamevate.pixelwizard.GameRenderer;
import com.nni.gamevate.pixelwizard.PixelWizard;
import com.nni.gamevate.pixelwizard.utils.InputHandler;
import com.nni.gamevate.pixelwizard.world.GameWorld;

/**
 * @author Marcus Garmon 12/29/2016
 */
public class GameScreen extends AbstractScreen {
	
	private GameWorld _world;
	private GameRenderer _renderer;
	private InputMultiplexer _inputMultiplexer;
	private InputHandler _inputHandler;
	
	
	public GameScreen(final PixelWizard pixelWizard) {
		super(pixelWizard);
		System.out.println("On Game Screen");
		
		_world = new  GameWorld();
		_renderer = new GameRenderer(_world);
		
		_inputHandler = new InputHandler(_world, _renderer.getCamera());
		_inputMultiplexer = new InputMultiplexer();
		_inputMultiplexer.addProcessor(_inputHandler.getSkillBarProcessor());
		_inputMultiplexer.addProcessor(_inputHandler.getAnalogProcessor());
		Gdx.input.setInputProcessor(_inputMultiplexer);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		_world.update(delta);
		_renderer.render();	
	}
		
	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}
}