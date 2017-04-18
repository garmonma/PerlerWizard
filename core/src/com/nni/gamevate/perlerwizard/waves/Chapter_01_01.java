package com.nni.gamevate.perlerwizard.waves;

import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imps;

public class Chapter_01_01 extends Level{

	public Chapter_01_01() {
		super();
		
		goldReward = 100;
		itemRewards.add("Goblin Ear");
		
		wave1.add(new Goblin(wave1Start, 3, 1));
		wave1.add(new Goblin(wave1Start, 5, 1));
		wave1.add(new Goblin(wave1Start, 7, 1));
		wave1.add(new Imps(wave1Start +1, 4, 1));
		wave1.add(new Imps(wave1Start +1, 6, 1));
	}

}
