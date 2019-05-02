package rpg.guis;

import java.awt.EventQueue;

import javax.swing.JFrame;


import java.awt.GridLayout;
import javax.swing.JPanel;

import rpg.game.Handler;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;
import javax.swing.border.MatteBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;


public class MapGUI {

	private JFrame frame;
	private JButton btnClose;
	private JPanel panel;
	private Handler h;
	private JLabel[][] labels;
	
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;
	private JLabel lbl9;
	private JLabel lbl10;
	private JLabel lbl11;
	private JLabel lbl12;
	private JLabel lbl13;
	private JLabel lbl14;
	private JLabel lbl15;
	private JLabel lbl16;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MapGUI window = new MapGUI(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MapGUI(Handler h) {
		this.h = h;
		h.getG().getGm().getFrmRpg().setEnabled(false);
		initialize();
		labels = new JLabel[][]{ 
				{lbl1, lbl2, lbl3, lbl4},
				{lbl5, lbl6, lbl7, lbl8},
				{lbl9, lbl10, lbl11, lbl12},
				{lbl13, lbl14, lbl15, lbl16}
				};
		frame.requestFocus();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.frame = new JFrame();
		frame.getContentPane().setBackground(new Color(210, 180, 140));
		
		frame.setResizable(false);
		frame.setTitle("Map");
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnClose = new JButton("Close");
		btnClose.setBackground(new Color(219, 112, 147));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				h.getG().getGm().getFrmRpg().setEnabled(true);
				h.getG().getGm().getFrmRpg().requestFocus();
				frame.dispose();
			}
		});
		btnClose.setBounds(495, 366, 89, 23);
		frame.getContentPane().add(btnClose);
		
		panel = new JPanel();
		panel.setBackground(new Color(205, 133, 63));
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBounds(10, 40, 574, 315);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		lbl1 = new JLabel("");
		lbl1.setFont(new Font("Arial", Font.BOLD, 18));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl1);
		
		lbl2 = new JLabel("");
		lbl2.setFont(new Font("Arial", Font.BOLD, 18));
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl2);
		
		lbl3 = new JLabel("");
		lbl3.setFont(new Font("Arial", Font.BOLD, 18));
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl3);
		
		lbl4 = new JLabel("");
		lbl4.setFont(new Font("Arial", Font.BOLD, 18));
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl4);
		
		lbl5 = new JLabel("");
		lbl5.setFont(new Font("Arial", Font.BOLD, 18));
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl5);
		
		lbl6 = new JLabel("");
		lbl6.setFont(new Font("Arial", Font.BOLD, 18));
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl6);
		
		lbl7 = new JLabel("");
		lbl7.setFont(new Font("Arial", Font.BOLD, 18));
		lbl7.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl7);
		
		lbl8 = new JLabel("");
		lbl8.setFont(new Font("Arial", Font.BOLD, 18));
		lbl8.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl8);
		
		lbl9 = new JLabel("");
		lbl9.setFont(new Font("Arial", Font.BOLD, 18));
		lbl9.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl9);
		
		lbl10 = new JLabel("");
		lbl10.setFont(new Font("Arial", Font.BOLD, 18));
		lbl10.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl10);
		
		lbl11 = new JLabel("");
		lbl11.setFont(new Font("Arial", Font.BOLD, 18));
		lbl11.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl11);
		
		lbl12 = new JLabel("");
		lbl12.setFont(new Font("Arial", Font.BOLD, 18));
		lbl12.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl12);
		
		lbl13 = new JLabel("");
		lbl13.setFont(new Font("Arial", Font.BOLD, 18));
		lbl13.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl13);
		
		lbl14 = new JLabel("");
		lbl14.setFont(new Font("Arial", Font.BOLD, 18));
		lbl14.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl14);
		
		lbl15 = new JLabel("");
		lbl15.setFont(new Font("Arial", Font.BOLD, 18));
		lbl15.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl15);
		
		lbl16 = new JLabel("");
		lbl16.setFont(new Font("Arial", Font.BOLD, 18));
		lbl16.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl16);
		
		JLabel lblMap = new JLabel("Map");
		lblMap.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMap.setHorizontalAlignment(SwingConstants.CENTER);
		lblMap.setBounds(250, 11, 99, 23);
		frame.getContentPane().add(lblMap);
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public JLabel[][] getLabels(){
		return this.labels;
	}
	
	public void setLabels(JLabel[][] labels) {
		this.labels = labels;
	}

	public void drawMap(JLabel[][] labels){
		this.lbl1 = labels[0][0];
		this.lbl2 = labels[0][1];
		this.lbl3 = labels[0][2];
		this.lbl4 = labels[0][3];

		this.lbl5 = labels[1][0];
		this.lbl6 = labels[1][1];
		this.lbl7 = labels[1][2];
		this.lbl8 = labels[1][3];

		this.lbl9  = labels[2][0];
		this.lbl10 = labels[2][1];
		this.lbl11 = labels[2][2];
		this.lbl12 = labels[2][3];

		this.lbl13 = labels[3][0];
		this.lbl14 = labels[3][1];
		this.lbl15 = labels[3][2];
		this.lbl16  = labels[3][3];

		this.frame.repaint();
	}
	
	
}
