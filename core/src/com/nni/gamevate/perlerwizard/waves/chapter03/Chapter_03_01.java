package com.nni.gamevate.perlerwizard.waves.chapter03;

import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_03_01 extends Level {

	public Chapter_03_01() {
		super();
		
		goldReward = 500;
		itemRewards.add("Vision Shield");
		itemRewards.add("Vision Shield");
		itemRewards.add("Vision Shield");
		
		wave1.add(new Orc(wave1Start, 3, 1));
		wave1.add(new Orc(wave1Start, 5, 1));
		wave1.add(new Orc(wave1Start, 7, 1));
		wave1.add(new Goblin(wave1Start +1, 4, 1));
		wave1.add(new Goblin(wave1Start +1, 5, 1));
		wave1.add(new Goblin(wave1Start +1, 6, 1));
		wave1.add(new Goblin(wave1Start +1, 7, 1));
		wave1.add(new Goblin(wave1Start +1, 8, 1));
	}

}
