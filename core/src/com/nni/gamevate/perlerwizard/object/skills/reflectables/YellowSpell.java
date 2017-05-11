package com.nni.gamevate.perlerwizard.object.skills.reflectables;

import com.badlogic.gdx.graphics.Color;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;

/**
 * 
 * @author Marcus Garmon 12/29/2016
 * 
 * The Yellow Spell travels at a very fast speed. It has the ability
 * to paralyze the first enemy that it hits. special effect
 * resets after bouncing off of the shield.
 *
 */
public class YellowSpell extends Spell {
	
	public YellowSpell(float x, float y){
		super(x, y);
		color = Color.YELLOW;
		_speed = 10;
		_velocity.set(_direction).scl(_speed);
		castSound = PerlerWizard.assetManager.get(AssetDescriptors.LIGHTNING_SPELL_CAST);
		hitSound = PerlerWizard.assetManager.get(AssetDescriptors.LIGHTNING_SPELL_HIT);
	}

	public YellowSpell(float width, float height, float x, float y) {
		super(width, height, x, y);
		
		_speed = 10;
		_velocity.set(_direction).scl(_speed);
	}
}