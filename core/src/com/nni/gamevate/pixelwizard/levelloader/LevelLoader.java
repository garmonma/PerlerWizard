package com.nni.gamevate.pixelwizard.levelloader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;


/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class LevelLoader {
	
	public static Level load(FileHandle fileHandle){	
		Json json = new Json();
		Level level = json.fromJson(Level.class, fileHandle);
		
		Gdx.app.log("Level", level.toString());
		
		return level;
	}
}