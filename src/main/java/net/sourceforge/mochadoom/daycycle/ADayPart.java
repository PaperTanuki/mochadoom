package net.sourceforge.mochadoom.daycycle;

import net.sourceforge.mochadoom.doom.DoomMain;

/**
 * Implements common functionality for states.
 * 
 * @author Franco Cruces
 *
 */
public abstract class ADayPart implements IDayPart {

	protected DoomMain<?, ?> DM; // printing messages
	protected Kronos kronos; // state changes
	protected int myDuration; // duration in ticks for this cycle

	/**
	 * Constructor. Needs a Kronos to change its state, needs a DoomMain to in
	 * order to print.
	 * 
	 * @param DM
	 *            - Current DoomMain
	 * @param aKronos
	 *            - Kronos controlling
	 */
	public ADayPart(DoomMain<?, ?> DM, Kronos aKronos) {
		this.DM = DM;
		this.kronos = aKronos;
		this.myDuration = this.getMyDuration();
	}

	@Override
	public void Ticker() {
		checkTime();
	}

	@Override
	public void checkTime() {
		if ((this.DM.leveltime % this.myDuration) == 1) {
			this.display(this.startMessage());
		}
		if ((this.DM.leveltime % this.myDuration) == (this.myDuration / 2)) {
			this.display(this.halfMessage());
		}
		if ((this.DM.leveltime % this.myDuration) == (this.myDuration * 4 / 5)) {
			this.display(this.almostOverMessage());
		}
		if ((this.DM.leveltime % this.myDuration) == 0 && this.DM.leveltime > 0) {
			this.changePart();
		}
	}

	@Override
	public void display(String message) {
		// TODO Decide if necessary. Also could be different.
		this.DM.players[this.DM.consoleplayer].message = message;
	}

	@Override
	public int getTimeInPart() {
		return this.DM.leveltime % this.myDuration;
	}

	@Override
	public int getDuration() {
		return this.myDuration;
	}

	@Override
	public boolean isDay() {
		return false;
	}

	@Override
	public boolean isNight() {
		return false;
	}
	
}
