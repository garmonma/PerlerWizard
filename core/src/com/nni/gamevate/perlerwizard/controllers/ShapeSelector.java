package com.nni.gamevate.perlerwizard.controllers;

import com.nni.gamevate.perlerwizard.object.spells.shape.SpellShape;

/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class ShapeSelector {
	
	private SpellShape[] _spellShapes;
	
	// 0 - 3
	private int _selectedPosition;
	
	public ShapeSelector(){
		_spellShapes = new SpellShape[4];
		_selectedPosition = 0;
	}
	
	public void rotateRight(){
		_selectedPosition = (_selectedPosition + _spellShapes.length - 1) % _spellShapes.length;
	}
	
	public void rotateLeft(){
		_selectedPosition = (_selectedPosition + 1) % _spellShapes.length;
	}
	
	public SpellShape getSpellShape(){
		return _spellShapes[_selectedPosition];
	}
	
	public SpellShape getSpellShape(int position){
		return _spellShapes[position];
	}
	
	public int getSelectedPosition(){
		return _selectedPosition;
	}
	
	// TODO When user begins a stage, they can select the spell shapes they want to use
	public void insert(SpellShape shape, int position){
		_spellShapes[position] = shape;
	}

}