package com.nni.gamevate.perlerwizard.waves.chapter04;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Mimic;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Minitaurus;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_04_17 extends Level {

	public Chapter_04_17() {
		super();
		
		goldReward = 100;
		
		Minitaurus forestMinotaur01 = new Minitaurus(1.0f, 1.0f, wave1Start, 3, 1);
		forestMinotaur01.setElementType(ElementType.FOREST);
		
		Minitaurus forestMinotaur02 = new Minitaurus(1.0f, 1.0f, wave1Start, 5, 1);
		forestMinotaur02.setElementType(ElementType.FOREST);
		
		wave1.add(forestMinotaur01);
		wave1.add(forestMinotaur02);
		////////////////////////////////////////////////
		
		Goblin lightningGoblin01 = new Goblin(wave2Start, 3, 2);
		lightningGoblin01.setElementType(ElementType.LIGHTNING);
		
		Goblin lightningGoblin02 = new Goblin(wave2Start, 4, 2);
		lightningGoblin02.setElementType(ElementType.LIGHTNING);
		
		Goblin lightningGoblin03 = new Goblin(wave2Start, 5, 2);
		lightningGoblin03.setElementType(ElementType.LIGHTNING);
		
		wave2.add(lightningGoblin01);
		wave2.add(lightningGoblin02);
		wave2.add(lightningGoblin03);

		//////////////////////////////////////////////////

		Mimic fireMimic01 = new Mimic(wave3Start, 3, 3);
		fireMimic01.setElementType(ElementType.FIRE);
		
		Mimic fireMimic02 = new Mimic(wave3Start, 4, 3);
		fireMimic02.setElementType(ElementType.FIRE);
		
		Mimic fireMimic03 = new Mimic(wave3Start, 5, 3);
		fireMimic03.setElementType(ElementType.FIRE);
		
		Mimic fireMimic04 = new Mimic(wave3Start, 6, 3);
		fireMimic04.setElementType(ElementType.FIRE);
	
		Mimic fireMimic05 = new Mimic(wave3Start, 7, 3);
		fireMimic05.setElementType(ElementType.FIRE);
		
		Mimic fireMimic06 = new Mimic(wave3Start, 8, 3);
		fireMimic06.setElementType(ElementType.FIRE);
		
		Mimic fireMimic07 = new Mimic(wave3Start, 9, 3);
		fireMimic07.setElementType(ElementType.FIRE);
		
		Mimic fireMimic08 = new Mimic(wave3Start, 10, 3);
		fireMimic08.setElementType(ElementType.FIRE);
		
		Mimic fireMimic09 = new Mimic(wave3Start, 11, 3);
		fireMimic09.setElementType(ElementType.FIRE);
		
		Mimic fireMimic10 = new Mimic(wave3Start, 12, 3);
		fireMimic10.setElementType(ElementType.FIRE);

		wave3.add(fireMimic01);
		wave3.add(fireMimic02);
		wave3.add(fireMimic03);
		wave3.add(fireMimic04);
		wave3.add(fireMimic05);
		wave3.add(fireMimic06);
		wave3.add(fireMimic07);
		wave3.add(fireMimic08);
		wave3.add(fireMimic09);
		wave3.add(fireMimic10);
	}
}