/*
 * This object will represent a full set of telemetry data
 * Sensor information for all sensors, information on speed, direction, bluetooth connectivity  
 * 
 * 
 */

public class TelemetryData {
	
	int lightSensorData;
    int touchSensorData;
    int ultrasonicSensorData;
    int soundSensorData;
	
	public TelemetryData(byte[] data){
		lightSensorData = data[0];
		touchSensorData = data[1];
		ultrasonicSensorData = data[2];
		soundSensorData = data[3];
	}

	public int getLightSensorData() {
		return lightSensorData;
	}

	public void setLightSensorData(int lightSensorData) {
		this.lightSensorData = lightSensorData;
	}

	public int getTouchSensorData() {
		return touchSensorData;
	}

	public void setTouchSensorData(int touchSensorData) {
		this.touchSensorData = touchSensorData;
	}

	public int getUltrasonicSensorData() {
		return ultrasonicSensorData;
	}

	public void setUltrasonicSensorData(int ultrasonicSensorData) {
		this.ultrasonicSensorData = ultrasonicSensorData;
	}

	public int getSoundSensorData() {
		return soundSensorData;
	}

	public void setSoundSensorData(int soundSensorData) {
		this.soundSensorData = soundSensorData;
	}

}
