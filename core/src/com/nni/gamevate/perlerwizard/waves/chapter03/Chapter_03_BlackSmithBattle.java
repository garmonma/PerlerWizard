package com.nni.gamevate.perlerwizard.waves.chapter03;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Pixie;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_03_BlackSmithBattle extends Level {

	public Chapter_03_BlackSmithBattle() {
		super();
		
		goldReward = 550;
		
		itemRewards.add("Fire Goblin Scalp");
		itemRewards.add("Vision Shield Recovery");
		itemRewards.add("orc Axe");
		
		Goblin fireGoblin01 = new Goblin(wave1Start, 4, 1);
		fireGoblin01.setElementType(ElementType.FIRE);
		
		wave1.add(fireGoblin01);
		wave1.add(new Orc(wave1Start, 5, 1));
		wave1.add(new Orc(wave1Start, 6, 1));
		wave1.add(new Orc(wave1Start, 7, 1));
		wave1.add(new Orc(wave1Start, 8, 1));
		
		wave1.add(new Pixie(wave1Start + 1, 6, 1));
	}

}
