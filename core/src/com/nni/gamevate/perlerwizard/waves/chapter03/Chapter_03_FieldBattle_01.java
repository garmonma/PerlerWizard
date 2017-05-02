package com.nni.gamevate.perlerwizard.waves.chapter03;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imp;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_03_FieldBattle_01 extends Level {

	public Chapter_03_FieldBattle_01() {
		super();
		
		itemRewards.add("Fire Goblin Scalp");
		itemRewards.add("Imp Leavings");
		itemRewards.add("Imp Leavings");
		itemRewards.add("Imp Leavings");
		
		Goblin fireGoblin01 = new Goblin(wave1Start, 4, 1);
		fireGoblin01.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin02 = new Goblin(wave1Start, 6, 1);
		fireGoblin02.setElementType(ElementType.FIRE);
		
		Goblin fireGoblin03 = new Goblin(wave1Start, 8, 1);
		fireGoblin03.setElementType(ElementType.FIRE);
		
		wave1.add(fireGoblin01);
		wave1.add(fireGoblin02);
		wave1.add(fireGoblin03);

		wave1.add(new Imp(wave1Start +1, 5, 1));
		wave1.add(new Imp(wave1Start +1, 6, 1));
		wave1.add(new Imp(wave1Start +1, 7, 1));
		wave1.add(new Imp(wave1Start +1, 8, 1));
		wave1.add(new Imp(wave1Start +1, 9, 1));
		wave1.add(new Imp(wave1Start +2, 5, 1));
		wave1.add(new Imp(wave1Start +2, 6, 1));
		wave1.add(new Imp(wave1Start +2, 7, 1));
		wave1.add(new Imp(wave1Start +2, 8, 1));
		wave1.add(new Imp(wave1Start +2, 9, 1));
	}
}
