package com.nni.gamevate.perlerwizard.object;

public class MapNode {
	
	private int _nodeId;
	private float _x;
	private float _y;
	
	
	public MapNode(int id, float x, float y){
		_nodeId = id;
		_x = x;
		_y = y;
	}
	
	public void setNodeId(int id){
		_nodeId = id;
	}
	
	public void setX(float x){
		_x = x;
	}
	
	public void setY(float y){
		_y = y;
	}
	
	public int getNodeId(){
		return _nodeId;
	}
	
	public float getX(){
		return _x;
	}
	
	public float getY(){
		return _y;
	}
	
	

}
