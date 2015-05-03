package fr.bmartel.protocol.radiotap.inter;


/**
 * Template for Channel field of radiotap heder 
 * 
 * Tx/Rx frequency in MHz and modulation used or not
 * 
 * @author Bertrand Martel
 *
 */
public interface IRadiotapChannel {

	/**
	 * Channel being used
	 * 
	 * @return
	 */
	public int getChannelNum();

	/**
	 * Turbo mode increase channel to 40MHz instead of 20MHz
	 * @return
	 */
	public boolean isTurboChannel();

	/**
	 * Complementary Code Keying Modulation
	 * 
	 * @return
	 */
	public boolean isCckChannel();

	/**
	 * Orthogonal Frequency Division Multiplexing 
	 * 
	 * @return
	 */
	public boolean isOfdmChannel();

	/**
	 * Channel 2Ghz used
	 * 
	 * @return
	 */
	public boolean isSpectrumChannel2GHZ();

	/**
	 * Channel 5Ghz used
	 * 
	 * @return
	 */
	public boolean isSpectrumChannel5GHZ();

	/**
	 * Define if passive scan is allowed
	 * @return
	 */
	public boolean isOnlyPassiveScanAllowed();

	/**
	 * uses OFDM or use CCK (switching possible)
	 * 
	 * @return
	 */
	public boolean isDynamicCckOfdmChannel();

	/**
	 * Gaussian Frequency Shift Keying Modulation
	 * 
	 * @return
	 */
	public boolean isGfskChannel();

	/** Tx/Rx frequency in MHz */
	public int getFrequency();
}
