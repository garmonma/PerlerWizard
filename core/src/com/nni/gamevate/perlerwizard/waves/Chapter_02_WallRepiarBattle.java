package com.nni.gamevate.perlerwizard.waves;

import com.nni.gamevate.perlerwizard.object.enemies.basic.Goblin;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imp;

public class Chapter_02_WallRepiarBattle extends Level {

	public Chapter_02_WallRepiarBattle() {
	
		//This battle will be randomized
		
		int random = 0;
		
		switch(random){
		case 1:
			
			goldReward = 100;
			
			wave1.add(new Goblin(wave1Start, 3, 1));
			wave1.add(new Goblin(wave1Start, 4, 1));
			wave1.add(new Goblin(wave1Start, 5, 1));
			wave1.add(new Goblin(wave1Start, 6, 1));
			break;
			
			
		case 2:
			
			goldReward = 125;
			
			wave1.add(new Goblin(wave1Start, 3, 1));
			wave1.add(new Goblin(wave1Start, 4, 1));
			wave1.add(new Goblin(wave1Start, 5, 1));
			wave1.add(new Goblin(wave1Start, 6, 1));
			wave1.add(new Goblin(wave1Start, 7, 1));
			wave1.add(new Imp(wave1Start +1, 4, 1));
			break;
			
			
		case 3:
			
			goldReward = 150;
			
			wave1.add(new Goblin(wave1Start, 3, 1));
			wave1.add(new Goblin(wave1Start, 4, 1));
			wave1.add(new Goblin(wave1Start, 5, 1));
			wave1.add(new Goblin(wave1Start, 6, 1));
			wave1.add(new Goblin(wave1Start, 7, 1));
			wave1.add(new Goblin(wave1Start, 8, 1));
			wave1.add(new Goblin(wave1Start, 9, 1));

			break;
			
			
			
		}
		
	}

}
