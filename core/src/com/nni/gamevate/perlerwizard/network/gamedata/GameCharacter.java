package com.nni.gamevate.perlerwizard.network.gamedata;

public class GameCharacter {

	public int characterID;
	public float healthPct;
	public int gold;
	public int experience;
	public int defense, attack;
	public float dodge, speed;
	public int job;
	public int level;
	@Override
	public String toString() {
		return String.format(
				"GameCharacter [characterID=%s, healthPct=%s, gold=%s, experience=%s, defense=%s, attack=%s, dodge=%s, speed=%s, job=%s, level=%s]",
				characterID, healthPct, gold, experience, defense, attack, dodge, speed, job, level);
	}

	
}
