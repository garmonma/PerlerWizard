package com.nni.gamevate.perlerwizard.waves.chapter01;

import com.nni.gamevate.perlerwizard.object.enemies.basic.Knight;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_01_04 extends Level {

	public Chapter_01_04() {
		super();
		
		wave1.add(new Knight(wave1Start, 5, 1));
		wave1.add(new Knight(wave1Start, 7, 1));
		wave1.add(new Knight(wave1Start, 9, 1));
	}

}
