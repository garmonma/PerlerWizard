package com.nni.gamevate.perlerwizard.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.opencsv.CSVReader;

public class WorldMapInitializer {

	private GameElement[][] map = new GameElement[12][20];
	private List<GameElement> mapList = new ArrayList<GameElement>();

	public WorldMapInitializer(String url) {
		FileHandle handle = Gdx.files.internal(url);

		try {
			InputStream csvStream = handle.read();
			InputStreamReader csvStreamReader = new InputStreamReader(csvStream);
			CSVReader csvReader = new CSVReader(csvStreamReader);
			String[] line;

			// throw away the header
			//csvReader.readNext();

			int lineCount = 0;
			while ((line = csvReader.readNext()) != null) {
				for(int position = 0; position < line.length; position++){
					
					processPosition(lineCount, position, Integer.parseInt(line[position]));
					
					Logger.log(line[position]);
				}				
				
				lineCount++;
				
			}
			
			csvReader.close();

		} catch (IOException e) {
			e.printStackTrace();

		} 

	}
	
	private void processPosition(int lineCount, int position, int element){
		switch(element){
		case ElementType.EMPTY:
			return;
		case ElementType.BASIC_NODE:
			map[lineCount][position] = new MapNode(position, lineCount, element);
			break;
		case ElementType.HORIZONTAL_DIRT_ROAD:
			map[lineCount][position] = new MapRoad(position, lineCount, element);
			break;
		case ElementType.VERTICAL_DIRT_ROAD:
			map[lineCount][position] = new MapRoad(position, lineCount, element);
			break;
		case ElementType.KING_CHAMBER_NODE:
			map[lineCount][position] = new MapNode(position, lineCount, element);
			break;
			
		}
		
		if(map[lineCount][position] != null){
			mapList.add(map[lineCount][position]);
		}
		
	}

	public List<GameElement> getMap() {
		for(GameElement e: mapList){
			Logger.log(e.toString());
		}
		return mapList;

	}

}
