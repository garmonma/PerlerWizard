package com.nni.gamevate.perlerwizard.object.spells.shape;

import com.badlogic.gdx.math.Vector2;
import com.nni.gamevate.perlerwizard.object.character.Hero;
import com.nni.gamevate.perlerwizard.object.character.Shield;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;
import com.nni.gamevate.perlerwizard.object.spells.Spell;
import com.nni.gamevate.perlerwizard.object.walls.Wall;

/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class TriangleSpell extends SpellShape {

	@Override
	protected Vector2 bounceOffShield(Spell spell, Shield shield) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Vector2 bounceOffEnemy(Spell spell, Enemy enemy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Vector2 bounceOffWall(Spell spell, Wall wall) {
		return new Vector2();
		
	}

	@Override
	protected void bounceOffHero(Spell spell, Hero hero) {
		// TODO Auto-generated method stub
		
	}

}
