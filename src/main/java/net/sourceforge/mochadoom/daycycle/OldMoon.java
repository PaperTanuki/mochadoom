package net.sourceforge.mochadoom.daycycle;

import net.sourceforge.mochadoom.doom.DoomMain;

public class OldMoon extends AMoonPhase {
	
	private OldMoon instance = null;

	protected OldMoon(DoomMain<?, ?> DM, Kronos kronos) {
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
	public IMoonPhase getInstance(DoomMain<?, ?> DM, Kronos aKronos) {
		if (instance == null) {
			instance = new OldMoon(DM, aKronos);
		}
		return instance;
	}


}
