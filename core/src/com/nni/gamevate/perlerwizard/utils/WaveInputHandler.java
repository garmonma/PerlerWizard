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

public class WaveInputHandler extends InputAdapter {
	private static final String tag = WaveInputHandler.class.getSimpleName();
	
	private Vector3 _touchCords;
	private OrthographicCamera _camera;

	public boolean up;
	public boolean down;
	public boolean right;
	public boolean left;
	public boolean fire;
	
	private World _world;
	private Hero _hero;

	public WaveInputHandler(OrthographicCamera camera,World world) {
		
		_touchCords = new Vector3();
		_camera = camera;
		_world = world;
		_hero = world.getHero();
		
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
		_hero.setDirection(dir);
		
		if(fire){			
			Skill s = _hero.attack(_hero.getSkillManager().getSelectedSkill());
			_world.addSkill(s);
		}			
	}
	
	
	@Override
	public boolean scrolled(int amount) {
		//Gdx.app.log(tag, "Scrolled : " + amount);
		if(amount > 0)
			_hero.getSkillManager().selectNext();
		else if(amount < 0)
			_hero.getSkillManager().selectPrevious();
		
		return super.scrolled(amount);
	}
	
	@Override
	public boolean keyDown(int keyCode){
		Gdx.app.log(tag, "KeyDown: " + keyCode);
				return true;
	}
}
