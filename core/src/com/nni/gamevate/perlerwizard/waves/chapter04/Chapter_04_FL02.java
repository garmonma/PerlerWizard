package com.nni.gamevate.perlerwizard.waves.chapter04;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imp;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_04_FL02 extends Level {

	public Chapter_04_FL02() {
		super();
		
		Imp waterImp01 = new Imp(wave1Start, 3, 1);
		waterImp01.setElementType(ElementType.WATER);
		
		Imp waterImp02 = new Imp(wave1Start, 4, 1);
		waterImp02.setElementType(ElementType.WATER);
		
		Imp waterImp03 = new Imp(wave1Start, 5, 1);
		waterImp03.setElementType(ElementType.WATER);
		
		Imp waterImp04 = new Imp(wave1Start, 6, 1);
		waterImp04.setElementType(ElementType.WATER);
		
		Imp waterImp05 = new Imp(wave1Start, 7, 1);
		waterImp05.setElementType(ElementType.WATER);
		
		Imp waterImp06 = new Imp(wave1Start, 8, 1);
		waterImp06.setElementType(ElementType.WATER);
	
		Imp waterImp07 = new Imp(wave1Start, 9, 1);
		waterImp07.setElementType(ElementType.WATER);
		
		Imp waterImp08 = new Imp(wave1Start, 10, 1);
		waterImp08.setElementType(ElementType.WATER);
		
		Imp waterImp09 = new Imp(wave1Start, 11, 1);
		waterImp09.setElementType(ElementType.WATER);
		
		Imp waterImp10 = new Imp(wave1Start, 2, 1);
		waterImp10.setElementType(ElementType.WATER);
		
		/////////////////////////////////////////
		Imp forestImp01 = new Imp(wave1Start+1, 3, 1);
		forestImp01.setElementType(ElementType.FOREST);
		
		Imp forestImp02 = new Imp(wave1Start+1, 4, 1);
		forestImp02.setElementType(ElementType.FOREST);
		
		Imp forestImp03 = new Imp(wave1Start+1, 5, 1);
		forestImp03.setElementType(ElementType.FOREST);
		
		Imp forestImp04 = new Imp(wave1Start+1, 6, 1);
		forestImp04.setElementType(ElementType.FOREST);
		
		Imp forestImp05 = new Imp(wave1Start+1, 7, 1);
		forestImp05.setElementType(ElementType.FOREST);
		
		Imp forestImp06 = new Imp(wave1Start+1, 8, 1);
		forestImp06.setElementType(ElementType.FOREST);
	
		Imp forestImp07 = new Imp(wave1Start+1, 9, 1);
		forestImp07.setElementType(ElementType.FOREST);
		
		Imp forestImp08 = new Imp(wave1Start+1, 10, 1);
		forestImp08.setElementType(ElementType.FOREST);
		
		Imp forestImp09 = new Imp(wave1Start+1, 11, 1);
		forestImp09.setElementType(ElementType.FOREST);
		
		Imp forestImp10 = new Imp(wave1Start+1, 2, 1);
		forestImp10.setElementType(ElementType.FOREST);
		
		///////////////////////////////////////
		Imp lightningImp01 = new Imp(wave1Start+2, 3, 1);
		lightningImp01.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp02 = new Imp(wave1Start+2, 4, 1);
		lightningImp02.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp03 = new Imp(wave1Start+2, 5, 1);
		lightningImp03.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp04 = new Imp(wave1Start+2, 6, 1);
		lightningImp04.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp05 = new Imp(wave1Start+2, 7, 1);
		lightningImp05.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp06 = new Imp(wave1Start+2, 8, 1);
		lightningImp06.setElementType(ElementType.LIGHTNING);
	
		Imp lightningImp07 = new Imp(wave1Start+2, 9, 1);
		lightningImp07.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp08 = new Imp(wave1Start+2, 10, 1);
		lightningImp08.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp09 = new Imp(wave1Start+2, 11, 1);
		lightningImp09.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp10 = new Imp(wave1Start+2, 2, 1);
		lightningImp10.setElementType(ElementType.LIGHTNING);
		
		wave1.add(waterImp01);
		wave1.add(waterImp02);
		wave1.add(waterImp03);
		wave1.add(waterImp04);
		wave1.add(waterImp05);
		wave1.add(waterImp06);
		wave1.add(waterImp07);
		wave1.add(waterImp08);
		wave1.add(waterImp09);
		wave1.add(waterImp10);
		
		wave1.add(forestImp01);
		wave1.add(forestImp02);
		wave1.add(forestImp03);
		wave1.add(forestImp04);
		wave1.add(forestImp05);
		wave1.add(forestImp06);
		wave1.add(forestImp07);
		wave1.add(forestImp08);
		wave1.add(forestImp09);
		wave1.add(forestImp10);
		
		wave1.add(lightningImp01);
		wave1.add(lightningImp02);
		wave1.add(lightningImp03);
		wave1.add(lightningImp04);
		wave1.add(lightningImp05);
		wave1.add(lightningImp06);
		wave1.add(lightningImp07);
		wave1.add(lightningImp08);
		wave1.add(lightningImp09);
		wave1.add(lightningImp10);
	}

}
