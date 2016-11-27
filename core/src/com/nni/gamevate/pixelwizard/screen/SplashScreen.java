package com.nni.gamevate.pixelwizard.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class SplashScreen extends AbstractScreen{

   public SplashScreen(Game g) {
      super( g );
      System.out.println( "On Splash Screen" );
   }

   @Override
   public void render( float delta ) {
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      

      if(Gdx.input.justTouched())
          getGame().setScreen(new MainMenuScreen(getGame()));
   }

   @Override
   public void show() {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void hide() {
      // TODO Auto-generated method stub
      
   }

}
