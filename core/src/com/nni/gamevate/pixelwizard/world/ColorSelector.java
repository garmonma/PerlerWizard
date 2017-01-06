package com.nni.gamevate.pixelwizard.world;

import com.nni.gamevate.pixelwizard.object.spells.color.SpellColor;

/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class ColorSelector {

	private SpellColor[] _spellColors;

	// 0 - 3
	private int _selectedPosition;

	public ColorSelector() {
		_spellColors = new SpellColor[4];
		_selectedPosition = 0;
	}

	public void rotateUp() {
		_selectedPosition = (_selectedPosition + _spellColors.length - 1) % _spellColors.length;
	}

	public void rotateDown() {
		_selectedPosition = (_selectedPosition + 1) % _spellColors.length;
	}

	public SpellColor getSpellColor() {
		return _spellColors[_selectedPosition];
	}
	
	public SpellColor getSpellColor(int position){
		return _spellColors[position];
	}
	
	public int getSelectedPosition(){
		return _selectedPosition;
	}

	// TODO When user begins a stage, they can select the spell color they want
	// to use
	public void insert(SpellColor color, int position) {
		_spellColors[position] = color;
	}

}
