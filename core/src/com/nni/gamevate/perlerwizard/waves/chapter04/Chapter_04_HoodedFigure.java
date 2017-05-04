package com.nni.gamevate.perlerwizard.waves.chapter04;

import com.nni.gamevate.perlerwizard.object.enemies.basic.HoodedFigure;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_04_HoodedFigure extends Level {

	public Chapter_04_HoodedFigure() {
		super();
		
		wave1.add(new HoodedFigure(wave1Start, 7, 1));
	}

}
