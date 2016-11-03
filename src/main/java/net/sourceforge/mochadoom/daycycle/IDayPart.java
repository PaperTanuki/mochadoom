package net.sourceforge.mochadoom.daycycle;

/**
 * Interface for states representing parts of the day.
 * Each part of the day gives monsters different attributes.
 * Current methods are only examples. 
 * 
 * @author Franco Cruces
 *
 */
public interface IDayPart {
	void Ticker();
	int getTimeInPart();
	/**
	 * Returns message to show when period starts.
	 */
	String startMessage();
	/**
	 * Returns message to show when half the period has passed.
	 */
	String halfMessage();
	/**
	 * Returns message to show when the period is a fifth left.
	 */
	String almostOverMessage();
	int myLength();
	void changePart();
	void checkTime();
	void display(String message);
	//TODO Make attributes change depending on current game difficulty.
	//TODO Add correct methods. These are examples.
	public float getVampireDamageMultiplier();
	public float getWerewolfDamageMultiplier();
}
