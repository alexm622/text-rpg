package rpg.guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import rpg.game.Game;
import rpg.game.Handler;
import rpg.utilities.SaveFileReader;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

@SuppressWarnings("unused")
public class NewSave {

	private JFrame frmNewSave;
	private JTextField txtEnterCharacterName;
	private JPanel panel;
	private Handler h;

	private static JLabel lblStrength = new JLabel("Strength: 1");
	private static JLabel lblCharisma = new JLabel("Charisma: 1");
	private static JLabel lblWisdom = new JLabel("Wisdom: 1");
	private static JLabel lblIntellegence = new JLabel("Intelligence: 1");
	private static JLabel lblDexterity = new JLabel("Dexterity: 1");
	private static JLabel lblConstitution = new JLabel("Constitution: 1");
	private int ptsLeft = 22;
	private static JButton bttn1plus = new JButton("+");
	private static JButton bttn1minus = new JButton("-");
	private static JButton bttn2plus = new JButton("+");
	private static JButton bttn2minus = new JButton("-");
	private static JButton bttn3plus = new JButton("+");
	private static JButton bttn3minus = new JButton("-");
	private static JButton bttn4plus = new JButton("+");
	private static JButton bttn4minus = new JButton("-");
	private static JButton bttn5plus = new JButton("+");
	private static JButton bttn5minus = new JButton("-");
	private static JButton bttn6plus = new JButton("+");
	private static JButton bttn6minus = new JButton("-");

	private static JLabel lblPtsLeft = new JLabel("Points Left: 22");
	// object arrays
	public JButton[] plusBttns = { bttn1plus, bttn2plus, bttn3plus, bttn4plus, bttn5plus, bttn6plus };
	public JButton[] minusBttns = { bttn1minus, bttn2minus, bttn3minus, bttn4minus, bttn5minus, bttn6minus };
	public JLabel[] labels = { lblStrength, lblCharisma, lblWisdom, lblIntellegence, lblDexterity, lblConstitution };
	public String[] strings = { "Strength: ", "Charisma: ", "Wisdom: ", "Intelligence: ", "Dexterity: ",
			"Constitution: " };

	private int[] values = { 1, 1, 1, 1, 1, 1 };
	private int[] lastvalues = { 1, 1, 1, 1, 1, 1 };

	/**
	 * Launch the application.
	 */
	public void main(Handler handler) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewSave window = new NewSave();
					window.frmNewSave.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		h = handler;
	}

	/**
	 * Create the application.
	 */
	public NewSave() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewSave = new JFrame();
		frmNewSave.setTitle("New Save");
		frmNewSave.setBounds(100, 100, 452, 424);
		frmNewSave.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNewSave.getContentPane().setLayout(null);

		txtEnterCharacterName = new JTextField();
		txtEnterCharacterName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEnterCharacterName.setBounds(0, 0, 436, 51);
		txtEnterCharacterName.setText("Enter Character Name");
		frmNewSave.getContentPane().add(txtEnterCharacterName);
		txtEnterCharacterName.setColumns(10);

		JButton btnCreate = new JButton("CREATE!");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnCreate.setBounds(0, 335, 436, 51);
		// create a new save
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// new save
				Create(txtEnterCharacterName.getText());
				h.getFm().Write(h.getP().stats);
				// add stat array
				frmNewSave.dispose();
			}
		});
		frmNewSave.getContentPane().add(btnCreate);

		panel = new JPanel();
		panel.setBounds(0, 50, 436, 282);
		frmNewSave.getContentPane().add(panel);
		panel.setLayout(null);

		lblPtsLeft.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPtsLeft.setBounds(261, 11, 124, 41);
		panel.add(lblPtsLeft);

		lblStrength.setBounds(64, 63, 115, 34);
		lblStrength.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblStrength);

		lblCharisma.setBounds(64, 111, 115, 34);
		lblCharisma.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblCharisma);

		lblWisdom.setBounds(64, 161, 115, 34);
		lblWisdom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblWisdom);

		lblIntellegence.setBounds(64, 198, 115, 34);
		lblIntellegence.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblIntellegence);

		lblDexterity.setBounds(270, 63, 115, 34);
		lblDexterity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblDexterity);

		lblConstitution.setBounds(270, 108, 115, 34);
		lblConstitution.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblConstitution);

		bttn1plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					set(0, true);
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
		bttn1plus.setBounds(168, 71, 41, 23);
		panel.add(bttn1plus);

		bttn2plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					set(1, true);
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
		bttn2plus.setBounds(168, 116, 41, 23);
		panel.add(bttn2plus);

		bttn3plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					set(2, true);
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
		bttn3plus.setBounds(168, 164, 41, 23);
		panel.add(bttn3plus);

		bttn4plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					set(3, true);
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
		bttn4plus.setBounds(168, 206, 41, 23);
		panel.add(bttn4plus);

		bttn5plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					set(4, true);
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
		bttn5plus.setBounds(383, 71, 41, 23);
		panel.add(bttn5plus);

		bttn6plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					set(5, true);
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
		bttn6plus.setBounds(383, 116, 41, 23);
		panel.add(bttn6plus);

		bttn1minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					set(0, false);
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
		bttn1minus.setBounds(10, 74, 41, 23);
		panel.add(bttn1minus);

		bttn2minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					set(1, false);
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
		bttn2minus.setBounds(10, 119, 41, 23);
		panel.add(bttn2minus);

		bttn3minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					set(2, false);
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
		bttn3minus.setBounds(10, 167, 41, 23);
		panel.add(bttn3minus);

		bttn4minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					set(3, false);
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
		bttn4minus.setBounds(10, 209, 41, 23);
		panel.add(bttn4minus);

		bttn5minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					set(4, false);
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
		bttn5minus.setBounds(225, 74, 41, 23);
		panel.add(bttn5minus);

		bttn6minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					set(5, false);
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
		bttn6minus.setBounds(225, 119, 41, 23);
		panel.add(bttn6minus);

	}

	private void set(int x, boolean y) throws Error { // lbl number, true = ++ false = --
		if (y && ptsLeft - 1 >= 0) {
			ptsLeft--;
			lblPtsLeft.setText("Points Left: " + ptsLeft);
			lastvalues[x] = values[x];
			values[x] = lastvalues[x] + 1;
			labels[x].setText(strings[x] + values[x]);
		} else if (!y && values[x] - 1 >= 1) {
			ptsLeft++;
			lblPtsLeft.setText("Points Left: " + ptsLeft);
			lastvalues[x] = values[x];
			values[x] = lastvalues[x] - 1;
			labels[x].setText(strings[x] + values[x]);
		} else if (ptsLeft - 1 < 0 && y) {
			throw new Error("no points left");
		} else if (values[x] - 1 < 1 && !y) {
			throw new Error("cant take any more points away");
		} else {
			throw new Error("Something gone wrong");
		}
	}

	public void Create(String text) {
		refresh();
		String[] stats = { text, Integer.toString(values[0]), Integer.toString(values[1]), Integer.toString(values[2]),
				Integer.toString(values[3]), Integer.toString(values[4]), Integer.toString(values[5]) };
		/*
		 * for (int i = 0; i < 7; i++) { System.out.println(stats[i]); }
		 */
		System.out.println("done");
		// GraphicMain.get_Handler().getG().getP().Create(text);
		h.getP().initStats(stats);
		return;
	}

	private void refresh() {
		// refresh all the values[]
		for (int i = 0; i < 6; i++) {

		}
	}

}
