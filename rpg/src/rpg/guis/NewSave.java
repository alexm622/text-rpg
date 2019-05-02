package rpg.guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import rpg.game.Game;
import rpg.game.Handler;
import rpg.utilities.Setup;
import rpg.utilities.json.Save;

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
import java.awt.Component;
import javax.swing.border.MatteBorder;
import java.awt.Color;

@SuppressWarnings("unused")
public class NewSave {

	private JFrame frmNewSave;
	private JTextField txtEnterCharacterName;
	private JPanel statData;
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
	private final JPanel ptsLeftLbl = new JPanel();
	private final JPanel statLbls = new JPanel();
	private final JPanel strBttns = new JPanel();
	private final JPanel charBttns = new JPanel();
	private final JPanel wisBttns = new JPanel();
	private final JPanel intBttns = new JPanel();
	private final JPanel dexBttns = new JPanel();
	private final JPanel constBttns = new JPanel();
	private final JPanel bttns = new JPanel();
	private final JPanel mainPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					new NewSave(null);
				} catch (Exception e) {
					rpg.game.Handler.debug(e.toString(), true);
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public NewSave(Handler h) {
		this.h = h;
		initialize();
		frmNewSave.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewSave = new JFrame();
		frmNewSave.setResizable(false);
		frmNewSave.getContentPane().setBackground(new Color(222, 184, 135));
		frmNewSave.setBackground(new Color(222, 184, 135));
		
		frmNewSave.setTitle("New Save");
		frmNewSave.setBounds(100, 100, 495, 440);
		frmNewSave.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmNewSave.getContentPane().setLayout(null);
		mainPanel.setBounds(26, 19, 436, 386);
		
		frmNewSave.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		txtEnterCharacterName = new JTextField();
		txtEnterCharacterName.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		txtEnterCharacterName.setBackground(new Color(255, 218, 185));
		txtEnterCharacterName.setBounds(0, 0, 436, 51);
		mainPanel.add(txtEnterCharacterName);
		txtEnterCharacterName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEnterCharacterName.setText("Enter Character Name");
		txtEnterCharacterName.setColumns(10);

		JButton btnCreate = new JButton("CREATE!");
		btnCreate.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnCreate.setBackground(new Color(244, 164, 96));
		btnCreate.setBounds(0, 335, 436, 51);
		mainPanel.add(btnCreate);
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 27));
		
				statData = new JPanel();
				statData.setBackground(new Color(210, 180, 140));
				statData.setBounds(0, 50, 436, 286);
				mainPanel.add(statData);
				statData.setLayout(null);
				ptsLeftLbl.setOpaque(false);
				ptsLeftLbl.setBounds(261, 11, 124, 41);
				
				statData.add(ptsLeftLbl);
				ptsLeftLbl.setLayout(null);
				lblPtsLeft.setBounds(0, 0, 124, 41);
				ptsLeftLbl.add(lblPtsLeft);
				
						lblPtsLeft.setFont(new Font("Tahoma", Font.PLAIN, 17));
						statLbls.setOpaque(false);
						statLbls.setBounds(64, 63, 321, 169);
						
						statData.add(statLbls);
						statLbls.setLayout(null);
						lblStrength.setBounds(0, 0, 115, 34);
						statLbls.add(lblStrength);
						lblStrength.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblCharisma.setBounds(0, 48, 115, 34);
						statLbls.add(lblCharisma);
						lblCharisma.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblWisdom.setBounds(0, 98, 115, 34);
						statLbls.add(lblWisdom);
						lblWisdom.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblIntellegence.setBounds(0, 135, 115, 34);
						statLbls.add(lblIntellegence);
						lblIntellegence.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblDexterity.setBounds(206, 0, 115, 34);
						statLbls.add(lblDexterity);
						lblDexterity.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblConstitution.setBounds(206, 45, 115, 34);
						statLbls.add(lblConstitution);
						lblConstitution.setFont(new Font("Tahoma", Font.PLAIN, 15));
						bttns.setOpaque(false);
						bttns.setBounds(10, 71, 414, 161);
						
						statData.add(bttns);
						bttns.setLayout(null);
						strBttns.setOpaque(false);
						strBttns.setBounds(0, 0, 199, 26);
						bttns.add(strBttns);
						strBttns.setLayout(null);
						bttn1plus.setBackground(new Color(205, 133, 63));
						bttn1plus.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
						bttn1plus.setBounds(158, 1, 41, 23);
						strBttns.add(bttn1plus);
						bttn1minus.setBackground(new Color(205, 133, 63));
						bttn1minus.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
						bttn1minus.setBounds(0, 1, 41, 23);
						strBttns.add(bttn1minus);
						charBttns.setOpaque(false);
						charBttns.setBounds(0, 45, 199, 26);
						bttns.add(charBttns);
						charBttns.setLayout(null);
						bttn2plus.setBackground(new Color(205, 133, 63));
						bttn2plus.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
						bttn2plus.setBounds(158, 1, 41, 23);
						charBttns.add(bttn2plus);
						bttn2minus.setBackground(new Color(205, 133, 63));
						bttn2minus.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
						bttn2minus.setBounds(0, 1, 41, 23);
						charBttns.add(bttn2minus);
						wisBttns.setOpaque(false);
						wisBttns.setBounds(0, 93, 199, 26);
						bttns.add(wisBttns);
						wisBttns.setLayout(null);
						bttn3plus.setBackground(new Color(205, 133, 63));
						bttn3plus.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
						bttn3plus.setBounds(158, 1, 41, 23);
						wisBttns.add(bttn3plus);
						bttn3minus.setBackground(new Color(205, 133, 63));
						bttn3minus.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
						bttn3minus.setBounds(0, 1, 41, 23);
						wisBttns.add(bttn3minus);
						intBttns.setOpaque(false);
						intBttns.setBounds(0, 135, 199, 26);
						bttns.add(intBttns);
						intBttns.setLayout(null);
						bttn4plus.setBackground(new Color(205, 133, 63));
						bttn4plus.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
						bttn4plus.setBounds(158, 1, 41, 23);
						intBttns.add(bttn4plus);
						bttn4minus.setBackground(new Color(205, 133, 63));
						bttn4minus.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
						bttn4minus.setBounds(0, 1, 41, 23);
						intBttns.add(bttn4minus);
						dexBttns.setOpaque(false);
						dexBttns.setBounds(215, 0, 199, 26);
						bttns.add(dexBttns);
						dexBttns.setLayout(null);
						bttn5plus.setBackground(new Color(205, 133, 63));
						bttn5plus.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
						bttn5plus.setBounds(158, 1, 41, 23);
						dexBttns.add(bttn5plus);
						bttn5minus.setBackground(new Color(205, 133, 63));
						bttn5minus.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
						bttn5minus.setAlignmentY(Component.TOP_ALIGNMENT);
						bttn5minus.setBounds(0, 1, 41, 23);
						dexBttns.add(bttn5minus);
						constBttns.setOpaque(false);
						constBttns.setBounds(215, 45, 199, 26);
						bttns.add(constBttns);
						constBttns.setLayout(null);
						bttn6plus.setBackground(new Color(205, 133, 63));
						bttn6plus.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
						bttn6plus.setBounds(158, 1, 41, 23);
						constBttns.add(bttn6plus);
						bttn6minus.setBackground(new Color(205, 133, 63));
						bttn6minus.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
						bttn6minus.setAlignmentY(0.0f);
						bttn6minus.setBounds(0, 1, 41, 23);
						constBttns.add(bttn6minus);
						
								bttn6minus.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										try {
											set(5, false);
										} catch (Exception x) {
											Handler.debug(x.toString(), true);
											x.printStackTrace();
										}
									}
								});
								
										bttn6plus.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												try {
													set(5, true);
												} catch (Exception x) {
													rpg.game.Handler.debug(x.toString(), true);
													x.printStackTrace();
												}
											}
										});
										
												bttn5minus.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														try {
															set(4, false);
														} catch (Exception x) {
															Handler.debug(x.toString(), true);
															x.printStackTrace();
														}
													}
												});
												
														bttn5plus.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																try {
																	set(4, true);
																} catch (Exception x) {
																	rpg.game.Handler.debug(x.toString(), true);
																	x.printStackTrace();
																}
															}
														});
														
																bttn4minus.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																		try {
																			set(3, false);
																		} catch (Exception x) {
																			Handler.debug(x.toString(), true);
																			x.printStackTrace();
																		}
																	}
																});
																
																		bttn4plus.addActionListener(new ActionListener() {
																			public void actionPerformed(ActionEvent e) {
																				try {
																					set(3, true);
																				} catch (Exception x) {
																					rpg.game.Handler.debug(x.toString(), true);
																					x.printStackTrace();
																				}
																			}
																		});
																		
																				bttn3minus.addActionListener(new ActionListener() {
																					public void actionPerformed(ActionEvent e) {
																						try {
																							set(2, false);
																						} catch (Exception x) {
																							Handler.debug(x.toString(), true);
																							x.printStackTrace();
																						}
																					}
																				});
																				
																						bttn3plus.addActionListener(new ActionListener() {
																							public void actionPerformed(ActionEvent e) {
																								try {
																									set(2, true);
																								} catch (Exception x) {
																									rpg.game.Handler.debug(x.toString(), true);
																									x.printStackTrace();
																								}
																							}
																						});
																						
																								bttn2minus.addActionListener(new ActionListener() {
																									public void actionPerformed(ActionEvent e) {
																										try {
																											set(1, false);
																										} catch (Exception x) {
																											rpg.game.Handler.debug(x.toString(), true);
																											x.printStackTrace();
																										}
																									}
																								});
																								
																										bttn2plus.addActionListener(new ActionListener() {
																											public void actionPerformed(ActionEvent e) {
																												try {
																													set(1, true);
																												} catch (Exception x) {
																													rpg.game.Handler.debug(x.toString(), true);
																													x.printStackTrace();
																												}
																											}
																										});
																										
																												bttn1minus.addActionListener(new ActionListener() {
																													public void actionPerformed(ActionEvent arg0) {
																														try {
																															set(0, false);
																														} catch (Exception x) {
																															rpg.game.Handler.debug(x.toString(), true);
																															x.printStackTrace();
																														}
																													}
																												});
																												
																														bttn1plus.addActionListener(new ActionListener() {
																															public void actionPerformed(ActionEvent e) {
																																try {
																																	set(0, true);
																																} catch (Exception x) {
																																	rpg.game.Handler.debug(x.toString(), true);
																																	x.printStackTrace();
																																}
																															}
																														});
		// create a new save
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// new save
				Create(txtEnterCharacterName.getText());
				// add stat array
				frmNewSave.dispose();
				Setup.CharDone(h);
				
			}
		});

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
		String[] stats = { text, Integer.toString(values[0]), Integer.toString(values[1]), Integer.toString(values[2]),
				Integer.toString(values[3]), Integer.toString(values[4]), Integer.toString(values[5]) };
		/*
		 * for (int i = 0; i < 7; i++) { System.out.println(stats[i]); }
		 */
		rpg.game.Handler.debug("fetched character info from the gui");
		// GraphicMain.get_Handler().getG().getP().Create(text);
		rpg.game.Handler.debug("character name: " + stats[0]);
		if(h.getG().getP() == null){
			rpg.game.Handler.debug("player is null", true);
		}else{
			rpg.game.Handler.debug("player is not null");
		}
		h.getG().getP().init(stats, new int[]{0,0});
		return;
	}
}
