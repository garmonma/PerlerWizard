package com.nni.gamevate.perlerwizard.waves;

import java.util.ArrayList;

import com.nni.gamevate.perlerwizard.events.Event;
import com.nni.gamevate.perlerwizard.events.Event.EventType;
import com.nni.gamevate.perlerwizard.events.EventManager;
import com.nni.gamevate.perlerwizard.events.Subscriber;
import com.nni.gamevate.perlerwizard.object.enemies.Enemy;

public abstract class Level implements Subscriber {
	
	public ArrayList<Enemy> wave1 = new ArrayList<Enemy>();	
	public ArrayList<Enemy> wave2 = new ArrayList<Enemy>();
	public ArrayList<Enemy> wave3 = new ArrayList<Enemy>();
	public static int wave1Start = 10;
	public static int wave2Start = 30;
	public static int wave3Start = 50;
	
	protected int goldReward;
	protected int timeLimit;
	protected ArrayList<String> itemRewards = new ArrayList<String>();
	
	
	protected Level(){
		EventManager.addSubscriber(EventType.ENEMY_ATTACKED, this);
		EventManager.addSubscriber(EventType.JOINED_GROUP, this);
	}
	
	@Override
	public void handleEvent(Event e) {
		switch (e.type) {
		case ENEMY_ATTACKED:
			handleAttackEvent(e);
			break;
		case JOINED_GROUP:
			handleJoinGroupEvent(e);
			break;
		default:
			break;
		}		
	}
	
	private void handleJoinGroupEvent(Event e){
		switch(e.message){
		case "1":			
			chase(wave1);
			chase(wave2);
			break;
		case "3":
			scare(wave2);
			chase(wave3);
			break;
		
		}
	}
	
	private  void handleAttackEvent(Event e){
		switch (e.message) {
		case "1":			
			scare(wave1);
			break;
		case "2":
			scare(wave2);
			break;
		case "3":		
			chase(wave3);
			break;
		default:
			break;
		}
	}
	
	private void chase(ArrayList<Enemy> list){
		for(Enemy e:list){
			e.setSleeping(false);
			e.setRunning(false);
			e.setChasing(true);
		}
	}
	
	private void scare(ArrayList<Enemy> list){
		for(Enemy e:list){
			if(e.isChasing())
				return;			
			
			e.setSleeping(false);
			e.setRunning(true);
		}
	}
	
	
	
}
