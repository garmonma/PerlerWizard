package com.nni.gamevate.perlerwizard.network;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.nni.gamevate.perlerwizard.network.GameData.GameCharacter;

import java.io.IOException;

public class ClientConnection {

	GameCharacter character;

	public ClientConnection() {
		Client client = new Client();
		client.setName("Test Client 01");
		client.start();
		try {
			client.connect(5000, "192.168.0.3", 54555, 54777);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ObjectRegistration.register(client);

		character = new GameCharacter();
		character.setCharacterID(1);
		client.sendTCP(character);

		client.addListener(new Listener() {
			@Override
			public void received(Connection conn, Object object) {

				if (object instanceof GameCharacter) {
					character = (GameCharacter) object;
					System.out.println("Character Recieved: " + character);
				}
			}
		});
	}
}