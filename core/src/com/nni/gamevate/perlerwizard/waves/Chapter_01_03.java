package com.nni.gamevate.perlerwizard.waves;

import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imp;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Pixie;

public class Chapter_01_03 extends Level {

	public Chapter_01_03() {
		super();
		
		goldReward = 100;
		
		itemRewards.add("Imp Leavings");
		
		wave1.add(new Goblin(wave1Start, 4, 1));
		wave1.add(new Goblin(wave1Start, 6, 1));
		wave1.add(new Goblin(wave1Start, 8, 1));
		wave1.add(new Pixie(wave1Start + 2, 5, 1));
		wave1.add(new Pixie(wave1Start + 2, 7, 1));
		wave1.add(new Imp(wave1Start + 1, 6, 1));
	}

}
