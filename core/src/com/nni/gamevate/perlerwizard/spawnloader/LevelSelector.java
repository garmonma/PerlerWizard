package com.nni.gamevate.perlerwizard.spawnloader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.nni.gamevate.perlerwizard.network.gamedata.Spawn;
import com.nni.gamevate.perlerwizard.waves.Level;
import com.nni.gamevate.perlerwizard.waves.Level_01;
import com.nni.gamevate.perlerwizard.waves.chapter01.Chapter_01_01;


/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class LevelSelector {
	
	public static Level getLevel(String id){
		
		switch(id){
		case "ch0101":
			return new Chapter_01_01();
		}
		
		
		return new Level_01();
		
	}
}