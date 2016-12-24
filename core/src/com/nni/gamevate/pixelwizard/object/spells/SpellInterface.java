package com.nni.gamevate.pixelwizard.object.spells;

import com.nni.gamevate.pixelwizard.object.character.Shield;
import com.nni.gamevate.pixelwizard.object.enemies.Enemy;

public interface SpellInterface {

	public void bounceOffWall(String side);
	
	public void bounceOffEnemy(Enemy enemy);
	
	public void bounceOffShield(Shield shield);
	
	public void evaporate();
	
	public void transfiguration(EnemySpell enemySpell);
}
