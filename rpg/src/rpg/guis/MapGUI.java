package rpg.guis;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;
import javax.swing.JPanel;

import rpg.game.Handler;
import rpg.guis.draw.DrawMap;
import rpg.utilities.map.Direction;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

import java.awt.Color;
import javax.swing.border.MatteBorder;


import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.Label;

public class MapGUI {

	private JFrame frame;
	private JButton btnClose;
	private JPanel panel;
	private Handler h;

	
	
	private JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9,
				   lbl10, lbl11, lbl12, lbl13, lbl14, lbl15, lbl16, lbl17, lbl18,
				   lbl19, lbl20, lbl21, lbl22, lbl23, lbl24, lbl25, lbl26, lbl27, 
				   lbl28, lbl29, lbl30, lbl31, lbl32, lbl33, lbl34, lbl35, lbl36, 
				   lbl37, lbl38, lbl39, lbl40, lbl41, lbl42, lbl43, lbl44, lbl45, 
				   lbl46, lbl47, lbl48, lbl49, lbl50, lbl51, lbl52, lbl53, lbl54, 
				   lbl55, lbl56, lbl57, lbl58, lbl59, lbl60, lbl61, lbl62, lbl63, 
				   lbl64, lbl65, lbl66, lbl67, lbl68, lbl69, lbl70, lbl71, lbl72,
				   lbl73, lbl74, lbl75, lbl76, lbl77, lbl78, lbl79, lbl80, lbl81;
	
