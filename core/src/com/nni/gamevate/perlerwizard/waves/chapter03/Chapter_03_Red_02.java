package com.nni.gamevate.perlerwizard.waves.chapter03;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Imp;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Pixie;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_03_Red_02 extends Level {

	public Chapter_03_Red_02() {
		super();
		
		goldReward = 200;
		
		Imp lightningImp01 = new Imp(wave1Start, 4, 1);
		lightningImp01.setElementType(ElementType.FIRE);
		
		Imp lightningImp02= new Imp(wave1Start, 6, 1);
		lightningImp02.setElementType(ElementType.FIRE);
		
		Imp lightningImp03 = new Imp(wave1Start, 8, 1);
		lightningImp03.setElementType(ElementType.FIRE);
		
		Pixie waterPixie01 = new Pixie(wave1Start, 5, 1);
		waterPixie01.setElementType(ElementType.WATER);
		
		Pixie waterPixie02 = new Pixie(wave1Start, 7, 1);
		waterPixie02.setElementType(ElementType.WATER);
		
		wave1.add(lightningImp01);
		wave1.add(lightningImp02);
		wave1.add(lightningImp03);
		wave1.add(waterPixie01);
		wave1.add(waterPixie02);
	}

}
