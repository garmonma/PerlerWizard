package com.nni.gamevate.perlerwizard.waves.chapter04;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Mimic;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Pixie;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_04_23 extends Level {

	public Chapter_04_23() {
		super();
		
		goldReward = 100;
		
		Mimic forestMimic01 = new Mimic(wave1Start, 3, 1);
		forestMimic01.setElementType(ElementType.FOREST);
		
		Mimic forestMimic02 = new Mimic(wave1Start, 5, 1);
		forestMimic02.setElementType(ElementType.FOREST);
		
		Mimic forestMimic03 = new Mimic(wave1Start, 7, 1);
		forestMimic03.setElementType(ElementType.FOREST);
		
		Mimic forestMimic04 = new Mimic(wave1Start, 9, 1);
		forestMimic04.setElementType(ElementType.FOREST);
		
		Mimic forestMimic05 = new Mimic(wave1Start, 11, 1);
		forestMimic05.setElementType(ElementType.FOREST);
		
		Pixie waterPixie01 = new Pixie(wave1Start+1, 4, 1);
		waterPixie01.setElementType(ElementType.WATER);
		
		Pixie waterPixie02 = new Pixie(wave1Start+1, 6, 1);
		waterPixie01.setElementType(ElementType.WATER);
		
		Pixie waterPixie03 = new Pixie(wave1Start+1, 8, 1);
		waterPixie01.setElementType(ElementType.WATER);
		
		Pixie waterPixie04 = new Pixie(wave1Start+1, 10, 1);
		waterPixie01.setElementType(ElementType.WATER);
		
		Pixie waterPixie05 = new Pixie(wave1Start+1, 12, 1);
		waterPixie01.setElementType(ElementType.WATER);
		
		wave1.add(forestMimic01);
		wave1.add(forestMimic02);
		wave1.add(forestMimic03);
		wave1.add(forestMimic04);
		wave1.add(forestMimic05);
		wave1.add(waterPixie01);
		wave1.add(waterPixie02);
		wave1.add(waterPixie03);
		wave1.add(waterPixie04);
		wave1.add(waterPixie05);
		//////////////////////////////////////////////////
		
		wave2.add(new Orc(wave2Start, 3, 2));
		wave2.add(new Orc(wave2Start, 5, 2));
		wave2.add(new Orc(wave2Start, 7, 2));
		wave2.add(new Orc(wave2Start, 9, 2));
		wave2.add(new Orc(wave2Start, 11, 2));
		
		wave2.add(new Orc(wave2Start+1, 3, 2));
		wave2.add(new Orc(wave2Start+1, 5, 2));
		wave2.add(new Orc(wave2Start+1, 7, 2));
		wave2.add(new Orc(wave2Start+1, 9, 2));
		wave2.add(new Orc(wave2Start+1, 11, 2));
		
		wave2.add(new Orc(wave2Start+2, 3, 2));
		wave2.add(new Orc(wave2Start+2, 5, 2));
		wave2.add(new Orc(wave2Start+2, 7, 2));
		wave2.add(new Orc(wave2Start+2, 9, 2));
		wave2.add(new Orc(wave2Start+2, 11, 2));
		/////////////////////////////////////
		
		Goblin fireGoblin01 = new Goblin(wave3Start, 3, 3);
		fireGoblin01.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin02 = new Goblin(wave3Start, 5, 3);
		fireGoblin02.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin03 = new Goblin(wave3Start, 7, 3);
		fireGoblin03.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin04 = new Goblin(wave3Start, 9, 3);
		fireGoblin04.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin05 = new Goblin(wave3Start, 11, 3);
		fireGoblin05.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin06 = new Goblin(wave3Start, 13, 3);
		fireGoblin06.setElementType(ElementType.FIRE);
		
		Goblin waterGoblin01 = new Goblin(wave3Start+1, 3, 3);
		waterGoblin01.setElementType(ElementType.WATER);
		
		Goblin waterGoblin02 = new Goblin(wave3Start+1, 5, 3);
		waterGoblin02.setElementType(ElementType.WATER);
		
		Goblin waterGoblin03 = new Goblin(wave3Start+1, 7, 3);
		waterGoblin03.setElementType(ElementType.WATER);
		
		Goblin waterGoblin04 = new Goblin(wave3Start+1, 9, 3);
		waterGoblin04.setElementType(ElementType.WATER);
		
		Goblin waterGoblin05 = new Goblin(wave3Start+1, 11, 3);
		waterGoblin05.setElementType(ElementType.WATER);
		
		Goblin waterGoblin06 = new Goblin(wave3Start+1, 13, 3);
		waterGoblin06.setElementType(ElementType.WATER);
		
		wave3.add(fireGoblin01);
		wave3.add(fireGoblin02);
		wave3.add(fireGoblin03);
		wave3.add(fireGoblin04);
		wave3.add(fireGoblin05);
		wave3.add(fireGoblin06);
		
		wave3.add(waterGoblin01);
		wave3.add(waterGoblin02);
		wave3.add(waterGoblin03);
		wave3.add(waterGoblin04);
		wave3.add(waterGoblin05);
		wave3.add(waterGoblin06);
		
	}
}