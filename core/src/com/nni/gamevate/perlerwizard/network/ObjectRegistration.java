package com.nni.gamevate.perlerwizard.network;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.nni.gamevate.perlerwizard.network.GameData.GameCharacter;



public class ObjectRegistration {

	private ObjectRegistration(){}
	
	public static void register(Client client){
		Kryo kyro = client.getKryo();
		kyro.register(GameCharacter.class);
	}
}
