package com.nni.gamevate.perlerwizard.waves.chapter04;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Minitaurus;
import com.nni.gamevate.perlerwizard.object.enemies.minibosses.Hydra;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_04_FR03 extends Level {

	public Chapter_04_FR03() {
		super();
		
		wave1.add(new Hydra(3.0f, 3.0f, wave1Start, 7, 1));
		
		////////////////////////////////////////////////////
		
		wave2.add(new Hydra(3.0f, 3.0f, wave2Start, 7, 2));
		////////////////////////////////////////////////////
		
		Minitaurus lightningMinotaur01 = new Minitaurus(2.0f, 2.0f, wave3Start, 3, 3);
		lightningMinotaur01.setElementType(ElementType.LIGHTNING);
		
		Minitaurus lightningMinotaur02 = new Minitaurus(2.0f, 2.0f, wave3Start+2, 5, 3);
		lightningMinotaur02.setElementType(ElementType.LIGHTNING);
		
		Minitaurus lightningMinotaur03 = new Minitaurus(2.0f, 2.0f, wave3Start, 7, 3);
		lightningMinotaur03.setElementType(ElementType.LIGHTNING);
		
		Minitaurus lightningMinotaur04 = new Minitaurus(2.0f, 2.0f, wave3Start+2, 9, 3);
		lightningMinotaur04.setElementType(ElementType.LIGHTNING);
		
		Minitaurus lightningMinotaur05 = new Minitaurus(2.0f, 2.0f, wave3Start, 11, 3);
		lightningMinotaur05.setElementType(ElementType.LIGHTNING);
		
		wave3.add(lightningMinotaur01);
		wave3.add(lightningMinotaur02);
		wave3.add(lightningMinotaur03);
		wave3.add(lightningMinotaur04);
		wave3.add(lightningMinotaur05);
	}

}
