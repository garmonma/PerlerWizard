package com.nni.gamevate.perlerwizard.waves.chapter04;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imp;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Mimic;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Minitaurus;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc.OrcType;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_04_22 extends Level {

	public Chapter_04_22() {
		super();
		
		goldReward = 100;
		
		Minitaurus waterMinotaur01 = new Minitaurus(1.0f, 1.0f, wave1Start, 3, 1);
		waterMinotaur01.setElementType(ElementType.WATER);
		
		Minitaurus waterMinotaur02 = new Minitaurus(1.0f, 1.0f, wave1Start, 5, 1);
		waterMinotaur02.setElementType(ElementType.WATER);
		
		Minitaurus waterMinotaur03 = new Minitaurus(1.0f, 1.0f, wave1Start, 7, 1);
		waterMinotaur03.setElementType(ElementType.WATER);
		
		Minitaurus waterMinotaur04 = new Minitaurus(1.0f, 1.0f, wave1Start, 9, 1);
		waterMinotaur04.setElementType(ElementType.WATER);
		
		
		wave1.add(waterMinotaur01);
		wave1.add(waterMinotaur02);
		wave1.add(waterMinotaur03);
		wave1.add(waterMinotaur04);

		//////////////////////////////////////////////////
		
		Imp lightningImp01 = new Imp(wave2Start, 3, 2);
		lightningImp01.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp02 = new Imp(wave2Start, 5, 2);
		lightningImp02.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp03 = new Imp(wave2Start, 7, 2);
		lightningImp03.setElementType(ElementType.LIGHTNING);
		
		Imp lightningImp04 = new Imp(wave2Start, 9, 2);
		lightningImp04.setElementType(ElementType.LIGHTNING);
		
		wave2.add(lightningImp01);
		wave2.add(lightningImp02);
		wave2.add(lightningImp03);
		wave2.add(lightningImp04);
		wave2.add(new Mimic(wave2Start+1, 3, 2));
		wave2.add(new Mimic(wave2Start+1, 5, 2));
		wave2.add(new Mimic(wave2Start+1, 7, 2));
		wave2.add(new Mimic(wave2Start+1, 9, 2));
		
		/////////////////////////////////////
		
		Orc fireFemaleOrc01 = new Orc(wave3Start, 3, 3);
		fireFemaleOrc01.setElementType(ElementType.FIRE);
		fireFemaleOrc01.setOrcType(OrcType.FEMALE);
		
		Orc fireFemaleOrc02 = new Orc(wave3Start, 5, 3);
		fireFemaleOrc02.setElementType(ElementType.FIRE);
		fireFemaleOrc02.setOrcType(OrcType.FEMALE);
		
		Orc fireFemaleOrc03 = new Orc(wave3Start, 7, 3);
		fireFemaleOrc03.setElementType(ElementType.FIRE);
		fireFemaleOrc03.setOrcType(OrcType.FEMALE);

		wave3.add(fireFemaleOrc01);
		wave3.add(fireFemaleOrc02);
		wave3.add(fireFemaleOrc03);
	}
}