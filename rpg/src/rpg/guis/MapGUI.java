package rpg.guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Canvas;

import java.awt.GridLayout;
import javax.swing.JPanel;

import rpg.game.Handler;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MapGUI {

	private JFrame frame;
	private JButton btnClose;
	private Canvas canvas;
	private JPanel panel;
	private Handler h;

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
		this.h =h;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Map");
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnClose.setBounds(495, 337, 89, 23);
		frame.getContentPane().add(btnClose);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 574, 315);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		canvas = new Canvas();
		panel.add(canvas);
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public Canvas getCanvas() {
		return this.canvas;
	}
	
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
}
