package com.nni.gamevate.pixelwizard.object.spells;

import com.badlogic.gdx.math.Vector2;

public interface SpellInterface {

	public void bounceOffWall(String side);
	
	public void bounceOffEnemy(String side, String enemy);
	
	public void bounceOffShield(Vector2 shieldPosition);
	
	public void evaporate();
	
	public void transfiguration(EnemySpell enemySpell);
}
