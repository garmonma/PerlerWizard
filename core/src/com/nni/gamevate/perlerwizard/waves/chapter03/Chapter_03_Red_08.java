package com.nni.gamevate.perlerwizard.waves.chapter03;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imp;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Pixie;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_03_Red_08 extends Level {

	public Chapter_03_Red_08() {
		super();
		
		Imp linghtningImp01 = new Imp(wave1Start, 5, 1);
		linghtningImp01.setElementType(ElementType.LIGHTNING);
		
		wave1.add(linghtningImp01);
		/////////////////////
		
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
		
		Pixie waterPixie06 = new Pixie(wave2Start, 4, 2);
		waterPixie06.setElementType(ElementType.WATER);
		
		Pixie waterPixie07 = new Pixie(wave2Start, 6, 2);
		waterPixie07.setElementType(ElementType.WATER);
		
		Pixie waterPixie08 = new Pixie(wave2Start, 8, 2);
		waterPixie08.setElementType(ElementType.WATER);
		
		Pixie waterPixie09 = new Pixie(wave2Start, 10, 2);
		waterPixie09.setElementType(ElementType.WATER);
		
		Pixie waterPixie10 = new Pixie(wave2Start, 12, 2);
		waterPixie10.setElementType(ElementType.WATER);
		
		wave2.add(waterPixie01);
		wave2.add(waterPixie02);
		wave2.add(waterPixie03);
		wave2.add(waterPixie04);
		wave2.add(waterPixie05);
		wave2.add(waterPixie06);
		wave2.add(waterPixie07);
		wave2.add(waterPixie08);
		wave2.add(waterPixie09);
		wave2.add(waterPixie10);
		////////////////////////////////
		
		
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
		
		Goblin fireGoblin06 = new Goblin(wave3Start, 4, 3);
		fireGoblin06.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin07 = new Goblin(wave3Start, 6, 3);
		fireGoblin07.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin08 = new Goblin(wave3Start, 8, 3);
		fireGoblin08.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin09 = new Goblin(wave3Start, 10, 3);
		fireGoblin09.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin10 = new Goblin(wave3Start, 12, 3);
		fireGoblin10.setElementType(ElementType.FIRE);
		
		wave3.add(fireGoblin01);
		wave3.add(fireGoblin02);
		wave3.add(fireGoblin03);
		wave3.add(fireGoblin04);
		wave3.add(fireGoblin05);
		wave3.add(fireGoblin06);
		wave3.add(fireGoblin07);
		wave3.add(fireGoblin08);
		wave3.add(fireGoblin09);
		wave3.add(fireGoblin10);
		
	}

}
