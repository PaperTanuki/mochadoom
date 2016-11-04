package net.sourceforge.mochadoom.daycycle;

import net.sourceforge.mochadoom.doom.DoomMain;

/**
 * God of time. Controls changes between parts of the day and time spent inside the level.
 * 
 * @author Franco Cruces
 *
 */
public class Kronos {
	// TODO Decide how to display different states
	
	// Everything measured in ticks
	// 35 ticks == 1 second
	
	// TODO Implement different cycles for each skill level.
	// TODO Move to defines
	private final int dayDuration = 35 * 30;
	private final int nightDuration = 35 * 45;
	private IDayPart dayPart;
	private DoomMain<?,?> DM;
	
	public Kronos(DoomMain<?,?> DM){
		this.DM = DM;
		this.dayPart = new Day(DM, this);
	}
	/**
	 * Method called with every tick while in level.
	 * 
	 * @param DM - current game.
	 */
	public void Ticker() {
		this.DM.leveltime++; // must be done first
		this.dayPart.Ticker(); // tells dayPart that a tick has passed
		
		// message for testing: DM.players[DM.consoleplayer].message = ((int)DM.leveltime/(60*35))+" mins, " + (DM.leveltime/35)%60 + " secs.";
		// btw, gameskill is accessible by DM.gameskill
	}
	
	public IDayPart currentDayPart(){
		return this.dayPart;
	}
	
	public void setDayPart(IDayPart aDayPart){
		this.dayPart = aDayPart;
	}
	
	public int getDayLength(){
		return this.dayDuration;
	}

	public int getNightLength(){
		return this.nightDuration;
	}
	
	public int getLevelTime(){
		return this.dayPart.getLevelTime();
	}
	
	public int getPartTime(){
		return this.dayPart.getTimeInPart();
	}
}
