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

}