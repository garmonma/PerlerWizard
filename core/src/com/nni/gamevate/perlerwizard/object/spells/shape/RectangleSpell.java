package com.nni.gamevate.perlerwizard.object.spells.shape;

import com.nni.gamevate.perlerwizard.object.character.Hero;
import com.nni.gamevate.perlerwizard.object.character.Shield;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.spells.Spell;
import com.nni.gamevate.perlerwizard.object.walls.Wall;

/**
 * 
 * @author Marcus Garmon 12/29/2016
 *
 */
public class RectangleSpell extends SpellShape {


	@Override
	public String toString() {
		return "rectangle";
	}

	@Override
	protected void bounceOffShield(Spell spell, Shield shield) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void bounceOffEnemy(Spell spell, Enemy enemy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void bounceOffWall(Spell spell, Wall wall) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void bounceOffHero(Spell spell, Hero hero) {
		// TODO Auto-generated method stub
		
	}
}
