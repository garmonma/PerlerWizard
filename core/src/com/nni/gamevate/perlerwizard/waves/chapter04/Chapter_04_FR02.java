package com.nni.gamevate.perlerwizard.waves.chapter04;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imp;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Mimic;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Minitaurus;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Slime;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_04_FR02 extends Level {

	public Chapter_04_FR02() {
		super();
		
		Mimic forestMimic01 = new Mimic(wave1Start, 3, 1);
		forestMimic01.setElementType(ElementType.FOREST);
		
		Mimic forestMimic02 = new Mimic(wave1Start, 5, 1);
		forestMimic02.setElementType(ElementType.FOREST);
		
		Mimic forestMimic03 = new Mimic(wave1Start, 7, 1);
		forestMimic03.setElementType(ElementType.FOREST);
		
		Mimic forestMimic04 = new Mimic(wave1Start, 9, 1);
		forestMimic04.setElementType(ElementType.FOREST);
		
		Mimic forestMimic05 = new Mimic(wave1Start, 11, 1);
		forestMimic05.setElementType(ElementType.FOREST);
		
		wave1.add(forestMimic01);
		wave1.add(forestMimic02);
		wave1.add(forestMimic03);
		wave1.add(forestMimic04);
		wave1.add(forestMimic05);
		
		Goblin waterGoblin01 = new Goblin(wave1Start-1, 5, 1);
		waterGoblin01.setElementType(ElementType.WATER);
		
		Goblin waterGoblin02 = new Goblin(wave1Start-1, 7, 1);
		waterGoblin02.setElementType(ElementType.WATER);
		
		Goblin waterGoblin03 = new Goblin(wave1Start-1, 9, 1);
		waterGoblin03.setElementType(ElementType.WATER);
		
		wave1.add(waterGoblin01);
		wave1.add(waterGoblin02);
		wave1.add(waterGoblin03);
		////////////////////////////////////////////////////
		
		Minitaurus lightningMinotaur01 = new Minitaurus(1.0f, 1.0f, wave2Start, 5, 2);
		lightningMinotaur01.setElementType(ElementType.LIGHTNING);
		
		Minitaurus lightningMinotaur02 = new Minitaurus(1.0f, 1.0f, wave2Start, 7, 2);
		lightningMinotaur02.setElementType(ElementType.LIGHTNING);
		
		Minitaurus lightningMinotaur03 = new Minitaurus(1.0f, 1.0f, wave2Start, 9, 2);
		lightningMinotaur03.setElementType(ElementType.LIGHTNING);
		
		Minitaurus lightningMinotaur04 = new Minitaurus(1.0f, 1.0f, wave2Start, 9, 2);
		lightningMinotaur04.setElementType(ElementType.LIGHTNING);
		
		wave2.add(lightningMinotaur01);
		wave2.add(lightningMinotaur02);
		wave2.add(lightningMinotaur03);
		wave2.add(lightningMinotaur04);
		////////////////////////////////////////////////////
		
		wave3.add(new Imp(wave3Start-1, 3, 3));
		wave3.add(new Imp(wave3Start-1, 5, 3));
		wave3.add(new Imp(wave3Start-1, 7, 3));
		wave3.add(new Imp(wave3Start-1, 9, 3));
		wave3.add(new Imp(wave3Start-1, 11, 3));
		
		wave3.add(new Imp(wave3Start+1, 2, 3));
		wave3.add(new Imp(wave3Start+1, 4, 3));
		wave3.add(new Imp(wave3Start+1, 6, 3));
		wave3.add(new Imp(wave3Start+1, 8, 3));
		wave3.add(new Imp(wave3Start+1, 10, 3));
		
		Slime forestSlime01 = new Slime(wave3Start-2, 2, 3);
		forestSlime01.setElementType(ElementType.FOREST);
		
		Slime forestSlime02 = new Slime(wave3Start-2, 4, 3);
		forestSlime02.setElementType(ElementType.FOREST);
		
		Slime forestSlime03 = new Slime(wave3Start-2, 6, 3);
		forestSlime03.setElementType(ElementType.FOREST);
		
		Slime forestSlime04 = new Slime(wave3Start-2, 8, 3);
		forestSlime04.setElementType(ElementType.FOREST);
		
		Slime forestSlime05 = new Slime(wave3Start-2, 10, 3);
		forestSlime05.setElementType(ElementType.FOREST);
		
		Slime forestSlime06 = new Slime(wave3Start+2, 3, 3);
		forestSlime06.setElementType(ElementType.FOREST);
		
		Slime forestSlime07 = new Slime(wave3Start+2, 5, 3);
		forestSlime07.setElementType(ElementType.FOREST);
		
		Slime forestSlime08 = new Slime(wave3Start+2, 7, 3);
		forestSlime08.setElementType(ElementType.FOREST);
		
		Slime forestSlime09 = new Slime(wave3Start+2, 9, 3);
		forestSlime09.setElementType(ElementType.FOREST);
		
		Slime forestSlime10 = new Slime(wave3Start+2, 11, 3);
		forestSlime10.setElementType(ElementType.FOREST);
		
		
		wave3.add(forestSlime01);
		wave3.add(forestSlime02);
		wave3.add(forestSlime03);
		wave3.add(forestSlime04);
		wave3.add(forestSlime05);
		wave3.add(forestSlime06);
		wave3.add(forestSlime07);
		wave3.add(forestSlime08);
		wave3.add(forestSlime09);
		wave3.add(forestSlime10);
	}

}
