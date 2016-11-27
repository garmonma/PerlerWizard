package com.nni.gamevate.pixelwizard.skills;

import com.nni.gamevate.pixelwizard.skills.color.SpellColor;
import com.nni.gamevate.pixelwizard.skills.shape.SpellShape;

public class Spell implements SpellInterface {
	
	private SpellColor _color;
	
	private SpellShape _shape;
	
	private double _speed;
	
	private int _bounceCount;
	
	private double _dmg;
	
	private double _dmgMuliplier;
	
	private double _spinMultiplier;
	
	public Spell(SpellColor color, SpellShape shape){
		_color = color;
		_shape = shape;
	}

	@Override
	public void bounce() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void evaporate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transfiguration() {
		// TODO Auto-generated method stub
		
	}
}