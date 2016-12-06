package net.sourceforge.mochadoom.daycycle;

import net.sourceforge.mochadoom.doom.DoomMain;

/**
 * Implements common functionality for moon phases.
 * 
 * @author Franco Cruces
 *
 */
public abstract class AMoonPhase implements IMoonPhase {
	protected DoomMain<?, ?> DM;
	protected Kronos kronos;

	/**
	 * Constructor.
	 * @param DM - DoomMain for leveltime consulting
	 * @param aKronos - kronos for state switching
	 */
	public AMoonPhase(DoomMain<?, ?> DM, Kronos aKronos) {
		this.DM = DM;
		this.kronos = aKronos;
	}

	@Override
	public boolean isNew() {
		return false;
	}

	@Override
	public boolean isYoung() {
		return false;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public boolean isOld() {
		return false;
	}

}
