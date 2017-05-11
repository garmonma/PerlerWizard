package com.nni.gamevate.perlerwizard.object.skills.reflectables;

import com.badlogic.gdx.graphics.Color;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;

/**
 * 
 * @author Marcus Garmon 11/27/2016
 * 
 *         The most basic spell color. It travels at a normal speed and has a
 *         cooldown of 3 seconds.
 *
 */
public class MagicCast extends Spell {
	
	public MagicCast(float x, float y){
		super(x, y);
		color = Color.WHITE;
		
		castSound = PerlerWizard.assetManager.get(AssetDescriptors.DEFAULT_SPELL_CAST);
		hitSound = PerlerWizard.assetManager.get(AssetDescriptors.DEFAULT_SPELL_HIT);
	}

	public MagicCast(float width, float height, float x, float y) {
		super(width, height, x, y);
	
	}
}