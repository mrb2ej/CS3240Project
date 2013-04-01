public class DataPacket {
	byte opcode;
	byte[] data;
	byte checkSum;
	byte readcheckSum;

	public DataPacket(byte op, byte[] packetData, byte chkSum) {
		opcode = op;
		data = packetData.clone();
		checkSum = chkSum;
	}

	public DataPacket(byte op, byte[] packetData) {
		opcode = op;
		data = packetData.clone();
		checkSum = calcChkSum();
	}

	public byte[] getAsByteArray() {
		byte[] packet = new byte[7];
		packet[0] = opcode;
		for (int x = 0; x < data.length; x++) {
			packet[x + 1] = data[x];
		}
		packet[6] = readcheckSum;
		return packet;
	}

	public byte calcChkSum() {
		byte total = getOnes(opcode);
		for (int x = 0; x < data.length; x++) {
			total += getOnes(data[x]);
		}
		return total;
	}

	private byte getOnes(byte in) {
		byte total = 0;
		for (int x = 0; x < 8; x++) {
			total += in % 2;
			in /= 2;
		}
		return total;
	}

	public String getMovementCommandName() {
		if (opcode == OP_MOTOR_COMMAND) {
			switch (data[0]) {
			case MOTOR_NOOP:
				return "Motor NOOP";
			case MOTOR_STOP:
				return "Stop";
			case MOTOR_FORWARD:
				return "Start Moving Forward";
			case MOTOR_BACKWARD:
				return "Start Moving Backward";
			case MOTOR_STOP_FORWARD:
				return "Stop Moving Forward";
			case MOTOR_STOP_BACKWARD:
				return "Stop Moving Backward";
			case MOTOR_LEFT:
				return "Start Moving Left";
			case MOTOR_RIGHT:
				return "Start Moving Right";
			case MOTOR_STOP_RIGHT:
				return "Stop Moving Right";
			case MOTOR_STOP_LEFT:
				return "Stop Moving Left";
			case MOTOR_INCREASE_SPEED:
				return "Increase Speed";
			case MOTOR_DECREASE_SPEED:
				return "Decrease Speed";
			default:
				return "";
			}
		}else{
			return "";
		}

	}

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
