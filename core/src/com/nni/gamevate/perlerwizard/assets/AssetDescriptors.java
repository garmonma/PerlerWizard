package com.nni.gamevate.perlerwizard.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetDescriptors {
	
	//Texture Atlas
	public static final AssetDescriptor<TextureAtlas> SPELLS =
            new AssetDescriptor<TextureAtlas>(AssetPaths.SPELLS, TextureAtlas.class);
	
	public static final AssetDescriptor<TextureAtlas> ENEMIES =
            new AssetDescriptor<TextureAtlas>(AssetPaths.ENEMIES, TextureAtlas.class);
	
	public static final AssetDescriptor<TextureAtlas> OBJECTS =
            new AssetDescriptor<TextureAtlas>(AssetPaths.OBJECTS, TextureAtlas.class);
	
	
	
	
	//Misc

	public static final AssetDescriptor<Texture> SPLASH_BACKGROUND =
            new AssetDescriptor<Texture>(AssetPaths.SPLASH_BACKGROUND, Texture.class);
	
	public static final AssetDescriptor<Texture> CASTLE_BACKGROUND =
            new AssetDescriptor<Texture>(AssetPaths.CASTLE_BACKGROUND, Texture.class);
	
	public static final AssetDescriptor<Skin> UI_SKIN =
            new AssetDescriptor<Skin>(AssetPaths.UI_SKIN, Skin.class);
	
	public static final AssetDescriptor<Texture> ENERGY_SHIELD_BOX =
            new AssetDescriptor<Texture>(AssetPaths.ENERGY_SHIELD_BOX, Texture.class);
	
	public static final AssetDescriptor<Texture> REFLECT_SKILL_BOX =
            new AssetDescriptor<Texture>(AssetPaths.REFLECT_SKILL_BOX, Texture.class);
	
	public static final AssetDescriptor<BitmapFont> FONT =
            new AssetDescriptor<BitmapFont>(AssetPaths.UI_FONT, BitmapFont.class);
	
	public static final AssetDescriptor<Texture> EVENTS_BUTTON =
            new AssetDescriptor<Texture>(AssetPaths.EVENTS_BUTTON, Texture.class);
	
	public static final AssetDescriptor<Texture> EVENTS_BUTTON_PRESSED =
            new AssetDescriptor<Texture>(AssetPaths.EVENTS_BUTTON_PRESSED, Texture.class);
	
	public static final AssetDescriptor<Texture> EQUIPMENT_BUTTON =
            new AssetDescriptor<Texture>(AssetPaths.EQUIPMENT_BUTTON, Texture.class);
	
	public static final AssetDescriptor<Texture> EQUIPMENT_BUTTON_PRESSED =
            new AssetDescriptor<Texture>(AssetPaths.EQUIPMENT_BUTTON_PRESSED, Texture.class);
	
	public static final AssetDescriptor<Texture> MENU_BUTTON =
            new AssetDescriptor<Texture>(AssetPaths.MENU_BUTTON, Texture.class);
	
	public static final AssetDescriptor<Texture> MENU_BUTTON_PRESSED =
            new AssetDescriptor<Texture>(AssetPaths.MENU_BUTTON_PRESSED, Texture.class);
	
	public static final AssetDescriptor<Texture> GAME_NODE_BASIC = 
			new AssetDescriptor<Texture>(AssetPaths.GAME_NODE_BASIC, Texture.class);
	
	public static final AssetDescriptor<Texture> DIRT_ROAD_HORIZONTAL = 
			new AssetDescriptor<Texture>(AssetPaths.DIRT_ROAD_HORIZONTAL, Texture.class);
	
	public static final AssetDescriptor<Texture> DIRT_ROAD_VERTICAL = 
			new AssetDescriptor<Texture>(AssetPaths.DIRT_ROAD_VERTICAL, Texture.class);

	public static final AssetDescriptor<Texture> FLOOR_BACKGROUND = 
			new AssetDescriptor<Texture>(AssetPaths.FLOOR_BACKGROUND, Texture.class);
	
	
	//Characters
	public static final AssetDescriptor<Texture> WIZARD = 
			new AssetDescriptor<Texture>(AssetPaths.WIZARD, Texture.class);
	
	public static final AssetDescriptor<Texture> GOBLIN_ATTACK = 
			new AssetDescriptor<Texture>(AssetPaths.GOBLIN_ATTACK, Texture.class);
	
	public static final AssetDescriptor<Texture> ORC_STEP_ONE = 
			new AssetDescriptor<Texture>(AssetPaths.ORC_STEP_ONE, Texture.class);
	
	//Spells
	public static final AssetDescriptor<Texture> FIRE_SPELL_SPRITE = 
			new AssetDescriptor<Texture>(AssetPaths.FIRE_SPELL_SPRITE, Texture.class);
	
	
	// Sounds and Music
	public static final AssetDescriptor<Music> OVERWORLD_SOUNDTRACK = 
			new AssetDescriptor<Music>(AssetPaths.OVERWORLD_SOUNDTRACK, Music.class);
	
	public static final AssetDescriptor<Sound> DEFAULT_SPELL_HIT = 
			new AssetDescriptor<Sound>(AssetPaths.DEFAULT_SPELL_HIT, Sound.class);
	
	public static final AssetDescriptor<Sound> DEFAULT_SPELL_CAST = 
			new AssetDescriptor<Sound>(AssetPaths.DEFAULT_SPELL_CAST, Sound.class);
	
	public static final AssetDescriptor<Sound> FIRE_SPELL_HIT = 
			new AssetDescriptor<Sound>(AssetPaths.FIRE_SPELL_HIT, Sound.class);
	
	public static final AssetDescriptor<Sound> FIRE_SPELL_CAST = 
			new AssetDescriptor<Sound>(AssetPaths.FIRE_SPELL_CAST, Sound.class);
	
	public static final AssetDescriptor<Sound> WATER_SPELL_HIT = 
			new AssetDescriptor<Sound>(AssetPaths.WATER_SPELL_HIT, Sound.class);
	
	public static final AssetDescriptor<Sound> WATER_SPELL_CAST = 
			new AssetDescriptor<Sound>(AssetPaths.WATER_SPELL_CAST, Sound.class);
	
	public static final AssetDescriptor<Sound> FOREST_SPELL_HIT = 
			new AssetDescriptor<Sound>(AssetPaths.FOREST_SPELL_HIT, Sound.class);
	
	public static final AssetDescriptor<Sound> FOREST_SPELL_CAST = 
			new AssetDescriptor<Sound>(AssetPaths.FOREST_SPELL_CAST, Sound.class);
	
	public static final AssetDescriptor<Sound> LIGHTNING_SPELL_HIT = 
			new AssetDescriptor<Sound>(AssetPaths.LIGHTNING_SPELL_HIT, Sound.class);
	
	public static final AssetDescriptor<Sound> LIGHTNING_SPELL_CAST = 
			new AssetDescriptor<Sound>(AssetPaths.LIGHTNING_SPELL_CAST, Sound.class);
	
	private AssetDescriptors(){}
}
