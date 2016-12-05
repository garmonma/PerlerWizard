package com.nni.gamevate.pixelwizard.object.spells.color;

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

   private double _speedMultiplier;
   private long _cooldown;
   protected Color _color;
   
   public SpellColor(){
      _speedMultiplier = 1.0;
      _cooldown = 180;
      initSpellEffect();
   }
   
   public double getSpeedMultiplier(){
      return _speedMultiplier;
   }
   
   public void setSpeedMultiplier(double speedMultiplier){
      _speedMultiplier = speedMultiplier;
   }
   
   public long getCooldown(){
      return _cooldown;
   }
   
   public void setCooldown(long cooldown){
      _cooldown = cooldown;
   }
   
   public abstract void initSpellEffect();
   
   public Color getColor(){
	   return _color;
   }
}