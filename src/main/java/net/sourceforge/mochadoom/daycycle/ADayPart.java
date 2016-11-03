package net.sourceforge.mochadoom.daycycle;

import net.sourceforge.mochadoom.doom.DoomMain;

/**
 * Implements common functionality for states.
 * 
 * @author Franco Cruces
 *
 */
public abstract class ADayPart implements IDayPart {

	protected int timeInPart;	// length control
	protected Kronos kronos;	// state changes
	protected DoomMain<?,?> DM;	// printing messages
	
	/**
	 * Constructor, needs a Kronos to change its state, needs a DoomMain in order to print.
	 * 
	 * @param DM - Current DoomMain
	 * @param aKronos - Kronos controlling
	 */
	public ADayPart(DoomMain<?,?> DM, Kronos aKronos){
		//TODO May not need the DoomMain
		this.DM = DM;
		this.timeInPart = 0;
		this.kronos = aKronos;
		this.display(this.startMessage());
	}
	/**
	 * Method called every time Kronos receives a tick.
	 * Increases time in this period and checks what to do.
	 */
	@Override
	public void Ticker(){
		this.timeInPart++;
		checkTime();
	}
	
	/**
	 * Checks if has to display a message or change state.
	 */
	@Override
	public void checkTime(){
		if (this.timeInPart == ( this.myLength() * 4 / 5 )){
			this.display(this.almostOverMessage());
		}
		if (this.timeInPart == ( this.myLength() / 2 ) ){
			this.display(this.halfMessage());
		}
		if (this.timeInPart == this.myLength()){
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
		return this.timeInPart;
	}
}
