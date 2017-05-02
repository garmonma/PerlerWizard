package com.nni.gamevate.perlerwizard.waves.chapter04;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Mimic;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Minitaurus;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_04_1115 extends Level {

	public Chapter_04_1115() {
		super();
		
		goldReward = 450;
		
		wave1.add(new Minitaurus(1.0f, 1.0f, wave1Start, 5, 1));
		wave1.add(new Minitaurus(1.0f, 1.0f, wave1Start, 8, 1));
		
		////////////////////////////////////////////////
		
		Mimic fireMimic01 = new Mimic(wave2Start+1, 3, 2);
		fireMimic01.setElementType(ElementType.FIRE);
		
		Mimic fireMimic02 = new Mimic(wave2Start+1, 5, 2);
		fireMimic02.setElementType(ElementType.FIRE);
		
		Mimic fireMimic03 = new Mimic(wave2Start+1, 7, 2);
		fireMimic03.setElementType(ElementType.FIRE);
		
		Goblin waterGoblin01 = new Goblin(wave2Start, 4, 2);
		waterGoblin01.setElementType(ElementType.WATER);
		
		Goblin waterGoblin02 = new Goblin(wave2Start, 6, 2);
		waterGoblin02.setElementType(ElementType.WATER);
		
		wave2.add(fireMimic01);
		wave2.add(fireMimic02);
		wave2.add(fireMimic03);
		wave2.add(waterGoblin01);
		wave2.add(waterGoblin02);
		//////////////////////////////////////////////////

	}
}