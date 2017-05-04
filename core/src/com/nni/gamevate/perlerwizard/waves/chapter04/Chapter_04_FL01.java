package com.nni.gamevate.perlerwizard.waves.chapter04;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Minitaurus;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc.OrcType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Slime;
import com.nni.gamevate.perlerwizard.object.enemies.minibosses.Hydra;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_04_FL01 extends Level {

	public Chapter_04_FL01() {
		super();
		
		Slime waterSlime01 = new Slime(wave1Start, 3, 1);
		waterSlime01.setElementType(ElementType.WATER);
		
		Slime waterSlime02 = new Slime(wave1Start, 4, 1);
		waterSlime02.setElementType(ElementType.WATER);
		
		Slime waterSlime03 = new Slime(wave1Start, 5, 1);
		waterSlime03.setElementType(ElementType.WATER);
		
		Slime waterSlime04 = new Slime(wave1Start, 6, 1);
		waterSlime04.setElementType(ElementType.WATER);
		
		Slime waterSlime05 = new Slime(wave1Start, 7, 1);
		waterSlime05.setElementType(ElementType.WATER);
		
		wave1.add(waterSlime01);
		wave1.add(waterSlime02);
		wave1.add(waterSlime03);
		wave1.add(waterSlime04);
		wave1.add(waterSlime05);
		
		Goblin waterGoblin01 = new Goblin(wave1Start+1, 3, 1);
		waterGoblin01.setElementType(ElementType.WATER);
		
		Goblin waterGoblin02 = new Goblin(wave1Start+1, 4, 1);
		waterGoblin02.setElementType(ElementType.WATER);
		
		Goblin waterGoblin03 = new Goblin(wave1Start+1, 5, 1);
		waterGoblin03.setElementType(ElementType.WATER);
		
		Goblin waterGoblin04 = new Goblin(wave1Start+1, 6, 1);
		waterGoblin04.setElementType(ElementType.WATER);
		
		Goblin waterGoblin05 = new Goblin(wave1Start+1, 7, 1);
		waterGoblin05.setElementType(ElementType.WATER);
		
		wave1.add(waterGoblin01);
		wave1.add(waterGoblin02);
		wave1.add(waterGoblin03);
		wave1.add(waterGoblin04);
		wave1.add(waterGoblin05);
		
		////////////////////////////////////////////////////
		Orc lightningFemaleOrc01 = new Orc(wave2Start, 3, 2);
		lightningFemaleOrc01.setElementType(ElementType.LIGHTNING);
		lightningFemaleOrc01.setOrcType(OrcType.FEMALE);
		
		Orc lightningFemaleOrc02 = new Orc(wave2Start, 5, 2);
		lightningFemaleOrc02.setElementType(ElementType.LIGHTNING);
		lightningFemaleOrc02.setOrcType(OrcType.FEMALE);
		
		Orc lightningFemaleOrc03 = new Orc(wave2Start, 7, 2);
		lightningFemaleOrc03.setElementType(ElementType.LIGHTNING);
		lightningFemaleOrc03.setOrcType(OrcType.FEMALE);
		
		Orc waterOrc01 = new Orc(wave2Start+1, 4, 2);
		waterOrc01.setElementType(ElementType.WATER);
		
		Orc waterOrc02 = new Orc(wave2Start+1, 6, 2);
		waterOrc02.setElementType(ElementType.WATER);
		
		Orc waterOrc03 = new Orc(wave2Start+1, 8, 2);
		waterOrc03.setElementType(ElementType.WATER);
		
		Minitaurus lightningMinotaur01 = new Minitaurus(2.0f, 2.0f, wave2Start, 11, 2);
		lightningMinotaur01.setElementType(ElementType.LIGHTNING);
		
		wave2.add(lightningMinotaur01);
		wave2.add(lightningFemaleOrc01);
		wave2.add(lightningFemaleOrc02);
		wave2.add(lightningFemaleOrc03);
		wave2.add(waterOrc01);
		wave2.add(waterOrc02);
		wave2.add(waterOrc03);
		////////////////////////////////////////////////////
		
		wave3.add(new Hydra(3.0f, 3.0f, wave3Start, 7, 3));
	}

}
