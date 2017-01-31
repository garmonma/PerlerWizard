package com.nni.gamevate.perlerwizard.network.gamedata;

import java.util.Arrays;


/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class Row {
	
	private int[] positions;

	public Row(){
		positions = new int[8];
	}
	
	public int[] getPositions(){
		return positions;
	}
	
	public void setPositions(int[] positions){
		this.positions = positions;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return String.format("Row [positions=%s]", positions != null
				? Arrays.toString(Arrays.copyOf(positions, Math.min(positions.length, maxLen))) : null);
	}
	
	
}
