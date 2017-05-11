package com.nni.gamevate.perlerwizard.waves.chapter04;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imp;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Pixie;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_04_20 extends Level {

	public Chapter_04_20() {
		super();
		
		goldReward = 100;
		
		Imp forestImp01 = new Imp(wave1Start, 3, 1);
		forestImp01.setElementType(ElementType.FOREST);
		
		Imp forestImp02 = new Imp(wave1Start, 5, 1);
		forestImp02.setElementType(ElementType.FOREST);
		
		Imp forestImp03 = new Imp(wave1Start, 7, 1);
		forestImp03.setElementType(ElementType.FOREST);
		
		Imp forestImp04 = new Imp(wave1Start, 9, 1);
		forestImp04.setElementType(ElementType.FOREST);
		
		Imp forestImp05 = new Imp(wave1Start, 11, 1);
		forestImp05.setElementType(ElementType.FOREST);
		
		wave1.add(forestImp01);
		wave1.add(forestImp02);
		wave1.add(forestImp03);
		wave1.add(forestImp04);
		wave1.add(forestImp05);

		//////////////////////////////////////////////////

		Pixie waterPixie01 = new Pixie(wave2Start, 3, 2);
		waterPixie01.setElementType(ElementType.WATER);
		
		Pixie waterPixie02 = new Pixie(wave2Start, 5, 2);
		waterPixie02.setElementType(ElementType.WATER);
		
		Pixie waterPixie03 = new Pixie(wave2Start, 7, 2);
		waterPixie03.setElementType(ElementType.WATER);
		
		Pixie waterPixie04 = new Pixie(wave2Start, 9, 2);
		waterPixie04.setElementType(ElementType.WATER);
		
		Pixie waterPixie05 = new Pixie(wave2Start, 11, 2);
		waterPixie05.setElementType(ElementType.WATER);
		
		wave2.add(waterPixie01);
		wave2.add(waterPixie02);
		wave2.add(waterPixie03);
		wave2.add(waterPixie04);
		wave2.add(waterPixie05);
		
		/////////////////////////////////////
		
		Orc waterOrc01 = new Orc(wave3Start, 3, 3);
		waterOrc01.setElementType(ElementType.WATER);
		
		Orc waterOrc02 = new Orc(wave3Start, 5, 3);
		waterOrc02.setElementType(ElementType.WATER);
		
		Orc waterOrc03 = new Orc(wave3Start, 7, 3);
		waterOrc03.setElementType(ElementType.WATER);

		wave3.add(waterOrc01);
		wave3.add(waterOrc02);
		wave3.add(waterOrc03);
	}
}