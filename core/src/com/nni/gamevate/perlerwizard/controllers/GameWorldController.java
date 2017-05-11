package com.nni.gamevate.perlerwizard.controllers;

import java.util.ArrayList;
import java.util.List;

import com.nni.gamevate.perlerwizard.GameConfig;
import com.nni.gamevate.perlerwizard.object.Background;
import com.nni.gamevate.perlerwizard.object.hero.HeroSprite;
import com.nni.gamevate.perlerwizard.spawnloader.LevelSelector;
import com.nni.gamevate.perlerwizard.utils.GameElement;
import com.nni.gamevate.perlerwizard.utils.MapNode;
import com.nni.gamevate.perlerwizard.utils.UIElement;
import com.nni.gamevate.perlerwizard.utils.WorldMapInitializer;
import com.nni.gamevate.perlerwizard.waves.Level;
import com.nni.gamevate.perlerwizard.waves.chapter01.Chapter_01_01;
import com.nni.gamevate.perlerwizard.waves.chapter01.Chapter_01_02;

public class GameWorldController {
	
	private Background _castleBackground;
	private List<GameElement> _mapPositions = new ArrayList<GameElement>();
	
	private String _heroLevel;
	private String _heroGold;
	
	private UIElement _healthBar;
	private UIElement _goldCoin;
	private UIElement _menuButton;
	private UIElement _equipmentButton;
	private UIElement _eventsButton;
	private UIElement _potionIcon;
	private UIElement _levelIndicator;
	private UIElement _expBar;
	
	private HeroSprite _heroSprite;
	
	private List<UIElement> _filledElements = new ArrayList<UIElement>();
	
	private MapNode _selectedNode;
	
	private String _level;
	
	private boolean _navigateEquipmentScreen, _navigateEventScreen, _navigateMenuScreen,
				_navigateGameScreen;
	
	
	public GameWorldController(){
		init();
	}
	
	public void update(float delta){
		
	}
	
	private void init(){
		_heroLevel = "12";
		_heroGold  = "100121";
		
		_castleBackground = new Background();
		_castleBackground.setPosition(4, 0);
		_castleBackground.setDimensions(
				(int)GameConfig.WORLD_WIDTH - 10, 
				(int)GameConfig.WORLD_HEIGHT);
		
		String map = "maps\\gameWorldMap.txt";
		WorldMapInitializer mapInitializer = new WorldMapInitializer(map);
		_mapPositions = mapInitializer.getMap();
		
		_heroSprite = new HeroSprite(
				_mapPositions.get(0).getX(), 
				_mapPositions.get(0).getY(), 
				_mapPositions.get(0).getWidth(), 
				_mapPositions.get(0).getHeight());
		
		_heroSprite.changeNode(1);
		
		//_expBar = new UIElement(38,  GameConfig.UI_SCREEN_HEIGHT-20, 64, 16);
		//_filledElements.add(_expBar);
		
		//_levelIndicator = new UIElement(20,  GameConfig.UI_SCREEN_HEIGHT, 16, 16);
		//_filledElements.add(_levelIndicator);
		
		//_healthBar = new UIElement(20,  GameConfig.UI_SCREEN_HEIGHT - 68, 128, 32);
		//_filledElements.add(_healthBar);
		
		//_goldCoin = new UIElement(20,  GameConfig.UI_SCREEN_HEIGHT - 126, 32, 32);
		//_filledElements.add(_goldCoin);
		
		//_potionIcon = new UIElement(20,  GameConfig.UI_SCREEN_HEIGHT - 188, 32, 32);
		//_filledElements.add(_potionIcon);
		
		_equipmentButton = new UIElement(20,  GameConfig.UI_SCREEN_HEIGHT - 120, 64, 64);
		_equipmentButton.pressable(true);
		_filledElements.add(_equipmentButton);
		
		_eventsButton = new UIElement(20,  GameConfig.UI_SCREEN_HEIGHT - 194, 64, 64);
		_eventsButton.pressable(true);
		_filledElements.add(_eventsButton);
		
		_menuButton = new UIElement(20,  GameConfig.UI_SCREEN_HEIGHT - 268, 64, 64);
		_menuButton.pressable(true);
		_filledElements.add(_menuButton);
		
		_navigateEquipmentScreen = false;
		_navigateEventScreen = false;
		_navigateMenuScreen = false;
	}
		
	public Background getCastleBackground(){
		return _castleBackground;
	}
	
	public List<GameElement> getMapNodes(){
		return _mapPositions;
	}
	
	public void selectNode(MapNode mapNode){
		_selectedNode = mapNode;
	}
	
	public String getHeroLevel(){
		return _heroLevel;
	}
	
	public String getHeroGold(){
		return _heroGold;
	}
	
	public UIElement getHealthBar(){
		return _healthBar;
	}
	
	public UIElement getGoldCoin(){
		return _goldCoin;
	}
	
	public UIElement getMenuButton(){
		return _menuButton;
	}
	
	public UIElement getEquipmentButton(){
		return _equipmentButton;
	}
	
	public UIElement getEventsButton(){
		return _eventsButton;
	}
	
	public UIElement getPotionIcon(){
		return _potionIcon;
	}
	
	public UIElement getLevelIndicator(){
		return _levelIndicator;
	}
	
	public UIElement getExpBar(){
		return _expBar;
	}
	
	public List<UIElement> getFilledUIElements(){
		return _filledElements;
	}
	
	public void initializedMatch(boolean b){
		_navigateGameScreen = b;
	}
	
	public boolean navigateGameScreen(){
		return _navigateGameScreen;
	}
	
	public void pressedEquipmentButton(boolean b){
		_navigateEquipmentScreen = b;
	}
	
	public boolean navigateEquipmentScreen(){
		return _navigateEquipmentScreen;
	}
	
	public void pressedEventButton(boolean b){
		_navigateEventScreen = b;
	}
	
	public boolean navaigateEventScreen(){
		return _navigateEventScreen;
	}
	
	public void pressedMenuButton(boolean b){
		_navigateMenuScreen = b;
	}
	
	public boolean navigateMenuScreen(){
		return _navigateMenuScreen;
	}
	
	public Level getSelectedLevel(){
		return LevelSelector.getLevel("ch0101");
	}
}
