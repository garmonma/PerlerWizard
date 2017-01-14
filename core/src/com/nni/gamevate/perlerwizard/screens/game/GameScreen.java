<<<<<<< HEAD
package com.nni.gamevate.perlerwizard.screens.game;


import com.nni.gamevate.perlerwizard.GameRenderer;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.screens.ScreenAdapter;
import com.nni.gamevate.perlerwizard.world.GameWorld;

/**
 * @author Marcus Garmon 12/29/2016
 */
public class GameScreen extends ScreenAdapter {
=======
package com.nni.gamevate.perlerwizard.screens;


import com.nni.gamevate.perlerwizard.GameRenderer;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.world.GameWorld;

/**
 * @author Marcus Garmon 12/29/2016
 */
public class GameScreen extends AbstractScreen {
>>>>>>> branch 'Dev-January-Alpha' of https://github.com/garmonma/PerlerWizard.git
	
	private PerlerWizard _perlerWizard;
	private GameWorld _world;
	private GameRenderer _renderer;
	
	
	public GameScreen(final PerlerWizard perlerWizard) {
		_perlerWizard = perlerWizard;
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