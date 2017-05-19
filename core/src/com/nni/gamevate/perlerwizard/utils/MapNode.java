package com.nni.gamevate.perlerwizard.utils;

public class MapNode extends GameElement {
	
	private int _nodeId;
	
	public MapNode(float x, float y, int type){
		super(x, y, type);
		
		width = 1.0f;
		height = 1.0f;
	}
	
	public void setNodeId(int id){
		_nodeId = id;
	}
	
	public void setX(float x){
		x = x;
	}
	
	public void setY(float y){
		y = y;
	}
	
	public int getNodeId(){
		return _nodeId;
	}

}
