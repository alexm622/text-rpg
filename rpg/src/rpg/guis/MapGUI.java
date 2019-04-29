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
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

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
		this.h = h;
		h.getG().getGm().freeze();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(210, 180, 140));
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setTitle("Map");
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnClose = new JButton("Close");
		btnClose.setBackground(new Color(219, 112, 147));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				h.getG().getGm().unfreeze();
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
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		canvas = new Canvas();
		panel.add(canvas);
		
		JLabel lblNewLabel = new JLabel("Map");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(250, 11, 99, 23);
		frame.getContentPane().add(lblNewLabel);
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
