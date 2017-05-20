package com.nni.gamevate.perlerwizard.object.skills.defense;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.TimeUtils;
import com.nni.gamevate.perlerwizard.object.hero.Hero;
import com.nni.gamevate.perlerwizard.object.skills.Skill;

public class Reflect extends Skill {
	
	private long timeCounter;

	public Reflect(float x, float y, Hero hero) {
		super(x, y);
		timeCounter = TimeUtils.millis();
		
		width = 1.2f;
		height = .25f;
		speed = hero.getSpeed();
	}

	public Reflect(float width, float height, float x, float y) {
		super(width, height, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float delta) {

		move();
		
		if (getX() < 3.90f) {
			position.x = 3.90f;
		}

		if (getX() > 14.90f) {
			position.x = 14.90f;
		}

	}
	
	private void move() {
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.getAccelerometerY() < 0) {
			position.x -= speed * Gdx.graphics.getDeltaTime();
		}

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.getAccelerometerY() > 0)
			position.x += speed * Gdx.graphics.getDeltaTime();

	}

}
