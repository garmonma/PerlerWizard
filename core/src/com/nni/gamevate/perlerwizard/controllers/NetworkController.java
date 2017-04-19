package com.nni.gamevate.perlerwizard.controllers;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.nni.gamevate.perlerwizard.network.gamedata.GameCharacter;
import com.nni.gamevate.perlerwizard.network.gamedata.MatchResult;
import com.nni.gamevate.perlerwizard.utils.Logger;

public class NetworkController {
	private Client _client;
	private GameCharacter _gc;
	
	public NetworkController(Client client){
		_client = client;
		
		_gc = new GameCharacter();
		_gc.characterID = 1;
		sendCharacter(_gc);

		_client.addListener(new Listener() {
			@Override
			public void received(Connection conn, Object object) {
				if (object instanceof GameCharacter) {
					_gc = (GameCharacter) object;
					Logger.log("Character Recieved: " + _gc);
							
				}
			}
		});
	}
	
	public void sendCharacter(GameCharacter gameCharacter){
		_client.sendTCP(gameCharacter);
		Logger.log("Game Character Sent");
	}
	
	public void sendMatchResult(MatchResult matchResult){
		//_client.sendTCP(matchResult);
		_client.sendUDP(matchResult);
		Logger.log("Match Result Sent : " + matchResult);
		
	}
	
	public GameCharacter getCharacter(){
		return _gc;
	}
	
	public void getSpawns(){
		
	}
	
	public Integer getCharacterID(){
		return _gc.characterID;
	}
}