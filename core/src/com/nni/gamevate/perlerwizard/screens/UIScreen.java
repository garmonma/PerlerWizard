package com.nni.gamevate.perlerwizard.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.screens.game.GameScreen;
import com.nni.gamevate.perlerwizard.screens.game.GameWorldScreen;

public abstract class UIScreen extends ScreenAdaptar {
    protected final PerlerWizard _perlerWizard;
    protected final AssetManager _assetManager;

    private Viewport _viewport;
    private Stage _stage;


    public UIScreen(PerlerWizard game) {
        _perlerWizard = game;
        _assetManager = game.getAssetManager();
    }

    @Override
    public void show() {
        _viewport = new FitViewport(GameConfig.UI_SCREEN_WIDTH, GameConfig.UI_SCREEN_HEIGHT);
        _stage = new Stage(_viewport, _perlerWizard.getSpriteBatch());

        Gdx.input.setInputProcessor(_stage);

        _stage.addActor(createUi());
    }

    protected abstract Actor createUi();
    
    protected void back(){
    	
    }

    @Override
    public void resize(int width, int height) {
        _viewport.update(width, height, true);
    }

    @Override
    public void render(float delta) {
    	Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        _stage.act();
        _stage.draw();
        
        if(Gdx.input.isTouched()){
			_perlerWizard.setScreen(new GameWorldScreen(_perlerWizard));
		}
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        _stage.dispose();
    }
}
