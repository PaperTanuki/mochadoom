package net.sourceforge.mochadoom.daycycle;

import net.sourceforge.mochadoom.doom.DoomMain;

public class NewMoon extends AMoonPhase {

	public NewMoon(DoomMain<?, ?> DM, Kronos kronos) {
		super(DM, kronos);
	}

	@Override
	public void changeState() {
		this.kronos.setMoon(new YoungMoon(DM, kronos));
	}

	@Override
	public boolean isNew() {
		return true;
	}

}
