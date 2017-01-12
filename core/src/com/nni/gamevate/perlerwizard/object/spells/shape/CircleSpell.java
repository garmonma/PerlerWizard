package com.nni.gamevate.perlerwizard.object.spells.shape;

import com.badlogic.gdx.Gdx;
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
//		Gdx.app.log("Bounce Difference", difference + "");
//		Gdx.app.log("BouncePct", pct + "");

		_bounceAngle = ((pct * 1.4f) + 20f);// * -1f;

	}

	@Override
	protected void bounceOffEnemy(Spell spell, Enemy enemy) {

		Gdx.app.log("BounceOffEnemy", "Bouncing");
		// front
		if (spell.getY() >= enemy.getY()) {
			float enemyFrontWidth = enemy.getX() + enemy.getWidth();
			float spellHitDifferenceFront = enemyFrontWidth - spell.getX();
			float hitPct = (100 * spellHitDifferenceFront) / enemy.getWidth();
			_bounceAngle = ((hitPct * 1.4f) + 200f);
			Gdx.app.log("Bounce Difference", spellHitDifferenceFront + "");
			Gdx.app.log("BouncePct", hitPct + "");
			return;
		}

		// back
		if (spell.getY() <= enemy.getY() + enemy.getHeight()) {
			float enemyFrontWidth = enemy.getX() + enemy.getWidth();
			float spellHitDifferenceFront = enemyFrontWidth - spell.getX();
			float hitPct = (100 * spellHitDifferenceFront) / enemy.getWidth();
			_bounceAngle = ((hitPct * 1.4f) + 20f);
			return;
		}

		// left
		if (spell.getX() >= enemy.getX()) {
			// Spell Traveling Upward
			if (_bounceAngle <= 90 && _bounceAngle >= 20) {
				_bounceAngle = _bounceAngle + 80;
			}

			// Spell Traveling downwards
			if (_bounceAngle >= 270 && _bounceAngle <= 340) {
				_bounceAngle = _bounceAngle - 80;
			}
			
			return;
		}

		// right
		if (spell.getX() <= enemy.getX() + enemy.getWidth()) {
			if (_bounceAngle >= 90 && _bounceAngle <= 160) {
				_bounceAngle = _bounceAngle - 80;
			}

			// Spell Traveling downward
			if (_bounceAngle >= 200 && _bounceAngle <= 270) {
				_bounceAngle = _bounceAngle + 80;
			}
			return;
		}
	}

	@Override
	protected void bounceOffWall(Spell spell, Wall wall) {
		if (wall.getSide().equalsIgnoreCase("left")) {
			// Spell Traveling upward
			if (_bounceAngle >= 90 && _bounceAngle <= 180) {
				_bounceAngle = _bounceAngle - 80;
			}

			// Spell Traveling downward
			if (_bounceAngle >= 180 && _bounceAngle <= 270) {
				_bounceAngle = _bounceAngle + 80;
			}
		}

		if (wall.getSide().equalsIgnoreCase("right")) {
			// Spell Traveling Upward
			if (_bounceAngle <= 90 && _bounceAngle >= 0) {
				_bounceAngle = _bounceAngle + 80;
			}

			// Spell Traveling downwards
			if (_bounceAngle >= 270 && _bounceAngle <= 360) {
				_bounceAngle = _bounceAngle - 80;
			}
		}

		if (wall.getSide().equalsIgnoreCase("upper")) {
			if (_bounceAngle == 90) {
				_bounceAngle = 270;
			} else if (_bounceAngle >= 90 && _bounceAngle <= 180) {
				_bounceAngle = _bounceAngle + 80;
			} else if (_bounceAngle >= 0 && _bounceAngle <= 90) {
				_bounceAngle = (_bounceAngle - 80) + 360;
			}
		}

	}

	@Override
	protected void bounceOffHero(Spell spell, Hero hero) {
		// TODO Auto-generated method stub

	}
}
