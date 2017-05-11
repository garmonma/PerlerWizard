package com.nni.gamevate.perlerwizard.waves.chapter01;

import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_01_02 extends Level {

	public Chapter_01_02() {
		super();
		
		goldReward = 100;
		
		itemRewards.add("Goblin Ear");
		
		wave1.add(new Goblin(wave1Start, 3, 1));
		wave1.add(new Goblin(wave1Start, 4, 1));
		wave1.add(new Goblin(wave1Start, 5, 1));
		wave1.add(new Goblin(wave1Start, 6, 1));
		wave1.add(new Goblin(wave1Start, 7, 1));
	}

}
