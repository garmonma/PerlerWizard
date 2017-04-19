package com.nni.gamevate.perlerwizard.object.skills;

import java.lang.reflect.Constructor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * Think of this class as a factory for skills
 * 
 * @author Shane
 *
 */
public class Wand {
	private static final String tag = Wand.class.getSimpleName();
	public Class<Skill> _skill;
	private long refreshTime;
	private long lastFire;
	
	
	
	public Wand(Class<Skill>skill,long refreshTime) {
		_skill = skill;
		this.refreshTime = refreshTime;
	}
	
	private boolean canFire(){
		if(TimeUtils.millis() - lastFire > refreshTime){
			lastFire = TimeUtils.millis();
			return true;
		}
		return false;
		
	}
	public void setInitialCooldown(float f){
		f = MathUtils.random(f);			
		lastFire = (long)(refreshTime * f) + TimeUtils.millis();
	}
	public Color getSkillColor(){
		try{			
			Constructor<Skill> con = _skill.getConstructor(float.class,float.class);
			Skill s = con.newInstance(-10,-10);	
			return s.getColor();
		}catch(Exception e){
			Gdx.app.log(tag, "Error Getting Color" + e);
		}
		return Color.CLEAR;
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
