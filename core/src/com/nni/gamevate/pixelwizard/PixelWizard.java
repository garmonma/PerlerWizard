package com.nni.gamevate.pixelwizard;

import com.badlogic.gdx.Game;
import com.nni.gamevate.pixelwizard.screen.SplashScreen;

public class PixelWizard extends Game {
	
   @Override
   public void create() {
      this.setScreen( new SplashScreen( this ) );
      
   }
}