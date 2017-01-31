package com.nni.gamevate.perlerwizard.controllers;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.nni.gamevate.perlerwizard.network.gamedata.GameCharacter;
import com.nni.gamevate.perlerwizard.network.gamedata.MatchResult;

public class NetworkController {
	private Client _client;
	
	public NetworkController(Client client){
		_client = client;

		_client.addListener(new Listener() {
			@Override
			public void received(Connection conn, Object object) {
				if (object instanceof GameCharacter) {
					GameCharacter gc = (GameCharacter) object;
					System.out.println("Character Recieved: " + gc);
				}
			}
		});
	}
	
	public void sendCharacter(GameCharacter gameCharacter){
		_client.sendTCP(gameCharacter);
	}
	
	public void sendMatchResult(MatchResult matchResult){
		_client.sendTCP(matchResult);
		
	}
	
	public void getSpawns(){
		
	}
}