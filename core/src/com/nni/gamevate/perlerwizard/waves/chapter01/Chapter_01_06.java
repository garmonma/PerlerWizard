package com.nni.gamevate.perlerwizard.waves.chapter01;

import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imp;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_01_06 extends Level {

	public Chapter_01_06() {
		super();
		
		goldReward = 175;
		
		itemRewards.add("Goblin Ear");
		itemRewards.add("Goblin Ear");
		itemRewards.add("Imp Leavings");
		
		wave1.add(new Goblin(wave1Start, 3, 1));
		wave1.add(new Goblin(wave1Start, 4, 1));
		wave1.add(new Goblin(wave1Start, 5, 1));
		wave1.add(new Goblin(wave1Start, 6, 1));
		wave1.add(new Goblin(wave1Start, 7, 1));
		wave1.add(new Goblin(wave1Start, 8, 1));
		wave1.add(new Goblin(wave1Start, 9, 1));
		
		wave1.add(new Imp(wave1Start +1, 5, 1));
		wave1.add(new Imp(wave1Start +1, 6, 1));
		wave1.add(new Imp(wave1Start +1, 7, 1));
	}

}
