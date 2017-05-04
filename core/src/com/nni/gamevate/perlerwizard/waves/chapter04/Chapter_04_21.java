package com.nni.gamevate.perlerwizard.waves.chapter04;

import com.nni.gamevate.perlerwizard.object.enemies.minibosses.Hydra;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_04_21 extends Level {

	public Chapter_04_21() {
		super();
		
		goldReward = 150;
		
		wave1.add(new Hydra(3, 3, wave1Start, 7, 1));
		
	}
}