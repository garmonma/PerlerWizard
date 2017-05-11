package com.nni.gamevate.perlerwizard.object.skills.reflectables;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;

/**
 * @author Marcus Garmon 12/29/2016
 * 
 *         The Blue Spell travels at normal speed. It has the ability to
 *         explode, breaking off into four smaller pieces.
 */
public class WaterCast extends Spell {
	
	public WaterCast(float x, float y){
		super(x, y);
		color = Color.BLUE;
		
		castSound = PerlerWizard.assetManager.get(AssetDescriptors.WATER_SPELL_CAST);
		hitSound = PerlerWizard.assetManager.get(AssetDescriptors.WATER_SPELL_HIT);
		
		castAnimation = new Animation(0.10f, 
				PerlerWizard.assetManager.get(AssetDescriptors.SPELLS).findRegions("water_spell"), 
				PlayMode.LOOP);

	}

	public WaterCast(float width, float height, float x, float y) {
		super(width, height, x, y);
		
	}
}