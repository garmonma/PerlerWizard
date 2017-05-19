package com.nni.gamevate.perlerwizard.object.skills;

import java.lang.reflect.Constructor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.nni.gamevate.perlerwizard.object.GameObject;

/**
 * Think of this class as a factory for skills
 * 
 * @author Shane
 *
 */
public class Wand {
	private static final String tag = Wand.class.getSimpleName();
	public Class<Skill> skill;
	private long refreshTime;
	private long lastFire;
	
	
	
	public Wand(Class<Skill>skill,long refreshTime) {
		this.skill = skill;
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
			Constructor<Skill> con = skill.getConstructor(float.class,float.class);
			Skill s = con.newInstance(-10,-10);	
			return s.getColor();
		}catch(Exception e){
			Gdx.app.log(tag, "Error Getting Color" + e);
		}
		return Color.CLEAR;
	}
			
	
	public Skill fire(float x, float y){
		return fire(x, y, null);
		
	}
	
	public Skill fire(float x, float y, Float angle){
		if(canFire() == true){
			try {
				Constructor<Skill> con = skill.getConstructor(float.class,float.class);
				Skill s = con.newInstance(x,y);
				
				if(angle != null)
					s.setCastAngle(angle);
				
				return s;
			} catch (Exception e) {
				Gdx.app.log(tag, e.toString());
			}			
		}
		
		return null;
	}
	
	public Skill rush(float x, float y, Float angle, GameObject g ){
		if(canFire() == true){
			try {
				Constructor<Skill> con = skill.getConstructor(float.class, float.class, GameObject.class);
				Skill s = con.newInstance(x,y, g);
				
				if(angle != null)
					s.setCastAngle(angle);
				
				return s;
			} catch (Exception e) {
				Gdx.app.log(tag, e.toString());
			}			
		}
		
		return null;
	}
}
