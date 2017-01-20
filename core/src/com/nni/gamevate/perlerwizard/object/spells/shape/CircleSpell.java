package com.nni.gamevate.perlerwizard.object.spells.shape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
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

	protected Vector2 bounceOffShield(Spell spell, Shield shield) {
		float shieldMaxX = shield.getX() + shield.getWidth();
		float difference = shieldMaxX - spell.getX();
		float pct = (100 * difference) / shield.getWidth();
		// Gdx.app.log("Bounce Difference", difference + "");
		// Gdx.app.log("BouncePct", pct + "");

		_bounceAngle = ((pct * 1.4f) + 20f);// * -1f;
		
		Vector2 reflectionAngle = spell.getVelocity().cpy();
		Vector2 wallVector = shield.getPosition().cpy().rotate90(0);
		

		float dot = reflectionAngle.dot(wallVector);
		dot *= -2.0f;
		wallVector.scl(dot);
		wallVector.add(reflectionAngle);

		reflectionAngle.set(wallVector).nor().setAngle(_bounceAngle);

		return reflectionAngle;
	}

	@Override
	protected Vector2 bounceOffEnemy(Spell spell, Enemy enemy) {
		
		Vector2 reflectionAngle = spell.getVelocity().cpy();
		Vector2 wallVector = enemy.getPosition().cpy().rotate90(0);
		

		float dot = reflectionAngle.dot(wallVector);
		dot *= -2.0f;
		wallVector.scl(dot);
		wallVector.add(reflectionAngle);

		reflectionAngle.set(wallVector).nor();
		
		//_bounceAngle = reflectionAngle.angle();
		
		return reflectionAngle;
		
		

		//return reflectionAngle;

//		Gdx.app.log("BounceOffEnemy", "Bouncing");
//		// front
//		if (spell.getY() >= enemy.getY()) {
//			float enemyFrontWidth = enemy.getX() + enemy.getWidth();
//			float spellHitDifferenceFront = enemyFrontWidth - spell.getX();
//			float hitPct = (100 * spellHitDifferenceFront) / enemy.getWidth();
//			_bounceAngle = ((hitPct * 1.4f) + 200f);
//			Gdx.app.log("Bounce Difference", spellHitDifferenceFront + "");
//			Gdx.app.log("BouncePct", hitPct + "");
//			return;
//		}
//
//		// back
//		if (spell.getY() <= enemy.getY() + enemy.getHeight()) {
//			float enemyFrontWidth = enemy.getX() + enemy.getWidth();
//			float spellHitDifferenceFront = enemyFrontWidth - spell.getX();
//			float hitPct = (100 * spellHitDifferenceFront) / enemy.getWidth();
//			_bounceAngle = ((hitPct * 1.4f) + 20f);
//			return;
//		}

	}

	@Override
	protected Vector2 bounceOffWall(Spell spell, Wall wall) {
		Vector2 reflectionAngle = spell.getVelocity().cpy();
		Vector2 wallVector = wall.getPosition().cpy();
			
		wallVector.nor();
		float dot = reflectionAngle.dot(wallVector);
		dot *= -2.0f;
		wallVector.scl(dot);
		wallVector.add(reflectionAngle).nor();

		reflectionAngle.set(wallVector).nor();
		
		//_bounceAngle = reflectionAngle.angle();
		
		

		return reflectionAngle;

	}

	@Override
	protected void bounceOffHero(Spell spell, Hero hero) {
		// TODO Auto-generated method stub

	}
}
