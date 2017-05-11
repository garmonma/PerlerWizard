package com.nni.gamevate.perlerwizard.object.skills.throwables;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;
import com.nni.gamevate.perlerwizard.object.skills.Skill;

public class RockThrow extends Skill {
	
	public RockThrow(float x, float y) {
		this(0.20f, 0.20f, x, y);
	}
	
	public RockThrow(float width, float height, float x, float y){
		super(width, height, x, y);
		
		speed = 6;
		
		castAnimation = new Animation(0.10f, 
				PerlerWizard.assetManager.get(AssetDescriptors.OBJECTS).findRegions("largeRock"), 
				PlayMode.LOOP);
	}
}