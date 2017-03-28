package com.nni.gamevate.perlerwizard.object.skills;

import java.lang.reflect.Constructor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;
import com.nni.gamevate.perlerwizard.utils.WaveInputHandler;

/**
 * Think of this class as a factory for skills
 * 
 * @author Shane
 *
 */
public class Wand {
	private static final String tag = Wand.class.getSimpleName();
	public Class<Skill> _skill;
	private long _refreshTime;
	private long lastFire;
	
	
	
	public Wand(Class<Skill>skill,long refreshTime) {
		_skill = skill;
		_refreshTime = refreshTime;
	}
	
	private boolean canFire(){
		if(TimeUtils.millis() - lastFire > _refreshTime){
			lastFire = TimeUtils.millis();
			return true;
		}
		return false;
		
	}
	
	public Skill fire(float x,float y){
		
		if(canFire() == true){
			try {
				Constructor<Skill> con = _skill.getConstructor(float.class,float.class);
				Skill s = con.newInstance(x,y);			
				return s;
			} catch (Exception e) {
				Gdx.app.log(tag, e.toString());
			}			
		}
		
		
		
		return null;
		
	}
}
