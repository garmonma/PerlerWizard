package com.nni.gamevate.pixelwizard.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public abstract class AbstractScreen implements Screen {

   private Game _pixelWizard;
   
   public AbstractScreen(Game g){
      _pixelWizard = g;
   }


   @Override
   public void resize( int width, int height ) {
      
   }

   @Override
   public void pause() {
   }

   @Override
   public void resume() {
      
   }


   @Override
   public void dispose() {
      
   }
   
   public Game getGame(){
      return _pixelWizard;
   }
   
}