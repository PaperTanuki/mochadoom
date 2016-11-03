package net.sourceforge.mochadoom.daycycle;

import net.sourceforge.mochadoom.doom.DoomMain;

/**
 * God of time. Controls changes between parts of the day.
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
	private final int dayLength = 35 * 30; 
	private final int nightLength = 35 * 45; 
	private IDayPart dayPart;
	
	public Kronos(){
		
	}
	/**
	 * Method called with every tick while in level.
	 * 
	 * @param DM - current game.
	 */
	public void Ticker(DoomMain<?,?> DM) {
		// Time message, may be useful: DM.players[DM.consoleplayer].message = ((int)DM.leveltime/(60*35))+" minutos y " + (DM.leveltime/35)%60 + " segundos.";
		
		// TODO Is there a better way? Will it always work?
		if (DM.leveltime <= 1){
			this.dayPart = new Day(DM, this);
		}
		this.dayPart.Ticker();
		
		// btw, gameskill is accessible by DM.gameskill
	}
	
	public IDayPart currentDayPart(){
		return this.dayPart;
	}
	
	public void setDayPart(IDayPart aDayPart){
		this.dayPart = aDayPart;
	}
	
	public int getDayLength(){
		return this.dayLength;
	}

	public int getNightLength(){
		return this.nightLength;
	}
}
