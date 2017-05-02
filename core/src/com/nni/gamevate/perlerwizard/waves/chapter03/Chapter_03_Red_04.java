package com.nni.gamevate.perlerwizard.waves.chapter03;

import com.nni.gamevate.perlerwizard.object.enemies.basic.Slime;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_03_Red_04 extends Level {

	public Chapter_03_Red_04() {
		super();
		
		wave1.add(new Slime(wave1Start, 3, 1));
		wave1.add(new Slime(wave1Start, 5, 1));
		wave1.add(new Slime(wave1Start, 7, 1));
		wave1.add(new Slime(wave1Start, 9, 1));
		wave1.add(new Slime(wave1Start, 11, 1));
		wave1.add(new Slime(wave1Start, 12, 1));
	}

}
