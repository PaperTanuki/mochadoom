package net.sourceforge.mochadoom.daycycle;

import net.sourceforge.mochadoom.doom.DoomMain;

public class YoungMoon extends AMoonPhase {

	public YoungMoon(DoomMain<?, ?> DM, Kronos kronos) {
		super(DM, kronos);
	}

	@Override
	public void changeState() {
		this.kronos.setMoon(new FullMoon(DM, kronos));
	}

	@Override
	public boolean isYoung() {
		return true;
	}

	@Override
	public String message() {
		return DaycycleConfig.youngMoon_startMessage;
	}

}
