package com.nni.gamevate.perlerwizard.waves.chapter04;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Pixie;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Slime;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_04_0105 extends Level {

	public Chapter_04_0105() {
		super();
		
		goldReward = 75;
		
		Slime waterSlime01 = new Slime(wave1Start, 3, 1);
		waterSlime01.setElementType(ElementType.WATER);
		
		Slime waterSlime02 = new Slime(wave1Start, 5, 1);
		waterSlime01.setElementType(ElementType.WATER);
		
		Slime waterSlime03 = new Slime(wave1Start, 7, 1);
		waterSlime01.setElementType(ElementType.WATER);
		
		wave1.add(waterSlime01);
		wave1.add(waterSlime02);
		wave1.add(waterSlime03);
		////////////////////////////////////////////////
		
		Pixie lightningPixie01 = new Pixie(wave2Start, 3, 2);
		lightningPixie01.setElementType(ElementType.LIGHTNING);
		
		Pixie lightningPixie02 = new Pixie(wave2Start, 5, 2);
		lightningPixie02.setElementType(ElementType.LIGHTNING);
		
		Pixie lightningPixie03 = new Pixie(wave2Start, 7, 2);
		lightningPixie03.setElementType(ElementType.LIGHTNING);
		
		Pixie lightningPixie04 = new Pixie(wave2Start, 9, 2);
		lightningPixie04.setElementType(ElementType.LIGHTNING);
		
		wave2.add(lightningPixie01);
		wave2.add(lightningPixie02);
		wave2.add(lightningPixie03);
		wave2.add(lightningPixie04);
		//////////////////////////////////////////////////
		
		Goblin forestGoblin01 = new Goblin(wave2Start+1, 3, 2);
		forestGoblin01.setElementType(ElementType.FOREST);
		
		Goblin forestGoblin02 = new Goblin(wave2Start+1, 5, 2);
		forestGoblin02.setElementType(ElementType.FOREST);
		
		Goblin forestGoblin03 = new Goblin(wave2Start+1, 7, 2);
		forestGoblin03.setElementType(ElementType.FOREST);
		
		Goblin forestGoblin04 = new Goblin(wave2Start+1, 9, 2);
		forestGoblin04.setElementType(ElementType.FOREST);
		
		wave2.add(forestGoblin01);
		wave2.add(forestGoblin02);
		wave2.add(forestGoblin03);
		wave2.add(forestGoblin04);
	}
}