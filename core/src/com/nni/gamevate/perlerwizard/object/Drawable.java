package com.nni.gamevate.perlerwizard.object;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;

/**
 * libgdx's default drawable is a little much for what i want.
 * @author Shane
 *
 */
public interface Drawable {
	public void draw(Batch batch);
	public  Color getColor();
}
