package com.nni.gamevate.perlerwizard.network;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.nni.gamevate.perlerwizard.network.gamedata.ChallengeLevel;
import com.nni.gamevate.perlerwizard.network.gamedata.GameCharacter;
import com.nni.gamevate.perlerwizard.network.gamedata.MatchResult;
import com.nni.gamevate.perlerwizard.network.gamedata.Row;
import com.nni.gamevate.perlerwizard.network.gamedata.Spawn;
import com.nni.gamevate.perlerwizard.network.gamedata.Wave;



public class ObjectRegistration {

	private ObjectRegistration(){}
	
	public static void register(Client client){
		Kryo kyro = client.getKryo();
		kyro.register(GameCharacter.class);
		kyro.register(MatchResult.class);
	}
}
