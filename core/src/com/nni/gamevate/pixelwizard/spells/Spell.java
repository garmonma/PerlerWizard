package com.nni.gamevate.pixelwizard.spells;

import com.nni.gamevate.pixelwizard.spells.color.SpellColor;
import com.nni.gamevate.pixelwizard.spells.shape.SpellShape;

public class Spell implements SpellInterface {
   private static final double BASE_SPEED = 100;
   private static final int DEFAULT_BOUNCE_COUNT = 3;
   private static final int DEFAULT_DAMAGE = 1;
   private static final int DEFAULT_SPIN = 0;
   private static final int MAX_SPIN = 1;
   private static final int MIN_SPIN = -1;
   
   private SpellColor _color;
   
   private SpellShape _shape;
   
   private double _speed;
   
   private double _dmg;
   
   private double _spin;
   
   private int _bounceCount;
   private int _bounceCounter;
   
   private long _spellTimer;
   
   public Spell(SpellColor color, SpellShape shape){
      _color = color;
      _shape = shape;
      
      _speed = BASE_SPEED * _color.getSpeedMultiplier();
      _spellTimer = _color.getCooldown();
      
      _dmg = DEFAULT_DAMAGE * _shape.getDmgMultiplier();
      _spin = DEFAULT_SPIN;
      
      _bounceCount = DEFAULT_BOUNCE_COUNT;
      _bounceCounter = _bounceCount;
      
   }

   @Override
   public void bounce(String enemy, String side) {
      _bounceCounter--;
      
      if(_bounceCounter == 0){
         evaporate();
      }  
      
      // Side can be left, right or center when bouncing off an object.
      if(side.equalsIgnoreCase( "left" )){
         _spin = _spin + .1;
         if(_spin > MAX_SPIN) _spin = MAX_SPIN;
      } else if(side.equalsIgnoreCase( "right" )) {
         _spin = _spin - .1;
         if(_spin < MIN_SPIN) _spin = MIN_SPIN;
      }

   }

   @Override
   public void evaporate() {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void transfiguration() {
      // TODO Auto-generated method stub
      
   }
   
   public double getSpeed(){
      return _speed;
   }
   
   public double getDmg(){
      return _dmg;
   }
   
   public double getSpin(){
      return _spin;
   }
   
   public double getSpellTimer(){
      return _spellTimer;
   }
}