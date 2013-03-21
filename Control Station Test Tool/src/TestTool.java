
public class TestTool {

	public TestTool(){
		//Include information for connecting to base station
		//Update when available 
	}
	
	
	public void parseCommand(DataPacket command){
		
		if(!isCommandCorrect(command)){
			//Generate a "checksum incorrect" error message
		
			DataPacket errorPacket = new DataPacket();
				//Set the error codes as required
			errorPacket.setOpcode(0);
			errorPacket.setData(1, 0, 0, 0, 0, 0);
			
			transmitPacket(errorPacket);
			return;
		}
		
		
		//Generate a response message
		
		DataPacket responsePacket = new DataPacket();
			//Set all response codes as required
		responsePacket.setOpcode(4);
		responsePacket.setData(0, 0, 0, 0, 0, 0);
		
		transmitPacket(responsePacket);
		return;
		
	}
	
	
	public DataPacket generateTelemetryData(){
		//Generate random telemetry data to be passed
		//to the base station
		
		DataPacket telemetryData = new DataPacket();
			//Set all response codes as required
		telemetryData.setOpcode(1);
		telemetryData.setData(0, 1, 0, 0, 0, 0);
		
		return telemetryData;
	}
	
	

	public void transmitPacket(DataPacket packet){
		//Transmit the packet from the robot to the base station
		
		//For this implementation, we just print the packet being sent
		System.out.println("Transmitting Packet: " + packet.toString()); 
	}
	
	
	private boolean isCommandCorrect(DataPacket command){
		//Ensure the command is formatted correctly 
		
		return (command.getChecksum() == command.getSum());
		
	}
	

}
