
package com.nni.gamevate.perlerwizard.object.hero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;
import com.nni.gamevate.perlerwizard.object.hero.equipment.Equipment;
import com.nni.gamevate.perlerwizard.object.skills.Skill;
import com.nni.gamevate.perlerwizard.object.skills.Skills;
import com.nni.gamevate.perlerwizard.object.skills.defense.EnergyShield;
import com.nni.gamevate.perlerwizard.object.skills.defense.Reflect;
import com.nni.gamevate.perlerwizard.object.skills.throwables.JavelinThrow;

public class Knight extends Hero {

	private final long REFLECT_REFRESH_TIMER = 500;
	private final long JAVELIN_THROW_REFRESH_TIMER = 3000;

	private long reflectLastCast;
	private long javelinThrowLastCast;

	public Knight(int width, int height, float x, float y, int level) {
		super(width, height, x, y, level);

		_speed = 6;
		//_hitPoints = (int) Math.ceil(_level * 32 * currentHealth);

		reflectLastCast = 0;
		javelinThrowLastCast = 0;
	}

	public Skill attack(int selectedSkill) {

		if (javelinThrowLastCast == 0 || TimeUtils.millis() - javelinThrowLastCast > JAVELIN_THROW_REFRESH_TIMER) {
			javelinThrowLastCast = TimeUtils.millis();
			Gdx.app.log("Casting", "Javelin Throw");
			return new JavelinThrow(getX() + getWidth() / 2, getY() + getHeight());
		}

		return null;
	}

	@Override
	public Skill castSpecial() {
		return null;
	}

	@Override
	public Skill castDefense() {
		if (reflectLastCast == 0 || TimeUtils.millis() - reflectLastCast > REFLECT_REFRESH_TIMER) {
			reflectLastCast = TimeUtils.millis();

			Gdx.app.log("Casting", "Reflect");
			return new Reflect(getX() - .10f, getY() + getHeight() + .15f, this);
		}

		return null;
	}

	@Override
	public void setEquipmentSlotOne(Equipment item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEquipmentSlotTwo(Equipment item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEquipmentSlotThree(Equipment item) {
		// TODO Auto-generated method stub

	}

	@Override
	public Skill attack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Skill attack(Skills skill) {
		// TODO Auto-generated method stub
		return null;
	}

}
