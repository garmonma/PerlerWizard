package com.nni.gamevate.pixelwizard.levelloader;

import java.util.List;


/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class Wave {

	private List<Row> rows;
	
	public Wave(){
		
	}
	
	public List<Row> getRows(){
		return rows;
	}
	
	public void setRows(List<Row> rows){
		this.rows = rows;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return String.format("Wave [rows=%s]", rows != null ? rows.subList(0, Math.min(rows.size(), maxLen)) : null);
	}
}