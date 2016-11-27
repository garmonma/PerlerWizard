package com.nni.gamevate.pixelwizard.spells.color;

/**
 * 
 * @author Marcus Garmon 11/27/2016
 * 
 * The RedSpell has a faster speed than regular spells but it requires a larger cooldown to use again.
 * A special effect that it could have is burn which could destroy shields or lower defense.
 *
 */
public class RedSpell extends SpellColor{

   public RedSpell(){
      
   }
   
   @Override
   public void initSpellEffect() {
      setSpeedMultiplier( 1.3 );
      setCooldown( 5000 );
   }
}