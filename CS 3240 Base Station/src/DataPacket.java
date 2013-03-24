
public class DataPacket {

	private byte opcode;
	private byte[] data = new byte[24];
	private byte end;
	private short checksum;
	
	public int getOpcode() {
		return opcode;
	}
	
	public void setOpcode(int opcode) {
		this.opcode = (byte) opcode;
	}
	
	public byte[] getData() {
		return data;
	}
	
	public void setData(byte[] byteArray) {
		data = byteArray.clone();
	}
	
	public int getChecksum() {
		return checksum;
	}
	
	public void setChecksum(int checksum){
		this.checksum = (short)checksum;
	}
	public void calculateChecksum() {	//call last after other methods
		checksum = (short)getSum();
	}
	
	public void setEnd(int end) {
		this.end = (byte)end;
	}
	public String toString(){
		String output = "";
		output+=convert(opcode, 8);
		for(int i = 0; i < 6; i++) {
			output+=convert(data[i], 32);
		}
		output+=convert(end, 8);
		output+=convert(checksum, 16);
		return output;
	}

	private String convert(int convertee, int bits) {
		String output = "";
		for (int i = 0; i < bits; i++) {
			Integer j = (convertee%2+2)%2;
			output+=j.toString();
			convertee /= 2;
		}
		return reverse(output);
	}
	
	public int getSum() {
		int sum = 0;
		int temp = opcode;
		while(temp != 0) {
			sum += (temp%2+2)%2;
			temp /= 2;
		}
		for (int i = 0; i < 6; i++) {
			temp = data[i];
			while(temp != 0) {
				sum += (temp%2+2)%2;
				temp /= 2;
			}
		}
		temp = end;
		while(temp != 0) {
			sum += (temp%2+2)%2;
			temp /= 2;
		}
		return sum;
	}
	
	private String reverse(String s) {
	    if (s.length() <= 1) { 
	        return s;
	    }
	    return reverse(s.substring(1, s.length())) + s.charAt(0);
	}
	
	public static void main(String[] args){
		DataPacket test = new DataPacket();
		test.setOpcode(1);
		//test.setData(1, 3, 1, 3, 1, 3);
		test.setEnd(0);
		test.calculateChecksum();
		System.out.println(test.toString());
	}
}