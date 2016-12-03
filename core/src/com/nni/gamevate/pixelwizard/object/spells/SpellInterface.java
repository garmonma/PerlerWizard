package com.nni.gamevate.pixelwizard.object.spells;

public interface SpellInterface {

	public void bounceOffWall(String side);
	
	public void bounceOffEnemy(String side, String enemy);
	
	public void evaporate();
	
	public void transfiguration();
}
