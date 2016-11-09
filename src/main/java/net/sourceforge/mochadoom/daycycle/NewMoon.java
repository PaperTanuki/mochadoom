package net.sourceforge.mochadoom.daycycle;

import net.sourceforge.mochadoom.doom.DoomMain;

public class NewMoon extends AMoonPhase {
	
	static NewMoon instance = null;

	protected NewMoon(DoomMain<?, ?> DM, Kronos kronos) {
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
	
	@Override
	public IMoonPhase getInstance(DoomMain<?, ?> DM, Kronos aKronos) {
		if (instance == null) {
			instance = new NewMoon(DM, aKronos);
		}
		return instance;
	}


}
