package com.nni.gamevate.perlerwizard.network;

import com.esotericsoftware.kryonet.Client;

import java.io.IOException;

public class ClientConnection {

	private Client client;

	public ClientConnection() {
		client = new Client();
		client.setName("Test Client 01");
		client.start();
		try {
			client.connect(5000, "192.168.0.3", 54555, 54777);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ObjectRegistration.register(client);
	}
	
	
	public Client getClient(){
		return client;
	}
}