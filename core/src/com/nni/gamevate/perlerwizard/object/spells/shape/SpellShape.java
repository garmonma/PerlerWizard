package com.nni.gamevate.perlerwizard.object.spells.shape;

import com.badlogic.gdx.math.Vector2;
import com.nni.gamevate.perlerwizard.object.Collidable;
import com.nni.gamevate.perlerwizard.object.Wall;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.hero.Hero;
import com.nni.gamevate.perlerwizard.object.hero.Shield;
import com.nni.gamevate.perlerwizard.object.spells.Spell;

/**
 * 
 * @author Marcus Garmon 12/29/2016
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
		_bounceAngle = DEFAULT_ANGLE;//new Vector2().setAngle(DEFAULT_ANGLE);

	}

	public Vector2 bounce(Spell spell, Collidable collidable){
		if(collidable instanceof Shield){
			return bounceOffShield(spell, (Shield)collidable);
		}
		
		if(collidable instanceof Enemy){
			return bounceOffEnemy(spell, (Enemy)collidable);
		}
		
		if(collidable instanceof Hero){
			bounceOffHero(spell, (Hero)collidable);
		}
		
		if(collidable instanceof Wall){
			return bounceOffWall(spell, (Wall)collidable);
		}
		
		return null;
	}
	
	protected abstract Vector2 bounceOffShield(Spell spell, Shield shield);
	
	protected abstract Vector2 bounceOffEnemy(Spell spell, Enemy enemy);
	
	protected abstract Vector2 bounceOffWall(Spell spell, Wall wall);
	
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