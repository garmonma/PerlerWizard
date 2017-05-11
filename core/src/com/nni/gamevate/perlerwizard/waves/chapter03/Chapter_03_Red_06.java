package com.nni.gamevate.perlerwizard.waves.chapter03;

import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc.OrcType;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_03_Red_06 extends Level {

	public Chapter_03_Red_06() {
		super();
		
		
		
		Orc femaleOrc01 = new Orc(wave1Start +2, 3, 1);
		femaleOrc01.setOrcType(OrcType.FEMALE);
		
		Orc femaleOrc02 = new Orc(wave1Start +2, 5, 1);
		femaleOrc02.setOrcType(OrcType.FEMALE);
		
		Orc femaleOrc03 = new Orc(wave1Start +2, 7, 1);
		femaleOrc03.setOrcType(OrcType.FEMALE);
		
		wave1.add(femaleOrc01);
		wave1.add(femaleOrc02);
		wave1.add(femaleOrc03);
		wave1.add(new Orc(wave1Start, 3, 1));
		wave1.add(new Orc(wave1Start, 5, 1));
		wave1.add(new Orc(wave1Start, 7, 1));
	}

}
