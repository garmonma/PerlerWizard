package com.nni.gamevate.perlerwizard.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetDescriptors {

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
	
	private AssetDescriptors(){}
}
