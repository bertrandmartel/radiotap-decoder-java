package fr.bmartel.protocol.radiotap.inter;

/**
 * Template for detecting presence or not of data type in radiotap header
 * 
 * @author Bertrand Martel
 *
 */
public interface IRadiotapFlags {

	public boolean isTFST();
	
	public boolean isFlags();
	
	public boolean isDataRate();
	
	public boolean isChannel();
	
	public boolean isFHSS();
	
	public boolean isDbmAntSignal();
	
	public boolean isDbmAntNoise();
	
	public boolean isLockQuality();
	
	public boolean isTxAttenuation();
	
	public boolean isDbTxAttenuation();
	
	public boolean isDbmTxPower();
	
	public boolean isAntenna();
	
	public boolean isDbAntennaSignal();
	
	public boolean isDbAntennaNoise();
	
	public boolean isRxFlags();
	
	public boolean isMcs();
	
	public boolean isAmpdu();
	
	public boolean isVht();
}
