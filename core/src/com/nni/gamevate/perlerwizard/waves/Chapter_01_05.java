package com.nni.gamevate.perlerwizard.waves;

import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;

public class Chapter_01_05 extends Level {

	public Chapter_01_05() {
		super();
		
		goldReward = 500;
		
		itemRewards.add("Massive Club");
		itemRewards.add("Goblin Ear");
		itemRewards.add("Goblin Ear");
		itemRewards.add("Goblin Ear");
		itemRewards.add("Goblin Ear");
		itemRewards.add("Goblin Ear");
		itemRewards.add("Imp Leavings");
		
		wave1.add(new Orc(2, 2, wave1Start, 6, 1));
	}

}