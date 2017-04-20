package com.nni.gamevate.perlerwizard.waves;

import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;

public class Chapter_02_RedEast extends Level {

	public Chapter_02_RedEast() {
		super();
		
		goldReward = 300;
		itemRewards.add("Goblin Hide");
		itemRewards.add("Goblin Hide");
		itemRewards.add("Goblin Ear");
		itemRewards.add("Goblin Ear");
		
		wave1.add(new Goblin(wave1Start, 5, 1));
		wave1.add(new Goblin(wave1Start, 6, 1));
		wave1.add(new Goblin(wave1Start, 7, 1));
		
		wave2.add(new Goblin(wave2Start, 5, 2));
		wave2.add(new Goblin(wave2Start, 6, 2));
		wave2.add(new Goblin(wave2Start, 7, 2));
		wave2.add(new Goblin(wave2Start, 8, 2));
		wave2.add(new Goblin(wave2Start, 9, 2));
		
		wave3.add(new Goblin(wave3Start, 5, 3));
		wave3.add(new Goblin(wave3Start, 6, 3));
		wave3.add(new Goblin(wave3Start, 7, 3));
		wave3.add(new Goblin(wave3Start, 8, 3));
		wave3.add(new Goblin(wave3Start, 9, 3));
		wave3.add(new Goblin(wave3Start +1, 5, 3));
		wave3.add(new Goblin(wave3Start +1, 6, 3));
		wave3.add(new Goblin(wave3Start +1, 7, 3));
		wave3.add(new Goblin(wave3Start +1, 8, 3));
		wave3.add(new Goblin(wave3Start +1, 9, 3));
		
	}

}
