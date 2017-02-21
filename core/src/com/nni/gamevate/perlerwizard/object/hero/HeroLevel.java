package com.nni.gamevate.perlerwizard.object.hero;

public enum HeroLevel {
	
	ONE(50),
	TWO(75),
	THREE(100),
	FOUR(125),
	FIVE(150),
	SIX(175),
	SEVEN(200),
	EIGHT(225);
	
	private final int hitPoints;
	
	HeroLevel(int hitPoints){
		
		this.hitPoints = hitPoints;
		
	}
	
	public int getHitPoints(){
		return this.hitPoints;
	}

}
