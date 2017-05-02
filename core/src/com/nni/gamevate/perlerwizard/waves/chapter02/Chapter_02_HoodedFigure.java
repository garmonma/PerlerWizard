package com.nni.gamevate.perlerwizard.waves.chapter02;

import com.nni.gamevate.perlerwizard.object.enemies.basic.HoodedFigure;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imp;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Pixie;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_02_HoodedFigure extends Level {

	public Chapter_02_HoodedFigure() {
		super();
		
		// This battle will have random Imps and Pixies throughout the chase. 
		// The player will scroll for one minute until he catches the hooded figure
		// The player doesn't have to kill the Imps or pixies until the final battle.

		wave1.add(new Pixie(wave1Start, 5, 1));
		wave1.add(new Pixie(wave1Start+1, 4, 1));
		wave1.add(new Pixie(wave1Start+2, 3, 1));
		wave1.add(new Pixie(wave1Start+3, 4, 1));
		wave1.add(new Pixie(wave1Start+4, 5, 1));
		
		wave1.add(new HoodedFigure(wave1Start+2, 6, 1));
		
		wave1.add(new Imp(wave1Start, 7, 1));
		wave1.add(new Imp(wave1Start+1, 8, 1));
		wave1.add(new Imp(wave1Start+2, 9, 1));
		wave1.add(new Imp(wave1Start+3, 8, 1));
		wave1.add(new Imp(wave1Start+4, 7, 1));
	}

}
