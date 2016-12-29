package com.nni.gamevate.pixelwizard.object.spells.shape;

import com.nni.gamevate.pixelwizard.object.character.Hero;
import com.nni.gamevate.pixelwizard.object.character.Shield;
import com.nni.gamevate.pixelwizard.object.enemies.Enemy;
import com.nni.gamevate.pixelwizard.object.spells.Spell;
import com.nni.gamevate.pixelwizard.object.walls.Wall;

public class CircleSpell extends SpellShape{
	
	
	
	public CircleSpell(){
		
	}
		
	@Override
	public String toString() {
		return "circle";
	}

	protected void bounceOffShield(Spell spell, Shield shield) {
		if (spell.getX() <= shield.getX() + ((shield.getWidth() / 3) * 1)) {
			// bounceRight(); angle = 45 degrees;
			_bounceAngle = 45;
		} else if (spell.getX() <= shield.getX() + ((shield.getWidth() / 3) * 2)) {
			// bounceStraight angle 90 degrees;
			_bounceAngle = 90;
		} else if (spell.getX() <= shield.getX() + ((shield.getWidth() / 3) * 3)) {
			// bounceLeft() angle = 135 degrees;
			_bounceAngle = 135;
		}// TODO Auto-generated method stub
		
		
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
