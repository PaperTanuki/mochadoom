package net.sourceforge.mochadoom.daycycle;

import net.sourceforge.mochadoom.doom.DoomMain;

/**
 * State pattern class representing daytime.
 * 
 * @author Franco Cruces
 *
 */
public class Day extends ADayPart {

	public Day(DoomMain<?, ?> DM, Kronos aKronos) {
		super(DM, aKronos);
	}

	@Override
	public int getMyDuration() {
		switch (DM.gameskill) {
		case sk_baby:
			return DaycycleConfig.baby_dayDuration;
		case sk_easy:
			return DaycycleConfig.easy_dayDuration;
		case sk_medium:
			return DaycycleConfig.medium_dayDuration;
		case sk_hard:
			return DaycycleConfig.hard_dayDuration;
		case sk_nightmare:
			return DaycycleConfig.nightmare_dayDuration;
		default:
			return -1;
		}
	}

	@Override
	public void changePart() {
		this.kronos.setDayPart(new Night(this.DM, this.kronos));
	}

	@Override
	public String startMessage() {
		this.DM.R.brighter();
	    this.DM.R.brighter();
		return DaycycleConfig.day_startMessage;
	}

	@Override
	public String halfMessage() {

        this.DM.R.brighter();

		return DaycycleConfig.day_halfMessage;
	}

	@Override
	public String almostOverMessage() {

        this.DM.R.darker();
		this.DM.R.darker();
		return DaycycleConfig.day_almostOverMessage;
	}

	@Override
	public boolean isDay() {
		return true;
	}

}
