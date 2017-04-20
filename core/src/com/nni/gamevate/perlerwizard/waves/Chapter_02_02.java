package com.nni.gamevate.perlerwizard.waves;

import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imp;

public class Chapter_02_02 extends Level {

	public Chapter_02_02() {
		super();
		
		goldReward = 150;
		itemRewards.add("Goblin Hide");
		
		Goblin goblin1 = new Goblin(wave1Start, 3, 1);
		// set speed here - increased by 25%
		
		Goblin goblin2 = new Goblin(wave1Start, 3, 1);
		// set speed here - increased by 25%
		
		wave1.add(goblin1);
		wave1.add(goblin2);
		wave1.add(new Goblin(wave1Start, 5, 1));
		wave1.add(new Goblin(wave1Start, 6, 1));
		wave1.add(new Imp(wave1Start +1, 6, 1));
	}

}