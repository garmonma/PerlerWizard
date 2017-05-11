package com.nni.gamevate.perlerwizard.object.skills.reflectables;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.nni.gamevate.perlerwizard.PerlerWizard;
import com.nni.gamevate.perlerwizard.assets.AssetDescriptors;

/**
 * @author Marcus Garmon 12/29/2016
 * 
 *         The GreenSpell travels slower than other spell colors but it has the
 *         ability to absorb life from those it hit and heals the caster upon
 *         touching it.
 */
public class GreenSpell extends Spell {
	
	public GreenSpell(float x, float y){
		super(x, y);
		color = Color.GREEN;
		_speed = 4.0f;
		_velocity.set(_direction).scl(_speed);
		
		castSound = PerlerWizard.assetManager.get(AssetDescriptors.FOREST_SPELL_CAST);
		hitSound = PerlerWizard.assetManager.get(AssetDescriptors.FOREST_SPELL_HIT);
		
		castAnimation = new Animation(0.10f, 
				PerlerWizard.assetManager.get(AssetDescriptors.SPELLS).findRegions("forest_spell"), 
				PlayMode.LOOP);
	}

	public GreenSpell(float width, float height, float x, float y) {
		super(width, height, x, y);
		_speed = 4.0f;
		_velocity.set(_direction).scl(_speed);
	}
}