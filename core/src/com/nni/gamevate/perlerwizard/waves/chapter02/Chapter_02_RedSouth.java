package com.nni.gamevate.perlerwizard.waves.chapter02;

import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imp;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Mimic;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Pixie;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_02_RedSouth extends Level {

	public Chapter_02_RedSouth() {
		super();
		
		goldReward = 500;
		itemRewards.add("Orc Axe");
		itemRewards.add("Imp Leavings");
		itemRewards.add("Mimic Teeth");
		itemRewards.add("Mimic Teeth");
		itemRewards.add("Mimic Teeth");
		itemRewards.add("Pixie Dust");
		itemRewards.add("Pixie Dust");
		
		wave1.add(new Pixie(wave1Start, 4, 1));
		wave1.add(new Pixie(wave1Start, 5, 1));
		wave1.add(new Pixie(wave1Start, 6, 1));
		wave1.add(new Pixie(wave1Start, 7, 1));
		wave1.add(new Pixie(wave1Start, 8, 1));
		wave1.add(new Mimic(wave1Start +1, 6, 1));
		
		wave2.add(new Orc(wave2Start, 5, 2));
		wave2.add(new Orc(wave2Start, 7, 2));
		wave2.add(new Orc(wave2Start, 9, 2));
		wave2.add(new Imp(wave2Start +1, 6, 2));
		wave2.add(new Imp(wave2Start +1, 8, 2));
		
		
		
		wave3.add(new Goblin(wave3Start, 3, 3));
		wave3.add(new Goblin(wave3Start, 4, 3));
		wave3.add(new Goblin(wave3Start, 6, 3));
		
		wave3.add(new Mimic(wave3Start +1, 3, 3));
		wave3.add(new Mimic(wave3Start +1, 5, 3));

		wave3.add(new Orc(wave3Start +2, 6, 3));
		wave3.add(new Orc(wave3Start +2, 7, 3));
	}

}
