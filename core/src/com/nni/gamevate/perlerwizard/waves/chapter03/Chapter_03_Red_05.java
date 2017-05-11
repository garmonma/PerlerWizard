package com.nni.gamevate.perlerwizard.waves.chapter03;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imp;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Mimic;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_03_Red_05 extends Level {

	public Chapter_03_Red_05() {
		super();
		
		Imp lightningImp01 = new Imp(wave1Start -1, 4, 1);
		lightningImp01.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp02 = new Imp(wave1Start -1, 6, 1);
		lightningImp02.setElementType(ElementType.LIGHTNING);
		
		wave1.add(new Orc(wave1Start, 3, 1));
		wave1.add(new Orc(wave1Start, 5, 1));
		wave1.add(new Orc(wave1Start, 7, 1));
		wave1.add(new Orc(wave1Start, 9, 1));
		
		wave1.add(lightningImp01);
		wave1.add(lightningImp02);
		
		wave1.add(new Mimic(wave1Start+1, 5, 1));
		wave1.add(new Mimic(wave1Start+1, 7, 1));
		wave1.add(new Mimic(wave1Start+1, 9, 1));
	}

}
