package com.nni.gamevate.pixelwizard;

import com.badlogic.gdx.Gdx;
import com.nni.gamevate.pixelwizard.object.character.Hero;

public class GameWorld {

	private Hero _hero;
	
	public GameWorld(){
		_hero = new Hero(800/2 - 64/2, 20, 64, 64);
	}
	
	public void update(float delta){
		Gdx.app.log("GameWorld", "update");
		
		_hero.update(delta);
	}
	
	public Hero getHero(){
		return _hero;
	}
}
