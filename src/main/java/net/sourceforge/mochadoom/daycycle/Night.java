package net.sourceforge.mochadoom.daycycle;

import net.sourceforge.mochadoom.daycycle.DaycycleConfig;
import net.sourceforge.mochadoom.doom.DoomMain;

/**
 * State pattern class representing nighttime.
 * 
 * @author Franco Cruces
 *
 */
public class Night extends ADayPart {
	
	private Night instance = null;
	private Day next = null;

	protected Night(DoomMain<?, ?> DM, Kronos aKronos) {
		super(DM, aKronos);
	}

	@Override
	public int getMyDuration() {
		switch (DM.gameskill) {
		case sk_baby:
			return DaycycleConfig.baby_nightDuration;
		case sk_easy:
			return DaycycleConfig.easy_nightDuration;
		case sk_medium:
			return DaycycleConfig.medium_nightDuration;
		case sk_hard:
			return DaycycleConfig.hard_nightDuration;
		case sk_nightmare:
			return DaycycleConfig.nightmare_nightDuration;
		default:
			return -1;
		}
	}

	@Override
	public void changePart() {
		this.kronos.setDayPart(next.getInstance(this.DM, this.kronos));
	}

	@Override
	public String startMessage() {
		return DaycycleConfig.night_startMessage;
	}

	@Override
	public String halfMessage() {
		return DaycycleConfig.night_halfMessage;
	}

	@Override
	public String almostOverMessage() {
		return DaycycleConfig.night_almostOverMessage;
	}

	@Override
	public boolean isNight() {
		return true;
	}

	@Override
	public IDayPart getInstance(DoomMain<?, ?> DM, Kronos aKronos) {
		if (instance == null) {
			instance = new Night(DM, aKronos);
		}
		return instance;
	}
}