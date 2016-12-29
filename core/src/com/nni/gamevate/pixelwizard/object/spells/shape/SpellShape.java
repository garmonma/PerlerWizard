package com.nni.gamevate.pixelwizard.object.spells.shape;

import com.nni.gamevate.pixelwizard.object.Collidable;
import com.nni.gamevate.pixelwizard.object.character.Hero;
import com.nni.gamevate.pixelwizard.object.character.Shield;
import com.nni.gamevate.pixelwizard.object.enemies.Enemy;
import com.nni.gamevate.pixelwizard.object.spells.Spell;
import com.nni.gamevate.pixelwizard.object.walls.Wall;

/**
 * 
 * @author Marcus Garmon
 *
 *         The Spell shape determines the damage of the spell and the spin of
 *         the spell. When a spell bounces, the spin(positive to the right,
 *         negative the left) will determine the direction that the spell will
 *         go. Some shapes will always have a neutral spin.
 */

public abstract class SpellShape {

	protected static final float DEFAULT_ANGLE = 90;

	protected double _dmgMultiplier;
	protected double _spinMultiplier;
	protected float _bounceAngle;

	public SpellShape() {
		_dmgMultiplier = 1.0;
		_spinMultiplier = 1.0;

	}

	public void bounce(Spell spell, Collidable collidable){
		if(collidable instanceof Shield){
			bounceOffShield(spell, (Shield)collidable);
		}
		
		if(collidable instanceof Enemy){
			bounceOffEnemy(spell, (Enemy)collidable);
		}
		
		if(collidable instanceof Hero){
			bounceOffHero(spell, (Hero)collidable);
		}
		
		if(collidable instanceof Wall){
			bounceOffWall(spell, (Wall)collidable);
		}
	}
	
	protected abstract void bounceOffShield(Spell spell, Shield shield);
	
	protected abstract void bounceOffEnemy(Spell spell, Enemy enemy);
	
	protected abstract void bounceOffWall(Spell spell, Wall wall);
	
	protected abstract void bounceOffHero(Spell spell, Hero hero);

	public double getDmgMultiplier() {
		return _dmgMultiplier;
	}

	public void setDmgMultiplier(double dmgMultiplier) {
		_dmgMultiplier = dmgMultiplier;
	}

	public double getSpinMultiplier() {
		return _spinMultiplier;
	}

	public void setSpinMultiplier(double spinMultiplier) {
		_spinMultiplier = spinMultiplier;
	}
	
	public float getBounceAngle(){
		return _bounceAngle;
	}
	
}