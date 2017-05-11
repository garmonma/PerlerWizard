package com.nni.gamevate.perlerwizard.waves.chapter03;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc.OrcType;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_03_Red_03 extends Level {

	public Chapter_03_Red_03() {
		super();
		
		goldReward = 200;
		
		Goblin fireGoblin01 = new Goblin(wave1Start, 4, 1);
		fireGoblin01.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin02 = new Goblin(wave1Start, 6, 1);
		fireGoblin02.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin03 = new Goblin(wave1Start, 8, 1);
		fireGoblin03.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin04 = new Goblin(wave1Start, 10, 1);
		fireGoblin04.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin05 = new Goblin(wave1Start, 12, 1);
		fireGoblin05.setElementType(ElementType.FIRE);
		
		Orc femaleOrc = new Orc(wave1Start +2, 8, 1);
		femaleOrc.setOrcType(OrcType.FEMALE);
		
		wave1.add(fireGoblin01);
		wave1.add(fireGoblin02);
		wave1.add(fireGoblin03);
		wave1.add(fireGoblin04);
		wave1.add(fireGoblin05);
		wave1.add(femaleOrc);
	}

}
