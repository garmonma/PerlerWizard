package com.nni.gamevate.perlerwizard.waves.chapter04;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imp;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;
import com.nni.gamevate.perlerwizard.object.enemies.minibosses.Hydra;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc.OrcType;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_04_24 extends Level {

	public Chapter_04_24() {
		super();
		
		goldReward = 100;
		
		Imp fireImp01 = new Imp(wave1Start, 3, 1);
		fireImp01.setElementType(ElementType.FIRE);
		
		Imp fireImp02 = new Imp(wave1Start, 3, 1);
		fireImp02.setElementType(ElementType.FIRE);
		
		Imp fireImp03 = new Imp(wave1Start, 3, 1);
		fireImp03.setElementType(ElementType.FIRE);
		
		Orc waterFemaleOrc01 = new Orc(wave1Start+1, 3, 1);
		waterFemaleOrc01.setElementType(ElementType.WATER);
		waterFemaleOrc01.setOrcType(OrcType.FEMALE);
		
		Orc waterFemaleOrc02 = new Orc(wave1Start+1, 5, 1);
		waterFemaleOrc02.setElementType(ElementType.WATER);
		waterFemaleOrc02.setOrcType(OrcType.FEMALE);
		
		Orc waterFemaleOrc03 = new Orc(wave1Start+1, 7, 1);
		waterFemaleOrc03.setElementType(ElementType.WATER);
		waterFemaleOrc03.setOrcType(OrcType.FEMALE);
		
		Orc waterFemaleOrc04 = new Orc(wave1Start+1, 9, 1);
		waterFemaleOrc04.setElementType(ElementType.WATER);
		waterFemaleOrc04.setOrcType(OrcType.FEMALE);
			
		wave1.add(fireImp01);
		wave1.add(fireImp02);
		wave1.add(fireImp03);
		wave1.add(waterFemaleOrc01);
		wave1.add(waterFemaleOrc02);
		wave1.add(waterFemaleOrc03);
		wave1.add(waterFemaleOrc04);
		//////////////////////////////////////////////////
		
		wave2.add(new Goblin(wave2Start, 3, 2));
		wave2.add(new Goblin(wave2Start, 5, 2));
		wave2.add(new Goblin(wave2Start, 7, 2));
		wave2.add(new Goblin(wave2Start, 9, 2));
		wave2.add(new Goblin(wave2Start, 11, 2));
		
		wave2.add(new Goblin(wave2Start+1, 3, 2));
		wave2.add(new Goblin(wave2Start+1, 5, 2));
		wave2.add(new Goblin(wave2Start+1, 7, 2));
		wave2.add(new Goblin(wave2Start+1, 9, 2));
		wave2.add(new Goblin(wave2Start+1, 11, 2));
		
		wave2.add(new Goblin(wave2Start+2, 3, 2));
		wave2.add(new Goblin(wave2Start+2, 5, 2));
		wave2.add(new Goblin(wave2Start+2, 7, 2));
		wave2.add(new Goblin(wave2Start+2, 9, 2));
		wave2.add(new Goblin(wave2Start+2, 11, 2));
		
		wave2.add(new Goblin(wave2Start+3, 3, 2));
		wave2.add(new Goblin(wave2Start+3, 5, 2));
		wave2.add(new Goblin(wave2Start+3, 7, 2));
		wave2.add(new Goblin(wave2Start+3, 9, 2));
		wave2.add(new Goblin(wave2Start+3, 11, 2));
		/////////////////////////////////////////////////////
		
		wave3.add(new Hydra(3.0f, 3.0f, wave1Start, 7, 3));
	}
}