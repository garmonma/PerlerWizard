package com.nni.gamevate.pixelwizard.levelloader;

import java.util.ArrayList;
import java.util.List;

public class Level {
	
	private List<Wave> waves = new ArrayList<Wave>();
	private int timeLimit;
	
	public Level(){
		
	}
	
	public List<Wave> getWaves(){
		return waves;
	}
	
	public void setWaves(List<Wave> waves){
		this.waves = waves;
	}
	
	public int getTimeLimit(){
		return timeLimit;
	}
	
	public void setTimeLimit(int timeLimit){
		this.timeLimit = timeLimit;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return String.format("Level [waves=%s, timeLimit=%s]",
				waves != null ? waves.subList(0, Math.min(waves.size(), maxLen)) : null, timeLimit);
	}
	
	
}