package com.nni.gamevate.perlerwizard.object.skills.rushables;

import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.object.GameObject;
import com.nni.gamevate.perlerwizard.object.skills.Skill;

public class Rush extends Skill {
	
	private GameObject gB;
	private Vector2 lastPosition;

	public Rush(float x, float y, GameObject g) {
		super(x, y);
		speed = 6;
		gB = g;
		lastPosition = new Vector2(gB.getPosition());
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);
		
		gB.setPosition(this.getPosition());
		
		if(Math.abs(getX() - getStartX()) > GameConfig.WORLD_WIDTH /2  ){
			gB.setPosition(new Vector2(lastPosition));
			alive = false;
		}
	}
}
