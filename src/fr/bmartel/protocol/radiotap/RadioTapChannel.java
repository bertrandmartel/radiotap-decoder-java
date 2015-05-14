/**
 * The MIT License (MIT)
 * 
 * Copyright (c) 2015 Bertrand Martel
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package fr.bmartel.protocol.radiotap;

import fr.bmartel.protocol.radiotap.inter.IRadiotapChannel;
import fr.bmartel.utils.ByteUtils;

/**
 * Define radio type channel for tx characteristic
 * 
 * @author Bertrand Martel
 * 
 */
public class RadioTapChannel implements IRadiotapChannel{

	/** Tx/Rx frequency in MHz */
	private int frequency = 0x00;

	/** channel number */
	private int channelNum = 0x00;

	/** tx characteristics */
	private boolean turboChannel = false;
	private boolean cckChannel = false;
	private boolean ofdmChannel = false;
	private boolean spectrumChannel2GHZ = false;
	private boolean spectrumChannel5GHZ = false;
	private boolean onlyPassiveScanAllowed = false;
	private boolean dynamicCckOfdmChannel = false;
	private boolean gfskChannel = false;

	/**
	 * Build a radio channel object
	 * 
	 * @param frequency
	 * @param turboChannel
	 * @param cckChannel
	 * @param ofdmChannel
	 * @param spectrumChannel2GHZ
	 * @param spectrumChannel5GHZ
	 * @param onlyPassiveScanAllowed
	 * @param dynamicCckOfdmChannel
	 * @param gfskChannel
	 */
	public RadioTapChannel(byte[] frequency, byte[] bitmask) {

		this.frequency = ByteUtils.convertByteArrayToInt(frequency);

		if ((bitmask[1] & 0x10) != 0) {
			turboChannel = true;
		}
		if ((bitmask[1] & 0x20) != 0) {
			cckChannel = true;
		}
		if ((bitmask[1] & 0x40) != 0) {
			ofdmChannel = true;
		}
		if ((bitmask[1] & 0x80) != 0) {
			spectrumChannel2GHZ = true;
		}
		if ((bitmask[0] & 0x01) != 0) {
			spectrumChannel5GHZ = true;
		}
		if ((bitmask[0] & 0x02) != 0) {
			onlyPassiveScanAllowed = true;
		}
		if ((bitmask[0] & 0x04) != 0) {
			dynamicCckOfdmChannel = true;
		}
		if ((bitmask[0] & 0x08) != 0) {
			gfskChannel = true;
		}
		channelNum = chooseChannelNum();
	}

	/**
	 * 
	 * Choose channel number according to frequency<br/>
	 * http://fr.wikipedia.org/wiki/Liste_des_canaux_Wi-Fi<br/>
	 * http://en.wikipedia.org/wiki/List_of_WLAN_channels
	 * 
	 * @return
	 */
	public int chooseChannelNum() {

		// 2.4Ghz Bandwidth 802.11b/g/n
		switch (frequency) {
		case 2412:
			return 1;
		case 2417:
			return 2;
		case 2422:
			return 3;
		case 2427:
			return 4;
		case 2432:
			return 5;
		case 2437:
			return 6;
		case 2442:
			return 7;
		case 2447:
			return 8;
		case 2452:
			return 9;
		case 2457:
			return 10;
		case 2462:
			return 11;
		case 2467:
			return 12;
		case 2472:
			return 13;
		case 2484:
			return 14;
		}

		// 5Ghz bandwidth 802.11a/h/j/n/ac
		switch (frequency) {
		case 4915:
			return 183;
		case 4920:
			return 184;
		case 4925:
			return 185;
		case 4935:
			return 187;
		case 4940:
			return 188;
		case 4945:
			return 189;
		case 4960:
			return 192;
		case 4980:
			return 196;
		case 5035:
			return 7;
		case 5040:
			return 8;
		case 5045:
			return 9;
		case 5055:
			return 11;
		case 5060:
			return 12;
		case 5080:
			return 16;
		case 5170:
			return 34;
		case 5180:
			return 36;
		case 5190:
			return 38;
		case 5200:
			return 40;
		case 5210:
			return 42;
		case 5220:
			return 44;
		case 5230:
			return 46;
		case 5240:
			return 48;
		case 5260:
			return 52;
		case 5280:
			return 56;
		case 5300:
			return 60;
		case 5320:
			return 64;
		case 5500:
			return 100;
		case 5520:
			return 104;
		case 5540:
			return 108;
		case 5560:
			return 112;
		case 5580:
			return 116;
		case 5600:
			return 120;
		case 5620:
			return 124;
		case 5640:
			return 128;
		case 5660:
			return 132;
		case 5680:
			return 136;
		case 5700:
			return 140;
		case 5745:
			return 149;
		case 5765:
			return 153;
		case 5785:
			return 157;
		case 5805:
			return 161;
		case 5825:
			return 165;
		}
		return -1;
	}
	
	@Override
	public boolean isTurboChannel() {
		return turboChannel;
	}

	public void setTurboChannel(boolean turboChannel) {
		this.turboChannel = turboChannel;
	}
	@Override
	public boolean isCckChannel() {
		return cckChannel;
	}

	public void setCckChannel(boolean cckChannel) {
		this.cckChannel = cckChannel;
	}
	@Override
	public boolean isOfdmChannel() {
		return ofdmChannel;
	}

	public void setOfdmChannel(boolean ofdmChannel) {
		this.ofdmChannel = ofdmChannel;
	}
	@Override
	public boolean isSpectrumChannel2GHZ() {
		return spectrumChannel2GHZ;
	}

	public void setSpectrumChannel2GHZ(boolean spectrumChannel2GHZ) {
		this.spectrumChannel2GHZ = spectrumChannel2GHZ;
	}
	@Override
	public boolean isSpectrumChannel5GHZ() {
		return spectrumChannel5GHZ;
	}

	public void setSpectrumChannel5GHZ(boolean spectrumChannel5GHZ) {
		this.spectrumChannel5GHZ = spectrumChannel5GHZ;
	}
	@Override
	public boolean isOnlyPassiveScanAllowed() {
		return onlyPassiveScanAllowed;
	}

	public void setOnlyPassiveScanAllowed(boolean onlyPassiveScanAllowed) {
		this.onlyPassiveScanAllowed = onlyPassiveScanAllowed;
	}
	@Override
	public boolean isDynamicCckOfdmChannel() {
		return dynamicCckOfdmChannel;
	}

	public void setDynamicCckOfdmChannel(boolean dynamicCckOfdmChannel) {
		this.dynamicCckOfdmChannel = dynamicCckOfdmChannel;
	}
	@Override
	public boolean isGfskChannel() {
		return gfskChannel;
	}

	public void setGfskChannel(boolean gfskChannel) {
		this.gfskChannel = gfskChannel;
	}
	@Override
	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(byte frequency) {
		this.frequency = frequency;
	}

	public int getChannelNum() {
		return channelNum;
	}

	public void setChannelNum(int channelNum) {
		this.channelNum = channelNum;
	}
}
