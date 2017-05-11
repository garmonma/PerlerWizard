package com.nni.gamevate.perlerwizard.waves.chapter03;

import com.nni.gamevate.perlerwizard.object.enemies.basic.Knight;
import com.nni.gamevate.perlerwizard.object.enemies.objects.VisionShield;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_03_KnightBattle_02 extends Level {

	public Chapter_03_KnightBattle_02() {
		super();
		
		
		wave1.add(new Knight(wave1Start, 4, 1));
		wave1.add(new Knight(wave1Start, 5, 1));
		
		wave1.add(new Knight(wave1Start, 6, 1));
		wave1.add(new Knight(wave1Start, 7, 1));
		wave1.add(new Knight(wave1Start, 8, 1));
		
		wave1.add(new VisionShield(wave1Start, 9, 1));
		wave1.add(new VisionShield(wave1Start, 10, 1));
	}

}
