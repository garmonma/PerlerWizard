package com.nni.gamevate.pixelwizard.levelloader;

import java.util.Arrays;

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
