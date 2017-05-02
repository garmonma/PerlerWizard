package com.nni.gamevate.perlerwizard.waves.chapter04;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Pixie;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc.OrcType;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_04_16 extends Level {

	public Chapter_04_16() {
		super();
		
		goldReward = 75;
		
		Orc waterFemaleOrc01 = new Orc(wave1Start, 3, 1);
		waterFemaleOrc01.setElementType(ElementType.WATER);
		waterFemaleOrc01.setOrcType(OrcType.FEMALE);
		
		Orc waterFemaleOrc02 = new Orc(wave1Start, 5, 1);
		waterFemaleOrc02.setElementType(ElementType.WATER);
		waterFemaleOrc02.setOrcType(OrcType.FEMALE);
		
		Orc waterFemaleOrc03 = new Orc(wave1Start, 7, 1);
		waterFemaleOrc03.setElementType(ElementType.WATER);
		waterFemaleOrc03.setOrcType(OrcType.FEMALE);
		
		Orc waterFemaleOrc04 = new Orc(wave1Start, 9, 1);
		waterFemaleOrc04.setElementType(ElementType.WATER);
		waterFemaleOrc04.setOrcType(OrcType.FEMALE);;
		
		wave1.add(waterFemaleOrc01);
		wave1.add(waterFemaleOrc02);
		wave1.add(waterFemaleOrc03);
		wave1.add(waterFemaleOrc04);
		////////////////////////////////////////////////
		
		Pixie lightningPixie01 = new Pixie(wave2Start, 3, 2);
		lightningPixie01.setElementType(ElementType.LIGHTNING);
		
		Pixie lightningPixie02 = new Pixie(wave2Start, 4, 2);
		lightningPixie02.setElementType(ElementType.LIGHTNING);
		
		Pixie lightningPixie03 = new Pixie(wave2Start, 5, 2);
		lightningPixie03.setElementType(ElementType.LIGHTNING);
		
		Pixie lightningPixie04 = new Pixie(wave2Start, 6, 2);
		lightningPixie04.setElementType(ElementType.LIGHTNING);
		
		Pixie lightningPixie05 = new Pixie(wave2Start, 7, 2);
		lightningPixie05.setElementType(ElementType.LIGHTNING);
		
		Pixie lightningPixie06 = new Pixie(wave2Start, 8, 2);
		lightningPixie06.setElementType(ElementType.LIGHTNING);
		
		Pixie lightningPixie07 = new Pixie(wave2Start, 9, 2);
		lightningPixie07.setElementType(ElementType.LIGHTNING);
		
		wave2.add(lightningPixie01);
		wave2.add(lightningPixie02);
		wave2.add(lightningPixie03);
		wave2.add(lightningPixie04);
		wave2.add(lightningPixie05);
		wave2.add(lightningPixie06);
		wave2.add(lightningPixie07);
		//////////////////////////////////////////////////

		Goblin waterGoblin01 = new Goblin(wave3Start, 3, 3);
		waterGoblin01.setElementType(ElementType.WATER);
		
		Goblin waterGoblin02 = new Goblin(wave3Start, 3, 4);
		waterGoblin02.setElementType(ElementType.WATER);
		
		Goblin waterGoblin03 = new Goblin(wave3Start, 3, 5);
		waterGoblin03.setElementType(ElementType.WATER);
		
		Goblin waterGoblin04 = new Goblin(wave3Start, 3, 6);
		waterGoblin04.setElementType(ElementType.WATER);
		
		Goblin waterGoblin05 = new Goblin(wave3Start, 3, 7);
		waterGoblin05.setElementType(ElementType.WATER);
		
		Goblin waterGoblin06 = new Goblin(wave3Start, 3, 8);
		waterGoblin06.setElementType(ElementType.WATER);
		
		Goblin waterGoblin07 = new Goblin(wave3Start, 3, 9);
		waterGoblin07.setElementType(ElementType.WATER);
		
		Goblin waterGoblin08 = new Goblin(wave3Start, 3, 10);
		waterGoblin08.setElementType(ElementType.WATER);
		
		wave3.add(waterGoblin01);
		wave3.add(waterGoblin02);
		wave3.add(waterGoblin03);
		wave3.add(waterGoblin04);
		wave3.add(waterGoblin05);
		wave3.add(waterGoblin06);
		wave3.add(waterGoblin07);
		wave3.add(waterGoblin08);
	}
}