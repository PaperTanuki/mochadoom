package net.sourceforge.mochadoom.daycycle;

import net.sourceforge.mochadoom.doom.DoomMain;

/**
 * God of time. Controls changes between parts of the day and time spent inside
 * the level.
 * 
 * @author Franco Cruces
 *
 */
public class Kronos {
	// TODO Implement double dispatch to get current state.
	// TODO Decide how to display different states
	// TODO Move to defines
	
	private Day startDay = null;
	private IDayPart dayPart = null;
	private DoomMain<?, ?> DM;
	private NewMoon startMoon = null;
	private IMoonPhase moon = null;

	/**
	 * Constructor. Initializes part of the day and moon phase.
	 * 
	 * @param DM
	 *            - DoomMain. Required to access leveltime at any time.
	 */
	public Kronos(DoomMain<?, ?> DM) {
		this.DM = DM;
		this.dayPart = startDay.getInstance(this.DM, this);
		this.moon = startMoon.getInstance(this.DM, this);
	}

	/**
	 * Method called with every tick while in level.
	 */
	public void Ticker() {
		this.DM.leveltime++; // must be done first
		this.dayPart.Ticker(); // tells dayPart that a tick has passed

		// message for testing: DM.players[DM.consoleplayer].message =
		// ((int)DM.leveltime/(60*35))+" mins, " + (DM.leveltime/35)%60 + "
		// secs.";

		// btw, gameskill is accessible by DM.gameskill
	}

	/**
	 * Returns current part of the day.
	 */
	public IDayPart currentDayPart() {
		return this.dayPart;
	}

	/**
	 * State pattern method. Sets new part of the day.
	 */
	public void setDayPart(IDayPart aDayPart) {
		this.dayPart = aDayPart;
	}

	/**
	 * Returns current time level asking DoomMain.
	 */
	public int getLevelTime() {
		return this.DM.leveltime;
	}

	/**
	 * Returns time spent in current part of the day.
	 */
	public int getPartTime() {
		return this.dayPart.getTimeInPart();
	}

	/**
	 * State pattern method. Sets new moon phase.
	 */
	public void setMoon(IMoonPhase moon) {
		this.moon = moon;
	}

	/**
	 * Returns current phase of the moon.
	 */
	public IMoonPhase currentMoonPhase() {
		return this.moon;
	}
}
