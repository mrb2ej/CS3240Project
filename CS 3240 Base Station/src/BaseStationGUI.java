import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
	private JLabel ultrasonicSensorLabel;
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
			controller = new BaseStationGUIController(this);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					thisKeyPressed(evt);
				}
			});
			{
				lightSensorLabel = new JLabel();
				getContentPane().add(lightSensorLabel);
				lightSensorLabel.setText("Light:");
				lightSensorLabel.setBounds(28, 33, 56, 16);
			}
			{
				soundSensorLabel = new JLabel();
				getContentPane().add(soundSensorLabel);
				soundSensorLabel.setText("Sound:");
				soundSensorLabel.setBounds(28, 61, 37, 16);
			}
			{
				ultrasonicSensorLabel = new JLabel();
				getContentPane().add(ultrasonicSensorLabel);
				ultrasonicSensorLabel.setText("Ultrasonic:");
				ultrasonicSensorLabel.setBounds(28, 89, 56, 16);
			}
			{
				touchSensorLabel = new JLabel();
				getContentPane().add(touchSensorLabel);
				touchSensorLabel.setText("Touch:");
				touchSensorLabel.setBounds(28, 117, 37, 16);
			}
			{
				locationLabel = new JLabel();
				getContentPane().add(locationLabel);
				locationLabel.setText("Location:");
				locationLabel.setBounds(28, 149, 49, 16);
			}
			{
				recordSequenceButton = new JButton();
				getContentPane().add(recordSequenceButton);
				recordSequenceButton.setText("Record Sequence");
				recordSequenceButton.setBounds(165, 240, 105, 23);
			}
			{
				uploadSequenceButton = new JButton();
				getContentPane().add(uploadSequenceButton);
				uploadSequenceButton.setText("Upload Sequence");
				uploadSequenceButton.setBounds(288, 240, 106, 23);
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
		System.out.println("this.keyPressed, event="+evt);

		controller.KeyboardMovementHandler(evt.getKeyCode());
		
	}

}
