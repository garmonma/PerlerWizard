package com.nni.gamevate.perlerwizard.controllers;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.nni.gamevate.perlerwizard.network.gamedata.GameCharacter;
import com.nni.gamevate.perlerwizard.network.gamedata.MatchResult;
import com.nni.gamevate.perlerwizard.utils.Logger;

public class NetworkController {
	private Client client;
	private GameCharacter gc;
	
	public NetworkController(Client client){
		this.client = client;
		
		gc = new GameCharacter();
		gc.characterID = 1;
		sendCharacter(gc);

		client.addListener(new Listener() {
			@Override
			public void received(Connection conn, Object object) {
				if (object instanceof GameCharacter) {
					gc = (GameCharacter) object;
					Logger.log("Character Recieved: " + gc);
							
				}
			}
		});
	}
	
	public void sendCharacter(GameCharacter gameCharacter){
		client.sendTCP(gameCharacter);
		Logger.log("Game Character Sent");
	}
	
	public void sendMatchResult(MatchResult matchResult){
		//_client.sendTCP(matchResult);
		client.sendUDP(matchResult);
		Logger.log("Match Result Sent : " + matchResult);
		
	}
	
	public GameCharacter getCharacter(){
		return gc;
	}
	
	public void getSpawns(){
		
	}
	
	public Integer getCharacterID(){
		return gc.characterID;
	}
}