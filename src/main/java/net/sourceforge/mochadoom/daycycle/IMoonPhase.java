package net.sourceforge.mochadoom.daycycle;

import net.sourceforge.mochadoom.doom.DoomMain;

/**
 * Interface for states representing moon cycles. Each moon gives monsters
 * different attributes.
 * 
 * @author Franco Cruces
 *
 */
public interface IMoonPhase {
	
	/**
	 * Method that creates the Moon using Singleton pattern.
	 */
	IMoonPhase getInstance(DoomMain<?, ?> DM, Kronos aKronos);
	
	/**
	 * State pattern method. Switches current moon phase to the next one.
	 */
	void changeState();

	/**
	 * Returns true if current moon phase is New Moon. Returns false otherwise.
	 */
	boolean isNew();

	/**
	 * Returns true if current moon phase is Young Moon. Returns false otherwise.
	 */
	boolean isYoung();

	/**
	 * Returns true if current moon phase is Full Moon. Returns false otherwise.
	 */
	boolean isFull();

	/**
	 * Returns true if current moon phase is Old Moon. Returns false otherwise.
	 */
	boolean isOld();
}
