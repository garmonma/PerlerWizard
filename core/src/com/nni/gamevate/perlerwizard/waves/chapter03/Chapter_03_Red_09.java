package com.nni.gamevate.perlerwizard.waves.chapter03;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imp;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Mimic;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc.OrcType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Pixie;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_03_Red_09 extends Level {

	public Chapter_03_Red_09() {
		super();
		
		Imp lightningImp01 = new Imp(wave1Start, 4, 1);
		lightningImp01.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp02 = new Imp(wave1Start, 5, 1);
		lightningImp02.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp03 = new Imp(wave1Start, 6, 1);
		lightningImp03.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp04 = new Imp(wave1Start, 7, 1);
		lightningImp04.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp05 = new Imp(wave1Start, 8, 1);
		lightningImp05.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp06 = new Imp(wave1Start, 9, 1);
		lightningImp06.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp07 = new Imp(wave1Start, 10, 1);
		lightningImp07.setElementType(ElementType.LIGHTNING);
		
		wave1.add(lightningImp01);
		wave1.add(lightningImp02);
		wave1.add(lightningImp03);
		wave1.add(lightningImp04);
		wave1.add(lightningImp05);
		wave1.add(lightningImp06);
		wave1.add(lightningImp07);
		
		wave1.add(new Mimic(wave1Start+1, 5, 1));
		wave1.add(new Mimic(wave1Start+1, 7, 1));
		wave1.add(new Mimic(wave1Start+1, 9, 1));
		/////////////////////////////
		
		
		Goblin fireGoblin01 = new Goblin(wave2Start, 3, 2);
		fireGoblin01.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin02 = new Goblin(wave2Start, 5, 2);
		fireGoblin02.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin03 = new Goblin(wave2Start, 7, 2);
		fireGoblin03.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin04 = new Goblin(wave2Start, 9, 2);
		fireGoblin04.setElementType(ElementType.FIRE);
		
		Orc femaleOrc01 = new Orc(wave2Start +2, 3, 2);
		femaleOrc01.setOrcType(OrcType.FEMALE);
		
		Orc femaleOrc02 = new Orc(wave2Start +2, 5, 2);
		femaleOrc02.setOrcType(OrcType.FEMALE);
		
		Orc femaleOrc03 = new Orc(wave2Start +2, 7, 2);
		femaleOrc03.setOrcType(OrcType.FEMALE);
		
		wave2.add(femaleOrc01);
		wave2.add(femaleOrc02);
		wave2.add(femaleOrc03);
		wave2.add(fireGoblin01);
		wave2.add(fireGoblin02);
		wave2.add(fireGoblin03);
		wave2.add(fireGoblin04);
		////////////////////////////////
		
		Pixie waterPixie01 = new Pixie(wave3Start+1, 5, 3);
		waterPixie01.setElementType(ElementType.WATER);
		
		wave3.add(waterPixie01);
		wave3.add(new Orc(wave3Start, 3, 3));
		wave3.add(new Orc(wave3Start, 4, 3));
		wave3.add(new Orc(wave3Start, 5, 3));
		wave3.add(new Orc(wave3Start, 6, 3));
		wave3.add(new Orc(wave3Start, 7, 3));
		wave3.add(new Orc(wave3Start, 8, 3));
		wave3.add(new Orc(wave3Start, 9, 3));
	}

}
