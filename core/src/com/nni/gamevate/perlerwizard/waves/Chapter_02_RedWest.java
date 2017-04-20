package com.nni.gamevate.perlerwizard.waves;

import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;

public class Chapter_02_RedWest extends Level {

	public Chapter_02_RedWest() {
		super();
		
		goldReward = 400;
		itemRewards.add("Orc Axe");
		itemRewards.add("Goblin Hide");

		wave1.add(new Orc(wave1Start, 6, 1));

		wave2.add(new Goblin(wave2Start, 5, 2));
		wave2.add(new Goblin(wave2Start, 6, 2));
		wave2.add(new Goblin(wave2Start, 7, 2));
		wave1.add(new Orc(wave2Start +1, 6, 2));
		
		wave3.add(new Orc(wave3Start, 5, 3));
		wave3.add(new Orc(wave3Start, 6, 3));
		wave3.add(new Orc(wave3Start, 7, 3));
		
	}

}
