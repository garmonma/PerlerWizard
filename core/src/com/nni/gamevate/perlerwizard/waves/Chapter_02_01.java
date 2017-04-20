package com.nni.gamevate.perlerwizard.waves;

import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imp;

public class Chapter_02_01 extends Level {

	public Chapter_02_01() {
		super();
		
		goldReward = 150;
		itemRewards.add("Goblin Ear");
		
		wave1.add(new Goblin(wave1Start, 3, 1));
		wave1.add(new Goblin(wave1Start, 4, 1));
		wave1.add(new Goblin(wave1Start, 5, 1));
		wave1.add(new Goblin(wave1Start, 6, 1));
		wave1.add(new Goblin(wave1Start, 7, 1));
		wave1.add(new Imp(wave1Start +1, 4, 1));
		wave1.add(new Imp(wave1Start +1, 5, 1));
		wave1.add(new Imp(wave1Start +1, 6, 1));
		
	}

}
