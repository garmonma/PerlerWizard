package com.nni.gamevate.perlerwizard.waves.chapter05;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Minitaurus;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc.OrcType;
import com.nni.gamevate.perlerwizard.object.enemies.minibosses.Hydra;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter05_Battle_S01P01 extends Level {

	public Chapter05_Battle_S01P01() {
		super();
		
		Minitaurus fireMinitaur01 = new Minitaurus(3.0f, 3.0f, wave1Start, 3, 1);
		fireMinitaur01.setElementType(ElementType.FIRE);
		
		Minitaurus fireMinitaur02 = new Minitaurus(3.0f, 3.0f, wave1Start, 5, 1);
		fireMinitaur02.setElementType(ElementType.FIRE);
		
		Minitaurus fireMinitaur03 = new Minitaurus(3.0f, 3.0f, wave1Start, 7, 1);
		fireMinitaur03.setElementType(ElementType.FIRE);
		
		Orc waterOrc01 = new Orc(wave1Start, 9, 1);
		waterOrc01.setElementType(ElementType.WATER);
		
		Orc waterOrc02 = new Orc(wave1Start, 10, 1);
		waterOrc02.setElementType(ElementType.WATER);
		
		Orc waterOrc03 = new Orc(wave1Start, 11, 1);
		waterOrc03.setElementType(ElementType.WATER);
		
		Goblin forestGoblin01 = new Goblin(wave1Start-1, 3, 1);
		forestGoblin01.setElementType(ElementType.FOREST);
		
		Goblin forestGoblin02 = new Goblin(wave1Start-1, 5, 1);
		forestGoblin02.setElementType(ElementType.FOREST);
		
		Goblin forestGoblin03 = new Goblin(wave1Start-1, 7, 1);
		forestGoblin03.setElementType(ElementType.FOREST);
		
		Goblin forestGoblin04 = new Goblin(wave1Start-1, 9, 1);
		forestGoblin04.setElementType(ElementType.FOREST);
		
		Goblin forestGoblin05 = new Goblin(wave1Start-1, 10, 1);
		forestGoblin05.setElementType(ElementType.FOREST);
		
		Goblin forestGoblin06 = new Goblin(wave1Start-1, 11, 1);
		forestGoblin06.setElementType(ElementType.FOREST);
		
		wave1.add(fireMinitaur01);
		wave1.add(fireMinitaur02);
		wave1.add(fireMinitaur03);
		wave1.add(waterOrc01);
		wave1.add(waterOrc02);
		wave1.add(waterOrc03);
		wave1.add(forestGoblin01);
		wave1.add(forestGoblin02);
		wave1.add(forestGoblin03);
		wave1.add(forestGoblin04);
		wave1.add(forestGoblin05);
		wave1.add(forestGoblin06);
		//////////////////////////////////////////////////////
		
		Orc femaleOrc01 = new Orc(wave2Start-0.2f, 4, 2);
		femaleOrc01.setOrcType(OrcType.FEMALE);
		
		Orc femaleOrc02 = new Orc(wave2Start-0.2f, 6, 2);
		femaleOrc02.setOrcType(OrcType.FEMALE);
		
		Orc femaleOrc03 = new Orc(wave2Start-0.2f, 8, 2);
		femaleOrc03.setOrcType(OrcType.FEMALE);
		
		Orc femaleOrc04 = new Orc(wave2Start-0.2f, 10, 2);
		femaleOrc04.setOrcType(OrcType.FEMALE);
		
		Orc femaleOrc05 = new Orc(wave2Start-0.2f, 12, 2);
		femaleOrc05.setOrcType(OrcType.FEMALE);
		
		Orc femaleOrc06 = new Orc(wave2Start+1, 4, 2);
		femaleOrc06.setOrcType(OrcType.FEMALE);
		
		Orc femaleOrc07 = new Orc(wave2Start+1, 6, 2);
		femaleOrc07.setOrcType(OrcType.FEMALE);
		
		Orc femaleOrc08 = new Orc(wave2Start+1, 8, 2);
		femaleOrc08.setOrcType(OrcType.FEMALE);
		
		Orc femaleOrc09 = new Orc(wave2Start+1, 10, 2);
		femaleOrc09.setOrcType(OrcType.FEMALE);
		
		Orc femaleOrc10 = new Orc(wave2Start+1, 12, 2);
		femaleOrc10.setOrcType(OrcType.FEMALE);
		
		Orc femaleOrc11 = new Orc(wave2Start+2, 4, 2);
		femaleOrc11.setOrcType(OrcType.FEMALE);
		
		Orc femaleOrc12 = new Orc(wave2Start+2, 6, 2);
		femaleOrc12.setOrcType(OrcType.FEMALE);
		
		Orc femaleOrc13 = new Orc(wave2Start+2, 8, 2);
		femaleOrc13.setOrcType(OrcType.FEMALE);
		
		Orc femaleOrc14 = new Orc(wave2Start+2, 10, 2);
		femaleOrc14.setOrcType(OrcType.FEMALE);
		
		Orc femaleOrc15 = new Orc(wave2Start+2, 12, 2);
		femaleOrc15.setOrcType(OrcType.FEMALE);
		
		wave2.add(femaleOrc01);
		wave2.add(femaleOrc02);
		wave2.add(femaleOrc03);
		wave2.add(femaleOrc04);
		wave2.add(femaleOrc05);
		wave2.add(femaleOrc06);
		wave2.add(femaleOrc07);
		wave2.add(femaleOrc08);
		wave2.add(femaleOrc09);
		wave2.add(femaleOrc10);
		wave2.add(femaleOrc11);
		wave2.add(femaleOrc12);
		wave2.add(femaleOrc13);
		wave2.add(femaleOrc14);
		wave2.add(femaleOrc15);
		//////////////////////////////////////////////////
		
		wave3.add(new Hydra(3.0f, 3.0f, wave3Start, 7, 3));
	}
}