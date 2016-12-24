package com.nni.gamevate.pixelwizard.object.spells;

public interface SpellInterface {

	public void bounceOffWall(String side);
	
	public void bounceOffEnemy();
	
	public void bounceOffShield();
	
	public void evaporate();
	
	public void transfiguration(EnemySpell enemySpell);
}
