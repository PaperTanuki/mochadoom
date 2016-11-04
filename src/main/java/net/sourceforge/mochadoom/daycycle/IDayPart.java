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
	/**
	 * Method called every time Kronos receives a tick.
	 * Increases time in this period and checks what to do.
	 */
	void Ticker();
	
	/**
	 * Consults duration and writes it to corresponding field.
	 */
	int getMyDuration();
	
	/**
	 * Returns the value on myDuration field.
	 */
	int getDuration();
	
	/**
	 * Returns time spent on current state.
	 */
	int getTimeInPart();
	
	/**
	 * Returns time spent on current .
	 */
	int getLevelTime();
	
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
	
	/**
	 * State pattern method. Switches to day or night.
	 */
	void changePart();
	
	/**
	 * Checks if has to display a message or change state.
	 */
	void checkTime();
	
	/**
	 * Displays given message via console player message.
	 */
	void display(String message);
	
	//TODO Make attributes change depending on current game difficulty.
	//TODO Add correct methods. These are examples.
	public float getVampireDamageMultiplier();
	public float getWerewolfDamageMultiplier();
}
