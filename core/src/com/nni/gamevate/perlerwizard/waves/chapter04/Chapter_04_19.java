package com.nni.gamevate.perlerwizard.waves.chapter04;

import com.nni.gamevate.perlerwizard.object.enemies.Enemy.ElementType;
import com.nni.gamevate.perlerwizard.object.enemies.basic.Minitaurus;
import com.nni.gamevate.perlerwizard.waves.Level;

public class Chapter_04_19 extends Level {

	public Chapter_04_19() {
		super();
		
		goldReward = 100;
		
		Minitaurus fireMinotaur01 = new Minitaurus(1.0f, 1.0f, wave1Start, 3, 1);
		fireMinotaur01.setElementType(ElementType.FIRE);
		
		Minitaurus fireMinotaur02 = new Minitaurus(1.0f, 1.0f, wave1Start, 5, 1);
		fireMinotaur02.setElementType(ElementType.FIRE);
		
		Minitaurus fireMinotaur03 = new Minitaurus(1.0f, 1.0f, wave1Start, 7, 1);
		fireMinotaur03.setElementType(ElementType.FIRE);
		
		Minitaurus fireMinotaur04 = new Minitaurus(1.0f, 1.0f, wave1Start, 9, 1);
		fireMinotaur04.setElementType(ElementType.FIRE);
		
		Minitaurus fireMinotaur05 = new Minitaurus(1.0f, 1.0f, wave1Start, 11, 1);
		fireMinotaur05.setElementType(ElementType.FIRE);
		
		wave1.add(fireMinotaur01);
		wave1.add(fireMinotaur02);
		wave1.add(fireMinotaur03);
		wave1.add(fireMinotaur04);
		wave1.add(fireMinotaur05);
	}
}