package com.nni.gamevate.pixelwizard.object.spells;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;
import com.nni.gamevate.pixelwizard.object.GameObject;
import com.nni.gamevate.pixelwizard.object.spells.color.SpellColor;
import com.nni.gamevate.pixelwizard.object.spells.shape.SpellShape;

public final class Spell extends GameObject implements SpellInterface {
	private static final double BASE_SPEED = 100;
	private static final int DEFAULT_BOUNCE_COUNT = 3;
	private static final int DEFAULT_DAMAGE = 1;
	private static final int DEFAULT_SPIN = 0;
	private static final int MAX_SPIN = 1;
	private static final int MIN_SPIN = -1;

	private SpellColor _color;

	private SpellShape _shape;

	private double _speed;

	private double _dmg;

	private double _spin;

	private int _bounceCount;
	private int _bounceCounter;

	private long _spellTimer;

	private Shape2D _bindingShape;

	private Vector2 _velocity;

	public Spell(int width, int height, float x, float y, SpellColor color, SpellShape shape) {
		super(width, height, x, y);

		_color = color;
		_shape = shape;
		_bindingShape = determineBindingShape(shape.toString());

		_speed = BASE_SPEED * _color.getSpeedMultiplier();
		_spellTimer = _color.getCooldown();

		_dmg = DEFAULT_DAMAGE * _shape.getDmgMultiplier();
		_spin = DEFAULT_SPIN;

		_bounceCount = DEFAULT_BOUNCE_COUNT;
		_bounceCounter = _bounceCount;

	}

	@Override
	public void update(float delta) {
		if (_position.x < 150) {
			bounceOffWall("left");
		}

		if (_position.x > 650 - 64) {
			bounceOffWall("right");
		}
		
		if(_position.y > 480){
			bounceOffWall("top");
		}
		
		if(_position.y < 1){
			evaporate();
		}
	}

	@Override
	public void bounceOffWall(String side) {

		// Side can be left, right or center when bouncing off an object.
		if (side.equalsIgnoreCase("left")) {
			_spin = _spin + .1;
			if (_spin > MAX_SPIN)
				_spin = MAX_SPIN;
		} else if (side.equalsIgnoreCase("right")) {
			_spin = _spin - .1;
			if (_spin < MIN_SPIN)
				_spin = MIN_SPIN;
		}
	}

	@Override
	public void bounceOffEnemy(String side, String enemy) {
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

	public double getSpeed() {
		return _speed;
	}

	public double getDmg() {
		return _dmg;
	}

	public double getSpin() {
		return _spin;
	}

	public double getSpellTimer() {
		return _spellTimer;
	}

	private Shape2D determineBindingShape(String shapeDefinition) {
		if (shapeDefinition.equalsIgnoreCase("circle")) {
			Circle circle = new Circle();

			return circle;
		} else if (shapeDefinition.equalsIgnoreCase("rectangle")) {
			Rectangle rectangle = new Rectangle();

			return rectangle;
		}

		return null;
	}
}