package fr.bmartel.protocol.radiotap;

import fr.bmartel.protocol.radiotap.inter.IRadiotapFlags;
import fr.bmartel.utils.ByteUtils;

/**
 * List of radio tap flags according standards defined in
 * http://www.radiotap.org/ <br/>
 * => headers added with first byte bitmask position / second byte ans os on =>
 * number of data with byte number for each
 * 
 * @author Bertrand Martel
 * 
 */
public class RadioTapFlags implements IRadiotapFlags {

	public final static byte INDEX_TFST = 0x00;
	public final static byte INDEX_FLAGS = 0x01;
	public final static byte INDEX_DATA_RATE = 0x02;
	public final static byte INDEX_CHANNEL = 0x03;
	public final static byte INDEX_FHSS = 0x04;
	public final static byte INDEX_DBM_ANT_SIGNAL = 0x05;
	public final static byte INDEX_DBM_ANT_NOISE = 0x06;
	public final static byte INDEX_LOCK_QUALITY = 0x07;
	public final static byte INDEX_TX_ATTENUATION = 0x08;
	public final static byte INDEX_DB_TX_ATTENUATION = 0x09;
	public final static byte INDEX_DBM_TX_POWER = 0x0A;
	public final static byte INDEX_ANTENNA = 0x0B;
	public final static byte INDEX_DB_ANTENNA_SIGNAL = 0x0C;
	public final static byte INDEX_DB_ANTENNA_NOISE = 0x0D;
	public final static byte INDEX_RX_FLAGS = 0x0E;
	public final static byte INDEX_MCS = 0x13;
	public final static byte INDEX_AMPDU = 0x14;
	public final static byte INDEX_VHT = 0x15;

	public boolean tfst = false;
	public boolean flagsPres = false;
	public boolean dataRate = false;
	public boolean channel = false;
	public boolean fhss = false;
	public boolean dbmAntSignal = false;
	public boolean dbmAntNoise = false;
	public boolean lockQuality = false;
	public boolean txAttenuation = false;
	public boolean dbTxAttenuation = false;
	public boolean dbmTxPower = false;
	public boolean antenna = false;
	public boolean dbAntennaSignal = false;
	public boolean dbAntennaNoise = false;
	public boolean rxFlags = false;
	public boolean mcs = false;
	public boolean ampdu = false;
	public boolean vht = false;
	
	static byte[] radioTapList = new byte[] { INDEX_TFST, INDEX_FLAGS,
			INDEX_DATA_RATE, INDEX_CHANNEL, INDEX_FHSS, INDEX_DBM_ANT_SIGNAL,
			INDEX_DBM_ANT_NOISE, INDEX_LOCK_QUALITY, INDEX_TX_ATTENUATION,
			INDEX_DB_TX_ATTENUATION, INDEX_DBM_TX_POWER, INDEX_ANTENNA,
			INDEX_DB_ANTENNA_SIGNAL, INDEX_DB_ANTENNA_NOISE, INDEX_RX_FLAGS,
			INDEX_MCS, INDEX_AMPDU, INDEX_VHT };

	public RadioTapFlags() {
	}

	/**
	 * Decode from flags properties
	 */
	public RadioTapData decode(byte[] flags, byte[] payload) {

		int flagsTotal = ByteUtils.convertByteArrayToInt(flags);

		RadioTapData data = new RadioTapData(payload);

		for (int k = 0; k < radioTapList.length; k++) {

			if ((flagsTotal & (1 << (radioTapList[k] & 0xFF))) != 0) {
				switch (radioTapList[k]) {
				case INDEX_TFST:
					tfst=true;
					data.setTFST();
					break;
				case INDEX_FLAGS:
					this.flagsPres=true;
					data.setFlags();
					break;
				case INDEX_DATA_RATE:
					this.dataRate=true;
					data.setDataRate();
					break;
				case INDEX_CHANNEL:
					this.channel=true;
					data.setChannel();
					break;
				case INDEX_FHSS:
					this.fhss=true;
					data.setFHSS();
					break;
				case INDEX_DBM_ANT_SIGNAL:
					this.dbmAntSignal=true;
					data.setDBMAntSignal();
					break;
				case INDEX_DBM_ANT_NOISE:
					this.dbmAntNoise=true;
					data.setDBMAntNoise();
					break;
				case INDEX_LOCK_QUALITY:
					this.lockQuality=true;
					data.setLockQuality();
					break;
				case INDEX_TX_ATTENUATION:
					this.txAttenuation=true;
					data.setTxAttenuation();
					break;
				case INDEX_DB_TX_ATTENUATION:
					this.dbTxAttenuation=true;
					data.setDbTxAttenuation();
					break;
				case INDEX_DBM_TX_POWER:
					this.dbmTxPower=true;
					data.setDbmTxPower();
					break;
				case INDEX_ANTENNA:
					this.antenna=true;
					data.setAntenna();
					break;
				case INDEX_DB_ANTENNA_SIGNAL:
					this.dbAntennaSignal=true;
					data.setDbAntennaSignal();
					break;
				case INDEX_DB_ANTENNA_NOISE:
					this.dbAntennaNoise=true;
					data.setDbAntennaNoise();
					break;
				case INDEX_RX_FLAGS:
					this.rxFlags=true;
					data.setRxFlags();
					break;
				case INDEX_MCS:
					this.mcs=true;
					data.setMcs();
					break;
				case INDEX_AMPDU:
					this.ampdu=true;
					data.setAmpduStatus();
					break;
				case INDEX_VHT:
					this.vht=true;
					data.setVHT();
					break;
				}
			}
		}
		return data;
	}

	@Override
	public boolean isTFST() {
		return tfst;
	}

	@Override
	public boolean isFlags() {
		return flagsPres;
	}

	@Override
	public boolean isDataRate() {
		return dataRate;
	}

	@Override
	public boolean isChannel() {
		return channel;
	}

	@Override
	public boolean isFHSS() {
		return fhss;
	}

	@Override
	public boolean isDbmAntSignal() {
		return dbmAntSignal;
	}

	@Override
	public boolean isDbmAntNoise() {
		return dbmAntNoise;
	}

	@Override
	public boolean isLockQuality() {
		return lockQuality;
	}

	@Override
	public boolean isTxAttenuation() {
		return txAttenuation;
	}

	@Override
	public boolean isDbTxAttenuation() {
		return dbTxAttenuation;
	}

	@Override
	public boolean isDbmTxPower() {
		return dbmTxPower;
	}

	@Override
	public boolean isAntenna() {
		return antenna;
	}

	@Override
	public boolean isDbAntennaSignal() {
		return dbAntennaSignal;
	}

	@Override
	public boolean isDbAntennaNoise() {
		return dbAntennaNoise;
	}

	@Override
	public boolean isRxFlags() {
		return rxFlags;
	}

	@Override
	public boolean isMcs() {
		return mcs;
	}

	@Override
	public boolean isAmpdu() {
		return ampdu;
	}

	@Override
	public boolean isVht() {
		return vht;
	}
}
