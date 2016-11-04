package net.sourceforge.mochadoom.daycycle;

import net.sourceforge.mochadoom.doom.DoomMain;

/**
 * Monsters' attributes during the day. State Pattern.
 * 
 * @author Franco Cruces
 *
 */
public class Day extends ADayPart {
	
	public Day(DoomMain<?,?> DM, Kronos aKronos) {
		super(DM, aKronos);
	}
	
	//TODO Replace with correct values and parameters.
	@Override
	public float getVampireDamageMultiplier() {
		// Example
		return 1;
	}

	@Override
	public float getWerewolfDamageMultiplier() {
		// Example
		return 1;
	}

	@Override
	public String startMessage(){
		return "Smile my boy. It's sunrise!";
	}
	
	@Override
	public String halfMessage(){
		return "It's noon.";
	}

	@Override
	public int getMyLength() {
		return this.kronos.getDayLength();
	}

	@Override
	public void changePart() {
		this.kronos.setDayPart(new Night(this.DM, this.kronos));
	}

	@Override
	public String almostOverMessage() {
		return "Brace yourself. Daytime is almost over.";
	}
}
