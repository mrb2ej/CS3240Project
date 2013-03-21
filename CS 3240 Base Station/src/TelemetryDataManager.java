/*
 * This module will be in charge of creating and parsing TelemetryData objects
 * 
 *  When the RobotCommunicator object receives a DataPacket object from the robot and parses that information,
 *  it will use a TelemetryDataManager object to create a TelemetryData object that will then be displayed by the 
 *  BaseStationGUIController to the BaseStationGUI object
 * 
 * If we ever need to serialize TelemetryData objects, this is the module that will manage the saving/loading
 * of the (.txt?) file
 * 
 */

public class TelemetryDataManager {

	TelemetryData currentData = new TelemetryData();
	
	public TelemetryDataManager(){
		
		
	}
}
