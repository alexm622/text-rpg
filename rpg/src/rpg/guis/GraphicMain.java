package rpg.guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.TextField;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import java.awt.ScrollPane;
import javax.swing.ScrollPaneConstants;

import rpg.game.Game;
import rpg.game.Handler;
import rpg.guis.draw.DrawMap;
import rpg.utilities.Setup;
import rpg.utilities.json.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.DebugGraphics;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

@SuppressWarnings("unused")
public class GraphicMain {

	private JFrame frmRpg;
	private JPanel choicePanel;
	private final ButtonGroup radioButtons = new ButtonGroup();
	private JTextField question;
	private JLabel name_level;
	private JLabel hp_gold;
	private JTextPane output;
	public static Handler h;
	private JRadioButton choice_1, choice_2, choice_3, choice_4, choice_5, choice_6, choice_yes, choice_no;

	private JMenuItem btnMods;
	private JPanel name;
	private JPanel hpgold;
	private JPanel menuPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphicMain window = new GraphicMain();
					window.frmRpg.setVisible(true);
				} catch (Exception e) {
					rpg.game.Handler.debug(e.toString(), true);
					e.printStackTrace();
				}
			}
		});
	}

	public void Init(GraphicMain gm) {

	}

	/**
	 * Create the application.
	 */
	public GraphicMain() {
		
		initialize();
		frmRpg.setVisible(true);
		frmRpg.repaint();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRpg = new JFrame();
		
		
		frmRpg.getContentPane().setBackground(new Color(210, 180, 140));
		frmRpg.setBackground(new Color(210, 180, 140));
		frmRpg.getContentPane().setEnabled(false);
		frmRpg.setTitle("Rpg");
		frmRpg.setResizable(false);
		frmRpg.setBounds(100, 100, 663, 471);
		frmRpg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRpg.getContentPane().setLayout(null);
				
				menuPanel = new JPanel();
				menuPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
				menuPanel.setBounds(0, 0, 657, 27);
				frmRpg.getContentPane().add(menuPanel);
				menuPanel.setLayout(null);
		
				JMenuBar menuBar = new JMenuBar();
				menuBar.setMargin(new Insets(0, 0, 2, 0));
				menuBar.setAlignmentY(Component.CENTER_ALIGNMENT);
				menuBar.setBounds(1, 1, 656, 26);
				menuBar.setBorderPainted(false);
				menuBar.setBorder(null);
				menuBar.setPreferredSize(new Dimension(0, 0));
				menuBar.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
				menuPanel.add(menuBar);
				menuBar.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
								
										// save button
										JMenuItem mntmSave = new JMenuItem("Save");
										mntmSave.setBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(0, 0, 0)));
										mntmSave.setBorderPainted(true);
										mntmSave.setOpaque(true);
										mntmSave.setBackground(SystemColor.inactiveCaption);
										mntmSave.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent arg0) {
												// save the player data
												new Save(h);
											}
										});
										
												JMenuItem mntmOpen = new JMenuItem("Load");
												mntmOpen.setBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(0, 0, 0)));
												mntmOpen.setBorderPainted(true);
												mntmOpen.setOpaque(true);
												mntmOpen.setForeground(Color.BLACK);
												mntmOpen.setBackground(SystemColor.inactiveCaption);
												mntmOpen.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent arg0) {
														new Setup(h, true);
													}
												});
												
														//
														JMenuItem mntmNew = new JMenuItem("New");
														menuBar.add(mntmNew);
														mntmNew.setHorizontalTextPosition(SwingConstants.LEFT);
														mntmNew.setHorizontalAlignment(SwingConstants.LEFT);
														mntmNew.setBorder(new MatteBorder(2, 2, 2, 1, (Color) new Color(0, 0, 0)));
														mntmNew.setBorderPainted(true);
														mntmNew.setOpaque(true);
														mntmNew.setBackground(SystemColor.inactiveCaption);
														mntmNew.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent arg0) {
																new Setup(h, false);
															}
														});
												menuBar.add(mntmOpen);
										menuBar.add(mntmSave);
												
												btnMods = new JMenuItem("Mods");
												btnMods.setBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(0, 0, 0)));
												btnMods.setBorderPainted(true);
												btnMods.setOpaque(true);
												btnMods.setBackground(SystemColor.inactiveCaption);
												menuBar.add(btnMods);
		
				JMenuItem mntmExit = new JMenuItem("Exit");
				mntmExit.setBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(0, 0, 0)));
				mntmExit.setBorderPainted(true);
				mntmExit.setOpaque(true);
				mntmExit.setBackground(SystemColor.inactiveCaption);
				menuBar.add(mntmExit);
		
		name = new JPanel();
		name.setDoubleBuffered(false);
		name.setBackground(SystemColor.inactiveCaption);
		name.setBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(0, 0, 0)));
		menuBar.add(name);
		name.setLayout(new BorderLayout(0, 0));
		
				name_level = new JLabel();
				name_level.setBorder(null);
				name_level.setFont(new Font("Tahoma", Font.PLAIN, 11));
				name_level.setAlignmentX(Component.CENTER_ALIGNMENT);
				name_level.setHorizontalAlignment(SwingConstants.CENTER);
				name.add(name_level, BorderLayout.CENTER);
				name_level.setText("test1");
		
		hpgold = new JPanel();
		hpgold.setBackground(SystemColor.inactiveCaption);
		hpgold.setDoubleBuffered(false);
		hpgold.setBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(0, 0, 0)));
		menuBar.add(hpgold);
				hpgold.setLayout(new BorderLayout(0, 0));
		
				hp_gold = new JLabel();
				hp_gold.setBorder(null);
				hp_gold.setFont(new Font("Tahoma", Font.PLAIN, 11));
				hp_gold.setAlignmentX(Component.CENTER_ALIGNMENT);
				hp_gold.setHorizontalAlignment(SwingConstants.CENTER);
				hpgold.add(hp_gold, BorderLayout.CENTER);
				hp_gold.setText("test2");
				
				JMenuItem mntmX = new JMenuItem(" X ");
				mntmX.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						exit();
					}
				});
				mntmX.setBorder(new MatteBorder(2, 1, 2, 2, (Color) new Color(0, 0, 0)));
				mntmX.setBorderPainted(true);
				mntmX.setBackground(new Color(219, 112, 147));
				mntmX.setOpaque(true);
				menuBar.add(mntmX);
		
				output = new JTextPane();
				output.setBorder(null);
				output.setAutoscrolls(false);
				output.setBackground(new Color(255, 228, 181));
				output.setText(" sdfs");
				output.setBounds(0, 23, 625, 274);
				output.setEditable(false);
				
						JScrollPane scrollPane = new JScrollPane(output, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
								ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
						scrollPane.setBorder(null);
						scrollPane.setAutoscrolls(true);
						scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
						scrollPane.setForeground(new Color(240, 128, 128));
						scrollPane.setBackground(new Color(245, 222, 179));
						scrollPane.setBounds(10, 31, 637, 278);
						frmRpg.getContentPane().add(scrollPane);

		choicePanel = new JPanel();
		choicePanel.setOpaque(false);
		choicePanel.setBounds(10, 308, 637, 127);
		frmRpg.getContentPane().add(choicePanel);
		choicePanel.setLayout(null);

		choice_1 = new JRadioButton("New radio button");
		choice_1.setVisible(false);
		choice_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		choice_1.setForeground(Color.BLACK);
		choice_1.setBackground(new Color(184, 134, 11));
		radioButtons.add(choice_1);
		choice_1.setActionCommand(this.getChoice_1().getText());
		choice_1.setBounds(10, 41, 212, 23);
		choicePanel.add(choice_1);

		choice_2 = new JRadioButton("New radio button");
		choice_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		choice_2.setForeground(Color.BLACK);
		choice_2.setBackground(new Color(184, 134, 11));
		radioButtons.add(choice_2);
		choice_2.setActionCommand(this.getChoice_2().getText());
		choice_2.setBounds(10, 67, 212, 23);
		choice_2.setVisible(false);
		choicePanel.add(choice_2);

		choice_3 = new JRadioButton("New radio button");
		choice_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		choice_3.setForeground(Color.BLACK);
		choice_3.setBackground(new Color(184, 134, 11));
		radioButtons.add(choice_3);
		choice_3.setActionCommand(this.getChoice_3().getText());
		choice_3.setBounds(10, 93, 212, 23);
		choice_3.setVisible(false);
		choicePanel.add(choice_3);

		choice_4 = new JRadioButton("New radio button");
		choice_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		choice_4.setForeground(Color.BLACK);
		choice_4.setBackground(new Color(184, 134, 11));
		radioButtons.add(choice_4);
		choice_4.setActionCommand(this.getChoice_4().getText());
		choice_4.setBounds(224, 41, 212, 23);
		choice_4.setVisible(false);
		choicePanel.add(choice_4);

		choice_5 = new JRadioButton("New radio button");
		choice_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		choice_5.setForeground(Color.BLACK);
		choice_5.setBackground(new Color(184, 134, 11));
		radioButtons.add(choice_5);
		choice_5.setActionCommand(this.getChoice_5().getText());
		choice_5.setBounds(224, 67, 212, 23);
		choice_5.setVisible(false);
		choicePanel.add(choice_5);

		choice_6 = new JRadioButton("New radio button");
		choice_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		choice_6.setForeground(Color.BLACK);
		choice_6.setBackground(new Color(184, 134, 11));
		choice_6.setActionCommand(this.getChoice_6().getText());
		radioButtons.add(choice_6);
		choice_6.setVisible(false);
		choice_6.setBounds(224, 93, 212, 23);
		choicePanel.add(choice_6);

		choice_yes = new JRadioButton("Yes");
		choice_yes.setFont(new Font("Tahoma", Font.BOLD, 11));
		choice_yes.setForeground(Color.BLACK);
		choice_yes.setBackground(new Color(184, 134, 11));
		radioButtons.add(choice_yes);
		choice_yes.setActionCommand(choice_yes.getText());
		choice_yes.setBounds(438, 41, 98, 23);
		choice_yes.setVisible(false);
		choicePanel.add(choice_yes);

		choice_no = new JRadioButton("No");
		choice_no.setFont(new Font("Tahoma", Font.BOLD, 11));
		choice_no.setForeground(Color.BLACK);
		choice_no.setBackground(new Color(184, 134, 11));
		choice_no.setActionCommand(choice_no.getText());
		radioButtons.add(choice_no);
		choice_no.setVisible(false);
		choice_no.setBounds(438, 67, 98, 23);
		choicePanel.add(choice_no);

		JButton choice_select = new JButton("Choose");
		choice_select.setAlignmentX(Component.CENTER_ALIGNMENT);
		choice_select.setBackground(new Color(60, 179, 113));
		choice_select.setForeground(new Color(0, 0, 0));
		choice_select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread.currentThread().notify();
			}
		});
		choice_select.setBounds(438, 93, 98, 23);
		choice_select.setVisible(true);
		choicePanel.add(choice_select);

		question = new JTextField();
		question.setBorder(null);
		question.setBackground(new Color(184, 134, 11));
		question.setForeground(new Color(255, 218, 185));
		question.setBounds(10, 11, 627, 20);
		choicePanel.add(question);
		question.setColumns(10);

		JButton invButton = new JButton("Inventory");
		invButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		invButton.setBackground(new Color(60, 179, 113));
		invButton.setForeground(new Color(0, 0, 0));
		invButton.setBounds(542, 41, 89, 23);
		choicePanel.add(invButton);

		JButton stats_button = new JButton("Stats");
		stats_button.setAlignmentX(Component.CENTER_ALIGNMENT);
		stats_button.setBackground(new Color(60, 179, 113));
		stats_button.setForeground(new Color(0, 0, 0));
		stats_button.setBounds(542, 67, 89, 23);
		choicePanel.add(stats_button);
		
		JButton mapButton = new JButton("Map (WIP)");
		mapButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		mapButton.setBackground(new Color(60, 179, 113));
		mapButton.setForeground(new Color(0, 0, 0));
		mapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DrawMap(h);
			}
		});
		mapButton.setBounds(542, 93, 89, 23);
		choicePanel.add(mapButton);
		
	}
	
	private void exit() {
		frmRpg.dispose();
	}

	public static Handler get_Handler() {
		return h;
	}

	public JLabel getName_level() {
		return name_level;
	}

	public void setName_level(JLabel name_level) {
		this.name_level = name_level;
	}

	public JLabel getXp_gold() {
		return hp_gold;
	}

	public void setXp_gold(JLabel xp_gold) {
		this.hp_gold = xp_gold;
	}

	public JTextPane getOutput() {
		return output;
	}

	public void setOutput(JTextPane output) {
		this.output = output;
	}

	public JRadioButton getChoice_1() {
		return choice_1;
	}

	public void setChoice_1(JRadioButton choice_1) {
		this.choice_1 = choice_1;
	}

	public JRadioButton getChoice_2() {
		return choice_2;
	}

	public void setChoice_2(JRadioButton choice_2) {
		this.choice_2 = choice_2;
	}

	public JRadioButton getChoice_3() {
		return choice_3;
	}

	public void setChoice_3(JRadioButton choice_3) {
		this.choice_3 = choice_3;
	}

	public JRadioButton getChoice_4() {
		return choice_4;
	}

	public void setChoice_4(JRadioButton choice_4) {
		this.choice_4 = choice_4;
	}

	public JRadioButton getChoice_5() {
		return choice_5;
	}

	public void setChoice_5(JRadioButton choice_5) {
		this.choice_5 = choice_5;
	}

	public JRadioButton getChoice_6() {
		return choice_6;
	}

	public void setChoice_6(JRadioButton choice_6) {
		this.choice_6 = choice_6;
	}

	public GraphicMain getM() {
		return this;
	}

	/**
	 * @return the frmRpg
	 */
	public JFrame getFrmRpg() {
		return frmRpg;
	}

	/**
	 * @param frmRpg the frmRpg to set
	 */
	public void setFrmRpg(JFrame frmRpg) {
		this.frmRpg = frmRpg;
	}

	/**
	 * @return the radioButtons
	 */
	public ButtonGroup getRadioButtons() {
		return radioButtons;
	}

	/**
	 * @return the question
	 */
	public JTextField getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(JTextField query) {
		this.question = query;
	}

	/**
	 * @return the hp_gold
	 */
	public JLabel getHp_gold() {
		return hp_gold;
	}

	/**
	 * @param hp_gold the hp_gold to set
	 */
	public void setHp_gold(JLabel hp_gold) {
		this.hp_gold = hp_gold;
	}

	/**
	 * @return the choice_yes
	 */
	public JRadioButton getChoice_yes() {
		return choice_yes;
	}

	/**
	 * @param choice_yes the choice_yes to set
	 */
	public void setChoice_yes(JRadioButton choice_yes) {
		this.choice_yes = choice_yes;
	}

	/**
	 * @return the choice_no
	 */
	public JRadioButton getChoice_no() {
		return choice_no;
	}

	/**
	 * @param choice_no the choice_no to set
	 */
	public void setChoice_no(JRadioButton choice_no) {
		this.choice_no = choice_no;
	}

	public void freeze(){
		this.frmRpg.setEnabled(false);
	}
	
	public void unfreeze(){
		this.frmRpg.setEnabled(true);
	}
}