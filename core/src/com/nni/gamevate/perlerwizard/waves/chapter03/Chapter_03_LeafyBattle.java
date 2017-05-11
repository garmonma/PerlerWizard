package com.nni.gamevate.perlerwizard.waves.chapter03;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imp;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Pixie;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Orc.OrcType;
import com.nni.gamevate.perlerwizard.object.enemies.minibosses.Ent;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_03_LeafyBattle extends Level {

	public Chapter_03_LeafyBattle() {
		// Wave 1: 3 Water Imps, Female Orc Wave 2: 2 Lightning Pixies, 2 Goblins Wave 3: Oakwood Ent
		
		
		goldReward = 100;
		itemRewards.add("Goblin Ear");
		
		Imp waterImp1 = new Imp(wave1Start, 4, 1);
		waterImp1.setElementType(ElementType.WATER);
		
		Imp waterImp2 = new Imp(wave1Start, 5, 1);
		waterImp2.setElementType(ElementType.WATER);
		
		Imp waterImp3 = new Imp(wave1Start, 6, 1);
		waterImp3.setElementType(ElementType.WATER);
		
		Orc femaleOrc01 = new Orc(wave1Start+2, 5, 1);
		femaleOrc01.setOrcType(OrcType.FEMALE);
		
		wave1.add(waterImp1);
		wave1.add(waterImp2);
		wave1.add(waterImp3);
		wave1.add(femaleOrc01);
		
		
		Pixie waterPixieOne = new Pixie(wave2Start, 5, 2);
		waterPixieOne.setElementType(ElementType.WATER);
		
		Pixie waterPixieTwo = new Pixie(wave2Start, 6, 2);
		waterPixieTwo.setElementType(ElementType.WATER);
		
		wave2.add(waterPixieOne);
		wave2.add(waterPixieTwo);
		
		wave2.add(new Goblin(wave2Start +1, 4, 2));
		wave2.add(new Goblin(wave2Start +1, 6, 2));
		
		Ent ent = new Ent(wave3Start, 8, 3);
		ent.setHealth(50);
		
		wave3.add(ent);
	}

}
