package com.nni.gamevate.perlerwizard.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.nni.gamevate.perlerwizard.object.World;
import com.nni.gamevate.perlerwizard.object.hero.Hero;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.screens.game.WaveGameScreen;

public class WaveInputHandler extends InputAdapter {
	private static final String tag = WaveInputHandler.class.getSimpleName();
	
	private Vector3 touchCords;
	private OrthographicCamera camera;

	public boolean up;
	public boolean down;
	public boolean right;
	public boolean left;
	public boolean fire;
	
	private World world;
	private Hero hero;

	public WaveInputHandler(OrthographicCamera camera,World world) {
		
		touchCords = new Vector3();
		this.camera = camera;
		this.world = world;
		this.hero = world.getHero();
		
	}

	public void tick(float delta){
		
		
		up = Gdx.input.isKeyPressed(Input.Keys.UP);
		down = Gdx.input.isKeyPressed(Input.Keys.DOWN);
		left = Gdx.input.isKeyPressed(Input.Keys.LEFT);
		right = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
		
		fire = Gdx.input.isKeyPressed(Input.Keys.SPACE) 
				|| Gdx.input.isTouched();
		
		
		Vector2 dir = new Vector2();
		if(up)
			dir.y++;
		if(down)
			dir.y--;
		if(left)
			dir.x--;
		if(right)
			dir.x++;
		hero.setDirection(dir);
		
		if(fire == true){			
			if(WaveGameScreen.gameOver == false){			
				Skill s = hero.attack(hero.getSkillManager().getSelectedSkill());
				world.addSkill(s);
			}
		}
	}
	
	
	@Override
	public boolean scrolled(int amount) {
		//Gdx.app.log(tag, "Scrolled : " + amount);
		if(amount > 0)
			hero.getSkillManager().selectNext();
		else if(amount < 0)
			hero.getSkillManager().selectPrevious();
		
		return super.scrolled(amount);
	}
	
	@Override
	public boolean keyDown(int keyCode){
		//Gdx.app.log(tag, "KeyDown: " + keyCode);
				return true;
	}
}
