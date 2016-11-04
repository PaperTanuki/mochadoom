package net.sourceforge.mochadoom.daycycle;

import net.sourceforge.mochadoom.doom.DoomMain;

/**
 * Implements common functionality for states.
 * 
 * @author Franco Cruces
 *
 */
public abstract class ADayPart implements IDayPart {

	protected DoomMain<?,?> DM;	// printing messages
	protected Kronos kronos;	// state changes
	protected int myDuration;	// duration in ticks for this cycle
	
	/**
	 * Constructor, needs a Kronos to change its state, needs a DoomMain to in order to print.
	 * 
	 * @param DM - Current DoomMain
	 * @param aKronos - Kronos controlling
	 */
	public ADayPart(DoomMain<?,?> DM, Kronos aKronos){
		//TODO May not need the DoomMain
		this.DM = DM;
		this.kronos = aKronos;
		this.myDuration = this.getMyLength();
	}
	
	/**
	 * Method called every time Kronos receives a tick.
	 * Increases time in this period and checks what to do.
	 */
	@Override
	public void Ticker(){
		checkTime();
	}
	
	/**
	 * Checks if has to display a message or change state.
	 */
	@Override
	public void checkTime(){
		if ((this.DM.leveltime % this.myDuration) == 1){
			this.display(this.startMessage());
		}
		if ((this.DM.leveltime % this.myDuration) == ( this.myDuration / 2 ) ){
			this.display(this.halfMessage());
		}
		if ((this.DM.leveltime % this.myDuration) == ( this.myDuration* 4 / 5 )){
			this.display(this.almostOverMessage());
		}
		if ((this.DM.leveltime % this.myDuration) == 0 && this.DM.leveltime > 0){
			this.changePart();
		}
	}
	
	/**
	 * Displays given message via console player message.
	 */
	@Override
	public void display(String message) {
		// TODO Decide if necessary. It could have less information using a printer. 
		this.DM.players[this.DM.consoleplayer].message = message;
	}

	/**
	 * Returns time spent on current state.
	 */
	@Override
	public int getTimeInPart(){
		return this.DM.leveltime % this.myDuration;
	}
	
	/**
	 * Returns time spent on current state.
	 */
	@Override
	public int getLevelTime(){
		return this.DM.leveltime;
	}
}
