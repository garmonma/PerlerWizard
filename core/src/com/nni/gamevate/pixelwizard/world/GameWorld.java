package com.nni.gamevate.pixelwizard.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.utils.Array;
import com.nni.gamevate.pixelwizard.object.character.Hero;
import com.nni.gamevate.pixelwizard.object.enemies.Enemy;
import com.nni.gamevate.pixelwizard.object.spells.EnemySpell;
import com.nni.gamevate.pixelwizard.object.spells.Spell;
import com.nni.gamevate.pixelwizard.object.spells.color.RedSpell;
import com.nni.gamevate.pixelwizard.object.spells.color.SpellColor;
import com.nni.gamevate.pixelwizard.object.spells.color.WhiteSpell;
import com.nni.gamevate.pixelwizard.object.spells.shape.CircleSpell;
import com.nni.gamevate.pixelwizard.object.spells.shape.RectangleSpell;
import com.nni.gamevate.pixelwizard.object.spells.shape.SpellShape;

public class GameWorld {

	private Hero _hero;
	private Array<Spell> _spells;
	private Array<Enemy> _enemies;
	private Array<EnemySpell> _enemySpells;
	
	private ShapeSelector _shapeSelector;
	private ColorSelector _colorSelector;

	
	public GameWorld(){
		_hero = new Hero(64, 64, 800/2 - 64/2, 20);
		_spells = new Array<Spell>();
		_enemies = new Array<Enemy>();
		_enemySpells = new Array<EnemySpell>();
		
		_shapeSelector = new ShapeSelector();
		_colorSelector = new ColorSelector();
		loadSelectors();
	}
	
	public void update(float delta){
		Gdx.app.log("GameWorld", "update");
		
		if(Gdx.input.isKeyPressed(Keys.SPACE) && _spells.size <= 8){
			if(_colorSelector.getSpellColor() != null){
				Spell spell = new Spell(16, 16, 
						_hero.getX(), _hero.getY(), _colorSelector.getSpellColor(), _shapeSelector.getSpellShape());
				
				_colorSelector.rotateDown();
				_shapeSelector.rotateLeft();
				
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
	
	public ShapeSelector getShapeSelector(){
		return _shapeSelector;
	}
	
	public ColorSelector getColorSelector(){
		return _colorSelector;
	}
	
	private void loadSelectors(){
		_shapeSelector.insert(new CircleSpell(), 0);
		_shapeSelector.insert(new RectangleSpell(), 1);
		_shapeSelector.insert(new CircleSpell(), 2);
		_shapeSelector.insert(new RectangleSpell(), 3);
		
		_colorSelector.insert(new WhiteSpell(), 0);
		_colorSelector.insert(new RedSpell(), 1);
		_colorSelector.insert(new WhiteSpell(), 2);
		_colorSelector.insert(new RedSpell(), 3);
	}
}