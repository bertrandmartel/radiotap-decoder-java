package fr.bmartel.protocol.radiotap.inter;

import fr.bmartel.protocol.radiotap.RadioTapMCS;
import fr.bmartel.protocol.radiotap.RadioTapVHT;

/**
 * Template for Radiotap data 
 * 
 * @author Bertrand Martel
 *
 */
public interface IRadiotapData {

	/** Properties of transmitted and received frames. */
	public int getFlags();
	
	/** TX/RX data rate in Mbps */
	public int getDataRate();
	
	public IRadiotapChannel getChannel();
	
	/** The hop set and pattern for frequency-hopping radios. */
	public byte getFHSS();
	
	/**
	 * RF signal power at the antenna. This field contains a single signed 8-bit
	 * value, which indicates the RF signal power at the antenna, in decibels
	 * difference from 1mW.
	 */
	public byte getDbmAntSignal();
	
	/**
	 * RF noise power at the antenna. This field contains a single signed 8-bit
	 * value, which indicates the RF signal power at the antenna, in decibels
	 * difference from 1mW.
	 */
	public byte getDbmAntNoise();
	
	/**
	 * Quality of Barker code lock. Unitless. Monotonically nondecreasing with
	 * "better" lock strength. Called "Signal Quality" in datasheets
	 */
	public int getLockQuality();
	
	/**
	 * Transmit power expressed as decibel distance from max power set at
	 * factory calibration. 0 is max power. Monotonically nondecreasing with
	 * lower power levels.
	 */
	public int getDbTxAttenuation();
	
	/** data payload extracted from radio tap header */
	public byte[] getPayload();
	
	/**
	 * Value in microseconds of the MAC's 64-bit 802.11 Time Synchronization
	 * Function timer when the first bit of the MPDU arrived at the MAC. For
	 * received frames only.
	 */
	public Long getTFST();
	
	/**
	 * Transmit power expressed as dBm (decibels from a 1 milliwatt reference).
	 * This is the absolute power level measured at the antenna port.
	 */
	public byte getDbmTxPower();
	
	/**
	 * Unitless indication of the Rx/Tx antenna for this packet. The first
	 * antenna is antenna 0.
	 */
	public byte getAntenna();
	
	/**
	 * RF signal power at the antenna, decibel difference from an arbitrary,
	 * fixed reference. This field contains a single unsigned 8-bit value.
	 */
	public byte getDbAntennaSignal();
	
	/**
	 * RF noise power at the antenna, decibel difference from an arbitrary,
	 * fixed reference. This field contains a single unsigned 8-bit value.
	 */
	public byte getDbAntennaNoise();
	
	/**
	 * Define if a PLCP (Physical Layer Convergence Protocol) CRC error was detected on this frame
	 * @return
	 */
	public boolean isPlcpCrcErrors();
	
	/**
	 * Modulation coding scheme
	 */
	public RadioTapMCS getMcs();
	
	/**
	 * Very High Throughput
	 */
	public RadioTapVHT getVht();
	
	/**
	 * Transmit power expressed as unitless distance from max power set at factory calibration
	 * 
	 * @return
	 */
	public int getTxAttenuation();
	
}
