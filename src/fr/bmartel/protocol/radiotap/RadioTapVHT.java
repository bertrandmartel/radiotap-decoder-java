package fr.bmartel.protocol.radiotap;

/**
 * Define Very High ThroughPut radio header type
 * 
 * @author Bertrand Martel
 * 
 */
public class RadioTapVHT {

	public RadioTapVHT(byte[] known, byte flags, byte bandwith, byte mcs_nss,
			byte coding, byte groupId, byte[] partialAid) {
		System.out.println("Very High ThroughPut detected... Not treating...");
	}
}
