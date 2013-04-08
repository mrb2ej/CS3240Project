package DebuggerTool;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import BaseStation.RobotCommunicator;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class DebuggerGUI extends javax.swing.JFrame {

	private JMenuItem helpMenuItem;
	private JMenu jMenu5;
	private JButton turnOffDebugMode;
	private JButton stopButton;
	private JButton stepButton;
	private JMenuItem deleteMenuItem;
	private JSeparator jSeparator1;
	private JMenuItem pasteMenuItem;
	private JMenuItem copyMenuItem;
	private JMenuItem cutMenuItem;
	private JMenu jMenu4;
	private JMenuItem exitMenuItem;
	private JSeparator jSeparator2;
	private JMenuItem closeFileMenuItem;
	private JMenuItem saveAsMenuItem;
	private JMenuItem saveMenuItem;
	private JMenuItem openFileMenuItem;
	private JMenuItem newFileMenuItem;
	private JMenu jMenu3;
	private JMenuBar jMenuBar1;
	private static DebuggerGUIController controller;

	
	/*
	 * This main is a mess. We should probably rework this later
	 */
	public static void main(String[] args, final RobotCommunicator comm) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				DebuggerGUI inst = new DebuggerGUI();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				controller = new DebuggerGUIController(inst, comm);
			}
		});
	}

	public DebuggerGUI() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setLocationByPlatform(true);
				this.setLocation(new java.awt.Point(500, 0));
				{
					stepButton = new JButton();
					getContentPane().add(stepButton);
					stepButton.setText("Step");
					stepButton.setBounds(39, 172, 64, 35);
					stepButton.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							stepButtonMouseClicked(evt);
						}
					});
				}
				{
					stopButton = new JButton();
					getContentPane().add(stopButton);
					stopButton.setText("Stop");
					stopButton.setBounds(114, 172, 64, 35);
					stopButton.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							stopButtonMouseClicked(evt);
						}
					});
				}
				{
					turnOffDebugMode = new JButton();
					getContentPane().add(turnOffDebugMode);
					turnOffDebugMode.setText("Turn Off Debug Mode");
					turnOffDebugMode.setBounds(189, 172, 202, 35);
					turnOffDebugMode.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							turnOffDebugModeButtonMouseClicked(evt);
						}
					});
				}
			}
			this.setSize(534, 359);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("File");
					{
						newFileMenuItem = new JMenuItem();
						jMenu3.add(newFileMenuItem);
						newFileMenuItem.setText("New");
					}
					{
						openFileMenuItem = new JMenuItem();
						jMenu3.add(openFileMenuItem);
						openFileMenuItem.setText("Open");
					}
					{
						saveMenuItem = new JMenuItem();
						jMenu3.add(saveMenuItem);
						saveMenuItem.setText("Save");
					}
					{
						saveAsMenuItem = new JMenuItem();
						jMenu3.add(saveAsMenuItem);
						saveAsMenuItem.setText("Save As ...");
					}
					{
						closeFileMenuItem = new JMenuItem();
						jMenu3.add(closeFileMenuItem);
						closeFileMenuItem.setText("Close");
					}
					{
						jSeparator2 = new JSeparator();
						jMenu3.add(jSeparator2);
					}
					{
						exitMenuItem = new JMenuItem();
						jMenu3.add(exitMenuItem);
						exitMenuItem.setText("Exit");
					}
				}
				{
					jMenu4 = new JMenu();
					jMenuBar1.add(jMenu4);
					jMenu4.setText("Edit");
					{
						cutMenuItem = new JMenuItem();
						jMenu4.add(cutMenuItem);
						cutMenuItem.setText("Cut");
					}
					{
						copyMenuItem = new JMenuItem();
						jMenu4.add(copyMenuItem);
						copyMenuItem.setText("Copy");
					}
					{
						pasteMenuItem = new JMenuItem();
						jMenu4.add(pasteMenuItem);
						pasteMenuItem.setText("Paste");
					}
					{
						jSeparator1 = new JSeparator();
						jMenu4.add(jSeparator1);
					}
					{
						deleteMenuItem = new JMenuItem();
						jMenu4.add(deleteMenuItem);
						deleteMenuItem.setText("Delete");
					}
				}
				{
					jMenu5 = new JMenu();
					jMenuBar1.add(jMenu5);
					jMenu5.setText("Help");
					{
						helpMenuItem = new JMenuItem();
						jMenu5.add(helpMenuItem);
						helpMenuItem.setText("Help");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void stepButtonMouseClicked(MouseEvent evt) {
		controller.step();
	}
	
	private void stopButtonMouseClicked(MouseEvent evt) {
		controller.stop();
	}
	
	private void turnOffDebugModeButtonMouseClicked(MouseEvent evt) {
		controller.turnOffDebugMode();
		this.dispose();
	}

}
