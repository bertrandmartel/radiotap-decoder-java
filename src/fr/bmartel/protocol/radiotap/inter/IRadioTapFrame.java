package fr.bmartel.protocol.radiotap.inter;

/**
 * Template for radiotap frame used in Radiotap decoder
 * 
 * @author Bertrand Martel
 *
 */
public interface IRadioTapFrame {

	/**
	 * Retrieve radio tap version (always 0) from radiotap.org
	 * 
	 * @return
	 */
	public int getRadiotapVersion();
	
	/**
	 * Retrieve length of the entire radiotap data including radiotap header
	 * 
	 * @return
	 */
	public int getRadioTapDataLength();
	
	/**
	 * Retrieve flag list used to tell which data will be present in radiotap data
	 * 
	 * @return
	 */
	public IRadiotapFlags getRadioTapFlagList();
	
	/**
	 * Retrieve radio tap data object
	 * 
	 * @return
	 */
	public IRadiotapData getRadioTapData();
}