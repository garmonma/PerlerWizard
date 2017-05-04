package com.nni.gamevate.perlerwizard.waves.chapter04;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imp;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Slime;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc.OrcType;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_04_18 extends Level {

	public Chapter_04_18() {
		super();
		
		goldReward = 100;
		
		Slime forestSlime01 = new Slime(wave1Start, 3, 1);
		forestSlime01.setElementType(ElementType.FOREST);
		
		Slime forestSlime02 = new Slime(wave1Start, 5, 1);
		forestSlime02.setElementType(ElementType.FOREST);
		
		Slime forestSlime03 = new Slime(wave1Start, 7, 1);
		forestSlime03.setElementType(ElementType.FOREST);
		
		Slime forestSlime04 = new Slime(wave1Start, 9, 1);
		forestSlime04.setElementType(ElementType.FOREST);
		
		wave1.add(forestSlime01);
		wave1.add(forestSlime02);
		wave1.add(forestSlime03);
		wave1.add(forestSlime04);
		////////////////////////////////////////////////
		
		Imp forestImp01 = new Imp(wave2Start, 3, 2);
		forestImp01.setElementType(ElementType.FOREST);
		
		Imp forestImp02 = new Imp(wave2Start, 5, 2);
		forestImp02.setElementType(ElementType.FOREST);
		
		Imp forestImp03 = new Imp(wave2Start, 7, 2);
		forestImp03.setElementType(ElementType.FOREST);
		
		Imp forestImp04 = new Imp(wave2Start, 9, 2);
		forestImp04.setElementType(ElementType.FOREST);
		
		wave2.add(forestImp01);
		wave2.add(forestImp02);
		wave2.add(forestImp03);
		wave2.add(forestImp04);

		//////////////////////////////////////////////////

		Orc forestFemaleOrc01 = new Orc(wave3Start, 3, 3);
		forestFemaleOrc01.setElementType(ElementType.FOREST);
		forestFemaleOrc01.setOrcType(OrcType.FEMALE);
		
		Orc forestFemaleOrc02 = new Orc(wave3Start, 5, 3);
		forestFemaleOrc02.setElementType(ElementType.FOREST);
		forestFemaleOrc02.setOrcType(OrcType.FEMALE);
		
		Orc forestFemaleOrc03 = new Orc(wave3Start, 7, 3);
		forestFemaleOrc03.setElementType(ElementType.FOREST);
		forestFemaleOrc03.setOrcType(OrcType.FEMALE);
		
		wave3.add(forestFemaleOrc01);
		wave3.add(forestFemaleOrc02);
		wave3.add(forestFemaleOrc03);
	}
}