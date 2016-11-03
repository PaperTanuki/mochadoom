package net.sourceforge.mochadoom.daycycle;

import net.sourceforge.mochadoom.doom.DoomMain;

/**
 * Monsters' attributes during the night. State Pattern.
 * 
 * @author Franco Cruces
 *
 */
public class Night extends ADayPart {

	public Night(DoomMain<?,?> DM, Kronos aKronos) {
		super(DM, aKronos);
	}
	
	//TODO Replace with correct values and parameters.
	@Override
	public float getVampireDamageMultiplier() {
		// Example
		return 2;
	}

	@Override
	public float getWerewolfDamageMultiplier() {
		// Example
		return 2;
	}

	@Override
	public String startMessage() {
		return "Dusk has fallen...";
	}

	@Override
	public String halfMessage() {
		return "It's midnight.";
	}

	@Override
	public int myLength() {
		return this.kronos.getNightLength();
	}

	@Override
	public void changePart() {
		this.kronos.setDayPart(new Day(this.DM, this.kronos));
	}

	@Override
	public String almostOverMessage() {
		return "Keep it up. Nighttime is almost over";
	}
}
