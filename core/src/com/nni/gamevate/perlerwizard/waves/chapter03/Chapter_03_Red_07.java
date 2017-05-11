package com.nni.gamevate.perlerwizard.waves.chapter03;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imp;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Mimic;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc.OrcType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Pixie;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_03_Red_07 extends Level {

	public Chapter_03_Red_07() {
		super();
		
		Goblin fireGoblin01 = new Goblin(wave1Start, 5, 1);
		fireGoblin01.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin02 = new Goblin(wave1Start, 7, 1);
		fireGoblin02.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin03 = new Goblin(wave1Start, 9, 1);
		fireGoblin03.setElementType(ElementType.FIRE);
		
		wave1.add(fireGoblin01);
		wave1.add(fireGoblin02);
		wave1.add(fireGoblin03);
		wave1.add(new Mimic(wave1Start+1, 5, 1));
		wave1.add(new Mimic(wave1Start+1, 7, 1));
		wave1.add(new Mimic(wave1Start+1, 9, 1));
		
		//////////////////////
		
		Imp lightningImp01 = new Imp(wave2Start, 3, 2);
		lightningImp01.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp02= new Imp(wave2Start, 4, 2);
		lightningImp02.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp03 = new Imp(wave2Start, 5, 2);
		lightningImp03.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp04 = new Imp(wave2Start, 6, 2);
		lightningImp01.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp05= new Imp(wave2Start, 7, 2);
		lightningImp02.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp06 = new Imp(wave2Start, 8, 2);
		lightningImp03.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp07 = new Imp(wave2Start, 9, 2);
		lightningImp03.setElementType(ElementType.LIGHTNING);
		
		Pixie waterPixie01 = new Pixie(wave2Start+1, 3, 2);
		waterPixie01.setElementType(ElementType.WATER);
		
		Pixie waterPixie02 = new Pixie(wave2Start+1, 5, 2);
		waterPixie02.setElementType(ElementType.WATER);
		
		Pixie waterPixie03 = new Pixie(wave2Start+1, 7, 2);
		waterPixie01.setElementType(ElementType.WATER);
		
		Pixie waterPixie04 = new Pixie(wave2Start+1, 9, 2);
		waterPixie02.setElementType(ElementType.WATER);
		
		Pixie waterPixie05 = new Pixie(wave2Start+1, 11, 2);
		waterPixie01.setElementType(ElementType.WATER);
		
		wave2.add(lightningImp01);
		wave2.add(lightningImp02);
		wave2.add(lightningImp03);
		wave2.add(lightningImp04);
		wave2.add(lightningImp05);
		wave2.add(lightningImp06);
		wave2.add(lightningImp07);

		wave2.add(waterPixie01);
		wave2.add(waterPixie02);
		wave2.add(waterPixie03);
		wave2.add(waterPixie04);
		wave2.add(waterPixie05);
		
		
		////////////////
		
		Goblin fireGoblin04 = new Goblin(wave3Start, 4, 3);
		fireGoblin01.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin05 = new Goblin(wave3Start, 6, 3);
		fireGoblin02.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin06 = new Goblin(wave3Start, 8, 3);
		fireGoblin03.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin07 = new Goblin(wave3Start, 10, 3);
		fireGoblin04.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin08 = new Goblin(wave3Start, 12, 3);
		fireGoblin05.setElementType(ElementType.FIRE);
		
		Orc femaleOrc01 = new Orc(wave3Start +2, 4, 3);
		femaleOrc01.setOrcType(OrcType.FEMALE);
		
		Orc femaleOrc02 = new Orc(wave3Start +2, 6, 3);
		femaleOrc02.setOrcType(OrcType.FEMALE);
		
		Orc femaleOrc03 = new Orc(wave3Start +2, 8, 3);
		femaleOrc03.setOrcType(OrcType.FEMALE);
		
		wave3.add(fireGoblin04);
		wave3.add(fireGoblin05);
		wave3.add(fireGoblin06);
		wave3.add(fireGoblin07);
		wave3.add(fireGoblin08);
		wave3.add(femaleOrc01);
		wave3.add(femaleOrc02);
		wave3.add(femaleOrc03);
		
		wave3.add(new Orc(wave3Start+1, 3, 3));
		wave3.add(new Orc(wave3Start+1, 5, 3));
		wave3.add(new Orc(wave3Start+1, 7, 3));
		wave3.add(new Orc(wave3Start+1, 9, 3));
		wave3.add(new Orc(wave3Start+1, 11, 3));
		
	}

}
