package com.nni.gamevate.perlerwizard.events;

public class Event {
	
	public enum EventType{
		ENEMY_ATTACKED, JOINED_GROUP, ENEMY_DEATH
	}
	
	public EventType type;
	public String message;
	public Event(EventType type, String message) {
		this.type = type;
		this.message = message;		
	}
	

}
