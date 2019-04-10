package rpg.guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;


import javax.swing.SwingConstants;

public class MemLoad {

	private JFrame frame;
	private JLabel loadingAsset;
	private JLabel percent;
	private JProgressBar loadProgress;
	private JLabel loadingText;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemLoad window = new MemLoad();
					window.frame.setVisible(true);
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
	public MemLoad() {
		initialize();

		
		
		frame.setVisible(true);
		

	}

	public void Close() {
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			rpg.game.Handler.debug(e.toString(), true);
			e.printStackTrace();
		}
		frame.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.frame = new JFrame();
		frame.setBounds(100, 100, 450, 122);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		this.loadingAsset = new JLabel();
		loadingAsset.setText("Asset Being Loaded");
		loadingAsset.setBounds(22, 52, 386, 25);
		frame.getContentPane().add(loadingAsset);

		this.percent = new JLabel();
		percent.setText("percent");
		percent.setFont(new Font("Tahoma", Font.BOLD, 15));
		percent.setBounds(236, 11, 101, 30);
		frame.getContentPane().add(percent);

		this.loadProgress = new JProgressBar();
		loadProgress.setBounds(10, 52, 414, 25);
		frame.getContentPane().add(loadProgress);

		this.loadingText = new JLabel();
		loadingText.setText("Loading:");
		loadingText.setHorizontalAlignment(SwingConstants.TRAILING);
		loadingText.setFont(new Font("Tahoma", Font.BOLD, 15));
		loadingText.setBounds(140, 11, 94, 30);
		frame.getContentPane().add(loadingText);
	}

	public void setAsset(String path) {
		rpg.game.Handler.debug("ran the set asset method");
		frame.validate();
	}

	public JLabel getLoadingAsset() {
		return this.loadingAsset;
	}

	public void setLoadingAsset(JLabel loadingAsset) {
		this.loadingAsset = loadingAsset;
	}

	public JLabel getPercent() {
		return this.percent;
	}

	public void setPercent(JLabel percent) {
		this.percent = percent;
	}

	public JProgressBar getLoadProgress() {
		return this.loadProgress;
	}

	public void setLoadProgress(JProgressBar loadProgress) {
		this.loadProgress = loadProgress;
	}

	public JLabel getLoadingText() {
		return this.loadingText;
	}

	public void setLoadingText(JLabel loadingText) {
		this.loadingText = loadingText;
	}

	public JFrame getFrame() {
		return this.frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void setTempBool(boolean bool) {
	}

}
