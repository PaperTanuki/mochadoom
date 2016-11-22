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

	private IDayPart dayPart;
	private DoomMain<?, ?> DM;
	private IMoonPhase moon;

	/**
	 * Constructor. Initializes part of the day and moon phase.
	 * 
	 * @param DM
	 *            - DoomMain. Required to access leveltime at any time.
	 */
	public Kronos(DoomMain<?, ?> DM) {
		this.DM = DM;
		this.dayPart = new Day(DM, this);
		this.moon = new OldMoon(DM, this);
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
	 * Tells the moon to change its phase. Called by night constructor.
	 */
	public void changeMoon() {
		this.moon.changeState();
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
	
	// State access methods.
	
	public boolean isDay() {
		return this.dayPart.isDay();
	}

	public boolean isNight() {
		return this.dayPart.isNight();
	}
	
	public boolean isNew() {
		return this.moon.isNew();
	}

	public boolean isYoung() {
		return this.moon.isYoung();
	}

	public boolean isFull() {
		return this.moon.isFull();
	}

	public boolean isOld() {
		return this.moon.isOld();
	}

}
