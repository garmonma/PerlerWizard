package com.nni.gamevate.pixelwizard;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * 
 * @author Marcus Garmon
 * @date Jan 5, 2017
 */
public class ViewportUtils {
	
	private static final int DEFAULT_CELL_SIZE = 1;
	
	
	public static void drawGrid(Viewport viewport, ShapeRenderer renderer){
		drawGrid(viewport, renderer, DEFAULT_CELL_SIZE);
	}
	
	public static void drawGrid(Viewport viewport, ShapeRenderer renderer, int cellSize){
		if(viewport == null){
			throw new IllegalArgumentException("Viewport is a required parameter!");
		}
		
		if(renderer == null){
			throw new IllegalArgumentException("ShapeRenderer is a required parameter!");
		}
		
		if(cellSize < DEFAULT_CELL_SIZE){
			cellSize = DEFAULT_CELL_SIZE;
		}
		
		Color oldColor = new Color(renderer.getColor());
		
		int worldWidth = (int) viewport.getWorldWidth();
		int worldHeight = (int) viewport.getWorldHeight();
		
		renderer.setProjectionMatrix(viewport.getCamera().combined);
		renderer.begin(ShapeType.Line);
		renderer.setColor(Color.WHITE);
		
		// draw vertical lines
		for(int x = -worldWidth; x < worldWidth; x += cellSize){
			renderer.line(x, -worldHeight, x, worldHeight);
		}
		
		//draw horizontal lines
		for(int y = -worldHeight; y < worldHeight; y += cellSize){
			renderer.line(-worldWidth, y, worldWidth, y);
		}
		
		renderer.setColor(Color.BLUE);
		renderer.line(worldWidth / 2, -worldHeight, worldWidth / 2, worldHeight);
		renderer.line(-worldWidth, worldHeight / 2, worldWidth, worldHeight / 2);
		
		// draw game bounds
        renderer.setColor(Color.GREEN);
        renderer.line(4, -worldHeight, 4, worldHeight);
        renderer.line(worldWidth - 4, -worldHeight, worldWidth - 4, worldHeight);
		
		renderer.end();
		
		renderer.setColor(oldColor);
	}
	
	
	private ViewportUtils(){
		
	}

}
