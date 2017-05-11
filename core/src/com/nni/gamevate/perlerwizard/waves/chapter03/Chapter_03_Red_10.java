package com.nni.gamevate.perlerwizard.waves.chapter03;

import com.nni.gamevate.perlerwizard.object.enemies.basic.Minitaurus;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_03_Red_10 extends Level {

	public Chapter_03_Red_10() {
		super();
		
		
		
		Minitaurus minitaur = new Minitaurus(2.0f, 2.0f, wave1Start, 8, 1);
		
		wave1.add(minitaur);
	}

}
