package com.nni.gamevate.perlerwizard.waves.chapter04;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Minitaurus;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc.OrcType;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_04_FR01 extends Level {

	public Chapter_04_FR01() {
		super();
		
		Orc waterFemaleOrc01 = new Orc(wave1Start, 5, 1);
		waterFemaleOrc01.setElementType(ElementType.WATER);
		waterFemaleOrc01.setOrcType(OrcType.FEMALE);
		
		Orc waterFemaleOrc02 = new Orc(wave1Start, 7, 1);
		waterFemaleOrc02.setElementType(ElementType.WATER);
		waterFemaleOrc02.setOrcType(OrcType.FEMALE);
		
		Orc waterFemaleOrc03 = new Orc(wave1Start, 9, 1);
		waterFemaleOrc03.setElementType(ElementType.WATER);
		waterFemaleOrc03.setOrcType(OrcType.FEMALE);
		
		Orc waterFemaleOrc04 = new Orc(wave1Start+1, 6, 1);
		waterFemaleOrc04.setElementType(ElementType.WATER);
		waterFemaleOrc04.setOrcType(OrcType.FEMALE);
		
		Orc waterFemaleOrc05 = new Orc(wave1Start+1, 8, 1);
		waterFemaleOrc05.setElementType(ElementType.WATER);
		waterFemaleOrc05.setOrcType(OrcType.FEMALE);
		
		Orc waterFemaleOrc06 = new Orc(wave1Start+1, 10, 1);
		waterFemaleOrc06.setElementType(ElementType.WATER);
		waterFemaleOrc06.setOrcType(OrcType.FEMALE);
		
		Orc lightningOrc01 = new Orc(wave1Start+2, 3, 1);
		lightningOrc01.setElementType(ElementType.LIGHTNING);
		
		Orc lightningOrc02 = new Orc(wave1Start+2, 3, 1);
		lightningOrc01.setElementType(ElementType.LIGHTNING);
		
		Orc lightningOrc03 = new Orc(wave1Start+2, 3, 1);
		lightningOrc01.setElementType(ElementType.LIGHTNING);
		
		Orc lightningOrc04 = new Orc(wave1Start+2, 3, 1);
		lightningOrc01.setElementType(ElementType.LIGHTNING);
		
		Orc lightningOrc05 = new Orc(wave1Start+2, 3, 1);
		lightningOrc01.setElementType(ElementType.LIGHTNING);
		
		Orc lightningOrc06 = new Orc(wave1Start+2, 3, 1);
		lightningOrc01.setElementType(ElementType.LIGHTNING);
	
		wave1.add(waterFemaleOrc01);
		wave1.add(waterFemaleOrc02);
		wave1.add(waterFemaleOrc03);
		wave1.add(waterFemaleOrc04);
		wave1.add(waterFemaleOrc05);
		wave1.add(waterFemaleOrc06);
		
		wave1.add(lightningOrc01);
		wave1.add(lightningOrc02);
		wave1.add(lightningOrc03);
		wave1.add(lightningOrc04);
		wave1.add(lightningOrc05);
		wave1.add(lightningOrc06);
		////////////////////////////////////////////////////
		
		Minitaurus waterMinotaur01 = new Minitaurus(1.0f, 1.0f, wave2Start, 5, 2);
		waterMinotaur01.setElementType(ElementType.WATER);
		
		Minitaurus waterMinotaur02 = new Minitaurus(1.0f, 1.0f, wave2Start, 7, 2);
		waterMinotaur02.setElementType(ElementType.WATER);
		
		Minitaurus waterMinotaur03 = new Minitaurus(1.0f, 1.0f, wave2Start, 9, 2);
		waterMinotaur03.setElementType(ElementType.WATER);
		
		wave2.add(waterMinotaur01);
		wave2.add(waterMinotaur02);
		wave2.add(waterMinotaur03);
		////////////////////////////////////////////////////
		
		
		wave3.add(new Orc(wave3Start-1, 3, 3));
		wave3.add(new Orc(wave3Start-1, 5, 3));
		wave3.add(new Orc(wave3Start-1, 7, 3));
		wave3.add(new Orc(wave3Start-1, 9, 3));
		wave3.add(new Orc(wave3Start-1, 11, 3));
		
		wave3.add(new Orc(wave3Start+1, 2, 3));
		wave3.add(new Orc(wave3Start+1, 4, 3));
		wave3.add(new Orc(wave3Start+1, 6, 3));
		wave3.add(new Orc(wave3Start+1, 8, 3));
		wave3.add(new Orc(wave3Start+1, 10, 3));
		
		
		wave3.add(new Orc(wave3Start+2, 3, 3));
		wave3.add(new Orc(wave3Start+2, 5, 3));
		wave3.add(new Orc(wave3Start+2, 7, 3));
		wave3.add(new Orc(wave3Start+2, 9, 3));
		wave3.add(new Orc(wave3Start+2, 11, 3));
		
		
		wave3.add(new Orc(wave3Start+3, 2, 3));
		wave3.add(new Orc(wave3Start+3, 4, 3));
		wave3.add(new Orc(wave3Start+3, 6, 3));
		wave3.add(new Orc(wave3Start+3, 8, 3));
		wave3.add(new Orc(wave3Start+3, 10, 3));
		
		
		
	}

}
