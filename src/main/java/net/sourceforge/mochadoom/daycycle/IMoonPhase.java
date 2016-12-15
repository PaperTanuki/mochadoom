package net.sourceforge.mochadoom.daycycle;

/**
 * Interface for states representing moon cycles. Each moon gives monsters
 * different attributes.
 * 
 * @author Franco Cruces
 *
 */
public interface IMoonPhase {

	/**
	 * State pattern method. Switches current moon phase to the next one.
	 */
	void changeState();

	/**
	 * Returns true if current moon phase is New Moon. Returns false otherwise.
	 */
	boolean isNew();

	/**
	 * Returns true if current moon phase is Young Moon. Returns false
	 * otherwise.
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

	String message();
}
