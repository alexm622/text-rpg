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
import rpg.utilities.SaveManager;
import rpg.utilities.Json.JsonMain;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class GraphicMain {

	public JFrame frmRpg;
	public final ButtonGroup radioButtons = new ButtonGroup();
	public JTextField query;
	public JTextField name_level;
	public JTextField hp_gold;
	public JTextPane output;
	public static Handler h;
	public static Game ga = new Game();
	public JRadioButton choice_1, choice_2, choice_3, choice_4, choice_5, choice_6, choice_yes, choice_no;
	private static SaveManager SM;
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
					e.printStackTrace();
				}
			}
		});
		ga.Start();
		Init();
	}

	private static void Init() {
		SM = new SaveManager();
		h = new Handler();
	}

	/**
	 * Create the application.
	 */
	public GraphicMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRpg = new JFrame();
		frmRpg.setTitle("Rpg");
		frmRpg.setResizable(false);
		frmRpg.setBounds(100, 100, 663, 463);
		frmRpg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRpg.getContentPane().setLayout(null);
		
		output = new JTextPane();
		output.setBounds(0, 23, 625, 274);
		output.setEditable(false);
		output.setEnabled(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 308, 647, 127);
		frmRpg.getContentPane().add(panel);
		panel.setLayout(null);
		
		choice_1 = new JRadioButton("New radio button");
		radioButtons.add(choice_1);
		choice_1.setActionCommand(this.getChoice_1().getText());
		choice_1.setBounds(10, 41, 212, 23);
		choice_1.setVisible(false);
		panel.add(choice_1);
		
		choice_2 = new JRadioButton("New radio button");
		radioButtons.add(choice_2);
		choice_2.setActionCommand(this.getChoice_2().getText());
		choice_2.setBounds(10, 67, 212, 23);
		choice_2.setVisible(false);
		panel.add(choice_2);
		
		choice_3 = new JRadioButton("New radio button");
		radioButtons.add(choice_3);
		choice_3.setActionCommand(this.getChoice_3().getText());
		choice_3.setBounds(10, 93, 212, 23);
		choice_3.setVisible(false);
		panel.add(choice_3);
		
		choice_4 = new JRadioButton("New radio button");
		radioButtons.add(choice_4);
		choice_4.setActionCommand(this.getChoice_4().getText());
		choice_4.setBounds(224, 41, 212, 23);
		choice_4.setVisible(false);
		panel.add(choice_4);
		
		choice_5 = new JRadioButton("New radio button");
		radioButtons.add(choice_5);
		choice_5.setActionCommand(this.getChoice_5().getText());
		choice_5.setBounds(224, 67, 212, 23);
		choice_5.setVisible(false);
		panel.add(choice_5);
		
		choice_6 = new JRadioButton("New radio button");
		choice_6.setActionCommand(this.getChoice_6().getText());
		radioButtons.add(choice_6);
		choice_6.setVisible(false);
		choice_6.setBounds(224, 93, 212, 23);
		panel.add(choice_6);
		
		choice_yes = new JRadioButton("Yes");
		radioButtons.add(choice_yes);
		choice_yes.setActionCommand(choice_yes.getText());
		choice_yes.setBounds(438, 41, 98, 23);
		choice_yes.setVisible(false);
		panel.add(choice_yes);
		
		choice_no = new JRadioButton("No");
		choice_no.setActionCommand(choice_no.getText());
		radioButtons.add(choice_no);
		choice_no.setVisible(false);
		choice_no.setBounds(438, 67, 98, 23);
		panel.add(choice_no);
		JButton choice_select = new JButton("Choose");
		choice_select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(radioButtons.getSelection().getActionCommand());
			}
		});
		choice_select.setBounds(548, 93, 89, 23);
		choice_select.setVisible(false);
		panel.add(choice_select);
		
		query = new JTextField();
		query.setBounds(0, 11, 647, 20);
		panel.add(query);
		query.setColumns(10);
		
		JButton invButton = new JButton("Inventory");
		invButton.setBounds(548, 41, 89, 23);
		panel.add(invButton);
		
		JButton stats_button = new JButton("Stats");
		stats_button.setBounds(548, 67, 89, 23);
		panel.add(stats_button);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, 647, 25);
		splitPane.setContinuousLayout(true);
		splitPane.setEnabled(false);
		frmRpg.getContentPane().add(splitPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setEnabled(false);
		splitPane.setLeftComponent(menuBar);
		
		
		//new save
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewSave n = new NewSave();
				n.main(null);
			}
		});
		menuBar.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Load");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JsonMain j = new JsonMain();
				j.test_class();
			}
		});
		menuBar.add(mntmOpen);
		
		//save button
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//save the player data
				SM.initSave();
			}
		});
		menuBar.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		menuBar.add(mntmExit);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setContinuousLayout(true);
		splitPane_1.setEnabled(false);
		splitPane.setRightComponent(splitPane_1);
		
		
		name_level = new JTextField();
		name_level.setEditable(false);
		splitPane_1.setLeftComponent(name_level);
		name_level.setColumns(10);
		
		hp_gold = new JTextField();
		hp_gold.setEditable(false);
		splitPane_1.setRightComponent(hp_gold);
		hp_gold.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane(output, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 23, 637, 286);
		frmRpg.getContentPane().add(scrollPane);
	}
	
	public static Handler get_Handler() {
		return h;
	}

	public JTextField getName_level() {
		return name_level;
	}

	public void setName_level(JTextField name_level) {
		this.name_level = name_level;
	}

	public JTextField getXp_gold() {
		return hp_gold;
	}

	public void setXp_gold(JTextField xp_gold) {
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

	public static Game get_Game() {
		// TODO Auto-generated method stub
		return ga;
	}

	
}