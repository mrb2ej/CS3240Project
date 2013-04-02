import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultCaret;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class BaseStationGUI extends javax.swing.JFrame {
	private JLabel lightSensorLabel;
	private JLabel touchData;
	private JButton stopButton;
	private JButton terminateButton;
	private JLabel speed;
	private JLabel speedLabel;
	private JScrollPane jScrollPane1;
	private JLabel sensorPanelLabel;
	private JPanel controlOutputPanel;
	private JLabel rightArrowLabel;
	private JLabel leftArrowLabel;
	private JLabel downArrowLabel;
	private JLabel upArrowLabel;
	private JLabel bluetoothData;
	private JLabel bluetoothLabel;
	private JPanel sensorDataPanel;
	private JLabel LocationData;
	private JLabel ultrasonicSensorLabel;
	private JLabel ultrasonicData;
	private JLabel soundData;
	private JLabel lightDataLabel;
	private JLabel recordingLogLabel;
	private JTextArea commandSequenceLog;
	private JButton uploadSequenceButton;
	private JButton recordSequenceButton;
	private JLabel locationLabel;
	private JLabel touchSensorLabel;
	private JLabel soundSensorLabel;
	private BaseStationGUIController controller;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BaseStationGUI inst = new BaseStationGUI();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public BaseStationGUI() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setFocusable(true);
			controller = new BaseStationGUIController(this);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				sensorDataPanel = new JPanel();
				getContentPane().add(sensorDataPanel);
				sensorDataPanel.setBounds(12, 12, 170, 200);
				sensorDataPanel.setLayout(null);
				{
					lightSensorLabel = new JLabel();
					sensorDataPanel.add(lightSensorLabel);
					lightSensorLabel.setText("Light:");
					lightSensorLabel.setBounds(28, 33, 79, 16);
				}
				{
					locationLabel = new JLabel();
					sensorDataPanel.add(locationLabel);
					locationLabel.setText("Location:");
					locationLabel.setBounds(28, 145, 79, 16);
				}
				{
					lightDataLabel = new JLabel();
					sensorDataPanel.add(lightDataLabel);
					lightDataLabel.setText("N/A");
					lightDataLabel.setBounds(113, 33, 45, 16);
				}
				{
					soundData = new JLabel();
					sensorDataPanel.add(soundData);
					soundData.setText("N/A");
					soundData.setBounds(113, 61, 40, 16);
				}
				{
					soundSensorLabel = new JLabel();
					sensorDataPanel.add(soundSensorLabel);
					soundSensorLabel.setText("Sound:");
					soundSensorLabel.setBounds(28, 61, 79, 16);
				}
				{
					ultrasonicData = new JLabel();
					sensorDataPanel.add(ultrasonicData);
					ultrasonicData.setText("N/A");
					ultrasonicData.setBounds(112, 89, 41, 16);
				}
				{
					ultrasonicSensorLabel = new JLabel();
					sensorDataPanel.add(ultrasonicSensorLabel);
					ultrasonicSensorLabel.setText("Ultrasonic:");
					ultrasonicSensorLabel.setBounds(28, 89, 78, 16);
				}
				{
					touchData = new JLabel();
					sensorDataPanel.add(touchData);
					touchData.setText("N/A");
					touchData.setBounds(111, 117, 42, 16);
				}
				{
					touchSensorLabel = new JLabel();
					sensorDataPanel.add(touchSensorLabel);
					touchSensorLabel.setText("Touch:");
					touchSensorLabel.setBounds(28, 117, 77, 16);
				}
				{
					LocationData = new JLabel();
					sensorDataPanel.add(LocationData);
					LocationData.setText("N/A");
					LocationData.setBounds(113, 145, 40, 16);
				}
				{
					bluetoothLabel = new JLabel();
					sensorDataPanel.add(bluetoothLabel);
					bluetoothLabel.setText("Bluetooth:");
					bluetoothLabel.setBounds(28, 173, 73, 16);
				}
				{
					bluetoothData = new JLabel();
					sensorDataPanel.add(bluetoothData);
					bluetoothData.setText("N/A");
					bluetoothData.setBounds(113, 173, 40, 16);
				}
				{
					sensorPanelLabel = new JLabel();
					sensorDataPanel.add(sensorPanelLabel);
					sensorPanelLabel.setText("Sensor Data");
					sensorPanelLabel.setBounds(28, 6, 116, 21);
					sensorPanelLabel.setFont(new java.awt.Font("Segoe UI",1,16));
				}
			}
			this.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					thisKeyPressed(evt);
				}
			});
			this.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent evt) {
					thisKeyReleased(evt);
				}
			});
			{
				recordSequenceButton = new JButton();
				getContentPane().add(recordSequenceButton);
				recordSequenceButton.setText("Record Sequence");
				recordSequenceButton.setBounds(246, 251, 157, 23);
			}
			{
				uploadSequenceButton = new JButton();
				getContentPane().add(uploadSequenceButton);
				uploadSequenceButton.setText("Upload Sequence");
				uploadSequenceButton.setBounds(414, 251, 144, 23);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 279, 545, 106);
				{
					commandSequenceLog = new JTextArea();
					jScrollPane1.setViewportView(commandSequenceLog);
					commandSequenceLog.setBounds(12, 279, 545, 106);
					commandSequenceLog.setEditable(false);
					DefaultCaret caret = (DefaultCaret)commandSequenceLog.getCaret();
					caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
				}
			}
			{
				recordingLogLabel = new JLabel();
				getContentPane().add(recordingLogLabel);
				recordingLogLabel.setText("Recording Log:");
				recordingLogLabel.setBounds(12, 247, 147, 26);
				recordingLogLabel.setFont(new java.awt.Font("Segoe UI",1,16));
			}
			{
				controlOutputPanel = new JPanel();
				getContentPane().add(controlOutputPanel);
				controlOutputPanel.setBounds(391, 12, 153, 162);
				controlOutputPanel.setLayout(null);
				{
					upArrowLabel = new JLabel();
					controlOutputPanel.add(upArrowLabel);
					upArrowLabel.setText("\u2191");
					upArrowLabel.setBounds(57, 2, 40, 77);
					upArrowLabel.setFont(new java.awt.Font("Segoe UI",1,72));
				}
				{
					rightArrowLabel = new JLabel();
					controlOutputPanel.add(rightArrowLabel);
					rightArrowLabel.setText("\u2192");
					rightArrowLabel.setBounds(74, 49, 79, 48);
					rightArrowLabel.setFont(new java.awt.Font("Segoe UI",1,72));
				}
				{
					leftArrowLabel = new JLabel();
					controlOutputPanel.add(leftArrowLabel);
					leftArrowLabel.setText("\u2190");
					leftArrowLabel.setBounds(8, 41, 89, 65);
					leftArrowLabel.setFont(new java.awt.Font("Segoe UI",1,72));
				}
				{
					downArrowLabel = new JLabel();
					controlOutputPanel.add(downArrowLabel);
					downArrowLabel.setText("\u2193");
					downArrowLabel.setBounds(57, 70, 34, 89);
					downArrowLabel.setFont(new java.awt.Font("Segoe UI",1,72));
				}
			}
			{
				speedLabel = new JLabel();
				getContentPane().add(speedLabel);
				speedLabel.setText("Speed (%):");
				speedLabel.setBounds(403, 174, 59, 16);
			}
			{
				speed = new JLabel();
				getContentPane().add(speed);
				speed.setText("0");
				speed.setBounds(474, 174, 52, 16);
			}
			{
				terminateButton = new JButton();
				getContentPane().add(terminateButton);
				terminateButton.setText("Terminate");
				terminateButton.setBounds(246, 85, 107, 48);
				terminateButton.setBackground(new java.awt.Color(255,0,0));
				terminateButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						terminateButtonMouseClicked(evt);
					}
				});
			}
			{
				stopButton = new JButton();
				getContentPane().add(stopButton);
				stopButton.setText("Stop");
				stopButton.setBounds(246, 28, 107, 46);
				stopButton.setBackground(new java.awt.Color(255,128,0));
				stopButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						stopButtonMouseClicked(evt);
					}
				});
			}
			pack();
			this.setSize(585, 435);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	
	/*
	 * Handle the keyboard input (up, down, left, right)
	 * 
	 */
	private void thisKeyPressed(KeyEvent evt) {
		//System.out.println("this.keyPressed, event="+evt);

		controller.KeyboardMovementHandler(evt.getKeyCode(), false);
		
	}


	private void thisKeyReleased(KeyEvent evt) {
		//System.out.println("this.keyReleased, event="+evt);

		controller.KeyboardMovementHandler(evt.getKeyCode(), true);
		
	}
	
	public void displayCommand(String command){
		commandSequenceLog.append(command + "\n");
		
	}
	
	private void terminateButtonMouseClicked(MouseEvent evt) {
		System.out.println("terminateButton.mouseClicked, event="+evt);
		
		controller.terminateRobot();
		
	}
	
	private void stopButtonMouseClicked(MouseEvent evt) {
		System.out.println("stopButton.mouseClicked, event="+evt);
		
		controller.stopRobot();
		
	}

}
