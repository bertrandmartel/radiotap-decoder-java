package fr.bmartel.radiotapdecoder.main;

import java.util.ArrayList;

import fr.bmartel.protocol.radiotap.inter.IRadioTapFrame;

/**
 * 
 * Display all radiotap decoded information
 * 
 * @author Bertrand Martel
 *
 */
public class DisplayPacket {

	/**
	 * Display all packet info
	 * 
	 * @param radiotapFrame
	 */
	public static void decode(ArrayList<IRadioTapFrame> radiotapFrame)
	{
		System.out.println("###############################################################################################");
		for (int i = 0; i < radiotapFrame.size();i++)
		{
			System.out.println("RadioTap Version : " + radiotapFrame.get(i).getRadiotapVersion());
			System.out.println("RadioTap length  : " + radiotapFrame.get(i).getRadioTapDataLength());
			System.out.println("RadioTap data    : ");
			
			if (radiotapFrame.get(i).getRadioTapFlagList().isTFST())
				System.out.println("\tTFST                 : " + radiotapFrame.get(i).getRadioTapData().getTFST() + "ms");
			if (radiotapFrame.get(i).getRadioTapFlagList().isFlags())
				System.out.println("\tflags                : " + radiotapFrame.get(i).getRadioTapData().getFlags());
			if (radiotapFrame.get(i).getRadioTapFlagList().isDataRate())
				System.out.println("\tdata rate            : " + radiotapFrame.get(i).getRadioTapData().getDataRate()+"kbps");
			if (radiotapFrame.get(i).getRadioTapFlagList().isDbmAntSignal())
				System.out.println("\tant signal in dbm    : " + radiotapFrame.get(i).getRadioTapData().getDbmAntSignal()+" dbm");
			if (radiotapFrame.get(i).getRadioTapFlagList().isDbmAntNoise())
				System.out.println("\tant noise in dbm     : " + radiotapFrame.get(i).getRadioTapData().getDbmAntNoise()+" dbm");
			if (radiotapFrame.get(i).getRadioTapFlagList().isLockQuality())
				System.out.println("\tlock quality         : " + radiotapFrame.get(i).getRadioTapData().getLockQuality()+" (unitless)");
			if (radiotapFrame.get(i).getRadioTapFlagList().isDbTxAttenuation())
				System.out.println("\ttx Attenuation       : " + radiotapFrame.get(i).getRadioTapData().getDbTxAttenuation()+" db");
			if (radiotapFrame.get(i).getRadioTapFlagList().isTxAttenuation())
				System.out.println("\ttx Attenuation       : " + radiotapFrame.get(i).getRadioTapData().getTxAttenuation()+" (unitless) (max power emitted)");
			if (radiotapFrame.get(i).getRadioTapFlagList().isDbmTxPower())
				System.out.println("\ttx power in dbm      : " + radiotapFrame.get(i).getRadioTapData().getDbmTxPower()+" dbm (absolute power level measured at the antenna port)");
			if (radiotapFrame.get(i).getRadioTapFlagList().isAntenna())
				System.out.println("\tantenna              : " + radiotapFrame.get(i).getRadioTapData().getAntenna()+" (unitless) (indication of the Rx/Tx antenna for this packet. The first antenna is antenna 0)");
			if (radiotapFrame.get(i).getRadioTapFlagList().isDbAntennaSignal())
				System.out.println("\tantenna signal in db : " + radiotapFrame.get(i).getRadioTapData().getDbAntennaSignal()+" db (RF signal power at the antenna, decibel difference from an arbitrary, fixed reference)");
			if (radiotapFrame.get(i).getRadioTapFlagList().isDbAntennaNoise())
				System.out.println("\tantenna noise in db  : " + radiotapFrame.get(i).getRadioTapData().getDbAntennaNoise()+" db (RF noise power at the antenna, decibel difference from an arbitrary, fixed reference)");
			if (radiotapFrame.get(i).getRadioTapFlagList().isRxFlags())
				System.out.println("\tPLCP CRC error       : " + radiotapFrame.get(i).getRadioTapData().isPlcpCrcErrors());
			
			if (radiotapFrame.get(i).getRadioTapFlagList().isChannel())
			{
				System.out.println("\t\tchannel number         : " + radiotapFrame.get(i).getRadioTapData().getChannel().getChannelNum());
				System.out.println("\t\tfrequency used         : " + radiotapFrame.get(i).getRadioTapData().getChannel().getFrequency()+"MHz");
				System.out.println("\t\tCCK channel            : " + radiotapFrame.get(i).getRadioTapData().getChannel().isCckChannel());
				System.out.println("\t\tDYNAMIC CCK channel    : " + radiotapFrame.get(i).getRadioTapData().getChannel().isDynamicCckOfdmChannel());
				System.out.println("\t\tGFSK channel           : " + radiotapFrame.get(i).getRadioTapData().getChannel().isGfskChannel());
				System.out.println("\t\tOFDM channel           : " + radiotapFrame.get(i).getRadioTapData().getChannel().isOfdmChannel());
				System.out.println("\t\tonly passive scan      : " + radiotapFrame.get(i).getRadioTapData().getChannel().isOnlyPassiveScanAllowed());
				System.out.println("\t\tspectrum channel 2GHZ  : " + radiotapFrame.get(i).getRadioTapData().getChannel().isSpectrumChannel2GHZ());
				System.out.println("\t\tspectrum channel 5GHZ  : " + radiotapFrame.get(i).getRadioTapData().getChannel().isSpectrumChannel5GHZ());
				System.out.println("\t\tturbo channel          : " + radiotapFrame.get(i).getRadioTapData().getChannel().isTurboChannel());
			}
			
			if (radiotapFrame.get(i).getRadioTapFlagList().isFHSS())
			{
				System.out.print("FHSS NOT DECODED !!!!");
			}
			if (radiotapFrame.get(i).getRadioTapFlagList().isVht())
			{
				System.out.print("VHT NOT DECODED !!!!");
			}
			if (radiotapFrame.get(i).getRadioTapFlagList().isMcs())
			{
				System.out.print("MCS NOT DECODED !!!!");
			}
			if (radiotapFrame.get(i).getRadioTapFlagList().isAmpdu())
			{
				System.out.print("AMPDU NOT DECODED !!!!");
			}
			System.out.println("###############################################################################################");
		}
	}
}
