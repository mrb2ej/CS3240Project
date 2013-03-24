public class DataPacket
{
	byte opcode;
	byte[] data;
	byte checkSum;
	
	public DataPacket(byte op, byte[] packetData, byte chkSum)
	{
		opcode = op;
		data = packetData.clone();
		checkSum = chkSum;
	}
	
	public DataPacket(byte op, byte[] packetData)
	{
		opcode = op;
		data = packetData.clone();
		checkSum = calcChkSum();
	}
	
	public byte[] getAsByteArray()
	{
		byte[] packet = new byte[7];
		packet[0] = opcode;
		for(int x = 0; x < data.length; x++)
		{
			packet[x+1] = data[x];
		}
		packet[6] = checkSum;
		return packet;
	}
	
	public byte calcChkSum()
	{
		byte total = getOnes(opcode);
		for(int x = 0; x < data.length; x++)
		{
			total += getOnes(data[x]);
		}
		return total;
	}
	
	private byte getOnes(byte in)
	{
		byte total = 0;
		for(int x = 0; x < 8; x++)
		{
			total += in % 2;
			in /= 2;
		}
		return total;
	}	
}