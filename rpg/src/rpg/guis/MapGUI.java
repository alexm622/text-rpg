package rpg.guis;




import javax.swing.JFrame;

import javax.swing.JPanel;

import org.apache.commons.lang3.time.StopWatch;
import rpg.game.Handler;
import rpg.guis.draw.DrawMap;
import rpg.utilities.map.Direction;

import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

import javax.swing.border.MatteBorder;


import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MapGUI {

	private  static JFrame frame;


	private Label posLabel;

	private static JPanel[] panels = new JPanel[3];

	public static int width, height;
	private StopWatch sw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				new MapGUI();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MapGUI() {
		Handler.g.getGm().getFrmRpg().setEnabled(false);
		initialize();
		frame.requestFocus();
		frame.setVisible(true);
		sw = new StopWatch();
		sw.start();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(210, 180, 140));
		frame.setTitle("Map");
		frame.setSize(600,525);
		width = 600;
		height = 525;
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
				Handler.g.getGm().getFrmRpg().setEnabled(true);
				Handler.g.getGm().getFrmRpg().requestFocus();
			}
		});

		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				Dimension size;
				size = frame.getSize();
				double tempH = size.getHeight();
				double tempW = size.getWidth();
				double percentW = tempW/width;
				double percentH = tempH/height;

				height = frame.getHeight();
				width = frame.getWidth();
				resized(e.getComponent(), percentW, percentH);
			}
		});
		frame.getContentPane().setLayout(null);

		panels[0] = new JPanel();
		panels[0].setBackground(new Color(205, 133, 63));
		panels[0].setBorder(new MatteBorder(2, 2, 2, 2, new Color(0, 0, 0)));
		panels[0].setBounds(5, 40, 574, 315);

		frame.getContentPane().add(panels[0]);
		panels[0].setLayout(new GridLayout(MapLblGen.WIDTH, MapLblGen.HEIGHT, 0, 0));



		panels[1] = new JPanel();
		panels[1].setBackground(new Color(222, 184, 135));
		panels[1].setBounds(103, 366, 403, 107);
		frame.getContentPane().add(panels[1]);
		panels[1].setLayout(null);


		JButton btnClose = new JButton("Close");
		btnClose.setBounds(314, 84, 89, 23);
		panels[1].add(btnClose);
		btnClose.setBackground(new Color(219, 112, 147));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 231, 107);
		panels[1].add(panel_1);
		panel_1.setOpaque(false);
		panel_1.setLayout(new BorderLayout(0, 0));

		JButton bttnLeft = new JButton("\u2190");
		bttnLeft.addActionListener(e -> {
			if(Handler.g.getP().move(Direction.LEFT)){
				DrawMap.repaint();
			}
			frame.repaint();
		});
		bttnLeft.setFont(new Font("Arial", Font.BOLD, 29));
		bttnLeft.setBorder(new MatteBorder(1, 2, 1, 1, new Color(0, 0, 0)));
		bttnLeft.setBackground(SystemColor.info);
		panel_1.add(bttnLeft, BorderLayout.WEST);

		JButton bttnUp = new JButton("\u2191");
		bttnUp.addActionListener(e -> {
			if(Handler.g.getP().move(Direction.UP)){
				DrawMap.repaint();
			}
			frame.repaint();
		});
		bttnUp.setFont(new Font("Arial", Font.BOLD, 29));
		bttnUp.setBorder(new MatteBorder(2, 2, 1, 2, new Color(0, 0, 0)));
		bttnUp.setBackground(SystemColor.info);
		panel_1.add(bttnUp, BorderLayout.NORTH);

		JButton bttnDown = new JButton("\u2193");
		bttnDown.addActionListener(arg0 -> {
			if(Handler.g.getP().move(Direction.DOWN)){
				DrawMap.repaint();
			}
			frame.repaint();
		});
		bttnDown.setFont(new Font("Arial", Font.BOLD, 29));
		bttnDown.setBorder(new MatteBorder(1, 2, 2, 2, new Color(0, 0, 0)));
		bttnDown.setBackground(SystemColor.info);
		panel_1.add(bttnDown, BorderLayout.SOUTH);

		JButton bttnRight = new JButton("\u2192");
		bttnRight.addActionListener(arg0 -> {
			if(Handler.g.getP().move(Direction.RIGHT)){
				DrawMap.repaint();
			}
			frame.repaint();
		});
		bttnRight.setFont(new Font("Arial", Font.BOLD, 29));
		bttnRight.setBorder(new MatteBorder(1, 1, 1, 2, new Color(0, 0, 0)));
		bttnRight.setBackground(SystemColor.info);
		panel_1.add(bttnRight, BorderLayout.EAST);

		JButton bttnActions = new JButton("Actions");
		bttnActions.addActionListener(e -> {
			panels[1].setVisible(false);
			panels[2].setVisible(true);
		});
		bttnActions.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		bttnActions.setBackground(SystemColor.info);
		bttnActions.setFont(new Font("Arial", Font.BOLD, 25));
		panel_1.add(bttnActions, BorderLayout.CENTER);

		posLabel = new Label("New label");
		posLabel.setBounds(266, 11, 106, 37);
		panels[1].add(posLabel);
		btnClose.addActionListener(arg0 -> {
			Handler.g.getGm().getFrmRpg().setEnabled(true);
			Handler.g.getGm().getFrmRpg().requestFocus();
			frame.dispose();
		});

		panels[2] = new JPanel();
		panels[2].setVisible(false);
		panels[2].setBackground(new Color(222, 184, 135));
		panels[2].setBounds(5, 366, 574, 107);
		frame.getContentPane().add(panels[2]);
		panels[2].setLayout(new GridLayout(5, 3, 0, 1));

		JButton op1 = new JButton("clear");
		op1.addActionListener(arg0 -> clear());
		panels[2].add(op1);

		JButton op2 = new JButton("op2");
		op2.addActionListener(e -> {
		});
		panels[2].add(op2);

		JButton op3 = new JButton("op3");
		op3.addActionListener(e -> {
		});
		panels[2].add(op3);

		JButton op4 = new JButton("op4");
		op4.addActionListener(e -> {
		});
		panels[2].add(op4);

		JButton backButton = new JButton("back");
		backButton.addActionListener(arg0 -> {
			panels[2].setVisible(false);
			panels[1].setVisible(true);
		});
		panels[2].add(backButton);

		JLabel lblMap = new JLabel("Map");
		lblMap.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMap.setHorizontalAlignment(SwingConstants.CENTER);
		lblMap.setBounds(242, 11, 99, 23);
		frame.getContentPane().add(lblMap);


	}
	



	public Label getPosLabel(){
		return posLabel;
	}
	public JPanel getPanel(){ return panels[0];}

	public JFrame getFrame(){
		return frame;
	}

	public void addLabels(JLabel[][] labels){
		for (JLabel[] label : labels) { //cycle through rows
			for (JLabel lbl : label) { // cycle through columns
				panels[0].add(lbl);
			}
		}
	}

	public void setPosLabel(Label posLabel){
		this.posLabel = posLabel;
	}

	private void clear(){
		boolean[][] cleared = Handler.memory.getMap().getCleared();
		int[] relPos = DrawMap.relPos;

		cleared[relPos[0]][relPos[1]] = !cleared[relPos[0]][relPos[1]];

		Handler.memory.getMap().setCleared(cleared);

		DrawMap.update();
	}

	private void resized(Component com, double percentW, double percentH){





		Component[] components = frame.getContentPane().getComponents();
		frame.getContentPane().removeAll();








		for (int i = 0; i < components.length; i++ ) {
			Component c = components[i];






			Rectangle bounds = c.getBounds();
			Font f = c.getFont();

			//set bounds
			Rectangle newBounds;
			double h, w, x, y;
			h = bounds.getHeight();
			w = bounds.getWidth();
			x = bounds.getX();
			y = bounds.getY();

			int newH, newW, newX, newY;

			newH = (int) Math.round(h * percentH);
			newW = (int) Math.round(w * percentW);

			newX = (int) Math.round(x * percentW);
			newY = (int) Math.round(y * percentH);

			newBounds = new Rectangle(newX, newY, newW, newH);

			//set font size

			Font newFont;

			float FSize = f.getSize2D();
			float newFSize;


			newFSize = (float)(FSize * percentW);

			newFont = f.deriveFont(f.getStyle(), newFSize);


			//apply changes
			c.setFont(newFont);
			c.setBounds(newBounds);










		}

		for(int i = 0; i < panels.length; i++){
			JPanel panel = panels[i];
			Component[] compPanel = panel.getComponents();
			panel.removeAll();
			for(int j = 0; j < compPanel.length; j++){
				Component c = compPanel[j];
				Rectangle bounds = c.getBounds();


				//set bounds
				Rectangle newBounds;
				double h, w, x, y;
				h = bounds.getHeight();
				w = bounds.getWidth();
				x = bounds.getX();
				y = bounds.getY();

				int newH, newW, newX, newY;

				newH = (int) Math.round(h * percentH);
				newW = (int) Math.round(w * percentW);

				newX = (int) Math.round(x * percentW);
				newY = (int) Math.round(y * percentH);

				newBounds = new Rectangle(newX, newY, newW, newH);

				c.setBounds(newBounds);

			}
			for(Component c : compPanel){
				panel.add(c);
			}
		}

		for(Component c : components){
			frame.getContentPane().add(c);
		}











	}
}
