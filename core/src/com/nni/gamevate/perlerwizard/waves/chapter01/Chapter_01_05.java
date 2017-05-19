package com.nni.gamevate.perlerwizard.waves.chapter01;

import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc.OrcType;
import com.nni.gamevate.perlerwizard.waves.Level;

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
		
		Orc orc = new Orc(2, 2, wave1Start, 6, 1);
		orc.setOrcType(OrcType.GIANT);
		
		
		wave1.add(orc);
	}

}
