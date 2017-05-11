package com.nni.gamevate.perlerwizard.waves.chapter04;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imp;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc.OrcType;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_04_0610 extends Level {

	public Chapter_04_0610() {
		super();
		
		goldReward = 100;
		
		Orc lightningFemaleOrc01 = new Orc(wave1Start, 3, 1);
		lightningFemaleOrc01.setElementType(ElementType.LIGHTNING);
		lightningFemaleOrc01.setOrcType(OrcType.FEMALE);
		
		Orc lightningFemaleOrc02 = new Orc(wave1Start, 5, 1);
		lightningFemaleOrc02.setElementType(ElementType.LIGHTNING);
		lightningFemaleOrc02.setOrcType(OrcType.FEMALE);
		
		Orc lightningFemaleOrc03 = new Orc(wave1Start, 7, 1);
		lightningFemaleOrc03.setElementType(ElementType.LIGHTNING);
		lightningFemaleOrc03.setOrcType(OrcType.FEMALE);
		
		Orc lightningFemaleOrc04 = new Orc(wave1Start, 9, 1);
		lightningFemaleOrc04.setElementType(ElementType.LIGHTNING);
		lightningFemaleOrc04.setOrcType(OrcType.FEMALE);
		
		Orc lightningFemaleOrc05 = new Orc(wave1Start, 11, 1);
		lightningFemaleOrc05.setElementType(ElementType.LIGHTNING);
		lightningFemaleOrc05.setOrcType(OrcType.FEMALE);
		
		wave1.add(lightningFemaleOrc01);
		wave1.add(lightningFemaleOrc02);
		wave1.add(lightningFemaleOrc03);
		wave1.add(lightningFemaleOrc04);
		wave1.add(lightningFemaleOrc05);
		////////////////////////////////////////////////
		
		Imp fireImp01 = new Imp(wave2Start, 3, 2);
		fireImp01.setElementType(ElementType.FIRE);
		
		Imp fireImp02 = new Imp(wave2Start, 5, 2);
		fireImp02.setElementType(ElementType.FIRE);
		
		Imp fireImp03 = new Imp(wave2Start, 7, 2);
		fireImp03.setElementType(ElementType.FIRE);
		
		wave2.add(fireImp01);
		wave2.add(fireImp02);
		wave2.add(fireImp03);
		//////////////////////////////////////////////////
		
	}
}