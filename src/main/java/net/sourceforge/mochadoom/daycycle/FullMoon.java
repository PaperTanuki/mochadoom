package net.sourceforge.mochadoom.daycycle;

import net.sourceforge.mochadoom.doom.DoomMain;

public class FullMoon extends AMoonPhase {

	public FullMoon(DoomMain<?, ?> DM, Kronos kronos) {
		super(DM, kronos);
	}

	@Override
	public void changeState() {
		this.kronos.setMoon(new OldMoon(DM, kronos));
	}

	@Override
	public boolean isFull() {
		return true;
	}

	@Override
	public String message() {
		return DaycycleConfig.fullMoon_startMessage;
	}

}
