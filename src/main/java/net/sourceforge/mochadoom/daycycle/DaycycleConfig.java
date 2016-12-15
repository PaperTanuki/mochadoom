package net.sourceforge.mochadoom.daycycle;

import static net.sourceforge.mochadoom.data.Defines.TICRATE;

/**
 * Configuration for messages to show and cycle duration on daycycle control.
 * Could be somewhere else, but preferred not to modify a different package.
 * 
 * @author Franco Cruces
 *
 */
public final class DaycycleConfig {
	// Durations in ticks. Multiply by TICRATE for seconds equivalent.

	// Base durations for each gameskill.
	public static final int baby_dayDuration = 30 * TICRATE;
	public static final int baby_nightDuration = 25 * TICRATE;
	public static final int easy_dayDuration = 30 * TICRATE;
	public static final int easy_nightDuration = 30 * TICRATE;
	public static final int medium_dayDuration = 30 * TICRATE;
	public static final int medium_nightDuration = 40 * TICRATE;
	public static final int hard_dayDuration = 30 * TICRATE;
	public static final int hard_nightDuration = 50 * TICRATE;
	public static final int nightmare_dayDuration = 20 * TICRATE;
	public static final int nightmare_nightDuration = 60 * TICRATE;

	// Messages for each stage.
	public static final String day_startMessage = "Smile my boy. It's sunrise!";
	public static final String day_halfMessage = "It's noon.";
	public static final String day_almostOverMessage = "Brace yourself. Daytime is almost over.";
	public static final String night_startMessage = "";
	public static final String night_halfMessage = "It's midnight.";
	public static final String night_almostOverMessage = "Keep it up. Nighttime is almost over.";

	// Messages for each moon phase.
	public static final String newMoon_startMessage = "The night gives birth to a New Moon.";
	public static final String youngMoon_startMessage = "There's a Young Moon.";
	public static final String fullMoon_startMessage = "The Full Moon lightens up the night.";
	public static final String oldMoon_startMessage = "There's an Old Moon.";

}
