package com.nni.gamevate.pixelwizard.object.spells.shape;

/**
 * 
 * @author Marcus Garmon
 *
 * The Spell shape determines the damage of the spell and the spin of the
 * spell. When a spell bounces, the spin(positive to the right, negative the left)
 * will determine the direction that the spell will go. Some shapes will always have
 * a neutral spin.
 */

public abstract class SpellShape {
   
   protected double _dmgMultiplier;
   protected double _spinMultiplier;
  
   
   public SpellShape(){
      _dmgMultiplier = 1.0;
      _spinMultiplier = 1.0;
      
   }
   
   public double getDmgMultiplier(){
      return _dmgMultiplier;
   }
   
   public void setDmgMultiplier(double dmgMultiplier ){
      _dmgMultiplier = dmgMultiplier;
   }
   
   public double getSpinMultiplier(){
      return _spinMultiplier;
   }
   
   public void setSpinMultiplier(double spinMultiplier){
      _spinMultiplier = spinMultiplier;
   }
}