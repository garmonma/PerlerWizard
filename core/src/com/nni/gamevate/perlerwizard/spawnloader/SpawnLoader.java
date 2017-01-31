package com.nni.gamevate.perlerwizard.spawnloader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.nni.gamevate.perlerwizard.network.gamedata.Spawn;


/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class SpawnLoader {
	
	public static Spawn load(FileHandle fileHandle){	
		Json json = new Json();
		Spawn level = json.fromJson(Spawn.class, fileHandle);
		
		Gdx.app.log("Level", level.toString());
		
		return level;
	}
}