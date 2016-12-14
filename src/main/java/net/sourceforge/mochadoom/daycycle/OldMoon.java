package net.sourceforge.mochadoom.daycycle;

import net.sourceforge.mochadoom.doom.DoomMain;

public class OldMoon extends AMoonPhase {

	public OldMoon(DoomMain<?, ?> DM, Kronos kronos) {
		super(DM, kronos);
	}

	@Override
	public void changeState() {
		this.kronos.setMoon(new NewMoon(DM, kronos));
	}

	@Override
	public boolean isOld() {
		return true;
	}

	@Override
	public String message() {
		return DaycycleConfig.oldMoon_startMessage;
	}

}
