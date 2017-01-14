<<<<<<< HEAD
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
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.screens.UIScreen;

/**
 * 
 * @author Marcus Garmon 12/29/2016
 *
 */
public class MainWorldScreen extends UIScreen {

	private static final String UI_SKIN = "ui/uiskin.json";
	private PerlerWizard _perlerWizard;
	private Viewport _viewport;

	private AssetManager am;
	private Stage stage;
	private Actor actor;
	private Skin skin;
	
	Button textButton;

	public MainWorldScreen(final PerlerWizard perlerWizard) {
		System.out.println("On Main Menu Screen");
		_perlerWizard = perlerWizard;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(delta);
		stage.draw();

		// if (Gdx.input.justTouched())
		// _perlerWizard.setScreen(new GameScreen(_perlerWizard));

	}

	@Override
	public void show() {
		_viewport = new FitViewport(800, 480);
		stage = new Stage(_viewport);

		am = new AssetManager();
		am.getLogger().setLevel(Logger.DEBUG);

		am.load(UI_SKIN, Skin.class);
		am.finishLoading();
		skin = am.get(UI_SKIN);

		
		initUI();

		Gdx.input.setInputProcessor(stage);

	}

	private void initUI() {
		//Table table = new Table();

		//table.defaults().pad(20);
		
		Touchpad tp = new Touchpad(1f, skin);
		//tp.setPosition(300, 300);
		tp.setBounds(150, 150, 200, 50);
		stage.addActor(tp);

	    textButton = new Button(skin);
		textButton.setSize(64, 32);
		textButton.setPosition(800/2, 480/2);
		
		//textButton.addAction(Actions.rotateBy(90f, 4f));
		
		
	//	table.add(textButton);

		//table.row();
		//table.center();
		//table.setFillParent(true);

		stage.addActor(textButton);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
		_viewport.update(width, height, true);
	}

	@Override
	public void dispose() {
		stage.dispose();
	}
=======
package com.nni.gamevate.perlerwizard.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.perlerwizard.GameConstants;
import com.nni.gamevate.perlerwizard.PerlerWizard;

/**
 * 
 * @author Marcus Garmon 12/29/2016
 *
 */
public class MainWorldScreen extends AbstractScreen {
	
	private static final String UI_SKIN = "ui/uiskin.json";
	private PerlerWizard _perlerWizard;
	private Viewport _viewport;

	private AssetManager am;
	private Stage stage;
	private Actor actor;
	private Skin skin;
	
	public MainWorldScreen(final PerlerWizard perlerWizard) {
		System.out.println("On Main Menu Screen");
		_perlerWizard = perlerWizard;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);
		stage.draw();

		if (Gdx.input.justTouched())
			_perlerWizard.setScreen(new GameScreen(_perlerWizard));

	}

	@Override
	public void show() {
		_viewport = new FitViewport(800, 480);
		stage = new Stage(_viewport);
		
		am = new AssetManager();
		am.getLogger().setLevel(Logger.DEBUG);
		
		am.load(UI_SKIN, Skin.class);
		am.finishLoading();
		skin = am.get(UI_SKIN);
		
		initUI();
		
		Gdx.input.setInputProcessor(stage);
		

	}
	
	private void initUI(){
		Table table= new Table();
		
		table.defaults().pad(20);
		
		for(int i = 0; i < 4; i++){
			TextButton textButton = new TextButton("Button " + i, skin);
			
			textButton.addListener(new ChangeListener(){

				@Override
				public void changed(ChangeEvent event, Actor actor) {
					Gdx.app.log("Button Change", "event = " + event + " Actor = " + actor);
					
				}
				
			});
			table.add(textButton);
			
		}
		
		table.row();
		
		stage.addActor(table);
	}
	
	

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void resize(int width, int height) {
		_viewport.update(width, height, true);
	}
	
	@Override
	public void dispose() {
		stage.dispose();
	}

>>>>>>> branch 'Dev-January-Alpha' of https://github.com/garmonma/PerlerWizard.git
}