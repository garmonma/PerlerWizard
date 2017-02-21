package com.nni.gamevate.perlerwizard.controllers;

import java.util.ArrayList;
import java.util.List;

import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.object.Background;
import com.nni.gamevate.perlerwizard.object.MapNode;
import com.nni.gamevate.perlerwizard.object.UIElement;

public class GameWorldController {
	
	private Background _castleBackground;
	private List<MapNode> _mapNodes = new ArrayList<MapNode>();
	
	private UIElement _healthBar;
	private UIElement _goldCoin;
	
	private MapNode _selectedNode;
	
	
	public GameWorldController(){
		init();
	}
	
	public void update(float delta){
		
	}
	
	private void init(){
		_castleBackground = new Background();
		_castleBackground.setPosition(0, 0);
		_castleBackground.setDimensions(
				(int)GameConfig.WORLD_WIDTH, 
				(int)GameConfig.WORLD_HEIGHT);
		
		initMapNodes();
	}
	

	
	public Background getCastleBackground(){
		return _castleBackground;
	}
	
	public List<MapNode> getMapNodes(){
		return _mapNodes;
	}
	
	
	private void initMapNodes(){
		//Side outer nodes
		MapNode mapNode1 = new MapNode(1, 1.75f, 1.75f);
		MapNode mapNode2 = new MapNode(2, 1.75f, 5.75f);
		MapNode mapNode3 = new MapNode(3, 1.75f, 9.75f);
		MapNode mapNode4 = new MapNode(4, 17.75f, 1.75f);
		MapNode mapNode5 = new MapNode(5, 17.75f, 5.75f);
		MapNode mapNode6 = new MapNode(6, 17.75f, 9.75f);
		
		//Top Outer Nodes
		MapNode mapNode7 = new MapNode(7, 3.75f, .75f);
		MapNode mapNode8 = new MapNode(8, 9.75f, .75f);
		MapNode mapNode9 = new MapNode(9, 15.75f, .75f);
		MapNode mapNode10 = new MapNode(11, 3.75f, 10.75f);
		MapNode mapNode11 = new MapNode(11, 9.75f, 10.75f);
		MapNode mapNode12 = new MapNode(12, 15.75f, 10.75f);
		
		
		MapNode mapNode13 = new MapNode(13, 0, 0);
		MapNode mapNode14 = new MapNode(14, 0, 0);
		MapNode mapNode15 = new MapNode(15, 0, 0);
		MapNode mapNode16 = new MapNode(16, 0, 0);
		MapNode mapNode17 = new MapNode(17, 0, 0);
		MapNode mapNode18 = new MapNode(18, 0, 0);
		MapNode mapNode19 = new MapNode(19, 0, 0);
		MapNode mapNode20 = new MapNode(20, 0, 0);
		
		//Four Center Nodes
		MapNode mapNode21 = new MapNode(21, 9.25f, 5.25f);
		MapNode mapNode22 = new MapNode(22, 9.25f, 6.25f);
		MapNode mapNode23 = new MapNode(23, 10.25f, 5.25f);
		MapNode mapNode24 = new MapNode(24, 10.25f, 6.25f);
		
		// King Chamber Node (Throne Room)
		MapNode mapNode25 = new MapNode(25, 9.75f, 5.75f);
		
		_mapNodes.add(mapNode1);
		_mapNodes.add(mapNode2);
		_mapNodes.add(mapNode3);
		_mapNodes.add(mapNode4);
		_mapNodes.add(mapNode5);
		_mapNodes.add(mapNode6);
		_mapNodes.add(mapNode7);
		_mapNodes.add(mapNode8);
		_mapNodes.add(mapNode9);
		_mapNodes.add(mapNode10);
		_mapNodes.add(mapNode11);
		_mapNodes.add(mapNode12);
		_mapNodes.add(mapNode13);
		_mapNodes.add(mapNode14);
		_mapNodes.add(mapNode15);
		_mapNodes.add(mapNode16);
		_mapNodes.add(mapNode17);
		_mapNodes.add(mapNode18);
		_mapNodes.add(mapNode19);
		_mapNodes.add(mapNode20);
		_mapNodes.add(mapNode21);
		_mapNodes.add(mapNode22);
		_mapNodes.add(mapNode23);
		_mapNodes.add(mapNode24);
		_mapNodes.add(mapNode25);
	}
	
	public void selectNode(MapNode mapNode){
		_selectedNode = mapNode;
	}
	
	public boolean navigate(){
		return true;
	}
}
