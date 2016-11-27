package com.nni.gamevate.pixelwizard.screen;

import com.badlogic.gdx.Game;

public class MainMenuScreen extends AbstractScreen{
   
   public MainMenuScreen(Game g){
      super(g);
      System.out.println( "On Main Menu Screen" );
   }

   @Override
   public void render( float delta ) {
      getGame().setScreen( new GameScreen(getGame()) );
      
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