	private JLabel[][] labels;
	private Label poslbl;
	private JPanel panelBttm;
	private JButton op3;
	private JButton op4;
	private JButton backbttn;
	private JPanel pnlActions;
	private JButton op1;
	private JButton op2;

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
			{ lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9},
			{ lbl10, lbl11, lbl12, lbl13, lbl14, lbl15, lbl16, lbl17, lbl18 },
			{ lbl19, lbl20, lbl21, lbl22, lbl23, lbl24, lbl25, lbl26, lbl27 },
			{ lbl28, lbl29, lbl30, lbl31, lbl32, lbl33, lbl34, lbl35, lbl36 },
			{ lbl37, lbl38, lbl39, lbl40, lbl41, lbl42, lbl43, lbl44, lbl45 },
			{ lbl46, lbl47, lbl48, lbl49, lbl50, lbl51, lbl52, lbl53, lbl54 },
			{ lbl55, lbl56, lbl57, lbl58, lbl59, lbl60, lbl61, lbl62, lbl63 },
			{ lbl64, lbl65, lbl66, lbl67, lbl68, lbl69, lbl70, lbl71, lbl72 },
			{ lbl73, lbl74, lbl75, lbl76, lbl77, lbl78, lbl79, lbl80, lbl81 }
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
		frame.setTitle("Map");
		frame.setSize(600,525);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
				h.getG().getGm().getFrmRpg().setEnabled(true);
				h.getG().getGm().getFrmRpg().requestFocus();
			}
		});
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(205, 133, 63));
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBounds(5, 40, 574, 315);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(9, 9, 0, 0));
		
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
		
		lbl17 = new JLabel("");
		lbl17.setHorizontalAlignment(SwingConstants.CENTER);
		lbl17.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl17);
		
		lbl18 = new JLabel("");
		lbl18.setHorizontalAlignment(SwingConstants.CENTER);
		lbl18.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl18);
		
		lbl19 = new JLabel("");
		lbl19.setHorizontalAlignment(SwingConstants.CENTER);
		lbl19.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl19);
		
		lbl20 = new JLabel("");
		lbl20.setHorizontalAlignment(SwingConstants.CENTER);
		lbl20.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl20);
		
		lbl21 = new JLabel("");
		lbl21.setHorizontalAlignment(SwingConstants.CENTER);
		lbl21.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl21);
		
		lbl22 = new JLabel("");
		lbl22.setHorizontalAlignment(SwingConstants.CENTER);
		lbl22.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl22);
		
		lbl23 = new JLabel("");
		lbl23.setHorizontalAlignment(SwingConstants.CENTER);
		lbl23.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl23);
		
		lbl24 = new JLabel("");
		lbl24.setHorizontalAlignment(SwingConstants.CENTER);
		lbl24.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl24);
		
		lbl25 = new JLabel("");
		lbl25.setHorizontalAlignment(SwingConstants.CENTER);
		lbl25.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl25);
		
		lbl26 = new JLabel("");
		lbl26.setHorizontalAlignment(SwingConstants.CENTER);
		lbl26.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl26);
		
		lbl27 = new JLabel("");
		lbl27.setHorizontalAlignment(SwingConstants.CENTER);
		lbl27.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl27);
		
		lbl28 = new JLabel("");
		lbl28.setHorizontalAlignment(SwingConstants.CENTER);
		lbl28.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl28);
		
		lbl29 = new JLabel("");
		lbl29.setHorizontalAlignment(SwingConstants.CENTER);
		lbl29.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl29);
		
		lbl30 = new JLabel("");
		lbl30.setHorizontalAlignment(SwingConstants.CENTER);
		lbl30.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl30);
		
		lbl31 = new JLabel("");
		lbl31.setHorizontalAlignment(SwingConstants.CENTER);
		lbl31.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl31);
		
		lbl32 = new JLabel("");
		lbl32.setHorizontalAlignment(SwingConstants.CENTER);
		lbl32.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl32);
		
		lbl33 = new JLabel("");
		lbl33.setHorizontalAlignment(SwingConstants.CENTER);
		lbl33.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl33);
		
		lbl34 = new JLabel("");
		lbl34.setHorizontalAlignment(SwingConstants.CENTER);
		lbl34.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl34);
		
		lbl35 = new JLabel("");
		lbl35.setHorizontalAlignment(SwingConstants.CENTER);
		lbl35.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl35);
		
		lbl36 = new JLabel("");
		lbl36.setHorizontalAlignment(SwingConstants.CENTER);
		lbl36.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl36);
		
		lbl37 = new JLabel("");
		lbl37.setHorizontalAlignment(SwingConstants.CENTER);
		lbl37.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl37);
		
		lbl38 = new JLabel("");
		lbl38.setHorizontalAlignment(SwingConstants.CENTER);
		lbl38.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl38);
		
		lbl39 = new JLabel("");
		lbl39.setHorizontalAlignment(SwingConstants.CENTER);
		lbl39.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl39);
		
		lbl40 = new JLabel("");
		lbl40.setHorizontalAlignment(SwingConstants.CENTER);
		lbl40.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl40);
		
		lbl41 = new JLabel("");
		lbl41.setHorizontalAlignment(SwingConstants.CENTER);
		lbl41.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl41);
		
		lbl42 = new JLabel("");
		lbl42.setHorizontalAlignment(SwingConstants.CENTER);
		lbl42.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl42);
		
		lbl43 = new JLabel("");
		lbl43.setHorizontalAlignment(SwingConstants.CENTER);
		lbl43.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl43);
		
		lbl44 = new JLabel("");
		lbl44.setHorizontalAlignment(SwingConstants.CENTER);
		lbl44.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl44);
		
		lbl45 = new JLabel("");
		lbl45.setHorizontalAlignment(SwingConstants.CENTER);
		lbl45.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl45);
		
		lbl46 = new JLabel("");
		lbl46.setHorizontalAlignment(SwingConstants.CENTER);
		lbl46.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl46);
		
		lbl47 = new JLabel("");
		lbl47.setHorizontalAlignment(SwingConstants.CENTER);
		lbl47.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl47);
		
		lbl48 = new JLabel("");
		lbl48.setHorizontalAlignment(SwingConstants.CENTER);
		lbl48.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl48);
		
		lbl49 = new JLabel("");
		lbl49.setHorizontalAlignment(SwingConstants.CENTER);
		lbl49.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl49);
		
		lbl50 = new JLabel("");
		lbl50.setHorizontalAlignment(SwingConstants.CENTER);
		lbl50.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl50);
		
		lbl51 = new JLabel("");
		lbl51.setHorizontalAlignment(SwingConstants.CENTER);
		lbl51.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl51);
		
		lbl52 = new JLabel("");
		lbl52.setHorizontalAlignment(SwingConstants.CENTER);
		lbl52.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl52);
		
		lbl53 = new JLabel("");
		lbl53.setHorizontalAlignment(SwingConstants.CENTER);
		lbl53.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl53);
		
		lbl54 = new JLabel("");
		lbl54.setHorizontalAlignment(SwingConstants.CENTER);
		lbl54.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl54);
		
		lbl55 = new JLabel("");
		lbl55.setHorizontalAlignment(SwingConstants.CENTER);
		lbl55.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl55);
		
		lbl56 = new JLabel("");
		lbl56.setHorizontalAlignment(SwingConstants.CENTER);
		lbl56.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl56);
		
		lbl57 = new JLabel("");
		lbl57.setHorizontalAlignment(SwingConstants.CENTER);
		lbl57.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl57);
		
		lbl58 = new JLabel("");
		lbl58.setHorizontalAlignment(SwingConstants.CENTER);
		lbl58.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl58);
		
		lbl59 = new JLabel("");
		lbl59.setHorizontalAlignment(SwingConstants.CENTER);
		lbl59.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl59);
		
		lbl60 = new JLabel("");
		lbl60.setHorizontalAlignment(SwingConstants.CENTER);
		lbl60.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl60);
		
		lbl61 = new JLabel("");
		lbl61.setHorizontalAlignment(SwingConstants.CENTER);
		lbl61.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl61);
		
		lbl62 = new JLabel("");
		lbl62.setHorizontalAlignment(SwingConstants.CENTER);
		lbl62.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl62);
		
		lbl63 = new JLabel("");
		lbl63.setHorizontalAlignment(SwingConstants.CENTER);
		lbl63.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl63);
		
		lbl64 = new JLabel("");
		lbl64.setHorizontalAlignment(SwingConstants.CENTER);
		lbl64.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl64);
		
		lbl65 = new JLabel("");
		lbl65.setHorizontalAlignment(SwingConstants.CENTER);
		lbl65.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl65);
		
		lbl66 = new JLabel("");
		lbl66.setHorizontalAlignment(SwingConstants.CENTER);
		lbl66.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl66);
		
		lbl67 = new JLabel("");
		lbl67.setHorizontalAlignment(SwingConstants.CENTER);
		lbl67.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl67);
		
		lbl68 = new JLabel("");
		lbl68.setHorizontalAlignment(SwingConstants.CENTER);
		lbl68.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl68);
		
		lbl69 = new JLabel("");
		lbl69.setHorizontalAlignment(SwingConstants.CENTER);
		lbl69.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl69);
		
		lbl70 = new JLabel("");
		lbl70.setHorizontalAlignment(SwingConstants.CENTER);
		lbl70.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl70);
		
		lbl71 = new JLabel("");
		lbl71.setHorizontalAlignment(SwingConstants.CENTER);
		lbl71.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl71);
		
		lbl72 = new JLabel("");
		lbl72.setHorizontalAlignment(SwingConstants.CENTER);
		lbl72.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl72);
		
		lbl73 = new JLabel("");
		lbl73.setHorizontalAlignment(SwingConstants.CENTER);
		lbl73.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl73);
		
		lbl74 = new JLabel("");
		lbl74.setHorizontalAlignment(SwingConstants.CENTER);
		lbl74.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl74);
		
		lbl75 = new JLabel("");
		lbl75.setHorizontalAlignment(SwingConstants.CENTER);
		lbl75.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl75);
		
		lbl76 = new JLabel("");
		lbl76.setHorizontalAlignment(SwingConstants.CENTER);
		lbl76.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl76);
		
		lbl77 = new JLabel("");
		lbl77.setHorizontalAlignment(SwingConstants.CENTER);
		lbl77.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl77);
		
		lbl78 = new JLabel("");
		lbl78.setHorizontalAlignment(SwingConstants.CENTER);
		lbl78.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl78);
		
		lbl79 = new JLabel("");
		lbl79.setHorizontalAlignment(SwingConstants.CENTER);
		lbl79.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl79);
		
		lbl80 = new JLabel("");
		lbl80.setHorizontalAlignment(SwingConstants.CENTER);
		lbl80.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl80);
		
		lbl81 = new JLabel("");
		lbl81.setHorizontalAlignment(SwingConstants.CENTER);
		lbl81.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lbl81);
		
		panelBttm = new JPanel();
		panelBttm.setBackground(new Color(222, 184, 135));
		panelBttm.setBounds(103, 366, 403, 107);
		frame.getContentPane().add(panelBttm);
		panelBttm.setLayout(null);
		
		btnClose = new JButton("Close");
		btnClose.setBounds(314, 84, 89, 23);
		panelBttm.add(btnClose);
		btnClose.setBackground(new Color(219, 112, 147));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 231, 107);
		panelBttm.add(panel_1);
		panel_1.setOpaque(false);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton bttnLeft = new JButton("\u2190");
		bttnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(h.getG().getP().move(Direction.LEFT)){
					DrawMap.repaint();
				}
				frame.repaint();
			}
		});
		bttnLeft.setFont(new Font("Arial", Font.BOLD, 29));
		bttnLeft.setBorder(new MatteBorder(1, 2, 1, 1, (Color) new Color(0, 0, 0)));
		bttnLeft.setBackground(SystemColor.info);
		panel_1.add(bttnLeft, BorderLayout.WEST);
		
		JButton bttnUp = new JButton("\u2191");
		bttnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(h.getG().getP().move(Direction.UP)){
					DrawMap.repaint();
				}
				frame.repaint();
			}
		});
		bttnUp.setFont(new Font("Arial", Font.BOLD, 29));
		bttnUp.setBorder(new MatteBorder(2, 2, 1, 2, (Color) new Color(0, 0, 0)));
		bttnUp.setBackground(SystemColor.info);
		panel_1.add(bttnUp, BorderLayout.NORTH);
		
		JButton bttnDown = new JButton("\u2193");
		bttnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(h.getG().getP().move(Direction.DOWN)){
					DrawMap.repaint();
				}
				frame.repaint();
			}
		});
		bttnDown.setFont(new Font("Arial", Font.BOLD, 29));
		bttnDown.setBorder(new MatteBorder(1, 2, 2, 2, (Color) new Color(0, 0, 0)));
		bttnDown.setBackground(SystemColor.info);
		panel_1.add(bttnDown, BorderLayout.SOUTH);
		
		JButton bttnRight = new JButton("\u2192");
		bttnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(h.getG().getP().move(Direction.RIGHT)){
					DrawMap.repaint();
				}
				frame.repaint();
			}
		});
		bttnRight.setFont(new Font("Arial", Font.BOLD, 29));
		bttnRight.setBorder(new MatteBorder(1, 1, 1, 2, (Color) new Color(0, 0, 0)));
		bttnRight.setBackground(SystemColor.info);
		panel_1.add(bttnRight, BorderLayout.EAST);
		
		JButton bttnActions = new JButton("Actions");
		bttnActions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBttm.setVisible(false);
				pnlActions.setVisible(true);
			}
		});
		bttnActions.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		bttnActions.setBackground(SystemColor.info);
		bttnActions.setFont(new Font("Arial", Font.BOLD, 25));
		panel_1.add(bttnActions, BorderLayout.CENTER);
		
		poslbl = new Label("New label");
		poslbl.setBounds(266, 11, 106, 37);
		panelBttm.add(poslbl);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				h.getG().getGm().getFrmRpg().setEnabled(true);
				h.getG().getGm().getFrmRpg().requestFocus();
				frame.dispose();
			}
		});
		
		pnlActions = new JPanel();
		pnlActions.setVisible(false);
		pnlActions.setBackground(new Color(222, 184, 135));
		pnlActions.setBounds(5, 366, 574, 107);
		frame.getContentPane().add(pnlActions);
		pnlActions.setLayout(new GridLayout(5, 3, 0, 1));
		
		op1 = new JButton("clear");
		op1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
			}
		});
		pnlActions.add(op1);
		
		op2 = new JButton("op2");
		op2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pnlActions.add(op2);
		
		op3 = new JButton("op3");
		op3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pnlActions.add(op3);
		
		op4 = new JButton("op4");
		op4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pnlActions.add(op4);
		
		backbttn = new JButton("back");
		backbttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlActions.setVisible(false);
				panelBttm.setVisible(true);
			}
		});
		pnlActions.add(backbttn);
		
		JLabel lblMap = new JLabel("Map");
		lblMap.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMap.setHorizontalAlignment(SwingConstants.CENTER);
		lblMap.setBounds(242, 11, 99, 23);
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

	public Label getPoslbl(){
		return poslbl;
	}

	public void setPoslbl(Label poslbl){
		this.poslbl = poslbl;
	}

	private void clear(){
		boolean[][] cleared = this.h.getMem().getMap().getCleared();
		int[] relPos = DrawMap.relPos;

		cleared[relPos[0]][relPos[1]] = !cleared[relPos[0]][relPos[1]];

		h.getMem().getMap().setCleared(cleared);

		DrawMap.update();
	}
}
