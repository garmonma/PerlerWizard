package com.nni.gamevate.perlerwizard.object.spells.color;

import com.badlogic.gdx.graphics.Color;

/**
 * 
 * @author Marcus Garmon 11/27/2016
 * 
 * The Spell Color determine the speed that the spell can travel and the
 * and how long the spell can be cast again. The color also determines any special effects
 * like maybe a burn, heal, explode.
 */

public abstract class SpellColor {

   private float _speedMultiplier;
   private long _cooldown;
   protected Color _color;
   
   public SpellColor(){
      _speedMultiplier = 1.0f;
      _cooldown = 1500000000l;
      initSpellEffect();
   }
   
   public float getSpeedMultiplier(){
      return _speedMultiplier;
   }
   
   public void setSpeedMultiplier(float speedMultiplier){
      _speedMultiplier = speedMultiplier;
   }
   
   public long getCooldown(){
      return _cooldown;
   }
   
   public void setCooldown(long cooldown){
      _cooldown = cooldown;
   }
   
   public abstract void initSpellEffect();
   
   public abstract boolean isOnCooldown(long cooldown);
   
   public abstract void reset();
	   
   public Color getColor(){
	   return _color;
   }
}