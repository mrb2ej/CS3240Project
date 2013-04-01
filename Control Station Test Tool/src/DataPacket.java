
public class DataPacket {

	private byte opcode;
	public byte[] data = new byte[5];
	private byte end;
	private byte checksum;
	private byte readchecksum;
	
	public int getOpcode() {
		return opcode;
	}
	
	public void setOpcode(int opcode) {
		this.opcode = (byte) opcode;
	}
	
	public byte[] getData() {
		return data;
	}
	
	public void setData(byte data0, byte data1, byte data2, byte data3, byte data4) {
		data[0]=data0;
		data[1]=data1;
		data[2]=data2;
		data[3]=data3;
		data[4]=data4;
	}
	
	public void setReadchecksum(int a) {
		readchecksum = (byte) a;
	}
	
	private void calculateChecksum() {	//call last after other methods
		checksum = (byte)getSum();
	}
	
	public boolean check() {
		calculateChecksum();
		return (checksum==readchecksum);
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
	
	private int getSum() {
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
	
//	public static void main(String[] args){
//		DataPacket test = new DataPacket();
//		test.setOpcode(1);
//		test.setData((byte)1, 3, 1, 3, 1, 3);
//		test.setEnd(0);
//		test.calculateChecksum();
//		System.out.println(test.toString());
//	}
	public static final byte OP_ERROR = 0;
	public static final byte OP_SENSOR_INFORMATION = 1;
	public static final byte OP_MOTOR_COMMAND = 2;
	public static final byte OP_DEBUGGER_COMMAND = 3;
	public static final byte OP_ACKNOWLEDGEMENT = 4;
	public static final byte OP_PING = 5;

	public static final byte ERROR_DISCONNECTED = 0;
	public static final byte ERROR_MESSAGE_CORRUPTED = 1;
	public static final byte ERROR_MESSAGE_TIMEOUT = 2;

	public static final byte SENSOR_LIGHT = 0;
	public static final byte SENSOR_TOUCH = 1;
	public static final byte SENSOR_ULTRASONIC = 2;
	public static final byte SENSOR_SOUND = 3;

	public static final byte MOTOR_NOOP = 0;
	public static final byte MOTOR_STOP = 1;
	public static final byte MOTOR_FORWARD = 2;
	public static final byte MOTOR_STOP_FORWARD = 3;
	public static final byte MOTOR_BACKWARD = 4;
	public static final byte MOTOR_STOP_BACKWARD = 5;
	public static final byte MOTOR_LEFT = 6;
	public static final byte MOTOR_STOP_LEFT = 7;
	public static final byte MOTOR_RIGHT = 8;
	public static final byte MOTOR_STOP_RIGHT = 9;
	public static final byte MOTOR_INCREASE_SPEED = 10;
	public static final byte MOTOR_DECREASE_SPEED = 11;

	public static final byte DEBUG_NOOP = 0;
	public static final byte DEBUG_INSERT_BREAK = 1;
	public static final byte DEBUG_RUN = 2;
	public static final byte DEBUG_STEP = 3;
	public static final byte DEBUG_STEP_OVER = 4;
	public static final byte DEBUG_INSPECT = 5;
	public static final byte DEBUG_RESET = 6;

	public static final byte ACKNOWLEDGE_RECEIVED = 0;
	public static final byte ACKNOWLEDGE_SENT = 1;
}
