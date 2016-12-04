package com.nni.gamevate.pixelwizard.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.utils.Array;
import com.nni.gamevate.pixelwizard.object.character.Hero;
import com.nni.gamevate.pixelwizard.object.spells.Spell;
import com.nni.gamevate.pixelwizard.object.spells.color.RedSpell;
import com.nni.gamevate.pixelwizard.object.spells.color.SpellColor;
import com.nni.gamevate.pixelwizard.object.spells.color.WhiteSpell;
import com.nni.gamevate.pixelwizard.object.spells.shape.CircleSpell;
import com.nni.gamevate.pixelwizard.object.spells.shape.SpellShape;

public class GameWorld {

	private Hero _hero;
	private Array<Spell> _spells;
	
	private String _selectedColor;
	private String _selectedShape;
	
	private SpellShape _nextSpellShape;
	private SpellColor _nextSpellColor;
	
	public GameWorld(){
		_hero = new Hero(64, 64, 800/2 - 64/2, 20);
		_spells = new Array<Spell>();
		
		_selectedShape = "x";
		_selectedColor = "white";
	}
	
	public void update(float delta){
		Gdx.app.log("GameWorld", "update");
		
		if(Gdx.input.isTouched() || Gdx.input.isKeyPressed(Keys.SPACE) ){
			_nextSpellColor = GetSpellColor();
			
			if(_nextSpellColor != null){
				Spell spell = new Spell(16, 16, 
						_hero.getX(), _hero.getY(), _nextSpellColor, new CircleSpell());
				
				_spells.add(spell);	
			}	
		}
		
		for(Spell spell: _spells){
			spell.update(delta);
		}
		
		_hero.update(delta);
	}
	
	public Hero getHero(){
		return _hero;
	}
	
	public Array<Spell> getSpells(){
		return _spells;
	}
	
	public SpellColor GetSpellColor(){
		if(_selectedColor.equalsIgnoreCase("white")){
			if(!WhiteSpell._onCooldown)
				return new WhiteSpell();
		} 
		
		if(_selectedColor.equalsIgnoreCase("red")){
			if(!RedSpell._onCooldown)
				return new RedSpell();
		} 
		
		return null;
	}
	
	public void setSelectedShape(String selectedShape){
		_selectedShape = selectedShape;
	}
	
	public void setSelectedColor(String selectedColor){
		_selectedColor = selectedColor;
	}
}