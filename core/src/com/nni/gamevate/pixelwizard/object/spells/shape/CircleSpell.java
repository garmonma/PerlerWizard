package com.nni.gamevate.pixelwizard.object.spells.shape;

import com.badlogic.gdx.Gdx;
import com.nni.gamevate.pixelwizard.object.character.Hero;
import com.nni.gamevate.pixelwizard.object.character.Shield;
import com.nni.gamevate.pixelwizard.object.enemies.Enemy;
import com.nni.gamevate.pixelwizard.object.spells.Spell;
import com.nni.gamevate.pixelwizard.object.walls.Wall;

public class CircleSpell extends SpellShape {

	public CircleSpell() {

	}

	@Override
	public String toString() {
		return "circle";
	}

	protected void bounceOffShield(Spell spell, Shield shield) {
		float shieldMaxX = shield.getX() + shield.getWidth();
		float difference = shieldMaxX - spell.getX();
		float pct = (100 * difference) / shield.getWidth();
		Gdx.app.log("Bounce Difference", difference + "");
		Gdx.app.log("BouncePct", pct + "");

		_bounceAngle = ((pct * 1.4f) + 20f);// * -1f;

	}

	@Override
	protected void bounceOffEnemy(Spell spell, Enemy enemy) {
		_bounceAngle = 270;
	}

	@Override
	protected void bounceOffWall(Spell spell, Wall wall) {
		if (wall.getSide().equalsIgnoreCase("left")) {
			if(_bounceAngle > 180){
				_bounceAngle = 315;
			} else {
				_bounceAngle = 45;
			}
		
		}

		if (wall.getSide().equalsIgnoreCase("right")) {
			if(_bounceAngle > 180){
				_bounceAngle = 225;
			} else {
				_bounceAngle = 135;
			}
		}

		if (wall.getSide().equalsIgnoreCase("upper")) {
			if(_bounceAngle == 45){
				_bounceAngle = 315;
			} else {
				_bounceAngle = 225;
			}
				

		}

	}

	@Override
	protected void bounceOffHero(Spell spell, Hero hero) {
		// TODO Auto-generated method stub

	}
}
