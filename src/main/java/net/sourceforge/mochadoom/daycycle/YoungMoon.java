package net.sourceforge.mochadoom.daycycle;

import net.sourceforge.mochadoom.doom.DoomMain;

public class YoungMoon extends AMoonPhase {
	
	static YoungMoon instance = null;

	protected YoungMoon(DoomMain<?, ?> DM, Kronos kronos) {
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
	public IMoonPhase getInstance(DoomMain<?, ?> DM, Kronos aKronos) {
		if (instance == null) {
			instance = new YoungMoon(DM, aKronos);
		}
		return instance;
	}


}
