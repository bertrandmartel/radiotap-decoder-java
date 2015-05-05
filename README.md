# Radiotap Decoder in Java #

http://akinaru.github.io/radiotap-decoder-java/

<i>Last update 04/05/2015</i>

Will decode any radiotap formatted byte array according to specification in http://www.radiotap.org

Following field will be implemented later:
* VHT field type decoding
* MCS field type decoding
* FHSS field type decoding
* AMPDU field type decoding

<hr/>

<b>USAGE</b>

The following usage show how to parse a pcapng file (from Wireshark) that contains Packet with Radiotap headers.

You can use 
* the jnetpcap library 
* my own lib in http://akinaru.github.io/pcapng-decoder-java/ (pcapng-decoder-java)

You dont have to take the jar to you it is already in lib folder

<hr/>

<b>COMMAND LINE SYNTAX</b> 

``java -cp ../lib/pcapngdecoder-1.0.jar:radiotapdecoder-1.0.jar  fr.bmartel.radiotapdecoder.main.DecodeMain -f ../radiotap_file/exemple.pcapng  -v``

-f <file.pcapng> : input file

-v               : verbose, will show all section parsing content

This exemple is launched from release folder

<hr/>

<b>PROGRAM SYNTAX</b>

``byte[] radioTapData = packet.getPacketData();``

``RadioTap radioTap = new RadioTap(radioTapData);``

You can then look at all fields that are in the radiotap data with ``radioTap.getRadioTapFlagList()``

Go check ``fr.bmartel.protocol.radiotap.inter.IRadiotapFlags`` interface to see all list.

``radioTap.getRadioTapFlagList().getRadioTapData()`` will give you all the data you can grab according to flags above.

Go check ``fr.bmartel.protocol.radiotap.inter.IRadiotapData`` to see all data available.

<hr/>

<b>Output Example</b>

###############################################################################################<br/>
RadioTap Version : 0<br/>
RadioTap length  : 18<br/>
RadioTap data    : <br/>
	flags                : 16<br/>
	data rate            : 1000kbps<br/><br/>
	ant signal in dbm    : -62 dbm<br/>
	antenna              : 7 (unitless) (indication of the Rx/Tx antenna for this packet)<br/>
	PLCP CRC error       : false<br/>
		channel number         : 12<br/>
		frequency used         : 2467MHz<br/>
		CCK channel            : true<br/>
		DYNAMIC CCK channel    : false<br/>
		GFSK channel           : false<br/>
		OFDM channel           : false<br/>
		only passive scan      : false<br/>
		spectrum channel 2GHZ  : true<br/>
		spectrum channel 5GHZ  : false<br/>
		turbo channel          : false<br/>
###############################################################################################<br/>
<hr/>
* Project is JRE 1.7 compliant
* You can build it with ant => build.xml
* Development on Eclipse 
* Specification from http://www.radiotap.org
