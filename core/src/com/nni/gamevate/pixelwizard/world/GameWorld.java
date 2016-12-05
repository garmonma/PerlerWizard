package com.nni.gamevate.pixelwizard.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
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
import com.nni.gamevate.pixelwizard.utils.InputHandler;

public class GameWorld {

	private Hero _hero;
	private Array<Spell> _spells;
	private Array<Enemy> _enemies;
	private Array<EnemySpell> _enemySpells;
	
	private ShapeSelector _shapeSelector;
	private ColorSelector _colorSelector;
	private long _lastSpell;
	
	private InputHandler _inputHandler;
	
	public GameWorld(){
		_hero = new Hero(64, 64, 800/2 - 64/2, 20);
		_spells = new Array<Spell>();
		_enemies = new Array<Enemy>();
		_enemySpells = new Array<EnemySpell>();
		
		_shapeSelector = new ShapeSelector();
		_colorSelector = new ColorSelector();
		loadSelectors();
		
		_inputHandler = new InputHandler(this);
		Gdx.input.setInputProcessor(_inputHandler);
	}
	
	public void update(float delta){
		//Gdx.app.log("GameWorld", "update");
		
	//	if(Gdx.input.isKeyPressed(Keys.SPACE) && _spells.size <= 8){
			castSpell();
			
		//}
		
		
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
	
	public void castSpell(){
		// 1.5 second global cooldown;
		
		if(TimeUtils.timeSinceNanos(_lastSpell) > 1500000000){	
			Gdx.app.log("Cooldown", 
					_colorSelector.getSpellColor().isOnCooldown(_colorSelector.getSpellColor().getCooldown()) + ""); 
			
			if(!_colorSelector.getSpellColor().isOnCooldown(_colorSelector.getSpellColor().getCooldown())){	
				Spell spell = new Spell(16, 16, 
						_hero.getX(), _hero.getY(), _colorSelector.getSpellColor(), _shapeSelector.getSpellShape());
				
				_colorSelector.rotateDown();
				_shapeSelector.rotateLeft();
				
				_spells.add(spell);	
				_lastSpell = TimeUtils.nanoTime();
			}	
		}
	}
}